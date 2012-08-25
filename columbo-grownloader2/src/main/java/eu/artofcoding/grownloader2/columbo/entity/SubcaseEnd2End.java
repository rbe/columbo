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
import java.math.BigInteger;
import java.util.Date;

public class SubcaseEnd2End implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subcaseId;

    private String accountabilityId;

    private String subcaseTrackingId;

    private String subcaseType;

    private String actionType;

    private String subcaseTitle;

    private String currentPriority;

    private String currentSeverity;

    private String currentStatus;

    private String conditionCodeValue;

    private Date commitDateGmt;

    private BigInteger nbReopen;

    private BigInteger numberEngineers;

    private BigInteger numberOwners;

    private String oieType;

    private String oieId;

    private Date crDateGmt;

    private String crLoginName;

    private String crWorkGroup;

    private String crEmployeeFirstName;

    private String crEmployeeLastName;

    private String crResponseCenter;

    private String crCountry;

    private BigInteger crTimeZoneId;

    private String firstStatusChange;

    private BigInteger timeToFirstRespMins;

    private Date irDateGmt;

    private String irLoginName;

    private String irWorkGroup;

    private String irEmployeeFirstName;

    private String irEmployeeLastName;

    private String irResponseCenter;

    private String irCountry;

    private BigInteger irTimeZoneId;

    private String laAtd;

    private Date laDateGmt;

    private String laLoginName;

    private String laWorkGroup;

    private String laEmployeeFirstName;

    private String laEmployeeLastName;

    private String laResponseCenter;

    private String laCountry;

    private BigInteger laTimeZoneId;

    private String owLoginName;

    private String owWorkGroup;

    private String owEmployeeFirstName;

    private String owEmployeeLastName;

    private String owResponseCenter;

    private String owCountry;

    private BigInteger owTimeZoneId;

    private Date clDateGmt;

    private String clLoginName;

    private String clWorkGroup;

    private String clEmployeeFirstName;

    private String clEmployeeLastName;

    private String clResponseCenter;

    private String clCountry;

    private BigInteger clTimeZoneId;

    private String summaryText;

    private String resolution;

    private BigInteger timeInOpenMins;

    private BigInteger elapsedTimeMins;

    private BigInteger timeInMonitorMins;

    private BigInteger ttlTimeInvestBillMins;

    private BigInteger ttlTimeInvestNonBillMins;

    private BigInteger ttlTimeInvestPhoneMins;

    private BigInteger ttlTimeInvestResearchMins;

    private String nlsSubcaseActionType;

    private String nlsPrioriy;

    private String nlsSeverity;

    private String nlsResolution;

    private Date dateModified;

    private BigInteger employeeOwner;

    private BigInteger employeeOriginator;

    private BigInteger employeeCloser;

    private Date dateAdded;

    private Long xDelayCd;

    private Long xTravelTimeMins;

    private String partnerId;

    private String partnerCoName;

    private Long obligatedLogToStart;

    private Long obligatedLogToClose;

    private BigInteger totalInvestedTimeMins;

    private String wdbDistrict;

    private String wdbProductLine;

    private String wdbWorkForce;

    private String wdbOffice;

    private String deliveryAlternative;

    private Date onsiteFixedDate;

    public SubcaseEnd2End() {
    }

    public SubcaseEnd2End(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public SubcaseEnd2End(String subcaseId, String subcaseTrackingId) {
        this.subcaseId = subcaseId;
        this.subcaseTrackingId = subcaseTrackingId;
    }

    public String getSubcaseId() {
        return subcaseId;
    }

    public void setSubcaseId(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public String getAccountabilityId() {
        return accountabilityId;
    }

    public void setAccountabilityId(String accountabilityId) {
        this.accountabilityId = accountabilityId;
    }

    public String getSubcaseTrackingId() {
        return subcaseTrackingId;
    }

    public void setSubcaseTrackingId(String subcaseTrackingId) {
        this.subcaseTrackingId = subcaseTrackingId;
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

    public String getCurrentPriority() {
        return currentPriority;
    }

    public void setCurrentPriority(String currentPriority) {
        this.currentPriority = currentPriority;
    }

    public String getCurrentSeverity() {
        return currentSeverity;
    }

    public void setCurrentSeverity(String currentSeverity) {
        this.currentSeverity = currentSeverity;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getConditionCodeValue() {
        return conditionCodeValue;
    }

    public void setConditionCodeValue(String conditionCodeValue) {
        this.conditionCodeValue = conditionCodeValue;
    }

    public Date getCommitDateGmt() {
        return commitDateGmt;
    }

    public void setCommitDateGmt(Date commitDateGmt) {
        this.commitDateGmt = commitDateGmt;
    }

    public BigInteger getNbReopen() {
        return nbReopen;
    }

    public void setNbReopen(BigInteger nbReopen) {
        this.nbReopen = nbReopen;
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

    public String getOieType() {
        return oieType;
    }

    public void setOieType(String oieType) {
        this.oieType = oieType;
    }

    public String getOieId() {
        return oieId;
    }

    public void setOieId(String oieId) {
        this.oieId = oieId;
    }

    public Date getCrDateGmt() {
        return crDateGmt;
    }

    public void setCrDateGmt(Date crDateGmt) {
        this.crDateGmt = crDateGmt;
    }

    public String getCrLoginName() {
        return crLoginName;
    }

    public void setCrLoginName(String crLoginName) {
        this.crLoginName = crLoginName;
    }

    public String getCrWorkGroup() {
        return crWorkGroup;
    }

    public void setCrWorkGroup(String crWorkGroup) {
        this.crWorkGroup = crWorkGroup;
    }

    public String getCrEmployeeFirstName() {
        return crEmployeeFirstName;
    }

    public void setCrEmployeeFirstName(String crEmployeeFirstName) {
        this.crEmployeeFirstName = crEmployeeFirstName;
    }

    public String getCrEmployeeLastName() {
        return crEmployeeLastName;
    }

    public void setCrEmployeeLastName(String crEmployeeLastName) {
        this.crEmployeeLastName = crEmployeeLastName;
    }

    public String getCrResponseCenter() {
        return crResponseCenter;
    }

    public void setCrResponseCenter(String crResponseCenter) {
        this.crResponseCenter = crResponseCenter;
    }

    public String getCrCountry() {
        return crCountry;
    }

    public void setCrCountry(String crCountry) {
        this.crCountry = crCountry;
    }

    public BigInteger getCrTimeZoneId() {
        return crTimeZoneId;
    }

    public void setCrTimeZoneId(BigInteger crTimeZoneId) {
        this.crTimeZoneId = crTimeZoneId;
    }

    public String getFirstStatusChange() {
        return firstStatusChange;
    }

    public void setFirstStatusChange(String firstStatusChange) {
        this.firstStatusChange = firstStatusChange;
    }

    public BigInteger getTimeToFirstRespMins() {
        return timeToFirstRespMins;
    }

    public void setTimeToFirstRespMins(BigInteger timeToFirstRespMins) {
        this.timeToFirstRespMins = timeToFirstRespMins;
    }

    public Date getIrDateGmt() {
        return irDateGmt;
    }

    public void setIrDateGmt(Date irDateGmt) {
        this.irDateGmt = irDateGmt;
    }

    public String getIrLoginName() {
        return irLoginName;
    }

    public void setIrLoginName(String irLoginName) {
        this.irLoginName = irLoginName;
    }

    public String getIrWorkGroup() {
        return irWorkGroup;
    }

    public void setIrWorkGroup(String irWorkGroup) {
        this.irWorkGroup = irWorkGroup;
    }

    public String getIrEmployeeFirstName() {
        return irEmployeeFirstName;
    }

    public void setIrEmployeeFirstName(String irEmployeeFirstName) {
        this.irEmployeeFirstName = irEmployeeFirstName;
    }

    public String getIrEmployeeLastName() {
        return irEmployeeLastName;
    }

    public void setIrEmployeeLastName(String irEmployeeLastName) {
        this.irEmployeeLastName = irEmployeeLastName;
    }

    public String getIrResponseCenter() {
        return irResponseCenter;
    }

    public void setIrResponseCenter(String irResponseCenter) {
        this.irResponseCenter = irResponseCenter;
    }

    public String getIrCountry() {
        return irCountry;
    }

    public void setIrCountry(String irCountry) {
        this.irCountry = irCountry;
    }

    public BigInteger getIrTimeZoneId() {
        return irTimeZoneId;
    }

    public void setIrTimeZoneId(BigInteger irTimeZoneId) {
        this.irTimeZoneId = irTimeZoneId;
    }

    public String getLaAtd() {
        return laAtd;
    }

    public void setLaAtd(String laAtd) {
        this.laAtd = laAtd;
    }

    public Date getLaDateGmt() {
        return laDateGmt;
    }

    public void setLaDateGmt(Date laDateGmt) {
        this.laDateGmt = laDateGmt;
    }

    public String getLaLoginName() {
        return laLoginName;
    }

    public void setLaLoginName(String laLoginName) {
        this.laLoginName = laLoginName;
    }

    public String getLaWorkGroup() {
        return laWorkGroup;
    }

    public void setLaWorkGroup(String laWorkGroup) {
        this.laWorkGroup = laWorkGroup;
    }

    public String getLaEmployeeFirstName() {
        return laEmployeeFirstName;
    }

    public void setLaEmployeeFirstName(String laEmployeeFirstName) {
        this.laEmployeeFirstName = laEmployeeFirstName;
    }

    public String getLaEmployeeLastName() {
        return laEmployeeLastName;
    }

    public void setLaEmployeeLastName(String laEmployeeLastName) {
        this.laEmployeeLastName = laEmployeeLastName;
    }

    public String getLaResponseCenter() {
        return laResponseCenter;
    }

    public void setLaResponseCenter(String laResponseCenter) {
        this.laResponseCenter = laResponseCenter;
    }

    public String getLaCountry() {
        return laCountry;
    }

    public void setLaCountry(String laCountry) {
        this.laCountry = laCountry;
    }

    public BigInteger getLaTimeZoneId() {
        return laTimeZoneId;
    }

    public void setLaTimeZoneId(BigInteger laTimeZoneId) {
        this.laTimeZoneId = laTimeZoneId;
    }

    public String getOwLoginName() {
        return owLoginName;
    }

    public void setOwLoginName(String owLoginName) {
        this.owLoginName = owLoginName;
    }

    public String getOwWorkGroup() {
        return owWorkGroup;
    }

    public void setOwWorkGroup(String owWorkGroup) {
        this.owWorkGroup = owWorkGroup;
    }

    public String getOwEmployeeFirstName() {
        return owEmployeeFirstName;
    }

    public void setOwEmployeeFirstName(String owEmployeeFirstName) {
        this.owEmployeeFirstName = owEmployeeFirstName;
    }

    public String getOwEmployeeLastName() {
        return owEmployeeLastName;
    }

    public void setOwEmployeeLastName(String owEmployeeLastName) {
        this.owEmployeeLastName = owEmployeeLastName;
    }

    public String getOwResponseCenter() {
        return owResponseCenter;
    }

    public void setOwResponseCenter(String owResponseCenter) {
        this.owResponseCenter = owResponseCenter;
    }

    public String getOwCountry() {
        return owCountry;
    }

    public void setOwCountry(String owCountry) {
        this.owCountry = owCountry;
    }

    public BigInteger getOwTimeZoneId() {
        return owTimeZoneId;
    }

    public void setOwTimeZoneId(BigInteger owTimeZoneId) {
        this.owTimeZoneId = owTimeZoneId;
    }

    public Date getClDateGmt() {
        return clDateGmt;
    }

    public void setClDateGmt(Date clDateGmt) {
        this.clDateGmt = clDateGmt;
    }

    public String getClLoginName() {
        return clLoginName;
    }

    public void setClLoginName(String clLoginName) {
        this.clLoginName = clLoginName;
    }

    public String getClWorkGroup() {
        return clWorkGroup;
    }

    public void setClWorkGroup(String clWorkGroup) {
        this.clWorkGroup = clWorkGroup;
    }

    public String getClEmployeeFirstName() {
        return clEmployeeFirstName;
    }

    public void setClEmployeeFirstName(String clEmployeeFirstName) {
        this.clEmployeeFirstName = clEmployeeFirstName;
    }

    public String getClEmployeeLastName() {
        return clEmployeeLastName;
    }

    public void setClEmployeeLastName(String clEmployeeLastName) {
        this.clEmployeeLastName = clEmployeeLastName;
    }

    public String getClResponseCenter() {
        return clResponseCenter;
    }

    public void setClResponseCenter(String clResponseCenter) {
        this.clResponseCenter = clResponseCenter;
    }

    public String getClCountry() {
        return clCountry;
    }

    public void setClCountry(String clCountry) {
        this.clCountry = clCountry;
    }

    public BigInteger getClTimeZoneId() {
        return clTimeZoneId;
    }

    public void setClTimeZoneId(BigInteger clTimeZoneId) {
        this.clTimeZoneId = clTimeZoneId;
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

    public BigInteger getTimeInOpenMins() {
        return timeInOpenMins;
    }

    public void setTimeInOpenMins(BigInteger timeInOpenMins) {
        this.timeInOpenMins = timeInOpenMins;
    }

    public BigInteger getElapsedTimeMins() {
        return elapsedTimeMins;
    }

    public void setElapsedTimeMins(BigInteger elapsedTimeMins) {
        this.elapsedTimeMins = elapsedTimeMins;
    }

    public BigInteger getTimeInMonitorMins() {
        return timeInMonitorMins;
    }

    public void setTimeInMonitorMins(BigInteger timeInMonitorMins) {
        this.timeInMonitorMins = timeInMonitorMins;
    }

    public BigInteger getTtlTimeInvestBillMins() {
        return ttlTimeInvestBillMins;
    }

    public void setTtlTimeInvestBillMins(BigInteger ttlTimeInvestBillMins) {
        this.ttlTimeInvestBillMins = ttlTimeInvestBillMins;
    }

    public BigInteger getTtlTimeInvestNonBillMins() {
        return ttlTimeInvestNonBillMins;
    }

    public void setTtlTimeInvestNonBillMins(BigInteger ttlTimeInvestNonBillMins) {
        this.ttlTimeInvestNonBillMins = ttlTimeInvestNonBillMins;
    }

    public BigInteger getTtlTimeInvestPhoneMins() {
        return ttlTimeInvestPhoneMins;
    }

    public void setTtlTimeInvestPhoneMins(BigInteger ttlTimeInvestPhoneMins) {
        this.ttlTimeInvestPhoneMins = ttlTimeInvestPhoneMins;
    }

    public BigInteger getTtlTimeInvestResearchMins() {
        return ttlTimeInvestResearchMins;
    }

    public void setTtlTimeInvestResearchMins(BigInteger ttlTimeInvestResearchMins) {
        this.ttlTimeInvestResearchMins = ttlTimeInvestResearchMins;
    }

    public String getNlsSubcaseActionType() {
        return nlsSubcaseActionType;
    }

    public void setNlsSubcaseActionType(String nlsSubcaseActionType) {
        this.nlsSubcaseActionType = nlsSubcaseActionType;
    }

    public String getNlsPrioriy() {
        return nlsPrioriy;
    }

    public void setNlsPrioriy(String nlsPrioriy) {
        this.nlsPrioriy = nlsPrioriy;
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

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public BigInteger getEmployeeOwner() {
        return employeeOwner;
    }

    public void setEmployeeOwner(BigInteger employeeOwner) {
        this.employeeOwner = employeeOwner;
    }

    public BigInteger getEmployeeOriginator() {
        return employeeOriginator;
    }

    public void setEmployeeOriginator(BigInteger employeeOriginator) {
        this.employeeOriginator = employeeOriginator;
    }

    public BigInteger getEmployeeCloser() {
        return employeeCloser;
    }

    public void setEmployeeCloser(BigInteger employeeCloser) {
        this.employeeCloser = employeeCloser;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Long getXDelayCd() {
        return xDelayCd;
    }

    public void setXDelayCd(Long xDelayCd) {
        this.xDelayCd = xDelayCd;
    }

    public Long getXTravelTimeMins() {
        return xTravelTimeMins;
    }

    public void setXTravelTimeMins(Long xTravelTimeMins) {
        this.xTravelTimeMins = xTravelTimeMins;
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

    public BigInteger getTotalInvestedTimeMins() {
        return totalInvestedTimeMins;
    }

    public void setTotalInvestedTimeMins(BigInteger totalInvestedTimeMins) {
        this.totalInvestedTimeMins = totalInvestedTimeMins;
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

    public String getDeliveryAlternative() {
        return deliveryAlternative;
    }

    public void setDeliveryAlternative(String deliveryAlternative) {
        this.deliveryAlternative = deliveryAlternative;
    }

    public Date getOnsiteFixedDate() {
        return onsiteFixedDate;
    }

    public void setOnsiteFixedDate(Date onsiteFixedDate) {
        this.onsiteFixedDate = onsiteFixedDate;
    }

    public int hashCode() {
        int hash = 0;
        hash += (subcaseId != null ? subcaseId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcaseEnd2End)) {
            return false;
        }
        SubcaseEnd2End other = (SubcaseEnd2End) object;
        if ((this.subcaseId == null && other.subcaseId != null) || (this.subcaseId != null && !this.subcaseId.equals(other.subcaseId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.SubcaseEnd2End[ subcaseId=" + subcaseId + " ]";
    }

}
