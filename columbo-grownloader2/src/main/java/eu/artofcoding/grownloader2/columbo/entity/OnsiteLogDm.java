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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OnsiteLogDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long onsiteLogId;

    private String accountabilityId;

    private String caseId;

    private String caseSubcase;

    private Date creationTime;

    private long employeeTableId;

    private String workGroup;

    private Long xBillableOvertime;

    private Long billableTime;

    private Long nonBillTime;

    private Long totalTime;

    private BigInteger billableExp;

    private BigInteger nonBillExp;

    private BigInteger totalExp;

    private String resolution;

    private BigDecimal xTravelTime;

    private Date xFixedTime;

    private Date xActualStartTime;

    private Date xActualStopTime;

    private BigDecimal xLaborCharge;

    private Date dateModified;

    private Long xNonBillOvertime;

    private Long xAgreedDowntime;

    private String notes;

    private String internalNotes;

    private String perfBy;

    private BigInteger creationTimeId;

    public OnsiteLogDm() {
    }

    public OnsiteLogDm(Long onsiteLogId) {
        this.onsiteLogId = onsiteLogId;
    }

    public OnsiteLogDm(Long onsiteLogId, long employeeTableId) {
        this.onsiteLogId = onsiteLogId;
        this.employeeTableId = employeeTableId;
    }

    public Long getOnsiteLogId() {
        return onsiteLogId;
    }

    public void setOnsiteLogId(Long onsiteLogId) {
        this.onsiteLogId = onsiteLogId;
    }

    public String getAccountabilityId() {
        return accountabilityId;
    }

    public void setAccountabilityId(String accountabilityId) {
        this.accountabilityId = accountabilityId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseSubcase() {
        return caseSubcase;
    }

    public void setCaseSubcase(String caseSubcase) {
        this.caseSubcase = caseSubcase;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public long getEmployeeTableId() {
        return employeeTableId;
    }

    public void setEmployeeTableId(long employeeTableId) {
        this.employeeTableId = employeeTableId;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    public Long getXBillableOvertime() {
        return xBillableOvertime;
    }

    public void setXBillableOvertime(Long xBillableOvertime) {
        this.xBillableOvertime = xBillableOvertime;
    }

    public Long getBillableTime() {
        return billableTime;
    }

    public void setBillableTime(Long billableTime) {
        this.billableTime = billableTime;
    }

    public Long getNonBillTime() {
        return nonBillTime;
    }

    public void setNonBillTime(Long nonBillTime) {
        this.nonBillTime = nonBillTime;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public BigInteger getBillableExp() {
        return billableExp;
    }

    public void setBillableExp(BigInteger billableExp) {
        this.billableExp = billableExp;
    }

    public BigInteger getNonBillExp() {
        return nonBillExp;
    }

    public void setNonBillExp(BigInteger nonBillExp) {
        this.nonBillExp = nonBillExp;
    }

    public BigInteger getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(BigInteger totalExp) {
        this.totalExp = totalExp;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public BigDecimal getXTravelTime() {
        return xTravelTime;
    }

    public void setXTravelTime(BigDecimal xTravelTime) {
        this.xTravelTime = xTravelTime;
    }

    public Date getXFixedTime() {
        return xFixedTime;
    }

    public void setXFixedTime(Date xFixedTime) {
        this.xFixedTime = xFixedTime;
    }

    public Date getXActualStartTime() {
        return xActualStartTime;
    }

    public void setXActualStartTime(Date xActualStartTime) {
        this.xActualStartTime = xActualStartTime;
    }

    public Date getXActualStopTime() {
        return xActualStopTime;
    }

    public void setXActualStopTime(Date xActualStopTime) {
        this.xActualStopTime = xActualStopTime;
    }

    public BigDecimal getXLaborCharge() {
        return xLaborCharge;
    }

    public void setXLaborCharge(BigDecimal xLaborCharge) {
        this.xLaborCharge = xLaborCharge;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Long getXNonBillOvertime() {
        return xNonBillOvertime;
    }

    public void setXNonBillOvertime(Long xNonBillOvertime) {
        this.xNonBillOvertime = xNonBillOvertime;
    }

    public Long getXAgreedDowntime() {
        return xAgreedDowntime;
    }

    public void setXAgreedDowntime(Long xAgreedDowntime) {
        this.xAgreedDowntime = xAgreedDowntime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public String getPerfBy() {
        return perfBy;
    }

    public void setPerfBy(String perfBy) {
        this.perfBy = perfBy;
    }

    public BigInteger getCreationTimeId() {
        return creationTimeId;
    }

    public void setCreationTimeId(BigInteger creationTimeId) {
        this.creationTimeId = creationTimeId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (onsiteLogId != null ? onsiteLogId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnsiteLogDm)) {
            return false;
        }
        OnsiteLogDm other = (OnsiteLogDm) object;
        if ((this.onsiteLogId == null && other.onsiteLogId != null) || (this.onsiteLogId != null && !this.onsiteLogId.equals(other.onsiteLogId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.OnsiteLogDm[ onsiteLogId=" + onsiteLogId + " ]";
    }

}
