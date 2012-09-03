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

public class WfmCase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountabilityId;

    private String callerPhone;

    private String callType;

    private String caseId;

    private String caseTitle;

    private Date closeDate;

    private BigInteger closeDateId;

    private String conditionCodeValue;

    private String contactFirstName;

    private String contactLastName;

    private String contractId;

    private String customerSiteId;

    private String domain;

    private BigInteger elapsedTime;

    private BigInteger employeeCloser;

    private BigInteger employeeOwner;

    private BigInteger employeeOriginator;

    private String firstLineFlag;

    private String modelNumber;

    private BigInteger numberEngineers;

    private Date openDate;

    private BigInteger openDateId;

    private String platform;

    private String priority;

    private String product;

    private String productFamily;

    private String productLine;

    private String resolution;

    private BigInteger responseTimeActual;

    private BigInteger responseTimeContractual;

    private String routing;

    private String serialNumber;

    private String severity;

    private String status;

    private String summaryText;

    private String systemHandle;

    private BigInteger timeInOpen;

    private BigInteger timeInMonitor;

    private BigInteger timeInvestedTeBillable;

    private BigInteger timeInvestedTeNonBillable;

    private BigInteger timeToSolveInEscalation;

    private String xCaseProduct;

    private String xEscalationLevel;

    private String xEscalationMgmt;

    private BigInteger codeIdCallType;

    private BigInteger codeIdPriority;

    private BigInteger codeIdResolution;

    private BigInteger codeIdSeverity;

    private BigInteger codeIdStatus;

    private BigInteger conditionCode;

    private Date dateAdded;

    private Date dateModified;

    private BigInteger timeInWorkaround;

    private String accessoryXName;

    private String osnosXName;

    private String xIpModel;

    private BigInteger diagnosticIpId;

    private BigInteger diagtoolIpId;

    private BigInteger qualityIpId;

    private String contactEMail;

    private BigInteger timeInvestedPhone;

    private BigInteger timeInvestedResearch;

    private String warrantyStatus;

    private BigInteger numberOwners;

    private String caseCategory;

    private String customerTrackingNbr;

    private String serviceNoteNumber;

    private Date warrProofPurchase;

    private String warrCode;

    private String warrDesc;

    private String warrResp;

    private String creditCard;

    private String creditCardBillType;

    private String nlsCallType;

    private String nlsPriority;

    private String nlsSeverity;

    private String nlsStatus;

    private String nlsLanguage;

    private String nlsResolution;

    private String productDescription;

    private String contactFax;

    private String contactPagerNumber;

    private String contactPagerPin;

    private String responseCoverage;

    private Date requestedEta;

    private String phoneNum;

    private String altPhoneNum;

    private BigInteger actlPhoneTime;

    private BigInteger actlResearchTime;

    private String deliverableItemDesc;

    private BigInteger hpReturnId;

    private String blueRedCd;

    private Date contrItmStartDate;

    private Date contrItmEndDate;

    private String xServiceId;

    private String obligType;

    private Long employeeTam;

    private Long employeeBkupTam;

    private String legacyLogNumber;

    private String legacyLogSys;

    private Long employeeBkupAcctRep;

    private String frontBackLine;

    private Long isSupercase;

    private Long caseVictim2case;

    private String contactAltPhone;

    private String assignBadgeNum;

    private Date entitleGuaranteedDt;

    private Date requestedGuaranteedDt;

    private String xProductLine;

    private String xOtc;

    private Date calculatedEta;

    private String hwResponseCode;

    private Long xTravelTime;

    private Long hwCaseElapsedStartToClose;

    private Short continueEffortFlag;

    private Long obligatedLogToStart;

    private Long obligatedLogToClose;

    private Long obligatedStartToClose;

    private BigInteger totalInvestedTime;

    private String wdbDistrict;

    private String wdbProductLine;

    private String wdbWorkForce;

    private String wdbOffice;

    private String geoIsoCountryCd;

    private String geoIsoCountryName;

    private String geoIsoShipCountryCd;

    private String geoIsoShipCountryName;

    private Date xDateAuthorized;

    private Date xDateQuoteCreated;

    private BigInteger quotationPeriod;

    private String entryPoint;

    private Short fdMissed;

    private Short sdMissed;

    private Short ndMissed;

    private Short ctrMissed;

    private Short responseMissedOther;

    private Short responseMissed;

    private String overallCaseCat;

    private String caseSvcCat;

    private String deliveryAlternative;

    private Short multipleVisitsFlag;

    private Short ctrFlag;

    private Short mcFlag;

    private Short m2HwRprCount;

    private Integer partQtyUsed;

    private Short rerepair30Days;

    private Short rerepair90Days;

    private Integer daysBtwnRerpr;

    private String prevDeliveryAlternative;

    private String prevCaseId;

    private Date prevOpenDate;

    private Date prevFixDate;

    private Short m8Qualified;

    private Integer numPartsRecommended;

    private Short noPartsRecommended;

    private Short partsRecommendedNpu;

    private BigDecimal partsDiagnosisAccuracy;

    private BigDecimal partsDiagnosisEfficiency;

    private Short m9Npu;

    private Long hwTurnAroundTime;

    private String xRepairClass;

    private String contactTitle;

    private String caseHistory;

    private String paymAuthNo;

    private BigDecimal totalExp;

    private Long supercaseId;

    private String caseAddress;

    private String caseAddress2;

    private String caseCity;

    private String caseCountry;

    private BigDecimal quoteTotalAmt;

    private Date qualEndDate;

    private Long qualInvestHours;

    private Long m1HwCount;

    private Long m1aHwCount;

    private Long m1bHwCount;

    private Long selectedOfferId;

    private Long warrantyOfferId;

    private Long hpModRefId;

    private Date lastStatusChangeDate;

    private String onsiteOffsiteFl;

    private BigDecimal onsiteAdminClosureTime;

    private Date onsiteFixedDate;

    private Date onsiteStartDate;

    private Date onsiteStopDate;

    private Date offsiteStartDate;

    private Date offsiteStopDate;

    private String contactPrefLanguage;

    private String xOverrideSerialNo;

    private String overridePartNumber;

    private String altFirstName;

    private String altLastName;

    private Long sitePartId;

    private Long hpId;

    private Long xCase2entitlementId;

    private Long xCase2serviceId;

    private Long xCase2searchedId;

    private String xCid;

    private String cclist1;

    private String cclist2;

    private Long hwTatNonWorkDay;

    private Long currentQueueId;

    private Long contactId;

    private Long hpPartnerId;

    private Short customerRescheduledMissed;

    private Short voidResolutionFlag;

    private BigInteger xHomeSoil;

    private String xRplStatus;

    private String xProdGrp;

    private String xProdSubgrp;

    private BigInteger xOnsiteSubcFlag;

    private String xSalesOrderNumber;

    private String responseCode;

    private String xMvMfrName;

    private String xMvPartNumber;

    private String xMdcpCustId;

    private String amid2;

    private String amid3;

    private String amid4;

    private String sdsId;

    public WfmCase() {
    }

    public WfmCase(String accountabilityId) {
        this.accountabilityId = accountabilityId;
    }

    public WfmCase(String accountabilityId, String caseId) {
        this.accountabilityId = accountabilityId;
        this.caseId = caseId;
    }

    public String getAccountabilityId() {
        return accountabilityId;
    }

    public void setAccountabilityId(String accountabilityId) {
        this.accountabilityId = accountabilityId;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
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

    public String getConditionCodeValue() {
        return conditionCodeValue;
    }

    public void setConditionCodeValue(String conditionCodeValue) {
        this.conditionCodeValue = conditionCodeValue;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getCustomerSiteId() {
        return customerSiteId;
    }

    public void setCustomerSiteId(String customerSiteId) {
        this.customerSiteId = customerSiteId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public BigInteger getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(BigInteger elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public BigInteger getEmployeeCloser() {
        return employeeCloser;
    }

    public void setEmployeeCloser(BigInteger employeeCloser) {
        this.employeeCloser = employeeCloser;
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

    public String getFirstLineFlag() {
        return firstLineFlag;
    }

    public void setFirstLineFlag(String firstLineFlag) {
        this.firstLineFlag = firstLineFlag;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public BigInteger getNumberEngineers() {
        return numberEngineers;
    }

    public void setNumberEngineers(BigInteger numberEngineers) {
        this.numberEngineers = numberEngineers;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductFamily() {
        return productFamily;
    }

    public void setProductFamily(String productFamily) {
        this.productFamily = productFamily;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public BigInteger getResponseTimeActual() {
        return responseTimeActual;
    }

    public void setResponseTimeActual(BigInteger responseTimeActual) {
        this.responseTimeActual = responseTimeActual;
    }

    public BigInteger getResponseTimeContractual() {
        return responseTimeContractual;
    }

    public void setResponseTimeContractual(BigInteger responseTimeContractual) {
        this.responseTimeContractual = responseTimeContractual;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getSystemHandle() {
        return systemHandle;
    }

    public void setSystemHandle(String systemHandle) {
        this.systemHandle = systemHandle;
    }

    public BigInteger getTimeInOpen() {
        return timeInOpen;
    }

    public void setTimeInOpen(BigInteger timeInOpen) {
        this.timeInOpen = timeInOpen;
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

    public BigInteger getTimeToSolveInEscalation() {
        return timeToSolveInEscalation;
    }

    public void setTimeToSolveInEscalation(BigInteger timeToSolveInEscalation) {
        this.timeToSolveInEscalation = timeToSolveInEscalation;
    }

    public String getXCaseProduct() {
        return xCaseProduct;
    }

    public void setXCaseProduct(String xCaseProduct) {
        this.xCaseProduct = xCaseProduct;
    }

    public String getXEscalationLevel() {
        return xEscalationLevel;
    }

    public void setXEscalationLevel(String xEscalationLevel) {
        this.xEscalationLevel = xEscalationLevel;
    }

    public String getXEscalationMgmt() {
        return xEscalationMgmt;
    }

    public void setXEscalationMgmt(String xEscalationMgmt) {
        this.xEscalationMgmt = xEscalationMgmt;
    }

    public BigInteger getCodeIdCallType() {
        return codeIdCallType;
    }

    public void setCodeIdCallType(BigInteger codeIdCallType) {
        this.codeIdCallType = codeIdCallType;
    }

    public BigInteger getCodeIdPriority() {
        return codeIdPriority;
    }

    public void setCodeIdPriority(BigInteger codeIdPriority) {
        this.codeIdPriority = codeIdPriority;
    }

    public BigInteger getCodeIdResolution() {
        return codeIdResolution;
    }

    public void setCodeIdResolution(BigInteger codeIdResolution) {
        this.codeIdResolution = codeIdResolution;
    }

    public BigInteger getCodeIdSeverity() {
        return codeIdSeverity;
    }

    public void setCodeIdSeverity(BigInteger codeIdSeverity) {
        this.codeIdSeverity = codeIdSeverity;
    }

    public BigInteger getCodeIdStatus() {
        return codeIdStatus;
    }

    public void setCodeIdStatus(BigInteger codeIdStatus) {
        this.codeIdStatus = codeIdStatus;
    }

    public BigInteger getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(BigInteger conditionCode) {
        this.conditionCode = conditionCode;
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

    public BigInteger getTimeInWorkaround() {
        return timeInWorkaround;
    }

    public void setTimeInWorkaround(BigInteger timeInWorkaround) {
        this.timeInWorkaround = timeInWorkaround;
    }

    public String getAccessoryXName() {
        return accessoryXName;
    }

    public void setAccessoryXName(String accessoryXName) {
        this.accessoryXName = accessoryXName;
    }

    public String getOsnosXName() {
        return osnosXName;
    }

    public void setOsnosXName(String osnosXName) {
        this.osnosXName = osnosXName;
    }

    public String getXIpModel() {
        return xIpModel;
    }

    public void setXIpModel(String xIpModel) {
        this.xIpModel = xIpModel;
    }

    public BigInteger getDiagnosticIpId() {
        return diagnosticIpId;
    }

    public void setDiagnosticIpId(BigInteger diagnosticIpId) {
        this.diagnosticIpId = diagnosticIpId;
    }

    public BigInteger getDiagtoolIpId() {
        return diagtoolIpId;
    }

    public void setDiagtoolIpId(BigInteger diagtoolIpId) {
        this.diagtoolIpId = diagtoolIpId;
    }

    public BigInteger getQualityIpId() {
        return qualityIpId;
    }

    public void setQualityIpId(BigInteger qualityIpId) {
        this.qualityIpId = qualityIpId;
    }

    public String getContactEMail() {
        return contactEMail;
    }

    public void setContactEMail(String contactEMail) {
        this.contactEMail = contactEMail;
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

    public String getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(String warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public BigInteger getNumberOwners() {
        return numberOwners;
    }

    public void setNumberOwners(BigInteger numberOwners) {
        this.numberOwners = numberOwners;
    }

    public String getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    public String getCustomerTrackingNbr() {
        return customerTrackingNbr;
    }

    public void setCustomerTrackingNbr(String customerTrackingNbr) {
        this.customerTrackingNbr = customerTrackingNbr;
    }

    public String getServiceNoteNumber() {
        return serviceNoteNumber;
    }

    public void setServiceNoteNumber(String serviceNoteNumber) {
        this.serviceNoteNumber = serviceNoteNumber;
    }

    public Date getWarrProofPurchase() {
        return warrProofPurchase;
    }

    public void setWarrProofPurchase(Date warrProofPurchase) {
        this.warrProofPurchase = warrProofPurchase;
    }

    public String getWarrCode() {
        return warrCode;
    }

    public void setWarrCode(String warrCode) {
        this.warrCode = warrCode;
    }

    public String getWarrDesc() {
        return warrDesc;
    }

    public void setWarrDesc(String warrDesc) {
        this.warrDesc = warrDesc;
    }

    public String getWarrResp() {
        return warrResp;
    }

    public void setWarrResp(String warrResp) {
        this.warrResp = warrResp;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCardBillType() {
        return creditCardBillType;
    }

    public void setCreditCardBillType(String creditCardBillType) {
        this.creditCardBillType = creditCardBillType;
    }

    public String getNlsCallType() {
        return nlsCallType;
    }

    public void setNlsCallType(String nlsCallType) {
        this.nlsCallType = nlsCallType;
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

    public String getNlsStatus() {
        return nlsStatus;
    }

    public void setNlsStatus(String nlsStatus) {
        this.nlsStatus = nlsStatus;
    }

    public String getNlsLanguage() {
        return nlsLanguage;
    }

    public void setNlsLanguage(String nlsLanguage) {
        this.nlsLanguage = nlsLanguage;
    }

    public String getNlsResolution() {
        return nlsResolution;
    }

    public void setNlsResolution(String nlsResolution) {
        this.nlsResolution = nlsResolution;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getContactFax() {
        return contactFax;
    }

    public void setContactFax(String contactFax) {
        this.contactFax = contactFax;
    }

    public String getContactPagerNumber() {
        return contactPagerNumber;
    }

    public void setContactPagerNumber(String contactPagerNumber) {
        this.contactPagerNumber = contactPagerNumber;
    }

    public String getContactPagerPin() {
        return contactPagerPin;
    }

    public void setContactPagerPin(String contactPagerPin) {
        this.contactPagerPin = contactPagerPin;
    }

    public String getResponseCoverage() {
        return responseCoverage;
    }

    public void setResponseCoverage(String responseCoverage) {
        this.responseCoverage = responseCoverage;
    }

    public Date getRequestedEta() {
        return requestedEta;
    }

    public void setRequestedEta(Date requestedEta) {
        this.requestedEta = requestedEta;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAltPhoneNum() {
        return altPhoneNum;
    }

    public void setAltPhoneNum(String altPhoneNum) {
        this.altPhoneNum = altPhoneNum;
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

    public String getDeliverableItemDesc() {
        return deliverableItemDesc;
    }

    public void setDeliverableItemDesc(String deliverableItemDesc) {
        this.deliverableItemDesc = deliverableItemDesc;
    }

    public BigInteger getHpReturnId() {
        return hpReturnId;
    }

    public void setHpReturnId(BigInteger hpReturnId) {
        this.hpReturnId = hpReturnId;
    }

    public String getBlueRedCd() {
        return blueRedCd;
    }

    public void setBlueRedCd(String blueRedCd) {
        this.blueRedCd = blueRedCd;
    }

    public Date getContrItmStartDate() {
        return contrItmStartDate;
    }

    public void setContrItmStartDate(Date contrItmStartDate) {
        this.contrItmStartDate = contrItmStartDate;
    }

    public Date getContrItmEndDate() {
        return contrItmEndDate;
    }

    public void setContrItmEndDate(Date contrItmEndDate) {
        this.contrItmEndDate = contrItmEndDate;
    }

    public String getXServiceId() {
        return xServiceId;
    }

    public void setXServiceId(String xServiceId) {
        this.xServiceId = xServiceId;
    }

    public String getObligType() {
        return obligType;
    }

    public void setObligType(String obligType) {
        this.obligType = obligType;
    }

    public Long getEmployeeTam() {
        return employeeTam;
    }

    public void setEmployeeTam(Long employeeTam) {
        this.employeeTam = employeeTam;
    }

    public Long getEmployeeBkupTam() {
        return employeeBkupTam;
    }

    public void setEmployeeBkupTam(Long employeeBkupTam) {
        this.employeeBkupTam = employeeBkupTam;
    }

    public String getLegacyLogNumber() {
        return legacyLogNumber;
    }

    public void setLegacyLogNumber(String legacyLogNumber) {
        this.legacyLogNumber = legacyLogNumber;
    }

    public String getLegacyLogSys() {
        return legacyLogSys;
    }

    public void setLegacyLogSys(String legacyLogSys) {
        this.legacyLogSys = legacyLogSys;
    }

    public Long getEmployeeBkupAcctRep() {
        return employeeBkupAcctRep;
    }

    public void setEmployeeBkupAcctRep(Long employeeBkupAcctRep) {
        this.employeeBkupAcctRep = employeeBkupAcctRep;
    }

    public String getFrontBackLine() {
        return frontBackLine;
    }

    public void setFrontBackLine(String frontBackLine) {
        this.frontBackLine = frontBackLine;
    }

    public Long getIsSupercase() {
        return isSupercase;
    }

    public void setIsSupercase(Long isSupercase) {
        this.isSupercase = isSupercase;
    }

    public Long getCaseVictim2case() {
        return caseVictim2case;
    }

    public void setCaseVictim2case(Long caseVictim2case) {
        this.caseVictim2case = caseVictim2case;
    }

    public String getContactAltPhone() {
        return contactAltPhone;
    }

    public void setContactAltPhone(String contactAltPhone) {
        this.contactAltPhone = contactAltPhone;
    }

    public String getAssignBadgeNum() {
        return assignBadgeNum;
    }

    public void setAssignBadgeNum(String assignBadgeNum) {
        this.assignBadgeNum = assignBadgeNum;
    }

    public Date getEntitleGuaranteedDt() {
        return entitleGuaranteedDt;
    }

    public void setEntitleGuaranteedDt(Date entitleGuaranteedDt) {
        this.entitleGuaranteedDt = entitleGuaranteedDt;
    }

    public Date getRequestedGuaranteedDt() {
        return requestedGuaranteedDt;
    }

    public void setRequestedGuaranteedDt(Date requestedGuaranteedDt) {
        this.requestedGuaranteedDt = requestedGuaranteedDt;
    }

    public String getXProductLine() {
        return xProductLine;
    }

    public void setXProductLine(String xProductLine) {
        this.xProductLine = xProductLine;
    }

    public String getXOtc() {
        return xOtc;
    }

    public void setXOtc(String xOtc) {
        this.xOtc = xOtc;
    }

    public Date getCalculatedEta() {
        return calculatedEta;
    }

    public void setCalculatedEta(Date calculatedEta) {
        this.calculatedEta = calculatedEta;
    }

    public String getHwResponseCode() {
        return hwResponseCode;
    }

    public void setHwResponseCode(String hwResponseCode) {
        this.hwResponseCode = hwResponseCode;
    }

    public Long getXTravelTime() {
        return xTravelTime;
    }

    public void setXTravelTime(Long xTravelTime) {
        this.xTravelTime = xTravelTime;
    }

    public Long getHwCaseElapsedStartToClose() {
        return hwCaseElapsedStartToClose;
    }

    public void setHwCaseElapsedStartToClose(Long hwCaseElapsedStartToClose) {
        this.hwCaseElapsedStartToClose = hwCaseElapsedStartToClose;
    }

    public Short getContinueEffortFlag() {
        return continueEffortFlag;
    }

    public void setContinueEffortFlag(Short continueEffortFlag) {
        this.continueEffortFlag = continueEffortFlag;
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

    public Long getObligatedStartToClose() {
        return obligatedStartToClose;
    }

    public void setObligatedStartToClose(Long obligatedStartToClose) {
        this.obligatedStartToClose = obligatedStartToClose;
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

    public String getGeoIsoCountryCd() {
        return geoIsoCountryCd;
    }

    public void setGeoIsoCountryCd(String geoIsoCountryCd) {
        this.geoIsoCountryCd = geoIsoCountryCd;
    }

    public String getGeoIsoCountryName() {
        return geoIsoCountryName;
    }

    public void setGeoIsoCountryName(String geoIsoCountryName) {
        this.geoIsoCountryName = geoIsoCountryName;
    }

    public String getGeoIsoShipCountryCd() {
        return geoIsoShipCountryCd;
    }

    public void setGeoIsoShipCountryCd(String geoIsoShipCountryCd) {
        this.geoIsoShipCountryCd = geoIsoShipCountryCd;
    }

    public String getGeoIsoShipCountryName() {
        return geoIsoShipCountryName;
    }

    public void setGeoIsoShipCountryName(String geoIsoShipCountryName) {
        this.geoIsoShipCountryName = geoIsoShipCountryName;
    }

    public Date getXDateAuthorized() {
        return xDateAuthorized;
    }

    public void setXDateAuthorized(Date xDateAuthorized) {
        this.xDateAuthorized = xDateAuthorized;
    }

    public Date getXDateQuoteCreated() {
        return xDateQuoteCreated;
    }

    public void setXDateQuoteCreated(Date xDateQuoteCreated) {
        this.xDateQuoteCreated = xDateQuoteCreated;
    }

    public BigInteger getQuotationPeriod() {
        return quotationPeriod;
    }

    public void setQuotationPeriod(BigInteger quotationPeriod) {
        this.quotationPeriod = quotationPeriod;
    }

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Short getFdMissed() {
        return fdMissed;
    }

    public void setFdMissed(Short fdMissed) {
        this.fdMissed = fdMissed;
    }

    public Short getSdMissed() {
        return sdMissed;
    }

    public void setSdMissed(Short sdMissed) {
        this.sdMissed = sdMissed;
    }

    public Short getNdMissed() {
        return ndMissed;
    }

    public void setNdMissed(Short ndMissed) {
        this.ndMissed = ndMissed;
    }

    public Short getCtrMissed() {
        return ctrMissed;
    }

    public void setCtrMissed(Short ctrMissed) {
        this.ctrMissed = ctrMissed;
    }

    public Short getResponseMissedOther() {
        return responseMissedOther;
    }

    public void setResponseMissedOther(Short responseMissedOther) {
        this.responseMissedOther = responseMissedOther;
    }

    public Short getResponseMissed() {
        return responseMissed;
    }

    public void setResponseMissed(Short responseMissed) {
        this.responseMissed = responseMissed;
    }

    public String getOverallCaseCat() {
        return overallCaseCat;
    }

    public void setOverallCaseCat(String overallCaseCat) {
        this.overallCaseCat = overallCaseCat;
    }

    public String getCaseSvcCat() {
        return caseSvcCat;
    }

    public void setCaseSvcCat(String caseSvcCat) {
        this.caseSvcCat = caseSvcCat;
    }

    public String getDeliveryAlternative() {
        return deliveryAlternative;
    }

    public void setDeliveryAlternative(String deliveryAlternative) {
        this.deliveryAlternative = deliveryAlternative;
    }

    public Short getMultipleVisitsFlag() {
        return multipleVisitsFlag;
    }

    public void setMultipleVisitsFlag(Short multipleVisitsFlag) {
        this.multipleVisitsFlag = multipleVisitsFlag;
    }

    public Short getCtrFlag() {
        return ctrFlag;
    }

    public void setCtrFlag(Short ctrFlag) {
        this.ctrFlag = ctrFlag;
    }

    public Short getMcFlag() {
        return mcFlag;
    }

    public void setMcFlag(Short mcFlag) {
        this.mcFlag = mcFlag;
    }

    public Short getM2HwRprCount() {
        return m2HwRprCount;
    }

    public void setM2HwRprCount(Short m2HwRprCount) {
        this.m2HwRprCount = m2HwRprCount;
    }

    public Integer getPartQtyUsed() {
        return partQtyUsed;
    }

    public void setPartQtyUsed(Integer partQtyUsed) {
        this.partQtyUsed = partQtyUsed;
    }

    public Short getRerepair30Days() {
        return rerepair30Days;
    }

    public void setRerepair30Days(Short rerepair30Days) {
        this.rerepair30Days = rerepair30Days;
    }

    public Short getRerepair90Days() {
        return rerepair90Days;
    }

    public void setRerepair90Days(Short rerepair90Days) {
        this.rerepair90Days = rerepair90Days;
    }

    public Integer getDaysBtwnRerpr() {
        return daysBtwnRerpr;
    }

    public void setDaysBtwnRerpr(Integer daysBtwnRerpr) {
        this.daysBtwnRerpr = daysBtwnRerpr;
    }

    public String getPrevDeliveryAlternative() {
        return prevDeliveryAlternative;
    }

    public void setPrevDeliveryAlternative(String prevDeliveryAlternative) {
        this.prevDeliveryAlternative = prevDeliveryAlternative;
    }

    public String getPrevCaseId() {
        return prevCaseId;
    }

    public void setPrevCaseId(String prevCaseId) {
        this.prevCaseId = prevCaseId;
    }

    public Date getPrevOpenDate() {
        return prevOpenDate;
    }

    public void setPrevOpenDate(Date prevOpenDate) {
        this.prevOpenDate = prevOpenDate;
    }

    public Date getPrevFixDate() {
        return prevFixDate;
    }

    public void setPrevFixDate(Date prevFixDate) {
        this.prevFixDate = prevFixDate;
    }

    public Short getM8Qualified() {
        return m8Qualified;
    }

    public void setM8Qualified(Short m8Qualified) {
        this.m8Qualified = m8Qualified;
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

    public Long getHwTurnAroundTime() {
        return hwTurnAroundTime;
    }

    public void setHwTurnAroundTime(Long hwTurnAroundTime) {
        this.hwTurnAroundTime = hwTurnAroundTime;
    }

    public String getXRepairClass() {
        return xRepairClass;
    }

    public void setXRepairClass(String xRepairClass) {
        this.xRepairClass = xRepairClass;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(String caseHistory) {
        this.caseHistory = caseHistory;
    }

    public String getPaymAuthNo() {
        return paymAuthNo;
    }

    public void setPaymAuthNo(String paymAuthNo) {
        this.paymAuthNo = paymAuthNo;
    }

    public BigDecimal getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(BigDecimal totalExp) {
        this.totalExp = totalExp;
    }

    public Long getSupercaseId() {
        return supercaseId;
    }

    public void setSupercaseId(Long supercaseId) {
        this.supercaseId = supercaseId;
    }

    public String getCaseAddress() {
        return caseAddress;
    }

    public void setCaseAddress(String caseAddress) {
        this.caseAddress = caseAddress;
    }

    public String getCaseAddress2() {
        return caseAddress2;
    }

    public void setCaseAddress2(String caseAddress2) {
        this.caseAddress2 = caseAddress2;
    }

    public String getCaseCity() {
        return caseCity;
    }

    public void setCaseCity(String caseCity) {
        this.caseCity = caseCity;
    }

    public String getCaseCountry() {
        return caseCountry;
    }

    public void setCaseCountry(String caseCountry) {
        this.caseCountry = caseCountry;
    }

    public BigDecimal getQuoteTotalAmt() {
        return quoteTotalAmt;
    }

    public void setQuoteTotalAmt(BigDecimal quoteTotalAmt) {
        this.quoteTotalAmt = quoteTotalAmt;
    }

    public Date getQualEndDate() {
        return qualEndDate;
    }

    public void setQualEndDate(Date qualEndDate) {
        this.qualEndDate = qualEndDate;
    }

    public Long getQualInvestHours() {
        return qualInvestHours;
    }

    public void setQualInvestHours(Long qualInvestHours) {
        this.qualInvestHours = qualInvestHours;
    }

    public Long getM1HwCount() {
        return m1HwCount;
    }

    public void setM1HwCount(Long m1HwCount) {
        this.m1HwCount = m1HwCount;
    }

    public Long getM1aHwCount() {
        return m1aHwCount;
    }

    public void setM1aHwCount(Long m1aHwCount) {
        this.m1aHwCount = m1aHwCount;
    }

    public Long getM1bHwCount() {
        return m1bHwCount;
    }

    public void setM1bHwCount(Long m1bHwCount) {
        this.m1bHwCount = m1bHwCount;
    }

    public Long getSelectedOfferId() {
        return selectedOfferId;
    }

    public void setSelectedOfferId(Long selectedOfferId) {
        this.selectedOfferId = selectedOfferId;
    }

    public Long getWarrantyOfferId() {
        return warrantyOfferId;
    }

    public void setWarrantyOfferId(Long warrantyOfferId) {
        this.warrantyOfferId = warrantyOfferId;
    }

    public Long getHpModRefId() {
        return hpModRefId;
    }

    public void setHpModRefId(Long hpModRefId) {
        this.hpModRefId = hpModRefId;
    }

    public Date getLastStatusChangeDate() {
        return lastStatusChangeDate;
    }

    public void setLastStatusChangeDate(Date lastStatusChangeDate) {
        this.lastStatusChangeDate = lastStatusChangeDate;
    }

    public String getOnsiteOffsiteFl() {
        return onsiteOffsiteFl;
    }

    public void setOnsiteOffsiteFl(String onsiteOffsiteFl) {
        this.onsiteOffsiteFl = onsiteOffsiteFl;
    }

    public BigDecimal getOnsiteAdminClosureTime() {
        return onsiteAdminClosureTime;
    }

    public void setOnsiteAdminClosureTime(BigDecimal onsiteAdminClosureTime) {
        this.onsiteAdminClosureTime = onsiteAdminClosureTime;
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

    public String getContactPrefLanguage() {
        return contactPrefLanguage;
    }

    public void setContactPrefLanguage(String contactPrefLanguage) {
        this.contactPrefLanguage = contactPrefLanguage;
    }

    public String getXOverrideSerialNo() {
        return xOverrideSerialNo;
    }

    public void setXOverrideSerialNo(String xOverrideSerialNo) {
        this.xOverrideSerialNo = xOverrideSerialNo;
    }

    public String getOverridePartNumber() {
        return overridePartNumber;
    }

    public void setOverridePartNumber(String overridePartNumber) {
        this.overridePartNumber = overridePartNumber;
    }

    public String getAltFirstName() {
        return altFirstName;
    }

    public void setAltFirstName(String altFirstName) {
        this.altFirstName = altFirstName;
    }

    public String getAltLastName() {
        return altLastName;
    }

    public void setAltLastName(String altLastName) {
        this.altLastName = altLastName;
    }

    public Long getSitePartId() {
        return sitePartId;
    }

    public void setSitePartId(Long sitePartId) {
        this.sitePartId = sitePartId;
    }

    public Long getHpId() {
        return hpId;
    }

    public void setHpId(Long hpId) {
        this.hpId = hpId;
    }

    public Long getXCase2entitlementId() {
        return xCase2entitlementId;
    }

    public void setXCase2entitlementId(Long xCase2entitlementId) {
        this.xCase2entitlementId = xCase2entitlementId;
    }

    public Long getXCase2serviceId() {
        return xCase2serviceId;
    }

    public void setXCase2serviceId(Long xCase2serviceId) {
        this.xCase2serviceId = xCase2serviceId;
    }

    public Long getXCase2searchedId() {
        return xCase2searchedId;
    }

    public void setXCase2searchedId(Long xCase2searchedId) {
        this.xCase2searchedId = xCase2searchedId;
    }

    public String getXCid() {
        return xCid;
    }

    public void setXCid(String xCid) {
        this.xCid = xCid;
    }

    public String getCclist1() {
        return cclist1;
    }

    public void setCclist1(String cclist1) {
        this.cclist1 = cclist1;
    }

    public String getCclist2() {
        return cclist2;
    }

    public void setCclist2(String cclist2) {
        this.cclist2 = cclist2;
    }

    public Long getHwTatNonWorkDay() {
        return hwTatNonWorkDay;
    }

    public void setHwTatNonWorkDay(Long hwTatNonWorkDay) {
        this.hwTatNonWorkDay = hwTatNonWorkDay;
    }

    public Long getCurrentQueueId() {
        return currentQueueId;
    }

    public void setCurrentQueueId(Long currentQueueId) {
        this.currentQueueId = currentQueueId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getHpPartnerId() {
        return hpPartnerId;
    }

    public void setHpPartnerId(Long hpPartnerId) {
        this.hpPartnerId = hpPartnerId;
    }

    public Short getCustomerRescheduledMissed() {
        return customerRescheduledMissed;
    }

    public void setCustomerRescheduledMissed(Short customerRescheduledMissed) {
        this.customerRescheduledMissed = customerRescheduledMissed;
    }

    public Short getVoidResolutionFlag() {
        return voidResolutionFlag;
    }

    public void setVoidResolutionFlag(Short voidResolutionFlag) {
        this.voidResolutionFlag = voidResolutionFlag;
    }

    public BigInteger getXHomeSoil() {
        return xHomeSoil;
    }

    public void setXHomeSoil(BigInteger xHomeSoil) {
        this.xHomeSoil = xHomeSoil;
    }

    public String getXRplStatus() {
        return xRplStatus;
    }

    public void setXRplStatus(String xRplStatus) {
        this.xRplStatus = xRplStatus;
    }

    public String getXProdGrp() {
        return xProdGrp;
    }

    public void setXProdGrp(String xProdGrp) {
        this.xProdGrp = xProdGrp;
    }

    public String getXProdSubgrp() {
        return xProdSubgrp;
    }

    public void setXProdSubgrp(String xProdSubgrp) {
        this.xProdSubgrp = xProdSubgrp;
    }

    public BigInteger getXOnsiteSubcFlag() {
        return xOnsiteSubcFlag;
    }

    public void setXOnsiteSubcFlag(BigInteger xOnsiteSubcFlag) {
        this.xOnsiteSubcFlag = xOnsiteSubcFlag;
    }

    public String getXSalesOrderNumber() {
        return xSalesOrderNumber;
    }

    public void setXSalesOrderNumber(String xSalesOrderNumber) {
        this.xSalesOrderNumber = xSalesOrderNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getXMvMfrName() {
        return xMvMfrName;
    }

    public void setXMvMfrName(String xMvMfrName) {
        this.xMvMfrName = xMvMfrName;
    }

    public String getXMvPartNumber() {
        return xMvPartNumber;
    }

    public void setXMvPartNumber(String xMvPartNumber) {
        this.xMvPartNumber = xMvPartNumber;
    }

    public String getXMdcpCustId() {
        return xMdcpCustId;
    }

    public void setXMdcpCustId(String xMdcpCustId) {
        this.xMdcpCustId = xMdcpCustId;
    }

    public String getAmid2() {
        return amid2;
    }

    public void setAmid2(String amid2) {
        this.amid2 = amid2;
    }

    public String getAmid3() {
        return amid3;
    }

    public void setAmid3(String amid3) {
        this.amid3 = amid3;
    }

    public String getAmid4() {
        return amid4;
    }

    public void setAmid4(String amid4) {
        this.amid4 = amid4;
    }

    public String getSdsId() {
        return sdsId;
    }

    public void setSdsId(String sdsId) {
        this.sdsId = sdsId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (accountabilityId != null ? accountabilityId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfmCase)) {
            return false;
        }
        WfmCase other = (WfmCase) object;
        if ((this.accountabilityId == null && other.accountabilityId != null) || (this.accountabilityId != null && !this.accountabilityId.equals(other.accountabilityId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader.columbo.entity.WfmCase[ accountabilityId=" + accountabilityId + " ]";
    }

}
