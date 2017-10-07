/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shrikantjesu
 */
public class EntityWrapperService {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager createEntityManager() {
        emf = Persistence.createEntityManagerFactory("itmd566PU");
        em = emf.createEntityManager();
        return em;
    }

    public static void closeEntityManager() {
        em.close();
        emf.close();
    }
}
