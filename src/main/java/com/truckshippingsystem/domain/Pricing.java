/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pricing")

public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int priceId;
    private int locCodeFrom;
    private int locCodeTo;
    private String locIdFrom;
    private String locIdTo;
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

    public String getLocIdFrom() {
        return locIdFrom;
    }

    public void setLocIdFrom(String locIdFrom) {
        this.locIdFrom = locIdFrom;
    }

    public String getLocIdTo() {
        return locIdTo;
    }

    public void setLocIdTo(String locIdTo) {
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

    @Override
    public String toString() {
        return "Pricing{" + "priceId=" + priceId + ", locCodeFrom=" + locCodeFrom + ", locCodeTo=" + locCodeTo + ", locIdFrom=" + locIdFrom + ", locIdTo=" + locIdTo + ", locNameFrom=" + locNameFrom + ", locNameTo=" + locNameTo + ", custId=" + custId + '}';
    }

  
}
