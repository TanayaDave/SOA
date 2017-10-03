/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjesu.truckshippingsystem;

/**
 *
 * @author user
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.truckshippingsystem.org/customer")

public class Customer { 
    
    private String custName;
    private int custId;
    private String custTitle;
    private Address address;
    private ContactDetails contactdetails;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustTitle() {
        return custTitle;
    }

    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
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
    
    
    
    
}
