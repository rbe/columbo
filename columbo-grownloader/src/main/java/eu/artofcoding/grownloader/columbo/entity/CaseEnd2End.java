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

public class CaseEnd2End implements Serializable {

    private static final long serialVersionUID = 1L;

    private String caseId;

    private String accountabilityId;

    private String callType;

    private String caseTitle;

    private String addnlInfoInitialPriority;

    private String currentPriority;

    private String addnlInfoInitialSeverity;

    private String currentSeverity;

    private String currentStatus;

    private String conditionCodeValue;

    private BigInteger nbReopen;

    private BigInteger numberEngineers;

    private BigInteger numberOwners;

    private String contractId;

    private String systemHandle;

    private String name;

    private String address;

    private String address2;

    private String zipCode;

    private String city;

    private String country;

    private String maid;

    private String segment;

    private String creditCard;

    private String creditCardBillType;

    private String contactFirstName;

    private String contactLastName;

    private String callerPhone;

    private String contactEMail;

    private String domain;

    private String productFamily;

    private String routing;

    private String platform;

    private String product;

    private String productDescription;

    private String caseCategory;

    private String productLine;

    private String serialNumber;

    private String serviceNoteNumber;

    private Date warrProofPurchase;

    private String warrCode;

    private String warrDesc;

    private String warrResp;

    private String customerTrackingNbr;

    private Date crDateGmt;

    private Date crDateCust;

    private String crLoginName;

    private String crWorkGroup;

    private String crEmployeeFirstName;

    private String crEmployeeLastName;

    private String crResponseCenter;

    private String crCountry;

    private BigInteger crTimeZoneId;

    private String irFirstStatusChange;

    private BigInteger timeToFirstResponseMins;

    private BigInteger responseTimeContractualMins;

    private Date irDateGmt;

    private Date irDateCust;

    private String irLoginName;

    private String irWorkGroup;

    private String irEmployeeFirstName;

    private String irEmployeeLastName;

    private String irResponseCenter;

    private String irCountry;

    private BigInteger irTimeZoneId;

    private String laAtd;

    private Date laDateGmt;

    private Date laDateCust;

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

    private Date clDateCust;

    private String clLoginName;

    private String clWorkGroup;

    private String clEmployeeFirstName;

    private String clEmployeeLastName;

    private String clResponseCenter;

    private String clCountry;

    private BigInteger clTimeZoneId;

    private String summaryText;

    private String resolution;

    private String warrantyStatus;

    private BigInteger timeInOpenMins;

    private BigInteger elapsedTimeMins;

    private BigInteger timeInMonitorMins;

    private BigInteger ttlTimeInvestBillMins;

    private BigInteger ttlTimeInvestNonBillMins;

    private BigInteger ttlTimeInvestPhoneMins;

    private BigInteger ttlTimeInvestResearchMins;

    private String xEscalationLevel;

    private String xEscalationManagement;

    private BigInteger timeToSolveInEscalation;

    private String accessoryXName;

    private String osnosXName;

    private String xIpModel;

    private BigInteger diagnosticIpId;

    private BigInteger diagtoolIpId;

    private BigInteger qualityIpId;

    private String nlsLanguage;

    private String nlsCallType;

    private String nlsPriority;

    private String nlsSeverity;

    private String nlsStatus;

    private String nlsResolution;

    private Date dateModified;

    private BigDecimal employeeOwner;

    private BigInteger employeeOriginator;

    private BigInteger employeeCloser;

    private Date dateAdded;

    private Long xTravelTimeMins;

    private Long hwCaseElapsedStartToClose;

    private Short continueEffortFlag;

    private Long obligatedLogToStart;

    private Long obligatedLogToClose;

    private Long obligatedStartToClose;

    private BigInteger totalInvestedTimeMins;

    private String wdbDistrict;

    private String wdbProductLine;

    private String wdbWorkForce;

    private String wdbOffice;

    private String geoIsoCountryCd;

    private String geoIsoCountryName;

    private String geoIsoShipCountryCd;

    private String geoIsoShipCountryName;

    private String entryPoint;

    private Short responseMissed;

    private String deliveryAlternative;

    private Short ctrFlag;

    private Date onsiteFixedDate;

    private Date qualStartDate;

    private Long qualEmployeeTableId;

    private String xHpId;

    private Short xTypeCd;

    private String entitlementXHpId;

    private Short entitlementXTypeCd;

    private String serviceXHpId;

    private Short serviceXTypeCd;

    private String searchedXHpId;

    private Short searchedXTypeCd;

    private String xServiceId;

    private String statePrvncName;

    private Short m8Qualified;

    private Short customerRescheduledMissed;

    private Short m1HwCount;

    private Short m1aHwCount;

    private Short m1bHwCount;

    private Short m2HwRprCount;

    private String pin;

    private BigInteger hpAuthEmployeeId;

    public CaseEnd2End() {
    }

