/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domain;

/**
 *
 * @author shrikantjesu
 */
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private int zip;
    private String addressLine1;
    private String addressLine2;   
    private String state;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
     public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", zip=" + zip + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + '}';
    }
    
    
    
}
