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
import javax.xml.bind.annotation.XmlAttribute;

public class EmployeeTEst {

    
    private int empId;
    private String fName;
    private String lName;
    private String designation;
    private Integer ssn;
    private Date dob;
    private Date dateHired;
    private Address address;

    public EmployeeTEst(Integer empId, String fName, String lName, String designation, Integer ssn,Address addrs) {
        this.empId = empId;
        this.fName = fName;
        this.lName = lName;
        this.designation = designation;
        this.ssn = ssn;
        this.address=addrs;
    }

    
    public String getFName() {
        return fName;
    }

    public void setName(String fName) {
        this.fName = fName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get the value of empId
     *
     * @return the value of empId
     */
    @XmlAttribute
    public int getEmpId() {
        return empId;
    }

    /**
     * Set the value of empId
     *
     * @param empId new value of empId
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * Get the value of lName
     *
     * @return the value of lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * Set the value of lName
     *
     * @param lName new value of lName
     */
    public void setlName(String lName) {
        this.lName = lName;
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

}