    public CaseEnd2End(String caseId) {
        this.caseId = caseId;
    }

    public CaseEnd2End(String caseId, String accountabilityId) {
        this.caseId = caseId;
        this.accountabilityId = accountabilityId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getAccountabilityId() {
        return accountabilityId;
    }

    public void setAccountabilityId(String accountabilityId) {
        this.accountabilityId = accountabilityId;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getAddnlInfoInitialPriority() {
        return addnlInfoInitialPriority;
    }

    public void setAddnlInfoInitialPriority(String addnlInfoInitialPriority) {
        this.addnlInfoInitialPriority = addnlInfoInitialPriority;
    }

    public String getCurrentPriority() {
        return currentPriority;
    }

    public void setCurrentPriority(String currentPriority) {
        this.currentPriority = currentPriority;
    }

    public String getAddnlInfoInitialSeverity() {
        return addnlInfoInitialSeverity;
    }

    public void setAddnlInfoInitialSeverity(String addnlInfoInitialSeverity) {
        this.addnlInfoInitialSeverity = addnlInfoInitialSeverity;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getSystemHandle() {
        return systemHandle;
    }

    public void setSystemHandle(String systemHandle) {
        this.systemHandle = systemHandle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaid() {
        return maid;
    }

    public void setMaid(String maid) {
        this.maid = maid;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
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

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getContactEMail() {
        return contactEMail;
    }

    public void setContactEMail(String contactEMail) {
        this.contactEMail = contactEMail;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProductFamily() {
        return productFamily;
    }

    public void setProductFamily(String productFamily) {
        this.productFamily = productFamily;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getCustomerTrackingNbr() {
        return customerTrackingNbr;
    }

    public void setCustomerTrackingNbr(String customerTrackingNbr) {
        this.customerTrackingNbr = customerTrackingNbr;
    }

    public Date getCrDateGmt() {
        return crDateGmt;
    }

    public void setCrDateGmt(Date crDateGmt) {
        this.crDateGmt = crDateGmt;
    }

    public Date getCrDateCust() {
        return crDateCust;
    }

    public void setCrDateCust(Date crDateCust) {
        this.crDateCust = crDateCust;
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

    public String getIrFirstStatusChange() {
        return irFirstStatusChange;
    }

    public void setIrFirstStatusChange(String irFirstStatusChange) {
        this.irFirstStatusChange = irFirstStatusChange;
    }

    public BigInteger getTimeToFirstResponseMins() {
        return timeToFirstResponseMins;
    }

    public void setTimeToFirstResponseMins(BigInteger timeToFirstResponseMins) {
        this.timeToFirstResponseMins = timeToFirstResponseMins;
    }

    public BigInteger getResponseTimeContractualMins() {
        return responseTimeContractualMins;
    }

    public void setResponseTimeContractualMins(BigInteger responseTimeContractualMins) {
        this.responseTimeContractualMins = responseTimeContractualMins;
    }

    public Date getIrDateGmt() {
        return irDateGmt;
    }

    public void setIrDateGmt(Date irDateGmt) {
        this.irDateGmt = irDateGmt;
    }

    public Date getIrDateCust() {
        return irDateCust;
    }

    public void setIrDateCust(Date irDateCust) {
        this.irDateCust = irDateCust;
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

    public Date getLaDateCust() {
        return laDateCust;
    }

    public void setLaDateCust(Date laDateCust) {
        this.laDateCust = laDateCust;
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

    public Date getClDateCust() {
        return clDateCust;
    }

    public void setClDateCust(Date clDateCust) {
        this.clDateCust = clDateCust;
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

    public String getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(String warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
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

    public String getXEscalationLevel() {
        return xEscalationLevel;
    }

    public void setXEscalationLevel(String xEscalationLevel) {
        this.xEscalationLevel = xEscalationLevel;
    }

    public String getXEscalationManagement() {
        return xEscalationManagement;
    }

    public void setXEscalationManagement(String xEscalationManagement) {
        this.xEscalationManagement = xEscalationManagement;
    }

    public BigInteger getTimeToSolveInEscalation() {
        return timeToSolveInEscalation;
    }

    public void setTimeToSolveInEscalation(BigInteger timeToSolveInEscalation) {
        this.timeToSolveInEscalation = timeToSolveInEscalation;
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

    public String getNlsLanguage() {
        return nlsLanguage;
    }

    public void setNlsLanguage(String nlsLanguage) {
        this.nlsLanguage = nlsLanguage;
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

    public BigDecimal getEmployeeOwner() {
        return employeeOwner;
    }

    public void setEmployeeOwner(BigDecimal employeeOwner) {
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

    public Long getXTravelTimeMins() {
        return xTravelTimeMins;
    }

    public void setXTravelTimeMins(Long xTravelTimeMins) {
        this.xTravelTimeMins = xTravelTimeMins;
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

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Short getResponseMissed() {
        return responseMissed;
    }

    public void setResponseMissed(Short responseMissed) {
        this.responseMissed = responseMissed;
    }

    public String getDeliveryAlternative() {
        return deliveryAlternative;
    }

    public void setDeliveryAlternative(String deliveryAlternative) {
        this.deliveryAlternative = deliveryAlternative;
    }

    public Short getCtrFlag() {
        return ctrFlag;
    }

    public void setCtrFlag(Short ctrFlag) {
        this.ctrFlag = ctrFlag;
    }

    public Date getOnsiteFixedDate() {
        return onsiteFixedDate;
    }

    public void setOnsiteFixedDate(Date onsiteFixedDate) {
        this.onsiteFixedDate = onsiteFixedDate;
    }

    public Date getQualStartDate() {
        return qualStartDate;
    }

    public void setQualStartDate(Date qualStartDate) {
        this.qualStartDate = qualStartDate;
    }

    public Long getQualEmployeeTableId() {
        return qualEmployeeTableId;
    }

    public void setQualEmployeeTableId(Long qualEmployeeTableId) {
        this.qualEmployeeTableId = qualEmployeeTableId;
    }

    public String getXHpId() {
        return xHpId;
    }

    public void setXHpId(String xHpId) {
        this.xHpId = xHpId;
    }

    public Short getXTypeCd() {
        return xTypeCd;
    }

    public void setXTypeCd(Short xTypeCd) {
        this.xTypeCd = xTypeCd;
    }

    public String getEntitlementXHpId() {
        return entitlementXHpId;
    }

    public void setEntitlementXHpId(String entitlementXHpId) {
        this.entitlementXHpId = entitlementXHpId;
    }

    public Short getEntitlementXTypeCd() {
        return entitlementXTypeCd;
    }

    public void setEntitlementXTypeCd(Short entitlementXTypeCd) {
        this.entitlementXTypeCd = entitlementXTypeCd;
    }

    public String getServiceXHpId() {
        return serviceXHpId;
    }

    public void setServiceXHpId(String serviceXHpId) {
        this.serviceXHpId = serviceXHpId;
    }

    public Short getServiceXTypeCd() {
        return serviceXTypeCd;
    }

    public void setServiceXTypeCd(Short serviceXTypeCd) {
        this.serviceXTypeCd = serviceXTypeCd;
    }

    public String getSearchedXHpId() {
        return searchedXHpId;
    }

    public void setSearchedXHpId(String searchedXHpId) {
        this.searchedXHpId = searchedXHpId;
    }

    public Short getSearchedXTypeCd() {
        return searchedXTypeCd;
    }

    public void setSearchedXTypeCd(Short searchedXTypeCd) {
        this.searchedXTypeCd = searchedXTypeCd;
    }

    public String getXServiceId() {
        return xServiceId;
    }

    public void setXServiceId(String xServiceId) {
        this.xServiceId = xServiceId;
    }

    public String getStatePrvncName() {
        return statePrvncName;
    }

    public void setStatePrvncName(String statePrvncName) {
        this.statePrvncName = statePrvncName;
    }

    public Short getM8Qualified() {
        return m8Qualified;
    }

    public void setM8Qualified(Short m8Qualified) {
        this.m8Qualified = m8Qualified;
    }

    public Short getCustomerRescheduledMissed() {
        return customerRescheduledMissed;
    }

    public void setCustomerRescheduledMissed(Short customerRescheduledMissed) {
        this.customerRescheduledMissed = customerRescheduledMissed;
    }

    public Short getM1HwCount() {
        return m1HwCount;
    }

    public void setM1HwCount(Short m1HwCount) {
        this.m1HwCount = m1HwCount;
    }

    public Short getM1aHwCount() {
        return m1aHwCount;
    }

    public void setM1aHwCount(Short m1aHwCount) {
        this.m1aHwCount = m1aHwCount;
    }

    public Short getM1bHwCount() {
        return m1bHwCount;
    }

    public void setM1bHwCount(Short m1bHwCount) {
        this.m1bHwCount = m1bHwCount;
    }

    public Short getM2HwRprCount() {
        return m2HwRprCount;
    }

    public void setM2HwRprCount(Short m2HwRprCount) {
        this.m2HwRprCount = m2HwRprCount;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigInteger getHpAuthEmployeeId() {
        return hpAuthEmployeeId;
    }

    public void setHpAuthEmployeeId(BigInteger hpAuthEmployeeId) {
        this.hpAuthEmployeeId = hpAuthEmployeeId;
    }

    public int hashCode() {
        int hash = 0;
        hash += (caseId != null ? caseId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaseEnd2End)) {
            return false;
        }
        CaseEnd2End other = (CaseEnd2End) object;
        if ((this.caseId == null && other.caseId != null) || (this.caseId != null && !this.caseId.equals(other.caseId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader.columbo.entity.CaseEnd2End[ caseId=" + caseId + " ]";
    }

}
