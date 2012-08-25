/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 1:44 PM
 */

package eu.artofcoding.grownloader2.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Table2 implements Serializable {

    private String customer;
    private BigDecimal id;
    private Timestamp bla;
    private Timestamp blub;
    private String anotherData;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Timestamp getBla() {
        return bla;
    }

    public void setBla(Timestamp bla) {
        this.bla = bla;
    }

    public Timestamp getBlub() {
        return blub;
    }

    public void setBlub(Timestamp blub) {
        this.blub = blub;
    }

    public String getAnotherData() {
        return anotherData;
    }

    public void setAnotherData(String anotherData) {
        this.anotherData = anotherData;
    }

}
