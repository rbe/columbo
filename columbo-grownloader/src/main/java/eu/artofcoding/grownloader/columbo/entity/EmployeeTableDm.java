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

package eu.artofcoding.grownloader.columbo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class EmployeeTableDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal employeeTableId;

    private String coreProcessDesc;

    private String country;

    private String employeeFirstName;

    private String employeeId;

    private String employeeLastName;

    private String employeeSite;

    private String employeeSiteId;

    private BigInteger employeeSupvrId;

    private String location;

    private String loginName;

    private String region;

    private String responseCenter;

    private String organization;

    private BigInteger timeZoneId;

    private String workGroup;

    private Date dateAdded;

    private Date dateModified;

    private String employeePhone;

    private String blueRedCd;

    private String pagerPhone;

    private String pagerPin;

    private String assignBadgeNum;

    private String activeFlag;

    private Short actingSupvrFlag;

    private String employeeType;

    private String wdbOffice;

    private String wdbScs;

    private Long userTableId;

    private String rcConfigName;

    private String privAccessClassName;

    private String privOfflineClassName;

    private String employeeEmail;

    private String xCeApplication;

    public EmployeeTableDm() {
    }

    public EmployeeTableDm(BigDecimal employeeTableId) {
        this.employeeTableId = employeeTableId;
    }

    public EmployeeTableDm(BigDecimal employeeTableId, BigInteger timeZoneId) {
        this.employeeTableId = employeeTableId;
        this.timeZoneId = timeZoneId;
    }

    public BigDecimal getEmployeeTableId() {
        return employeeTableId;
    }

    public void setEmployeeTableId(BigDecimal employeeTableId) {
        this.employeeTableId = employeeTableId;
    }

    public String getCoreProcessDesc() {
        return coreProcessDesc;
    }

    public void setCoreProcessDesc(String coreProcessDesc) {
        this.coreProcessDesc = coreProcessDesc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeSite() {
        return employeeSite;
    }

    public void setEmployeeSite(String employeeSite) {
        this.employeeSite = employeeSite;
    }

    public String getEmployeeSiteId() {
        return employeeSiteId;
    }

    public void setEmployeeSiteId(String employeeSiteId) {
        this.employeeSiteId = employeeSiteId;
    }

    public BigInteger getEmployeeSupvrId() {
        return employeeSupvrId;
    }

    public void setEmployeeSupvrId(BigInteger employeeSupvrId) {
        this.employeeSupvrId = employeeSupvrId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResponseCenter() {
        return responseCenter;
    }

    public void setResponseCenter(String responseCenter) {
        this.responseCenter = responseCenter;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public BigInteger getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(BigInteger timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
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

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getBlueRedCd() {
        return blueRedCd;
    }

    public void setBlueRedCd(String blueRedCd) {
        this.blueRedCd = blueRedCd;
    }

    public String getPagerPhone() {
        return pagerPhone;
    }

    public void setPagerPhone(String pagerPhone) {
        this.pagerPhone = pagerPhone;
    }

    public String getPagerPin() {
        return pagerPin;
    }

    public void setPagerPin(String pagerPin) {
        this.pagerPin = pagerPin;
    }

    public String getAssignBadgeNum() {
        return assignBadgeNum;
    }

    public void setAssignBadgeNum(String assignBadgeNum) {
        this.assignBadgeNum = assignBadgeNum;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Short getActingSupvrFlag() {
        return actingSupvrFlag;
    }

    public void setActingSupvrFlag(Short actingSupvrFlag) {
        this.actingSupvrFlag = actingSupvrFlag;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getWdbOffice() {
        return wdbOffice;
    }

    public void setWdbOffice(String wdbOffice) {
        this.wdbOffice = wdbOffice;
    }

    public String getWdbScs() {
        return wdbScs;
    }

    public void setWdbScs(String wdbScs) {
        this.wdbScs = wdbScs;
    }

    public Long getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(Long userTableId) {
        this.userTableId = userTableId;
    }

    public String getRcConfigName() {
        return rcConfigName;
    }

    public void setRcConfigName(String rcConfigName) {
        this.rcConfigName = rcConfigName;
    }

    public String getPrivAccessClassName() {
        return privAccessClassName;
    }

    public void setPrivAccessClassName(String privAccessClassName) {
        this.privAccessClassName = privAccessClassName;
    }

    public String getPrivOfflineClassName() {
        return privOfflineClassName;
    }

    public void setPrivOfflineClassName(String privOfflineClassName) {
        this.privOfflineClassName = privOfflineClassName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getXCeApplication() {
        return xCeApplication;
    }

    public void setXCeApplication(String xCeApplication) {
        this.xCeApplication = xCeApplication;
    }

    public int hashCode() {
        int hash = 0;
        hash += (employeeTableId != null ? employeeTableId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTableDm)) {
            return false;
        }
        EmployeeTableDm other = (EmployeeTableDm) object;
        if ((this.employeeTableId == null && other.employeeTableId != null) || (this.employeeTableId != null && !this.employeeTableId.equals(other.employeeTableId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader.columbo.entity.EmployeeTableDm[ employeeTableId=" + employeeTableId + " ]";
    }

}
