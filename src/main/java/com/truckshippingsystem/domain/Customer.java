/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String custFirstName;
    private String custTitle;
    private String custLastName;
    @Embedded
    private Address address;
    @Embedded
    private ContactDetails contactdetails;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    List<Order> orders = new ArrayList<>();

    public void addOrders(Order order) {
        this.orders.add(order);
        order.setCustomer(this);
    }

    /**
     * Get the value of custLastName
     *
     * @return the value of custLastName
     */
    public String getCustLastName() {
        return custLastName;
    }

    /**
     * Set the value of custLastName
     *
     * @param custLastName new value of custLastName
     */
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
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
