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
import java.util.Date;

public class HpOfferDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long offerId;

    private Date endDate;

    private Long offerRefId;

    private Long pkgRefId;

    private String profitCenter;

    private String svcProductLine;

    private String salesOrderNumber;

    private String sourceObligationId;

    private Long standAloneFlag;

    private String entitlementTypeCd;

    private String lineItem;

    private Long qtyAvailable;

    private Long qtyPurchased;

    private Date startDate;

    private String statusCd;

    private String termCd;

    private String warrantyComment;

    private Date dateAdded;

    private Date dateModified;

    private Short xIncidentBasedFlag;

    public HpOfferDm() {
    }

    public HpOfferDm(Long offerId) {
        this.offerId = offerId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getOfferRefId() {
        return offerRefId;
    }

    public void setOfferRefId(Long offerRefId) {
        this.offerRefId = offerRefId;
    }

    public Long getPkgRefId() {
        return pkgRefId;
    }

    public void setPkgRefId(Long pkgRefId) {
        this.pkgRefId = pkgRefId;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getSvcProductLine() {
        return svcProductLine;
    }

    public void setSvcProductLine(String svcProductLine) {
        this.svcProductLine = svcProductLine;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getSourceObligationId() {
        return sourceObligationId;
    }

    public void setSourceObligationId(String sourceObligationId) {
        this.sourceObligationId = sourceObligationId;
    }

    public Long getStandAloneFlag() {
        return standAloneFlag;
    }

    public void setStandAloneFlag(Long standAloneFlag) {
        this.standAloneFlag = standAloneFlag;
    }

    public String getEntitlementTypeCd() {
        return entitlementTypeCd;
    }

    public void setEntitlementTypeCd(String entitlementTypeCd) {
        this.entitlementTypeCd = entitlementTypeCd;
    }

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public Long getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(Long qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    public Long getQtyPurchased() {
        return qtyPurchased;
    }

    public void setQtyPurchased(Long qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getTermCd() {
        return termCd;
    }

    public void setTermCd(String termCd) {
        this.termCd = termCd;
    }

    public String getWarrantyComment() {
        return warrantyComment;
    }

    public void setWarrantyComment(String warrantyComment) {
        this.warrantyComment = warrantyComment;
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

    public Short getXIncidentBasedFlag() {
        return xIncidentBasedFlag;
    }

    public void setXIncidentBasedFlag(Short xIncidentBasedFlag) {
        this.xIncidentBasedFlag = xIncidentBasedFlag;
    }

    public int hashCode() {
        int hash = 0;
        hash += (offerId != null ? offerId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpOfferDm)) {
            return false;
        }
        HpOfferDm other = (HpOfferDm) object;
        if ((this.offerId == null && other.offerId != null) || (this.offerId != null && !this.offerId.equals(other.offerId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.HpOfferDm[ offerId=" + offerId + " ]";
    }

}
