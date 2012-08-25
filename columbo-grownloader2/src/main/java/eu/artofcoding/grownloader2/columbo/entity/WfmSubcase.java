/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 12:06 PM
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.artofcoding.grownloader2.columbo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class WfmSubcase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subcaseId;

    private String subcaseTrackingId;

    private String caseAccountabilityId;

    private String subcaseType;

    private String actionType;

    private String subcaseTitle;

    private String priority;

    private String severity;

    private Date commitDate;

    private BigInteger commitDateId;

    private String status;

    private BigInteger numberEngineers;

    private BigInteger numberOwners;

    private Date openDate;

    private BigInteger openDateId;

    private BigInteger employeeOriginator;

    private BigInteger responseTimeActual;

    private BigInteger employeeOwner;

    private Date closeDate;

    private BigInteger closeDateId;

    private BigInteger employeeCloser;

    private String summaryText;

    private String resolution;

    private BigInteger timeInOpen;

    private BigInteger elapsedTime;

    private BigInteger timeInMonitor;

    private BigInteger timeInvestedTeBillable;

    private BigInteger timeInvestedTeNonBillable;

    private BigInteger timeInvestedPhone;

    private BigInteger timeInvestedResearch;

    private Date dateAdded;

    private Date dateModified;

    private BigInteger conditionCode;

    private String conditionCodeValue;

    private String nlsSubcaseActionType;

    private String nlsPriority;

    private String nlsSeverity;

    private String nlsResolution;

    private String oieId;

    private String oieType;

    private BigInteger actlPhoneTime;

    private BigInteger actlResearchTime;

    private String xRepairClass;

    private String xSystemPartNumber;

    private String xSystemSerialNo;

    private String xOtc;

    private Long xDelayCd;

    private Long xTravelTime;

    private String partnerId;

    private String partnerCoName;

    private Long daysOpen;

    private Long obligatedLogToStart;

    private Long obligatedLogToClose;

    private BigInteger totalInvestedTime;

    private String wdbDistrict;

    private String wdbProductLine;

    private String wdbWorkForce;

    private String wdbOffice;

    private Short depotNtfFlag;

    private String subcaseSvcCat;

    private Integer partQtyUsed;

    private String deliveryAlternative;

    private Integer numPartsRecommended;

    private Short noPartsRecommended;

    private Short partsRecommendedNpu;
    // 

    private BigDecimal partsDiagnosisAccuracy;

    private BigDecimal partsDiagnosisEfficiency;

    private Short m9Npu;

    private String xFmnCso;

    private Date requiredDate;

    private String preferredEngineerFirstName;

    private String preferredEngineerLastName;

    private String backupEngineerFirstName;

    private String backupEngineerLastName;

    private String xServiceLocation;

    private String xTravelZone;

    private String qualifierEmpNo;

    private String partStatus;

    private String onsiteOffsiteFl;

    private Date onsiteFixedDate;

    private Date onsiteStartDate;

    private Date onsiteStopDate;

    private Date offsiteStartDate;

    private Date offsiteStopDate;

    private Long rmRevisionCounter;

    private String xPartNumber;

    private String xServiceNoteNumber;

    private String systemPartDescription;

    private Long currentQueueId;

    private String xSerialNo;

    private String pspId;

    private String ceStatus;

    private Short voidResolutionFlag;

    private BigInteger previousEmployeeOwner;

    public WfmSubcase() {
    }

    public WfmSubcase(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public WfmSubcase(String subcaseId, String subcaseTrackingId) {
        this.subcaseId = subcaseId;
        this.subcaseTrackingId = subcaseTrackingId;
    }

    public String getSubcaseId() {
        return subcaseId;
    }

    public void setSubcaseId(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public String getSubcaseTrackingId() {
        return subcaseTrackingId;
    }

    public void setSubcaseTrackingId(String subcaseTrackingId) {
        this.subcaseTrackingId = subcaseTrackingId;
    }

    public String getCaseAccountabilityId() {
        return caseAccountabilityId;
    }

    public void setCaseAccountabilityId(String caseAccountabilityId) {
        this.caseAccountabilityId = caseAccountabilityId;
    }

    public String getSubcaseType() {
        return subcaseType;
    }

    public void setSubcaseType(String subcaseType) {
        this.subcaseType = subcaseType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getSubcaseTitle() {
        return subcaseTitle;
    }

    public void setSubcaseTitle(String subcaseTitle) {
        this.subcaseTitle = subcaseTitle;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public BigInteger getCommitDateId() {
        return commitDateId;
    }

    public void setCommitDateId(BigInteger commitDateId) {
        this.commitDateId = commitDateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getNumberEngineers() {
        return numberEngineers;
    }

    public void setNumberEngineers(BigInteger numberEngineers) {
        this.numberEngineers = numberEngineers;
    }

    public BigInteger getNumberOwners() {
        return numberOwners;
    }

    public void setNumberOwners(BigInteger numberOwners) {
        this.numberOwners = numberOwners;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public BigInteger getOpenDateId() {
        return openDateId;
    }

    public void setOpenDateId(BigInteger openDateId) {
        this.openDateId = openDateId;
    }

    public BigInteger getEmployeeOriginator() {
        return employeeOriginator;
    }

    public void setEmployeeOriginator(BigInteger employeeOriginator) {
        this.employeeOriginator = employeeOriginator;
    }

    public BigInteger getResponseTimeActual() {
        return responseTimeActual;
    }

    public void setResponseTimeActual(BigInteger responseTimeActual) {
        this.responseTimeActual = responseTimeActual;
    }

    public BigInteger getEmployeeOwner() {
        return employeeOwner;
    }

    public void setEmployeeOwner(BigInteger employeeOwner) {
        this.employeeOwner = employeeOwner;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public BigInteger getCloseDateId() {
        return closeDateId;
    }

    public void setCloseDateId(BigInteger closeDateId) {
        this.closeDateId = closeDateId;
    }

    public BigInteger getEmployeeCloser() {
        return employeeCloser;
    }

    public void setEmployeeCloser(BigInteger employeeCloser) {
        this.employeeCloser = employeeCloser;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public BigInteger getTimeInOpen() {
        return timeInOpen;
    }

    public void setTimeInOpen(BigInteger timeInOpen) {
        this.timeInOpen = timeInOpen;
    }

    public BigInteger getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(BigInteger elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public BigInteger getTimeInMonitor() {
        return timeInMonitor;
    }

    public void setTimeInMonitor(BigInteger timeInMonitor) {
        this.timeInMonitor = timeInMonitor;
    }

    public BigInteger getTimeInvestedTeBillable() {
        return timeInvestedTeBillable;
    }

    public void setTimeInvestedTeBillable(BigInteger timeInvestedTeBillable) {
        this.timeInvestedTeBillable = timeInvestedTeBillable;
    }

    public BigInteger getTimeInvestedTeNonBillable() {
        return timeInvestedTeNonBillable;
    }

    public void setTimeInvestedTeNonBillable(BigInteger timeInvestedTeNonBillable) {
        this.timeInvestedTeNonBillable = timeInvestedTeNonBillable;
    }

    public BigInteger getTimeInvestedPhone() {
        return timeInvestedPhone;
    }

    public void setTimeInvestedPhone(BigInteger timeInvestedPhone) {
        this.timeInvestedPhone = timeInvestedPhone;
    }

    public BigInteger getTimeInvestedResearch() {
        return timeInvestedResearch;
    }

    public void setTimeInvestedResearch(BigInteger timeInvestedResearch) {
        this.timeInvestedResearch = timeInvestedResearch;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public BigInteger getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(BigInteger conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getConditionCodeValue() {
        return conditionCodeValue;
    }

    public void setConditionCodeValue(String conditionCodeValue) {
        this.conditionCodeValue = conditionCodeValue;
    }

    public String getNlsSubcaseActionType() {
        return nlsSubcaseActionType;
    }

    public void setNlsSubcaseActionType(String nlsSubcaseActionType) {
        this.nlsSubcaseActionType = nlsSubcaseActionType;
    }

    public String getNlsPriority() {
        return nlsPriority;
    }

    public void setNlsPriority(String nlsPriority) {
        this.nlsPriority = nlsPriority;
    }

    public String getNlsSeverity() {
        return nlsSeverity;
    }

    public void setNlsSeverity(String nlsSeverity) {
        this.nlsSeverity = nlsSeverity;
    }

    public String getNlsResolution() {
        return nlsResolution;
    }

    public void setNlsResolution(String nlsResolution) {
        this.nlsResolution = nlsResolution;
    }

    public String getOieId() {
        return oieId;
    }

    public void setOieId(String oieId) {
        this.oieId = oieId;
    }

    public String getOieType() {
        return oieType;
    }

    public void setOieType(String oieType) {
        this.oieType = oieType;
    }

    public BigInteger getActlPhoneTime() {
        return actlPhoneTime;
    }

    public void setActlPhoneTime(BigInteger actlPhoneTime) {
        this.actlPhoneTime = actlPhoneTime;
    }

    public BigInteger getActlResearchTime() {
        return actlResearchTime;
    }

    public void setActlResearchTime(BigInteger actlResearchTime) {
        this.actlResearchTime = actlResearchTime;
    }

    public String getXRepairClass() {
        return xRepairClass;
    }

    public void setXRepairClass(String xRepairClass) {
        this.xRepairClass = xRepairClass;
    }

    public String getXSystemPartNumber() {
        return xSystemPartNumber;
    }

    public void setXSystemPartNumber(String xSystemPartNumber) {
        this.xSystemPartNumber = xSystemPartNumber;
    }

    public String getXSystemSerialNo() {
        return xSystemSerialNo;
    }

    public void setXSystemSerialNo(String xSystemSerialNo) {
        this.xSystemSerialNo = xSystemSerialNo;
    }

    public String getXOtc() {
        return xOtc;
    }

    public void setXOtc(String xOtc) {
        this.xOtc = xOtc;
    }

    public Long getXDelayCd() {
        return xDelayCd;
    }

    public void setXDelayCd(Long xDelayCd) {
        this.xDelayCd = xDelayCd;
    }

    public Long getXTravelTime() {
        return xTravelTime;
    }

    public void setXTravelTime(Long xTravelTime) {
        this.xTravelTime = xTravelTime;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerCoName() {
        return partnerCoName;
    }

    public void setPartnerCoName(String partnerCoName) {
        this.partnerCoName = partnerCoName;
    }

    public Long getDaysOpen() {
        return daysOpen;
    }

    public void setDaysOpen(Long daysOpen) {
        this.daysOpen = daysOpen;
    }

    public Long getObligatedLogToStart() {
        return obligatedLogToStart;
    }

    public void setObligatedLogToStart(Long obligatedLogToStart) {
        this.obligatedLogToStart = obligatedLogToStart;
    }

    public Long getObligatedLogToClose() {
        return obligatedLogToClose;
    }

    public void setObligatedLogToClose(Long obligatedLogToClose) {
        this.obligatedLogToClose = obligatedLogToClose;
    }

    public BigInteger getTotalInvestedTime() {
        return totalInvestedTime;
    }

    public void setTotalInvestedTime(BigInteger totalInvestedTime) {
        this.totalInvestedTime = totalInvestedTime;
    }

    public String getWdbDistrict() {
        return wdbDistrict;
    }

    public void setWdbDistrict(String wdbDistrict) {
        this.wdbDistrict = wdbDistrict;
    }

    public String getWdbProductLine() {
        return wdbProductLine;
    }

    public void setWdbProductLine(String wdbProductLine) {
        this.wdbProductLine = wdbProductLine;
    }

    public String getWdbWorkForce() {
        return wdbWorkForce;
    }

    public void setWdbWorkForce(String wdbWorkForce) {
        this.wdbWorkForce = wdbWorkForce;
    }

    public String getWdbOffice() {
        return wdbOffice;
    }

    public void setWdbOffice(String wdbOffice) {
        this.wdbOffice = wdbOffice;
    }

    public Short getDepotNtfFlag() {
        return depotNtfFlag;
    }

    public void setDepotNtfFlag(Short depotNtfFlag) {
        this.depotNtfFlag = depotNtfFlag;
    }

    public String getSubcaseSvcCat() {
        return subcaseSvcCat;
    }

    public void setSubcaseSvcCat(String subcaseSvcCat) {
        this.subcaseSvcCat = subcaseSvcCat;
    }

    public Integer getPartQtyUsed() {
        return partQtyUsed;
    }

    public void setPartQtyUsed(Integer partQtyUsed) {
        this.partQtyUsed = partQtyUsed;
    }

    public String getDeliveryAlternative() {
        return deliveryAlternative;
    }

    public void setDeliveryAlternative(String deliveryAlternative) {
        this.deliveryAlternative = deliveryAlternative;
    }

    public Integer getNumPartsRecommended() {
        return numPartsRecommended;
    }

    public void setNumPartsRecommended(Integer numPartsRecommended) {
        this.numPartsRecommended = numPartsRecommended;
    }

    public Short getNoPartsRecommended() {
        return noPartsRecommended;
    }

    public void setNoPartsRecommended(Short noPartsRecommended) {
        this.noPartsRecommended = noPartsRecommended;
    }

    public Short getPartsRecommendedNpu() {
        return partsRecommendedNpu;
    }

    public void setPartsRecommendedNpu(Short partsRecommendedNpu) {
        this.partsRecommendedNpu = partsRecommendedNpu;
    }

    public BigDecimal getPartsDiagnosisAccuracy() {
        return partsDiagnosisAccuracy;
    }

    public void setPartsDiagnosisAccuracy(BigDecimal partsDiagnosisAccuracy) {
        this.partsDiagnosisAccuracy = partsDiagnosisAccuracy;
    }

    public BigDecimal getPartsDiagnosisEfficiency() {
        return partsDiagnosisEfficiency;
    }

    public void setPartsDiagnosisEfficiency(BigDecimal partsDiagnosisEfficiency) {
        this.partsDiagnosisEfficiency = partsDiagnosisEfficiency;
    }

    public Short getM9Npu() {
        return m9Npu;
    }

    public void setM9Npu(Short m9Npu) {
        this.m9Npu = m9Npu;
    }

    public String getXFmnCso() {
        return xFmnCso;
    }

    public void setXFmnCso(String xFmnCso) {
        this.xFmnCso = xFmnCso;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getPreferredEngineerFirstName() {
        return preferredEngineerFirstName;
    }

    public void setPreferredEngineerFirstName(String preferredEngineerFirstName) {
        this.preferredEngineerFirstName = preferredEngineerFirstName;
    }

    public String getPreferredEngineerLastName() {
        return preferredEngineerLastName;
    }

    public void setPreferredEngineerLastName(String preferredEngineerLastName) {
        this.preferredEngineerLastName = preferredEngineerLastName;
    }

    public String getBackupEngineerFirstName() {
        return backupEngineerFirstName;
    }

    public void setBackupEngineerFirstName(String backupEngineerFirstName) {
        this.backupEngineerFirstName = backupEngineerFirstName;
    }

    public String getBackupEngineerLastName() {
        return backupEngineerLastName;
    }

    public void setBackupEngineerLastName(String backupEngineerLastName) {
        this.backupEngineerLastName = backupEngineerLastName;
    }

    public String getXServiceLocation() {
        return xServiceLocation;
    }

    public void setXServiceLocation(String xServiceLocation) {
        this.xServiceLocation = xServiceLocation;
    }

    public String getXTravelZone() {
        return xTravelZone;
    }

    public void setXTravelZone(String xTravelZone) {
        this.xTravelZone = xTravelZone;
    }

    public String getQualifierEmpNo() {
        return qualifierEmpNo;
    }

    public void setQualifierEmpNo(String qualifierEmpNo) {
        this.qualifierEmpNo = qualifierEmpNo;
    }

    public String getPartStatus() {
        return partStatus;
    }

    public void setPartStatus(String partStatus) {
        this.partStatus = partStatus;
    }

    public String getOnsiteOffsiteFl() {
        return onsiteOffsiteFl;
    }

    public void setOnsiteOffsiteFl(String onsiteOffsiteFl) {
        this.onsiteOffsiteFl = onsiteOffsiteFl;
    }

    public Date getOnsiteFixedDate() {
        return onsiteFixedDate;
    }

    public void setOnsiteFixedDate(Date onsiteFixedDate) {
        this.onsiteFixedDate = onsiteFixedDate;
    }

    public Date getOnsiteStartDate() {
        return onsiteStartDate;
    }

    public void setOnsiteStartDate(Date onsiteStartDate) {
        this.onsiteStartDate = onsiteStartDate;
    }

    public Date getOnsiteStopDate() {
        return onsiteStopDate;
    }

    public void setOnsiteStopDate(Date onsiteStopDate) {
        this.onsiteStopDate = onsiteStopDate;
    }

    public Date getOffsiteStartDate() {
        return offsiteStartDate;
    }

    public void setOffsiteStartDate(Date offsiteStartDate) {
        this.offsiteStartDate = offsiteStartDate;
    }

    public Date getOffsiteStopDate() {
        return offsiteStopDate;
    }

    public void setOffsiteStopDate(Date offsiteStopDate) {
        this.offsiteStopDate = offsiteStopDate;
    }

    public Long getRmRevisionCounter() {
        return rmRevisionCounter;
    }

    public void setRmRevisionCounter(Long rmRevisionCounter) {
        this.rmRevisionCounter = rmRevisionCounter;
    }

    public String getXPartNumber() {
        return xPartNumber;
    }

    public void setXPartNumber(String xPartNumber) {
        this.xPartNumber = xPartNumber;
    }

    public String getXServiceNoteNumber() {
        return xServiceNoteNumber;
    }

    public void setXServiceNoteNumber(String xServiceNoteNumber) {
        this.xServiceNoteNumber = xServiceNoteNumber;
    }

    public String getSystemPartDescription() {
        return systemPartDescription;
    }

    public void setSystemPartDescription(String systemPartDescription) {
        this.systemPartDescription = systemPartDescription;
    }

    public Long getCurrentQueueId() {
        return currentQueueId;
    }

    public void setCurrentQueueId(Long currentQueueId) {
        this.currentQueueId = currentQueueId;
    }

    public String getXSerialNo() {
        return xSerialNo;
    }

    public void setXSerialNo(String xSerialNo) {
        this.xSerialNo = xSerialNo;
    }

    public String getPspId() {
        return pspId;
    }

    public void setPspId(String pspId) {
        this.pspId = pspId;
    }

    public String getCeStatus() {
        return ceStatus;
    }

    public void setCeStatus(String ceStatus) {
        this.ceStatus = ceStatus;
    }

    public Short getVoidResolutionFlag() {
        return voidResolutionFlag;
    }

    public void setVoidResolutionFlag(Short voidResolutionFlag) {
        this.voidResolutionFlag = voidResolutionFlag;
    }

    public BigInteger getPreviousEmployeeOwner() {
        return previousEmployeeOwner;
    }

    public void setPreviousEmployeeOwner(BigInteger previousEmployeeOwner) {
        this.previousEmployeeOwner = previousEmployeeOwner;
    }

    public int hashCode() {
        int hash = 0;
        hash += (subcaseId != null ? subcaseId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfmSubcase)) {
            return false;
        }
        WfmSubcase other = (WfmSubcase) object;
        if ((this.subcaseId == null && other.subcaseId != null) || (this.subcaseId != null && !this.subcaseId.equals(other.subcaseId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.WfmSubcase[ subcaseId=" + subcaseId + " ]";
    }

}
