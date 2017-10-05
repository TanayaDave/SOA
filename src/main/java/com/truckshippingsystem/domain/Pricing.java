/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domain;

/**
 *
 * @author user
 */

public class Pricing {
    
    private int priceId;
    private int locCodeFrom;
    private int locCodeTo;
    private int locIdFrom;
    private int locIdTo;
    private String locNameFrom;
    private String locNameTo;
    private int custId;

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getLocCodeFrom() {
        return locCodeFrom;
    }

    public void setLocCodeFrom(int locCodeFrom) {
        this.locCodeFrom = locCodeFrom;
    }

    public int getLocCodeTo() {
        return locCodeTo;
    }

    public void setLocCodeTo(int locCodeTo) {
        this.locCodeTo = locCodeTo;
    }

    public int getLocIdFrom() {
        return locIdFrom;
    }

    public void setLocIdFrom(int locIdFrom) {
        this.locIdFrom = locIdFrom;
    }

    public int getLocIdTo() {
        return locIdTo;
    }

    public void setLocIdTo(int locIdTo) {
        this.locIdTo = locIdTo;
    }

    public String getLocNameFrom() {
        return locNameFrom;
    }

    public void setLocNameFrom(String locNameFrom) {
        this.locNameFrom = locNameFrom;
    }

    public String getLocNameTo() {
        return locNameTo;
    }

    public void setLocNameTo(String locNameTo) {
        this.locNameTo = locNameTo;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    
    
}
