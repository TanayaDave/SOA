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
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.truckshippingsystem.org/driver")
public class Driver {
    
    private int driverId;
    private String driverName;
    private String driverLicNo;
    private String driverLicState;
    private String type;
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicNo() {
        return driverLicNo;
    }

    public void setDriverLicNo(String driverLicNo) {
        this.driverLicNo = driverLicNo;
    }

    public String getDriverLicState() {
        return driverLicState;
    }

    public void setDriverLicState(String driverLicState) {
        this.driverLicState = driverLicState;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
