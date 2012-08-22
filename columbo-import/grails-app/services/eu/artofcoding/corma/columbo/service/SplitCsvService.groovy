/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.corma.columbo.service

import org.apache.camel.CamelContext

/**
 * 
 */
class SplitCsvService {
    
    /**
     * Scope prototype, one instance per injection.
     */
     static scope = 'prototype'
    
    /**
     * Grails configuration.
     */
    def grailsApplication
    
    /**
     * Use transactions?
     */
    static transactional = false
    
    /**
     * Processed line counter.
     */
    private int processedLineCount = 0
    
    /**
     * First line with column headers.
     */
    private java.util.List firstColumns = []
    
    /**
     * Map column name to position in line.
     */
    private java.util.Map columnPositionMap = [:]
    
    /**
     * Hold 'already seen' primary key values.
     */
    private HashSet<String> seenPkValues = []

    /**
     * Charset of input file.
     */
    private groovy.util.CharsetToolkit actualCtk
    private java.nio.charset.Charset actualCharset

    /**
     * Counter for generated files (due to duplicate keys).
     */
    private int filecount = -1
    
    /**
     * Filename of actual output file.
     */
    private String filename

    /**
     * File reference to actual output file.
     */
    private java.io.File actualFile
    
    /**
     * Writer for successfully processed lines.
     */
    private java.io.File successFile
    private java.io.Writer successWriter

    /**
     * Remember all generated files.
     */
    private java.util.List<java.io.File> successFiles = []
    
    /**
     * Writer for UNsuccessfully processed lines.
     */
    private java.io.File errorFile
    private java.io.Writer errorWriter
    
    /**
     * Remember all generated error files.
     */
    private java.util.List<java.io.File> errorFiles = []
    
    /**
     * Invert a map. Taken from http://jira.codehaus.org/browse/GROOVY-4294.
     * http://jira.codehaus.org/secure/attachment/49994/patchfile.txt
     */
    private <K, V> Map<V, K> invertMap(Map<K, V> self) {
    	Map<V, K> answer = new HashMap<V, K>();
    	Iterator<Map.Entry<K, V>> it = self.entrySet().iterator();
    	while(it.hasNext()) {
    		Map.Entry entry = it.next();
    		answer.put((V)entry.getValue(), (K)entry.getKey());
    	}
    	return answer;
    }

    /**
     * Generate filename: strip extension and add counter.
     */
    String makeFilename(filename, i) {
        // Strip extension and add _i
        filename -~ /\..*$/ + '_' + i 
    }
    
    /**
     * Setup output files: create filename using counter 'filecount',
     * create directories and file references for 'success' and 'error' files.
     * Takes care for the appropriate character set of output files.
     * Writes the column header in the first line of each output file.
     */
    def setupOutputFiles = {
        // Make filename
        filename = makeFilename(actualFile.name, ++filecount)
        // Open writer for successfully processed lines
        successFile = new java.io.File("${grailsApplication.config.columbo.splitter.directories.success}", filename + '.csv')
        successFiles << successFile
        successFile.parentFile.mkdirs()
        successWriter = successFile.newWriter(actualCharset.name())
        // Add first line/column header
        successWriter << firstColumns.join(';') + '\r\n'
        // Open writer for lines with errors
        errorFile = new java.io.File("${grailsApplication.config.columbo.splitter.directories.error}", , filename + '.csv')
        errorFiles << errorFile
        errorFile.parentFile.mkdirs()
        errorWriter = errorFile.newWriter(actualCharset.name())
    }

    /**
     * Close actual output files.
     */
    def closeOutputFiles = {
        // 
        def deletedSuccessFiles = successFiles.collect {
            if (it.size() < 10) {
                log.info "${it}: Size of success file is < 10, deleting"
                it.delete()
                it
            }
        }
        successFiles -= deletedSuccessFiles
        // Close success file
        if (successWriter) {
            successWriter.flush()
            successWriter.close()
            successWriter = null
        } else {
            log.error "closeOutputFiles: Cannot close successWriter"
        }
        // 
        def deletedErrorFiles = errorFiles.collect {
            if (it.size() < 10) {
                log.debug "${it}: Size of error file is < 10, deleting"
                it.delete()
                it
            }
        }
        errorFiles -= deletedErrorFiles
        // Close error file
        if (errorWriter) {
            errorWriter.flush()
            errorWriter.close()
            errorWriter = null
        } else {
            log.error "closeOutputFiles: Cannot close errorWriter"
        }
    }

