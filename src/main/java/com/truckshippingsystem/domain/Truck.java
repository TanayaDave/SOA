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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String vin;
    private String color;
    private int capacity;
    private String type;
    private String licPlateNo;
    private String make;
    private String year;
    @OneToMany(mappedBy = "truck")
    private List<Drivers> drivers = new ArrayList<>();
   
    public void addDrivers(Drivers a) {
        this.drivers.add(a);
        a.setTruck(this);
    }

    public Truck() {
    }

    public Truck(int id, String vin, String color, int capacity, String type, String licPlateNo, String make, String year) {
        this.id = id;
        this.vin = vin;
        this.color = color;
        this.capacity = capacity;
        this.type = type;
        this.licPlateNo = licPlateNo;
        this.make = make;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicPlateNo() {
        return licPlateNo;
    }

    public void setLicPlateNo(String licPlateNo) {
        this.licPlateNo = licPlateNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Drivers> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Drivers> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Truck{" + "id=" + id + ", vin=" + vin + ", color=" + color + ", capacity=" + capacity + ", type=" + type + ", licPlateNo=" + licPlateNo + ", make=" + make + ", year=" + year + ", drivers=" + drivers + '}';
    }

}
