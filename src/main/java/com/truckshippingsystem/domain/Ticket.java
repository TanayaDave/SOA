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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author user
 */
@Entity
public class Ticket {
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
       
    private int driverId;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private double fine;
    
    @Column(name = "ticketdescription")
    private String desc;
    
    private boolean isPaid;

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
      @Override
    public String toString() {
        return "Tickets{" + "Id=" + id + ", driver id = " + driverId + ", date=" + date + ", fine=" + fine + ", desc=" + desc + ", isPaid=" + isPaid +  '}';
    }
    
}
