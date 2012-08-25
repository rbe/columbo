/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 12:28 PM
 */

package eu.artofcoding.grownloader2.columbo.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class HpSvDlvrDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long hpSvDlvrId;

    private String caseId;

    private String subcaseId;

    private Date xDueDate;

    private String xServiceLocation;

    private String xAddress;

    private String xAddress2;

    private String xCity;

    private String xState;

    private String xZipcode;

    private String xIsoCountryCode;

    private Date xEarliestStartTime;

    private String xContactPhone;

    private String businessCenterName;

    private String region;

    private String district;

    private String engineerFirstName;

    private String engineerLastName;

    private Long timezoneId;

    private Date dateAdded;

    private Date dateModified;

    private Long xCeAcknowledgeFlag;

    private String xContactFirstName;

    private String xContactLastName;

    private String ceStatus;

    private Long xEstimatedTaskDuration;

    private String xCsrRefusedReason;

    private String xNlsCsrRefusedReason;

    private String xContactAltPhone;

    private String xContactEmail;

    private String xContactPrefLang;

    private String xAltContactFirstName;

    private String xAltContactLastName;

    private String xAltContactPhone;

    private String xAltContactAltPhone;

    private String xAltContactEmail;

    private String xAltContactPrefLang;

    private BigInteger xContactEditedFlag;

    private String xDepartment;

    private BigInteger xNoAutoDispatchFlag;

    private BigInteger xContactSurveyFlag;

    private BigInteger firstHpSkillRefId;

    private BigInteger activityLogId;

    public HpSvDlvrDm() {
    }

    public HpSvDlvrDm(Long hpSvDlvrId) {
        this.hpSvDlvrId = hpSvDlvrId;
    }

    public HpSvDlvrDm(Long hpSvDlvrId, String caseId) {
        this.hpSvDlvrId = hpSvDlvrId;
        this.caseId = caseId;
    }

    public Long getHpSvDlvrId() {
        return hpSvDlvrId;
    }

    public void setHpSvDlvrId(Long hpSvDlvrId) {
        this.hpSvDlvrId = hpSvDlvrId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getSubcaseId() {
        return subcaseId;
    }

    public void setSubcaseId(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public Date getXDueDate() {
        return xDueDate;
    }

    public void setXDueDate(Date xDueDate) {
        this.xDueDate = xDueDate;
    }

    public String getXServiceLocation() {
        return xServiceLocation;
    }

    public void setXServiceLocation(String xServiceLocation) {
        this.xServiceLocation = xServiceLocation;
    }

    public String getXAddress() {
        return xAddress;
    }

    public void setXAddress(String xAddress) {
        this.xAddress = xAddress;
    }

    public String getXAddress2() {
        return xAddress2;
    }

    public void setXAddress2(String xAddress2) {
        this.xAddress2 = xAddress2;
    }

    public String getXCity() {
        return xCity;
    }

    public void setXCity(String xCity) {
        this.xCity = xCity;
    }

    public String getXState() {
        return xState;
    }

    public void setXState(String xState) {
        this.xState = xState;
    }

    public String getXZipcode() {
        return xZipcode;
    }

    public void setXZipcode(String xZipcode) {
        this.xZipcode = xZipcode;
    }

    public String getXIsoCountryCode() {
        return xIsoCountryCode;
    }

    public void setXIsoCountryCode(String xIsoCountryCode) {
        this.xIsoCountryCode = xIsoCountryCode;
    }

    public Date getXEarliestStartTime() {
        return xEarliestStartTime;
    }

    public void setXEarliestStartTime(Date xEarliestStartTime) {
        this.xEarliestStartTime = xEarliestStartTime;
    }

    public String getXContactPhone() {
        return xContactPhone;
    }

    public void setXContactPhone(String xContactPhone) {
        this.xContactPhone = xContactPhone;
    }

    public String getBusinessCenterName() {
        return businessCenterName;
    }

    public void setBusinessCenterName(String businessCenterName) {
        this.businessCenterName = businessCenterName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEngineerFirstName() {
        return engineerFirstName;
    }

    public void setEngineerFirstName(String engineerFirstName) {
        this.engineerFirstName = engineerFirstName;
    }

    public String getEngineerLastName() {
        return engineerLastName;
    }

    public void setEngineerLastName(String engineerLastName) {
        this.engineerLastName = engineerLastName;
    }

    public Long getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Long timezoneId) {
        this.timezoneId = timezoneId;
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

    public Long getXCeAcknowledgeFlag() {
        return xCeAcknowledgeFlag;
    }

    public void setXCeAcknowledgeFlag(Long xCeAcknowledgeFlag) {
        this.xCeAcknowledgeFlag = xCeAcknowledgeFlag;
    }

    public String getXContactFirstName() {
        return xContactFirstName;
    }

    public void setXContactFirstName(String xContactFirstName) {
        this.xContactFirstName = xContactFirstName;
    }

    public String getXContactLastName() {
        return xContactLastName;
    }

    public void setXContactLastName(String xContactLastName) {
        this.xContactLastName = xContactLastName;
    }

    public String getCeStatus() {
        return ceStatus;
    }

    public void setCeStatus(String ceStatus) {
        this.ceStatus = ceStatus;
    }

    public Long getXEstimatedTaskDuration() {
        return xEstimatedTaskDuration;
    }

    public void setXEstimatedTaskDuration(Long xEstimatedTaskDuration) {
        this.xEstimatedTaskDuration = xEstimatedTaskDuration;
    }

    public String getXCsrRefusedReason() {
        return xCsrRefusedReason;
    }

    public void setXCsrRefusedReason(String xCsrRefusedReason) {
        this.xCsrRefusedReason = xCsrRefusedReason;
    }

    public String getXNlsCsrRefusedReason() {
        return xNlsCsrRefusedReason;
    }

    public void setXNlsCsrRefusedReason(String xNlsCsrRefusedReason) {
        this.xNlsCsrRefusedReason = xNlsCsrRefusedReason;
    }

    public String getXContactAltPhone() {
        return xContactAltPhone;
    }

    public void setXContactAltPhone(String xContactAltPhone) {
        this.xContactAltPhone = xContactAltPhone;
    }

    public String getXContactEmail() {
        return xContactEmail;
    }

    public void setXContactEmail(String xContactEmail) {
        this.xContactEmail = xContactEmail;
    }

    public String getXContactPrefLang() {
        return xContactPrefLang;
    }

    public void setXContactPrefLang(String xContactPrefLang) {
        this.xContactPrefLang = xContactPrefLang;
    }

    public String getXAltContactFirstName() {
        return xAltContactFirstName;
    }

    public void setXAltContactFirstName(String xAltContactFirstName) {
        this.xAltContactFirstName = xAltContactFirstName;
    }

    public String getXAltContactLastName() {
        return xAltContactLastName;
    }

    public void setXAltContactLastName(String xAltContactLastName) {
        this.xAltContactLastName = xAltContactLastName;
    }

    public String getXAltContactPhone() {
        return xAltContactPhone;
    }

    public void setXAltContactPhone(String xAltContactPhone) {
        this.xAltContactPhone = xAltContactPhone;
    }

    public String getXAltContactAltPhone() {
        return xAltContactAltPhone;
    }

    public void setXAltContactAltPhone(String xAltContactAltPhone) {
        this.xAltContactAltPhone = xAltContactAltPhone;
    }

    public String getXAltContactEmail() {
        return xAltContactEmail;
    }

    public void setXAltContactEmail(String xAltContactEmail) {
        this.xAltContactEmail = xAltContactEmail;
    }

    public String getXAltContactPrefLang() {
        return xAltContactPrefLang;
    }

    public void setXAltContactPrefLang(String xAltContactPrefLang) {
        this.xAltContactPrefLang = xAltContactPrefLang;
    }

    public BigInteger getXContactEditedFlag() {
        return xContactEditedFlag;
    }

    public void setXContactEditedFlag(BigInteger xContactEditedFlag) {
        this.xContactEditedFlag = xContactEditedFlag;
    }

    public String getXDepartment() {
        return xDepartment;
    }

    public void setXDepartment(String xDepartment) {
        this.xDepartment = xDepartment;
    }

    public BigInteger getXNoAutoDispatchFlag() {
        return xNoAutoDispatchFlag;
    }

    public void setXNoAutoDispatchFlag(BigInteger xNoAutoDispatchFlag) {
        this.xNoAutoDispatchFlag = xNoAutoDispatchFlag;
    }

    public BigInteger getXContactSurveyFlag() {
        return xContactSurveyFlag;
    }

    public void setXContactSurveyFlag(BigInteger xContactSurveyFlag) {
        this.xContactSurveyFlag = xContactSurveyFlag;
    }

    public BigInteger getFirstHpSkillRefId() {
        return firstHpSkillRefId;
    }

    public void setFirstHpSkillRefId(BigInteger firstHpSkillRefId) {
        this.firstHpSkillRefId = firstHpSkillRefId;
    }

    public BigInteger getActivityLogId() {
        return activityLogId;
    }

    public void setActivityLogId(BigInteger activityLogId) {
        this.activityLogId = activityLogId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (hpSvDlvrId != null ? hpSvDlvrId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpSvDlvrDm)) {
            return false;
        }
        HpSvDlvrDm other = (HpSvDlvrDm) object;
        if ((this.hpSvDlvrId == null && other.hpSvDlvrId != null) || (this.hpSvDlvrId != null && !this.hpSvDlvrId.equals(other.hpSvDlvrId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.HpSvDlvrDm[ hpSvDlvrId=" + hpSvDlvrId + " ]";
    }

}
