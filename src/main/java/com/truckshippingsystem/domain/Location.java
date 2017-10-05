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

public class Location {
    
    private int locId;
    private String locName;
    private int custId;
    private int locCode;
    private Address address;
    private ContactDetails contactdetails;

    public int getLocCode() {
        return locCode;
    }

    public void setLocCode(int locCode) {
        this.locCode = locCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactDetails getContactdetails() {
        return contactdetails;
    }

    public void setContactdetails(ContactDetails contactdetails) {
        this.contactdetails = contactdetails;
    }
    
    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    
}