    /**
     * Analyze first line: column headers.
     * @param columns Array with column names.
     */
    def analyzeFirstLine = { inputFile, columns ->
        log.info "${inputFile.name}: Found ${columns.size()} columns in first line: ${columns}"
        firstColumns = columns[0..-1].collect {
            it //it.replace('"', '')
        }
        firstColumns.eachWithIndex { col, colIdx ->
            columnPositionMap[col] = colIdx
        }
    }

    /**
     * 
     * @param pk Primary key.
     * @param lineNumber Actual line number in input file.
     * @param columns An array: an already-split-by-column-separator line.
     */
    def processLine = { inputFile, pk, lineNumber, columns ->
        try {
            // Check column count; a wrong column count may indicate:
            //   a last, broken line
            if (columns.size() != firstColumns.size()) {
                // Write skipped line into error log
                log.warn "WHATS THIS? ${columns}"
                // Write line to actual file
                if (!successWriter) {
                    setupOutputFiles()
                }
                errorWriter << columns.join(';') + '\r\n'
            } else { // Process line
                // Record primary key in actual line
                def pkValues = pk.collect {
                    def pos = columnPositionMap[it]
                    try {
                        columns[pos]
                    } catch (e) {
                        log.error "${inputFile.name}: Cannot record primary key in line ${lineNumber}, column #${pos}, columns=${columns}: ${e}"
                    }
                }.join("-") // If the primary key is made up of more than one value, they are joined by a dash
                // Check if the primary key had occurred before
                if (!seenPkValues.contains(pkValues)) {
                    // Remember it
                    seenPkValues << pkValues
                    // Write line to actual file
                    if (!successWriter) {
                        setupOutputFiles()
                    }
                    successWriter << columns.join(';') + '\r\n'
                } else { // Key occured before, split file at this line
                    log.warn "${inputFile.name}: Found DUPLICATE KEY '${pkValues}' at line ${lineNumber}"
                    // Reset seenPkValues
                    seenPkValues.clear()
                    // Split file: change the filename, write line and all remaining into a new file
                    closeOutputFiles()
                }
            }
        } catch (e) {
            log.error "${inputFile.name}: Cannot process line ${lineNumber}: ${e}"
        }
    }

    /**
     * Process a file.
     * @param pk Primary key.
     * @param columns An array: an already-split-by-column-separator line.
     */
    def processFile = { inputFile, pk, columns ->
        // First line contains column description: try to find primary key field(s)
        if (processedLineCount == 0) {
            // Analyze first line
            analyzeFirstLine(inputFile, columns)
            // Setup output files
            setupOutputFiles()
        } else {
            // Process line with data
            processLine(inputFile, pk, processedLineCount, columns)
        }
        // Increase line counter
        processedLineCount++
    }

    /**
     * Reset state. Used when a new input file is processed.
     */
    def resetState = {
        successFiles.clear()
        errorFiles.clear()
        processedLineCount = 0
        firstColumns.clear()
        columnPositionMap.clear()
        successWriter = null
        errorWriter = null
        filecount = -1
        filename = null
    }

    /**
     * Analyze a file and generate multiple files if duplicate keys are found.
     * 5 kB: '/Users/rbe/project/columbo/data/Case_End2End_20101019-095209.csv'
     * 399 MB: Case_End2End_20100818-093002
     * 428 MB: Case_End2End_20100819-093001
     * @param inputFile java.io.File
     * @return java.util.Map containing two keys: success for successfully imported files
     *         and error for file c
     */
    java.util.Map analyzeAndSplit(java.io.File inputFile) {
        try {
            // Reset state
            resetState()
            // Set actual file
            actualFile = inputFile
            // Guess charset
            actualCtk = new groovy.util.CharsetToolkit(inputFile)
            actualCharset = actualCtk.charset
            log.info "${inputFile.name}: Charset is ${actualCharset.name()}"
            // Get primary keys for actual file/table
            def pk
            grailsApplication.config.columbo.splitter.primaryKeys.each { k, v ->
                // Find key in filename
                def i = inputFile.name.toUpperCase().indexOf(k.toUpperCase())
                if (i > -1) {
                    pk = v
                }
            }
            // Read file line by line and split by column separator
            inputFile.splitEachLine(';', actualCharset.name(), { columns ->
                // First character 'bad' when reading UTF-16LE
                if (columns[0] != '"') {
                    columns[0] = columns[0][1..-1]
                }
                processFile(inputFile, pk, columns)
            })
            // Log total processed line count
            log.info "${inputFile.name}: Processed ${processedLineCount} lines"
        } catch (e) {
            log.error "${inputFile.name}: EXCEPTION: ${e} during processing"
            e.printStackTrace()
        } finally {
            closeOutputFiles()
            return [success: successFiles, error: errorFiles]
        }
    }
    
}
