/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "CId")
    private int custId;

    @Column(name = "OrdDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "EmpId")
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "untCost")
    private Integer unitCost;

    @Column(name = "qty")
    private Integer qnty;

    @Column(name = "lId")
    private Integer locId;

    @Column(name = "tId")
    private Integer truckId;

    @Column(name = "ttlAmt")
    private Integer totalAmount;

    
    /**
     * Get the value of truckId
     *
     * @return the value of truckId
     */
    public Integer getTruckId() {
        return truckId;
    }

    /**
     * Set the value of truckId
     *
     * @param truckId new value of truckId
     */
    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    /**
     * Get the value of totalAmount
     *
     * @return the value of totalAmount
     */
    public Integer getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the value of totalAmount
     *
     * @param totalAmount new value of totalAmount
     */
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the value of locId
     *
     * @return the value of locId
     */
    public Integer getLocId() {
        return locId;
    }

    /**
     * Set the value of locId
     *
     * @param locId new value of locId
     */
    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    /**
     * Get the value of employeeId
     *
     * @return the value of employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the value of employeeId
     *
     * @param employeeId new value of employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get the value of qnty
     *
     * @return the value of qnty
     */
    public Integer getQnty() {
        return qnty;
    }

    /**
     * Set the value of qnty
     *
     * @param qnty new value of qnty
     */
    public void setQnty(Integer qnty) {
        this.qnty = qnty;
    }

    /**
     * Get the value of unitCost
     *
     * @return the value of unitCost
     */
    public Integer getUnitCost() {
        return unitCost;
    }

    /**
     * Set the value of unitCost
     *
     * @param unitCost new value of unitCost
     */
    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * Get the value of orderDate
     *
     * @return the value of orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the value of orderDate
     *
     * @param orderDate new value of orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

}
