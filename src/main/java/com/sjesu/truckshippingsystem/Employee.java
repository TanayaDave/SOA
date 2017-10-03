/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjesu.truckshippingsystem;

/**
 *
 * @author shrikantjesu
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.truckshippingsystem.org/employee")
public class Employee {
    private String name;
    private int id;
    private String role;
    private Address address;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @XmlAttribute
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
}
