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
import java.util.Date;

public class HpPartOrderDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long hpPartOrderId;

    private String subcaseId;

    private String caseId;

    private Long xAddressTypeCd;

    private String xOrderId;

    private String xOrderNumber;

    private Date xPartOrderEta;

    private String xPartOrderType;

    private String xPickPackInstructions;

    private String xReceivedInstructions;

    private Date xRequestedEta;

    private String xSentInstructions;

    private String xShipAddress;

    private String xShipAddress2;

    private String xShipCity;

    private String xShipCountry;

    private String xShipState;

    private String xShipZipcode;

    private String xCompanyName;

    private String xLogisticsSystem;

    private String xContactAltPhone;

    private String xContactFirstName;

    private String xContactLastName;

    private String xContactPhone;

    private Date xLastModTime;

    private String xLoggingTypeCd;

    private Long xPartialOrderFlag;

    private String xLogisticsCenter;

    private String xLogisticsCenterPhone;

    private String xServiceNotificationNumber;

    private String xOrderType;

    private Date xCreationTime;

    private String xServiceNoteNumber;

    private Date dateAdded;

    private Date dateModified;

    private String shipMethod;

    private String deliveryPriority;

    private String xShipIsoCountryCode;

    private String xContactFaxNumber;

    private Short xReservedFlag;

    private Long hpPartOrder2ccDlvrPrior;

    private Long hpPartOrder2ccShipMethod;

    private String hpPartOrderReason;

    private String xShipMthdUpgRsn;

    private Long responsibleEmployeeId;

    public HpPartOrderDm() {
    }

    public HpPartOrderDm(Long hpPartOrderId) {
        this.hpPartOrderId = hpPartOrderId;
    }

    public HpPartOrderDm(Long hpPartOrderId, String subcaseId) {
        this.hpPartOrderId = hpPartOrderId;
        this.subcaseId = subcaseId;
    }

    public Long getHpPartOrderId() {
        return hpPartOrderId;
    }

    public void setHpPartOrderId(Long hpPartOrderId) {
        this.hpPartOrderId = hpPartOrderId;
    }

    public String getSubcaseId() {
        return subcaseId;
    }

    public void setSubcaseId(String subcaseId) {
        this.subcaseId = subcaseId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public Long getXAddressTypeCd() {
        return xAddressTypeCd;
    }

    public void setXAddressTypeCd(Long xAddressTypeCd) {
        this.xAddressTypeCd = xAddressTypeCd;
    }

    public String getXOrderId() {
        return xOrderId;
    }

    public void setXOrderId(String xOrderId) {
        this.xOrderId = xOrderId;
    }

    public String getXOrderNumber() {
        return xOrderNumber;
    }

    public void setXOrderNumber(String xOrderNumber) {
        this.xOrderNumber = xOrderNumber;
    }

    public Date getXPartOrderEta() {
        return xPartOrderEta;
    }

    public void setXPartOrderEta(Date xPartOrderEta) {
        this.xPartOrderEta = xPartOrderEta;
    }

    public String getXPartOrderType() {
        return xPartOrderType;
    }

    public void setXPartOrderType(String xPartOrderType) {
        this.xPartOrderType = xPartOrderType;
    }

    public String getXPickPackInstructions() {
        return xPickPackInstructions;
    }

    public void setXPickPackInstructions(String xPickPackInstructions) {
        this.xPickPackInstructions = xPickPackInstructions;
    }

    public String getXReceivedInstructions() {
        return xReceivedInstructions;
    }

    public void setXReceivedInstructions(String xReceivedInstructions) {
        this.xReceivedInstructions = xReceivedInstructions;
    }

    public Date getXRequestedEta() {
        return xRequestedEta;
    }

    public void setXRequestedEta(Date xRequestedEta) {
        this.xRequestedEta = xRequestedEta;
    }

    public String getXSentInstructions() {
        return xSentInstructions;
    }

    public void setXSentInstructions(String xSentInstructions) {
        this.xSentInstructions = xSentInstructions;
    }

    public String getXShipAddress() {
        return xShipAddress;
    }

    public void setXShipAddress(String xShipAddress) {
        this.xShipAddress = xShipAddress;
    }

    public String getXShipAddress2() {
        return xShipAddress2;
    }

    public void setXShipAddress2(String xShipAddress2) {
        this.xShipAddress2 = xShipAddress2;
    }

    public String getXShipCity() {
        return xShipCity;
    }

    public void setXShipCity(String xShipCity) {
        this.xShipCity = xShipCity;
    }

    public String getXShipCountry() {
        return xShipCountry;
    }

    public void setXShipCountry(String xShipCountry) {
        this.xShipCountry = xShipCountry;
    }

    public String getXShipState() {
        return xShipState;
    }

    public void setXShipState(String xShipState) {
        this.xShipState = xShipState;
    }

    public String getXShipZipcode() {
        return xShipZipcode;
    }

    public void setXShipZipcode(String xShipZipcode) {
        this.xShipZipcode = xShipZipcode;
    }

    public String getXCompanyName() {
        return xCompanyName;
    }

    public void setXCompanyName(String xCompanyName) {
        this.xCompanyName = xCompanyName;
    }

    public String getXLogisticsSystem() {
        return xLogisticsSystem;
    }

    public void setXLogisticsSystem(String xLogisticsSystem) {
        this.xLogisticsSystem = xLogisticsSystem;
    }

    public String getXContactAltPhone() {
        return xContactAltPhone;
    }

    public void setXContactAltPhone(String xContactAltPhone) {
        this.xContactAltPhone = xContactAltPhone;
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

    public String getXContactPhone() {
        return xContactPhone;
    }

    public void setXContactPhone(String xContactPhone) {
        this.xContactPhone = xContactPhone;
    }

    public Date getXLastModTime() {
        return xLastModTime;
    }

    public void setXLastModTime(Date xLastModTime) {
        this.xLastModTime = xLastModTime;
    }

    public String getXLoggingTypeCd() {
        return xLoggingTypeCd;
    }

    public void setXLoggingTypeCd(String xLoggingTypeCd) {
        this.xLoggingTypeCd = xLoggingTypeCd;
    }

    public Long getXPartialOrderFlag() {
        return xPartialOrderFlag;
    }

    public void setXPartialOrderFlag(Long xPartialOrderFlag) {
        this.xPartialOrderFlag = xPartialOrderFlag;
    }

    public String getXLogisticsCenter() {
        return xLogisticsCenter;
    }

    public void setXLogisticsCenter(String xLogisticsCenter) {
        this.xLogisticsCenter = xLogisticsCenter;
    }

    public String getXLogisticsCenterPhone() {
        return xLogisticsCenterPhone;
    }

    public void setXLogisticsCenterPhone(String xLogisticsCenterPhone) {
        this.xLogisticsCenterPhone = xLogisticsCenterPhone;
    }

    public String getXServiceNotificationNumber() {
        return xServiceNotificationNumber;
    }

    public void setXServiceNotificationNumber(String xServiceNotificationNumber) {
        this.xServiceNotificationNumber = xServiceNotificationNumber;
    }

    public String getXOrderType() {
        return xOrderType;
    }

    public void setXOrderType(String xOrderType) {
        this.xOrderType = xOrderType;
    }

    public Date getXCreationTime() {
        return xCreationTime;
    }

    public void setXCreationTime(Date xCreationTime) {
        this.xCreationTime = xCreationTime;
    }

    public String getXServiceNoteNumber() {
        return xServiceNoteNumber;
    }

    public void setXServiceNoteNumber(String xServiceNoteNumber) {
        this.xServiceNoteNumber = xServiceNoteNumber;
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

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getDeliveryPriority() {
        return deliveryPriority;
    }

    public void setDeliveryPriority(String deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }

    public String getXShipIsoCountryCode() {
        return xShipIsoCountryCode;
    }

    public void setXShipIsoCountryCode(String xShipIsoCountryCode) {
        this.xShipIsoCountryCode = xShipIsoCountryCode;
    }

    public String getXContactFaxNumber() {
        return xContactFaxNumber;
    }

    public void setXContactFaxNumber(String xContactFaxNumber) {
        this.xContactFaxNumber = xContactFaxNumber;
    }

    public Short getXReservedFlag() {
        return xReservedFlag;
    }

    public void setXReservedFlag(Short xReservedFlag) {
        this.xReservedFlag = xReservedFlag;
    }

    public Long getHpPartOrder2ccDlvrPrior() {
        return hpPartOrder2ccDlvrPrior;
    }

    public void setHpPartOrder2ccDlvrPrior(Long hpPartOrder2ccDlvrPrior) {
        this.hpPartOrder2ccDlvrPrior = hpPartOrder2ccDlvrPrior;
    }

    public Long getHpPartOrder2ccShipMethod() {
        return hpPartOrder2ccShipMethod;
    }

    public void setHpPartOrder2ccShipMethod(Long hpPartOrder2ccShipMethod) {
        this.hpPartOrder2ccShipMethod = hpPartOrder2ccShipMethod;
    }

    public String getHpPartOrderReason() {
        return hpPartOrderReason;
    }

    public void setHpPartOrderReason(String hpPartOrderReason) {
        this.hpPartOrderReason = hpPartOrderReason;
    }

    public String getXShipMthdUpgRsn() {
        return xShipMthdUpgRsn;
    }

    public void setXShipMthdUpgRsn(String xShipMthdUpgRsn) {
        this.xShipMthdUpgRsn = xShipMthdUpgRsn;
    }

    public Long getResponsibleEmployeeId() {
        return responsibleEmployeeId;
    }

    public void setResponsibleEmployeeId(Long responsibleEmployeeId) {
        this.responsibleEmployeeId = responsibleEmployeeId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (hpPartOrderId != null ? hpPartOrderId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpPartOrderDm)) {
            return false;
        }
        HpPartOrderDm other = (HpPartOrderDm) object;
        if ((this.hpPartOrderId == null && other.hpPartOrderId != null) || (this.hpPartOrderId != null && !this.hpPartOrderId.equals(other.hpPartOrderId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader.columbo.entity.HpPartOrderDm[ hpPartOrderId=" + hpPartOrderId + " ]";
    }

}
