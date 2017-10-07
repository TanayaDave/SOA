/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.services.EntityWrapperService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author manis
 */
public class TestJpa {
    
     public static void main(String[] args) {

          EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
           
     }
    
}
