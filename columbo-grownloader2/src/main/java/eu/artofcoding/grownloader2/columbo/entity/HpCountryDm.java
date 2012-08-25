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

package eu.artofcoding.grownloader2.columbo.entity;

import java.io.Serializable;

public class HpCountryDm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long countryId;

    private Long countryCode;

    private Long dev;

    private Long currencyId;

    private String xIsoCode;

    private String xCharacterSet;

    private String xSuperRegion;

    private String name;

    public HpCountryDm() {
    }

    public HpCountryDm(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }

    public Long getDev() {
        return dev;
    }

    public void setDev(Long dev) {
        this.dev = dev;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getXIsoCode() {
        return xIsoCode;
    }

    public void setXIsoCode(String xIsoCode) {
        this.xIsoCode = xIsoCode;
    }

    public String getXCharacterSet() {
        return xCharacterSet;
    }

    public void setXCharacterSet(String xCharacterSet) {
        this.xCharacterSet = xCharacterSet;
    }

    public String getXSuperRegion() {
        return xSuperRegion;
    }

    public void setXSuperRegion(String xSuperRegion) {
        this.xSuperRegion = xSuperRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpCountryDm)) {
            return false;
        }
        HpCountryDm other = (HpCountryDm) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "eu.artofcoding.grownloader2.columbo.entity.HpCountryDm[ countryId=" + countryId + " ]";
    }

}
