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
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String empFirstName;

    private String empLastName;

    private String role;

    @Embedded
    private Address address;

    private Integer ssn;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Temporal(TemporalType.DATE)
    private Date dateHired;

    @Embedded
    private ContactDetails cotactDetails;

    /**
     * Get the value of empLastName
     *
     * @return the value of empLastName
     */
    public String getEmpLastName() {
        return empLastName;
    }

    /**
     * Set the value of empLastName
     *
     * @param empLastName new value of empLastName
     */
    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    /**
     * Get the value of cotactDetails
     *
     * @return the value of cotactDetails
     */
    public ContactDetails getCotactDetails() {
        return cotactDetails;
    }

    /**
     * Set the value of cotactDetails
     *
     * @param cotactDetails new value of cotactDetails
     */
    public void setCotactDetails(ContactDetails cotactDetails) {
        this.cotactDetails = cotactDetails;
    }

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

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Employee{" + "name=" + empFirstName + ", id=" + id + ", role=" + role + ", ssn=" + ssn + ", dob=" + dob + ", dateHired=" + dateHired + ", address=" + address.toString() + '}';
    }

}
