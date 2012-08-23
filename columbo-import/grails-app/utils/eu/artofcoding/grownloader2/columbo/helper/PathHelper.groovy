/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.corma.columbo.helper

class PathHelper {
    
    /**
     * 
     */
    static List splitBySeparator(String path) {
        def bs = '\\\\'   // double escaped
        def fs = '/'
        path.split(/$fs|$bs/)
    }
    
}
