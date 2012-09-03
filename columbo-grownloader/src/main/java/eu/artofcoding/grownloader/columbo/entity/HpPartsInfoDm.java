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

package eu.artofcoding.grownloader.columbo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class HpPartsInfoDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNumber;

    private String clfyUserLogin;

    private String externalUserLogin;

    private BigDecimal selectedQuantity;

    private String partNumber;

    private String partDesc;

    private String partClassDesc;

    private String currency;

    private BigInteger listPrice;

    private String sourceLocation;

    private Date timestamp;

    private String typeFlag;

    private Date dateAdded;

    private Date dateModified;

    private String partModifierCd;

    private String partModifierDesc;

    private String callpackPartNum;

    private String callpackPartDesc;

    private Date partEstArrvTime;

    private String xFailureCd;

    private String xSerialNumber;

    private String xRemovedSerialNumber;

    private String xProductLine;

    private Date xShipDate;

    private String xRmaNumber;

    private String xPartStatus;

    private Long xLineNumber;

    private String xPartNotes;

    private String xWaybill;

    private String xCarrierId;

    private String xPartType;

    private Short xBomFlag;

    private Short xEscalatedFlag;

    private Long xBillable;

    private String xOfferPartNumber;

    private String xPartUsage;

    private Date xScEta;

    private String xRemovedPartDesc;

    private String xRemovedPartNumber;

    private Date xReturnDeadline;

    private String xReturnInstructions;

    private Short xReturnOverrideFlag;

    private String xTrackingNumber;

    private Short xUnitSwapFlag;

    private String xSvcProductLine;

    private Short xCancelFlag;

    private Short xFuncEqFlag;

    private String xFuncEqPartNumber;

    private Date xLastModTime;

    private Long xLogisticsLineNumber;

    private String xReconciliationResult;

    private Short xReservedFlag;

    private Date xCreationTime;

    private Short xFailureAnalysisFlag;

    private String caseId;

    private String xRepairType;

    private Long xPartQualification2user;

    private Long hpPartOrderId;

    private Long xPartSourced2user;

    private String xPickPackInstructions;

    private String xDlvrPriorCd;

    private String xShipMethodCd;

    private String xShipInstCd;

    private String xSpecialInstCd;

    private Date xOrderedDt;

    private String xReqdPartNumber;

    private String xReturnableCd;

    private String xNlsPartStatus;

    private String xNlsPartUsage;

    private Date xCustomerReceivedDate;

    private BigInteger xCriticalForRepairFlag;

    public HpPartsInfoDm() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClfyUserLogin() {
        return clfyUserLogin;
    }

    public void setClfyUserLogin(String clfyUserLogin) {
        this.clfyUserLogin = clfyUserLogin;
    }

    public String getExternalUserLogin() {
        return externalUserLogin;
    }

    public void setExternalUserLogin(String externalUserLogin) {
        this.externalUserLogin = externalUserLogin;
    }

    public BigDecimal getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(BigDecimal selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public String getPartClassDesc() {
        return partClassDesc;
    }

    public void setPartClassDesc(String partClassDesc) {
        this.partClassDesc = partClassDesc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigInteger getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigInteger listPrice) {
        this.listPrice = listPrice;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(String typeFlag) {
        this.typeFlag = typeFlag;
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

    public String getPartModifierCd() {
        return partModifierCd;
    }

    public void setPartModifierCd(String partModifierCd) {
        this.partModifierCd = partModifierCd;
    }

    public String getPartModifierDesc() {
        return partModifierDesc;
    }

    public void setPartModifierDesc(String partModifierDesc) {
        this.partModifierDesc = partModifierDesc;
    }

    public String getCallpackPartNum() {
        return callpackPartNum;
    }

    public void setCallpackPartNum(String callpackPartNum) {
        this.callpackPartNum = callpackPartNum;
    }

    public String getCallpackPartDesc() {
        return callpackPartDesc;
    }

    public void setCallpackPartDesc(String callpackPartDesc) {
        this.callpackPartDesc = callpackPartDesc;
    }

    public Date getPartEstArrvTime() {
        return partEstArrvTime;
    }

    public void setPartEstArrvTime(Date partEstArrvTime) {
        this.partEstArrvTime = partEstArrvTime;
    }

    public String getXFailureCd() {
        return xFailureCd;
    }

    public void setXFailureCd(String xFailureCd) {
        this.xFailureCd = xFailureCd;
    }

    public String getXSerialNumber() {
        return xSerialNumber;
    }

    public void setXSerialNumber(String xSerialNumber) {
        this.xSerialNumber = xSerialNumber;
    }

    public String getXRemovedSerialNumber() {
        return xRemovedSerialNumber;
    }

    public void setXRemovedSerialNumber(String xRemovedSerialNumber) {
        this.xRemovedSerialNumber = xRemovedSerialNumber;
    }

    public String getXProductLine() {
        return xProductLine;
    }

    public void setXProductLine(String xProductLine) {
        this.xProductLine = xProductLine;
    }

    public Date getXShipDate() {
        return xShipDate;
    }

    public void setXShipDate(Date xShipDate) {
        this.xShipDate = xShipDate;
    }

    public String getXRmaNumber() {
        return xRmaNumber;
    }

    public void setXRmaNumber(String xRmaNumber) {
        this.xRmaNumber = xRmaNumber;
    }

    public String getXPartStatus() {
        return xPartStatus;
    }

    public void setXPartStatus(String xPartStatus) {
        this.xPartStatus = xPartStatus;
    }

    public Long getXLineNumber() {
        return xLineNumber;
    }

    public void setXLineNumber(Long xLineNumber) {
        this.xLineNumber = xLineNumber;
    }

    public String getXPartNotes() {
        return xPartNotes;
    }

    public void setXPartNotes(String xPartNotes) {
        this.xPartNotes = xPartNotes;
    }

    public String getXWaybill() {
        return xWaybill;
    }

    public void setXWaybill(String xWaybill) {
        this.xWaybill = xWaybill;
    }

    public String getXCarrierId() {
        return xCarrierId;
    }

    public void setXCarrierId(String xCarrierId) {
        this.xCarrierId = xCarrierId;
    }

    public String getXPartType() {
        return xPartType;
    }

    public void setXPartType(String xPartType) {
        this.xPartType = xPartType;
    }

    public Short getXBomFlag() {
        return xBomFlag;
    }

    public void setXBomFlag(Short xBomFlag) {
        this.xBomFlag = xBomFlag;
    }

    public Short getXEscalatedFlag() {
        return xEscalatedFlag;
    }

    public void setXEscalatedFlag(Short xEscalatedFlag) {
        this.xEscalatedFlag = xEscalatedFlag;
    }

    public Long getXBillable() {
        return xBillable;
    }

    public void setXBillable(Long xBillable) {
        this.xBillable = xBillable;
    }

    public String getXOfferPartNumber() {
        return xOfferPartNumber;
    }

    public void setXOfferPartNumber(String xOfferPartNumber) {
        this.xOfferPartNumber = xOfferPartNumber;
    }

    public String getXPartUsage() {
        return xPartUsage;
    }

    public void setXPartUsage(String xPartUsage) {
        this.xPartUsage = xPartUsage;
    }

    public Date getXScEta() {
        return xScEta;
    }

    public void setXScEta(Date xScEta) {
        this.xScEta = xScEta;
    }

    public String getXRemovedPartDesc() {
        return xRemovedPartDesc;
    }

    public void setXRemovedPartDesc(String xRemovedPartDesc) {
        this.xRemovedPartDesc = xRemovedPartDesc;
    }

    public String getXRemovedPartNumber() {
        return xRemovedPartNumber;
    }

    public void setXRemovedPartNumber(String xRemovedPartNumber) {
        this.xRemovedPartNumber = xRemovedPartNumber;
    }

    public Date getXReturnDeadline() {
        return xReturnDeadline;
    }

    public void setXReturnDeadline(Date xReturnDeadline) {
        this.xReturnDeadline = xReturnDeadline;
    }

    public String getXReturnInstructions() {
        return xReturnInstructions;
    }

    public void setXReturnInstructions(String xReturnInstructions) {
        this.xReturnInstructions = xReturnInstructions;
    }

    public Short getXReturnOverrideFlag() {
        return xReturnOverrideFlag;
    }

    public void setXReturnOverrideFlag(Short xReturnOverrideFlag) {
        this.xReturnOverrideFlag = xReturnOverrideFlag;
    }

    public String getXTrackingNumber() {
        return xTrackingNumber;
    }

    public void setXTrackingNumber(String xTrackingNumber) {
        this.xTrackingNumber = xTrackingNumber;
    }

    public Short getXUnitSwapFlag() {
        return xUnitSwapFlag;
    }

    public void setXUnitSwapFlag(Short xUnitSwapFlag) {
        this.xUnitSwapFlag = xUnitSwapFlag;
    }

    public String getXSvcProductLine() {
        return xSvcProductLine;
    }

    public void setXSvcProductLine(String xSvcProductLine) {
        this.xSvcProductLine = xSvcProductLine;
    }

    public Short getXCancelFlag() {
        return xCancelFlag;
    }

    public void setXCancelFlag(Short xCancelFlag) {
        this.xCancelFlag = xCancelFlag;
    }

    public Short getXFuncEqFlag() {
        return xFuncEqFlag;
    }

    public void setXFuncEqFlag(Short xFuncEqFlag) {
        this.xFuncEqFlag = xFuncEqFlag;
    }

    public String getXFuncEqPartNumber() {
        return xFuncEqPartNumber;
    }

    public void setXFuncEqPartNumber(String xFuncEqPartNumber) {
        this.xFuncEqPartNumber = xFuncEqPartNumber;
    }

    public Date getXLastModTime() {
        return xLastModTime;
    }

    public void setXLastModTime(Date xLastModTime) {
        this.xLastModTime = xLastModTime;
    }

    public Long getXLogisticsLineNumber() {
        return xLogisticsLineNumber;
    }

    public void setXLogisticsLineNumber(Long xLogisticsLineNumber) {
        this.xLogisticsLineNumber = xLogisticsLineNumber;
    }

    public String getXReconciliationResult() {
        return xReconciliationResult;
    }

    public void setXReconciliationResult(String xReconciliationResult) {
        this.xReconciliationResult = xReconciliationResult;
    }

    public Short getXReservedFlag() {
        return xReservedFlag;
    }

    public void setXReservedFlag(Short xReservedFlag) {
        this.xReservedFlag = xReservedFlag;
    }

    public Date getXCreationTime() {
        return xCreationTime;
    }

    public void setXCreationTime(Date xCreationTime) {
        this.xCreationTime = xCreationTime;
    }

    public Short getXFailureAnalysisFlag() {
        return xFailureAnalysisFlag;
    }

    public void setXFailureAnalysisFlag(Short xFailureAnalysisFlag) {
        this.xFailureAnalysisFlag = xFailureAnalysisFlag;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getXRepairType() {
        return xRepairType;
    }

    public void setXRepairType(String xRepairType) {
        this.xRepairType = xRepairType;
    }

    public Long getXPartQualification2user() {
        return xPartQualification2user;
    }

    public void setXPartQualification2user(Long xPartQualification2user) {
        this.xPartQualification2user = xPartQualification2user;
    }

    public Long getHpPartOrderId() {
        return hpPartOrderId;
    }

    public void setHpPartOrderId(Long hpPartOrderId) {
        this.hpPartOrderId = hpPartOrderId;
    }

    public Long getXPartSourced2user() {
        return xPartSourced2user;
    }

    public void setXPartSourced2user(Long xPartSourced2user) {
        this.xPartSourced2user = xPartSourced2user;
    }

    public String getXPickPackInstructions() {
        return xPickPackInstructions;
    }

    public void setXPickPackInstructions(String xPickPackInstructions) {
        this.xPickPackInstructions = xPickPackInstructions;
    }

    public String getXDlvrPriorCd() {
        return xDlvrPriorCd;
    }

    public void setXDlvrPriorCd(String xDlvrPriorCd) {
        this.xDlvrPriorCd = xDlvrPriorCd;
    }

    public String getXShipMethodCd() {
        return xShipMethodCd;
    }

    public void setXShipMethodCd(String xShipMethodCd) {
        this.xShipMethodCd = xShipMethodCd;
    }

    public String getXShipInstCd() {
        return xShipInstCd;
    }

    public void setXShipInstCd(String xShipInstCd) {
        this.xShipInstCd = xShipInstCd;
    }

    public String getXSpecialInstCd() {
        return xSpecialInstCd;
    }

    public void setXSpecialInstCd(String xSpecialInstCd) {
        this.xSpecialInstCd = xSpecialInstCd;
    }

    public Date getXOrderedDt() {
        return xOrderedDt;
    }

    public void setXOrderedDt(Date xOrderedDt) {
        this.xOrderedDt = xOrderedDt;
    }

    public String getXReqdPartNumber() {
        return xReqdPartNumber;
    }

    public void setXReqdPartNumber(String xReqdPartNumber) {
        this.xReqdPartNumber = xReqdPartNumber;
    }

    public String getXReturnableCd() {
        return xReturnableCd;
    }

    public void setXReturnableCd(String xReturnableCd) {
        this.xReturnableCd = xReturnableCd;
    }

    public String getXNlsPartStatus() {
        return xNlsPartStatus;
    }

    public void setXNlsPartStatus(String xNlsPartStatus) {
        this.xNlsPartStatus = xNlsPartStatus;
    }

    public String getXNlsPartUsage() {
        return xNlsPartUsage;
    }

    public void setXNlsPartUsage(String xNlsPartUsage) {
        this.xNlsPartUsage = xNlsPartUsage;
    }

    public Date getXCustomerReceivedDate() {
        return xCustomerReceivedDate;
    }

    public void setXCustomerReceivedDate(Date xCustomerReceivedDate) {
        this.xCustomerReceivedDate = xCustomerReceivedDate;
    }

    public BigInteger getXCriticalForRepairFlag() {
        return xCriticalForRepairFlag;
    }

    public void setXCriticalForRepairFlag(BigInteger xCriticalForRepairFlag) {
        this.xCriticalForRepairFlag = xCriticalForRepairFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HpPartsInfoDm that = (HpPartsInfoDm) o;

        if (callpackPartDesc != null ? !callpackPartDesc.equals(that.callpackPartDesc) : that.callpackPartDesc != null)
            return false;
        if (callpackPartNum != null ? !callpackPartNum.equals(that.callpackPartNum) : that.callpackPartNum != null)
            return false;
        if (caseId != null ? !caseId.equals(that.caseId) : that.caseId != null) return false;
        if (clfyUserLogin != null ? !clfyUserLogin.equals(that.clfyUserLogin) : that.clfyUserLogin != null)
            return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (dateAdded != null ? !dateAdded.equals(that.dateAdded) : that.dateAdded != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (externalUserLogin != null ? !externalUserLogin.equals(that.externalUserLogin) : that.externalUserLogin != null)
            return false;
        if (hpPartOrderId != null ? !hpPartOrderId.equals(that.hpPartOrderId) : that.hpPartOrderId != null)
            return false;
        if (listPrice != null ? !listPrice.equals(that.listPrice) : that.listPrice != null) return false;
        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (partClassDesc != null ? !partClassDesc.equals(that.partClassDesc) : that.partClassDesc != null)
            return false;
        if (partDesc != null ? !partDesc.equals(that.partDesc) : that.partDesc != null) return false;
        if (partEstArrvTime != null ? !partEstArrvTime.equals(that.partEstArrvTime) : that.partEstArrvTime != null)
            return false;
        if (partModifierCd != null ? !partModifierCd.equals(that.partModifierCd) : that.partModifierCd != null)
            return false;
        if (partModifierDesc != null ? !partModifierDesc.equals(that.partModifierDesc) : that.partModifierDesc != null)
            return false;
        if (partNumber != null ? !partNumber.equals(that.partNumber) : that.partNumber != null) return false;
        if (selectedQuantity != null ? !selectedQuantity.equals(that.selectedQuantity) : that.selectedQuantity != null)
            return false;
        if (sourceLocation != null ? !sourceLocation.equals(that.sourceLocation) : that.sourceLocation != null)
            return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (typeFlag != null ? !typeFlag.equals(that.typeFlag) : that.typeFlag != null) return false;
        if (xBillable != null ? !xBillable.equals(that.xBillable) : that.xBillable != null) return false;
        if (xBomFlag != null ? !xBomFlag.equals(that.xBomFlag) : that.xBomFlag != null) return false;
        if (xCancelFlag != null ? !xCancelFlag.equals(that.xCancelFlag) : that.xCancelFlag != null) return false;
        if (xCarrierId != null ? !xCarrierId.equals(that.xCarrierId) : that.xCarrierId != null) return false;
        if (xCreationTime != null ? !xCreationTime.equals(that.xCreationTime) : that.xCreationTime != null)
            return false;
        if (xCriticalForRepairFlag != null ? !xCriticalForRepairFlag.equals(that.xCriticalForRepairFlag) : that.xCriticalForRepairFlag != null)
            return false;
        if (xCustomerReceivedDate != null ? !xCustomerReceivedDate.equals(that.xCustomerReceivedDate) : that.xCustomerReceivedDate != null)
            return false;
        if (xDlvrPriorCd != null ? !xDlvrPriorCd.equals(that.xDlvrPriorCd) : that.xDlvrPriorCd != null) return false;
        if (xEscalatedFlag != null ? !xEscalatedFlag.equals(that.xEscalatedFlag) : that.xEscalatedFlag != null)
            return false;
        if (xFailureAnalysisFlag != null ? !xFailureAnalysisFlag.equals(that.xFailureAnalysisFlag) : that.xFailureAnalysisFlag != null)
            return false;
        if (xFailureCd != null ? !xFailureCd.equals(that.xFailureCd) : that.xFailureCd != null) return false;
        if (xFuncEqFlag != null ? !xFuncEqFlag.equals(that.xFuncEqFlag) : that.xFuncEqFlag != null) return false;
        if (xFuncEqPartNumber != null ? !xFuncEqPartNumber.equals(that.xFuncEqPartNumber) : that.xFuncEqPartNumber != null)
            return false;
        if (xLastModTime != null ? !xLastModTime.equals(that.xLastModTime) : that.xLastModTime != null) return false;
        if (xLineNumber != null ? !xLineNumber.equals(that.xLineNumber) : that.xLineNumber != null) return false;
        if (xLogisticsLineNumber != null ? !xLogisticsLineNumber.equals(that.xLogisticsLineNumber) : that.xLogisticsLineNumber != null)
            return false;
        if (xNlsPartStatus != null ? !xNlsPartStatus.equals(that.xNlsPartStatus) : that.xNlsPartStatus != null)
            return false;
        if (xNlsPartUsage != null ? !xNlsPartUsage.equals(that.xNlsPartUsage) : that.xNlsPartUsage != null)
            return false;
        if (xOfferPartNumber != null ? !xOfferPartNumber.equals(that.xOfferPartNumber) : that.xOfferPartNumber != null)
            return false;
        if (xOrderedDt != null ? !xOrderedDt.equals(that.xOrderedDt) : that.xOrderedDt != null) return false;
        if (xPartNotes != null ? !xPartNotes.equals(that.xPartNotes) : that.xPartNotes != null) return false;
        if (xPartQualification2user != null ? !xPartQualification2user.equals(that.xPartQualification2user) : that.xPartQualification2user != null)
            return false;
        if (xPartSourced2user != null ? !xPartSourced2user.equals(that.xPartSourced2user) : that.xPartSourced2user != null)
            return false;
        if (xPartStatus != null ? !xPartStatus.equals(that.xPartStatus) : that.xPartStatus != null) return false;
        if (xPartType != null ? !xPartType.equals(that.xPartType) : that.xPartType != null) return false;
        if (xPartUsage != null ? !xPartUsage.equals(that.xPartUsage) : that.xPartUsage != null) return false;
        if (xPickPackInstructions != null ? !xPickPackInstructions.equals(that.xPickPackInstructions) : that.xPickPackInstructions != null)
            return false;
        if (xProductLine != null ? !xProductLine.equals(that.xProductLine) : that.xProductLine != null) return false;
        if (xReconciliationResult != null ? !xReconciliationResult.equals(that.xReconciliationResult) : that.xReconciliationResult != null)
            return false;
        if (xRemovedPartDesc != null ? !xRemovedPartDesc.equals(that.xRemovedPartDesc) : that.xRemovedPartDesc != null)
            return false;
        if (xRemovedPartNumber != null ? !xRemovedPartNumber.equals(that.xRemovedPartNumber) : that.xRemovedPartNumber != null)
            return false;
        if (xRemovedSerialNumber != null ? !xRemovedSerialNumber.equals(that.xRemovedSerialNumber) : that.xRemovedSerialNumber != null)
            return false;
        if (xRepairType != null ? !xRepairType.equals(that.xRepairType) : that.xRepairType != null) return false;
        if (xReqdPartNumber != null ? !xReqdPartNumber.equals(that.xReqdPartNumber) : that.xReqdPartNumber != null)
            return false;
        if (xReservedFlag != null ? !xReservedFlag.equals(that.xReservedFlag) : that.xReservedFlag != null)
            return false;
        if (xReturnDeadline != null ? !xReturnDeadline.equals(that.xReturnDeadline) : that.xReturnDeadline != null)
            return false;
        if (xReturnInstructions != null ? !xReturnInstructions.equals(that.xReturnInstructions) : that.xReturnInstructions != null)
            return false;
        if (xReturnOverrideFlag != null ? !xReturnOverrideFlag.equals(that.xReturnOverrideFlag) : that.xReturnOverrideFlag != null)
            return false;
        if (xReturnableCd != null ? !xReturnableCd.equals(that.xReturnableCd) : that.xReturnableCd != null)
            return false;
        if (xRmaNumber != null ? !xRmaNumber.equals(that.xRmaNumber) : that.xRmaNumber != null) return false;
        if (xScEta != null ? !xScEta.equals(that.xScEta) : that.xScEta != null) return false;
        if (xSerialNumber != null ? !xSerialNumber.equals(that.xSerialNumber) : that.xSerialNumber != null)
            return false;
        if (xShipDate != null ? !xShipDate.equals(that.xShipDate) : that.xShipDate != null) return false;
        if (xShipInstCd != null ? !xShipInstCd.equals(that.xShipInstCd) : that.xShipInstCd != null) return false;
        if (xShipMethodCd != null ? !xShipMethodCd.equals(that.xShipMethodCd) : that.xShipMethodCd != null)
            return false;
        if (xSpecialInstCd != null ? !xSpecialInstCd.equals(that.xSpecialInstCd) : that.xSpecialInstCd != null)
            return false;
        if (xSvcProductLine != null ? !xSvcProductLine.equals(that.xSvcProductLine) : that.xSvcProductLine != null)
            return false;
        if (xTrackingNumber != null ? !xTrackingNumber.equals(that.xTrackingNumber) : that.xTrackingNumber != null)
            return false;
        if (xUnitSwapFlag != null ? !xUnitSwapFlag.equals(that.xUnitSwapFlag) : that.xUnitSwapFlag != null)
            return false;
        if (xWaybill != null ? !xWaybill.equals(that.xWaybill) : that.xWaybill != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (clfyUserLogin != null ? clfyUserLogin.hashCode() : 0);
        result = 31 * result + (externalUserLogin != null ? externalUserLogin.hashCode() : 0);
        result = 31 * result + (selectedQuantity != null ? selectedQuantity.hashCode() : 0);
        result = 31 * result + (partNumber != null ? partNumber.hashCode() : 0);
        result = 31 * result + (partDesc != null ? partDesc.hashCode() : 0);
        result = 31 * result + (partClassDesc != null ? partClassDesc.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + (sourceLocation != null ? sourceLocation.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (typeFlag != null ? typeFlag.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (partModifierCd != null ? partModifierCd.hashCode() : 0);
        result = 31 * result + (partModifierDesc != null ? partModifierDesc.hashCode() : 0);
        result = 31 * result + (callpackPartNum != null ? callpackPartNum.hashCode() : 0);
        result = 31 * result + (callpackPartDesc != null ? callpackPartDesc.hashCode() : 0);
        result = 31 * result + (partEstArrvTime != null ? partEstArrvTime.hashCode() : 0);
        result = 31 * result + (xFailureCd != null ? xFailureCd.hashCode() : 0);
        result = 31 * result + (xSerialNumber != null ? xSerialNumber.hashCode() : 0);
        result = 31 * result + (xRemovedSerialNumber != null ? xRemovedSerialNumber.hashCode() : 0);
        result = 31 * result + (xProductLine != null ? xProductLine.hashCode() : 0);
        result = 31 * result + (xShipDate != null ? xShipDate.hashCode() : 0);
        result = 31 * result + (xRmaNumber != null ? xRmaNumber.hashCode() : 0);
        result = 31 * result + (xPartStatus != null ? xPartStatus.hashCode() : 0);
        result = 31 * result + (xLineNumber != null ? xLineNumber.hashCode() : 0);
        result = 31 * result + (xPartNotes != null ? xPartNotes.hashCode() : 0);
        result = 31 * result + (xWaybill != null ? xWaybill.hashCode() : 0);
        result = 31 * result + (xCarrierId != null ? xCarrierId.hashCode() : 0);
        result = 31 * result + (xPartType != null ? xPartType.hashCode() : 0);
        result = 31 * result + (xBomFlag != null ? xBomFlag.hashCode() : 0);
        result = 31 * result + (xEscalatedFlag != null ? xEscalatedFlag.hashCode() : 0);
        result = 31 * result + (xBillable != null ? xBillable.hashCode() : 0);
        result = 31 * result + (xOfferPartNumber != null ? xOfferPartNumber.hashCode() : 0);
        result = 31 * result + (xPartUsage != null ? xPartUsage.hashCode() : 0);
        result = 31 * result + (xScEta != null ? xScEta.hashCode() : 0);
        result = 31 * result + (xRemovedPartDesc != null ? xRemovedPartDesc.hashCode() : 0);
        result = 31 * result + (xRemovedPartNumber != null ? xRemovedPartNumber.hashCode() : 0);
        result = 31 * result + (xReturnDeadline != null ? xReturnDeadline.hashCode() : 0);
        result = 31 * result + (xReturnInstructions != null ? xReturnInstructions.hashCode() : 0);
        result = 31 * result + (xReturnOverrideFlag != null ? xReturnOverrideFlag.hashCode() : 0);
        result = 31 * result + (xTrackingNumber != null ? xTrackingNumber.hashCode() : 0);
        result = 31 * result + (xUnitSwapFlag != null ? xUnitSwapFlag.hashCode() : 0);
        result = 31 * result + (xSvcProductLine != null ? xSvcProductLine.hashCode() : 0);
        result = 31 * result + (xCancelFlag != null ? xCancelFlag.hashCode() : 0);
        result = 31 * result + (xFuncEqFlag != null ? xFuncEqFlag.hashCode() : 0);
        result = 31 * result + (xFuncEqPartNumber != null ? xFuncEqPartNumber.hashCode() : 0);
        result = 31 * result + (xLastModTime != null ? xLastModTime.hashCode() : 0);
        result = 31 * result + (xLogisticsLineNumber != null ? xLogisticsLineNumber.hashCode() : 0);
        result = 31 * result + (xReconciliationResult != null ? xReconciliationResult.hashCode() : 0);
        result = 31 * result + (xReservedFlag != null ? xReservedFlag.hashCode() : 0);
        result = 31 * result + (xCreationTime != null ? xCreationTime.hashCode() : 0);
        result = 31 * result + (xFailureAnalysisFlag != null ? xFailureAnalysisFlag.hashCode() : 0);
        result = 31 * result + (caseId != null ? caseId.hashCode() : 0);
        result = 31 * result + (xRepairType != null ? xRepairType.hashCode() : 0);
        result = 31 * result + (xPartQualification2user != null ? xPartQualification2user.hashCode() : 0);
        result = 31 * result + (hpPartOrderId != null ? hpPartOrderId.hashCode() : 0);
        result = 31 * result + (xPartSourced2user != null ? xPartSourced2user.hashCode() : 0);
        result = 31 * result + (xPickPackInstructions != null ? xPickPackInstructions.hashCode() : 0);
        result = 31 * result + (xDlvrPriorCd != null ? xDlvrPriorCd.hashCode() : 0);
        result = 31 * result + (xShipMethodCd != null ? xShipMethodCd.hashCode() : 0);
        result = 31 * result + (xShipInstCd != null ? xShipInstCd.hashCode() : 0);
        result = 31 * result + (xSpecialInstCd != null ? xSpecialInstCd.hashCode() : 0);
        result = 31 * result + (xOrderedDt != null ? xOrderedDt.hashCode() : 0);
        result = 31 * result + (xReqdPartNumber != null ? xReqdPartNumber.hashCode() : 0);
        result = 31 * result + (xReturnableCd != null ? xReturnableCd.hashCode() : 0);
        result = 31 * result + (xNlsPartStatus != null ? xNlsPartStatus.hashCode() : 0);
        result = 31 * result + (xNlsPartUsage != null ? xNlsPartUsage.hashCode() : 0);
        result = 31 * result + (xCustomerReceivedDate != null ? xCustomerReceivedDate.hashCode() : 0);
        result = 31 * result + (xCriticalForRepairFlag != null ? xCriticalForRepairFlag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HpPartsInfoDm{" +
                "caseId='" + caseId + '\'' +
                '}';
    }
}
