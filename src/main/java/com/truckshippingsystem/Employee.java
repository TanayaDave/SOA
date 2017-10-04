/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem;

/**
 *
 * @author shrikantjesu
 */
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.truckshippingsystem.org/employee")
public class Employee {

    private String name;
    
    private int id;
    
    private String role;
    
    private Address address;

    private String email;

    private Integer cellNo;

    private Integer ssn;

    private Date dob;

    private Date dateHired;

    /**
     * Get the value of dateHired
     *
     * @return the value of dateHired
     */
    public Date getDateHired() {
        return dateHired;
    }

    /**
     * Set the value of dateHired
     *
     * @param dateHired new value of dateHired
     */
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    /**
     * Get the value of dob
     *
     * @return the value of dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Set the value of dob
     *
     * @param dob new value of dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Get the value of ssn
     *
     * @return the value of ssn
     */
    public Integer getSsn() {
        return ssn;
    }

    /**
     * Set the value of ssn
     *
     * @param ssn new value of ssn
     */
    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    /**
     * Get the value of cellNo
     *
     * @return the value of cellNo
     */
    public Integer getCellNo() {
        return cellNo;
    }

    /**
     * Set the value of cellNo
     *
     * @param cellNo new value of cellNo
     */
    public void setCellNo(Integer cellNo) {
        this.cellNo = cellNo;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

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

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", role=" + role  + ", email=" + email + ", cellNo=" + cellNo + ", ssn=" + ssn + ", dob=" + dob + ", dateHired=" + dateHired + ", address=" + address.toString()+ '}';
    }
    
}
