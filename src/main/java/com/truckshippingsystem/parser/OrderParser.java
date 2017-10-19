/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.domain.Order;
import com.truckshippingsystem.utility.EntityWrapperService;
import com.truckshippingsystem.utility.Utility;
import java.io.File;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author shrikantjesu
 */
public class OrderParser {

    public static void ParseOrder() {

        try {
            File inputFile = new File(".//XML//Orders.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            OrderUserHandler userhandler = new OrderUserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class OrderUserHandler extends DefaultHandler {

    private boolean bCustId = false;
    private boolean bEmployeeId = false;
    private boolean bOrderDate = false;
    private boolean bUnitCost = false;
    private boolean bQnty = false;
    private boolean bTotalAmount = false;
    private boolean bLocId = false;
    private boolean bTruckId = false;

    private Order order;

    public OrderUserHandler() {

        this.order = new Order();
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Order")) {
            String addId = attributes.getValue("id");
            System.out.println("Order Id : " + addId);
        } else if (qName.equalsIgnoreCase("EmployeeId")) {
            bEmployeeId = true;
        }else if (qName.equalsIgnoreCase("CustId")) {
            bCustId = true;
        } else if (qName.equalsIgnoreCase("OrderDate")) {
            bOrderDate = true;
        } else if (qName.equalsIgnoreCase("UnitCost")) {
            bUnitCost = true;
        } else if (qName.equalsIgnoreCase("Qnty")) {
            bQnty = true;
        } else if (qName.equalsIgnoreCase("LocId")) {
            bLocId = true;
        } else if (qName.equalsIgnoreCase("TruckId")) {
            bTruckId = true;
        } else if (qName.equalsIgnoreCase("TotalAmount")) {
            bTotalAmount = true;
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("Order")) {
             EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.order);
            transc.commit();
            
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

         if (bCustId) {
            System.out.println("CustId: " + new String(ch, start, length));
//            order.setOrderDate(Utility.formatDate(new String(ch, start, length)));
            bCustId = false;
        } else if (bEmployeeId) {
            System.out.println("EmployeeId: " + new String(ch, start, length));
            order.setEmployeeId(Integer.parseInt(new String(ch, start, length)));
            bEmployeeId = false;
        } else if (bOrderDate) {
            System.out.println("OrderDate: " + new String(ch, start, length));
            order.setOrderDate(Utility.formatDate(new String(ch, start, length)));
            bOrderDate = false;
        } else if (bUnitCost) {
            System.out.println("UnitCost: " + new String(ch, start, length));
            order.setUnitCost(Integer.parseInt(new String(ch, start, length)));
            bUnitCost = false;
        } else if (bQnty) {
            System.out.println("DateHired: " + new String(ch, start, length));
            order.setQnty(Integer.parseInt(new String(ch, start, length)));
            bQnty = false;
        } else if (bLocId) {
            System.out.println("LocId: " + new String(ch, start, length));
            order.setLocId(Integer.parseInt(new String(ch, start, length)));
            bLocId = false;
        } else if (bTruckId) {
            System.out.println("TruckId: " + new String(ch, start, length));
            order.setTruckId(Integer.parseInt(new String(ch, start, length)));
            bTruckId = false;
        } else if (bTotalAmount) {
            System.out.println("TotalAmount: " + new String(ch, start, length));
            order.setTotalAmount(Integer.parseInt(new String(ch, start, length)));
            bTotalAmount = false;
        }
    }
}
