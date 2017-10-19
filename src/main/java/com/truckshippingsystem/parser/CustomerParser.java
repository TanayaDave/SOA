/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.domain.Address;
import com.truckshippingsystem.domain.ContactDetails;
import com.truckshippingsystem.domain.Customer;
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
public class CustomerParser {

    public static void ParseEmployee() {

        try {
            File inputFile = new File(".//XML//Customers.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            CustomerUserHandler userhandler = new CustomerUserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class CustomerUserHandler extends DefaultHandler {

    private boolean bCustTitle = false;
    private boolean bCustFirstName = false;
    private boolean bCustLastName = false;
    private boolean bAddressLine1 = false;
    private boolean bAddressLine2 = false;
    private boolean bCity = false;
    private boolean bState = false;
    private boolean bZip = false;
    private boolean bPhoneNumber = false;
    private boolean bAltPhoneNumber = false;
    private boolean bEmail = false;
    private boolean bFaxNumber = false;
    private boolean bEmployeeId = false;
    private boolean bOrderDate = false;
    private boolean bUnitCost = false;
    private boolean bQnty = false;
    private boolean bTotalAmount = false;
    private boolean bLocId = false;
    private boolean bTruckId = false;

    private Customer customer;
    private Order order;

    public CustomerUserHandler() {
        this.customer = new Customer();
        this.customer.setAddress(new Address());
        this.customer.setContactdetails(new ContactDetails());
        this.order = new Order();
    }

    public void initalizeCustomerProp() {
        this.customer = new Customer();
        this.customer.setAddress(new Address());
        this.customer.setContactdetails(new ContactDetails());
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Customer")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Customer Id: " + rollNo);
        } else if (qName.equalsIgnoreCase("CustFirstName")) {
            bCustFirstName = true;
        } else if (qName.equalsIgnoreCase("CustLastName")) {
            bCustLastName = true;
        } else if (qName.equalsIgnoreCase("p1:address")) {
            String addId = attributes.getValue("addId");
            System.out.println("Add Id : " + addId);
        } else if (qName.equalsIgnoreCase("AddressLine1")) {
            bAddressLine1 = true;
        } else if (qName.equalsIgnoreCase("AddressLine2")) {
            bAddressLine2 = true;
        } else if (qName.equalsIgnoreCase("City")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("State")) {
            bState = true;
        } else if (qName.equalsIgnoreCase("Zip")) {
            bZip = true;
        } else if (qName.equalsIgnoreCase("PhoneNumber")) {
            bPhoneNumber = true;
        } else if (qName.equalsIgnoreCase("AltPhoneNumber")) {
            bAltPhoneNumber = true;
        } else if (qName.equalsIgnoreCase("Email")) {
            bEmail = true;
        } else if (qName.equalsIgnoreCase("FaxNumber")) {
            bFaxNumber = true;
        } else if (qName.equalsIgnoreCase("CustTitle")) {
            bCustTitle = true;
        } else if (qName.equalsIgnoreCase("TotalAmount")) {
            bTotalAmount = true;
        } else if (qName.equalsIgnoreCase("Order")) {
            String addId = attributes.getValue("id");
            System.out.println("Order Id : " + addId);
        } else if (qName.equalsIgnoreCase("EmployeeId")) {
            bEmployeeId = true;
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

        if (qName.equalsIgnoreCase("Customer")) {
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.customer);
            transc.commit();
            initalizeCustomerProp();
        }
        if (qName.equalsIgnoreCase("Order")) {
            this.customer.addOrders(order);
            order = new Order();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

         if (bCustTitle) {
            System.out.println("CustTitle: " + new String(ch, start, length));
            customer.setCustTitle(new String(ch, start, length));
            bCustTitle = false;
        } else if (bCustFirstName) {
            System.out.println("CustFirstName: " + new String(ch, start, length));
            customer.setCustFirstName(new String(ch, start, length));
            bCustFirstName = false;
        } else if (bCustLastName) {
            System.out.println("CustLastName: " + new String(ch, start, length));
            customer.setCustLastName(new String(ch, start, length));
            bCustLastName = false;
        } else if (bAddressLine1) {
            customer.getAddress().setAddressLine1(new String(ch, start, length));
            System.out.println("AddressLine1: " + customer.getAddress().getAddressLine1());
            bAddressLine1 = false;
        } else if (bAddressLine2) {
            System.out.println("AddressLine2: " + new String(ch, start, length));
            customer.getAddress().setAddressLine2(new String(ch, start, length));
            bAddressLine2 = false;
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
            customer.getAddress().setCity(new String(ch, start, length));
            bCity = false;
        } else if (bState) {
            System.out.println("State: " + new String(ch, start, length));
            customer.getAddress().setState(new String(ch, start, length));
            bState = false;
        } else if (bZip) {
            System.out.println("Zip: " + new String(ch, start, length));
            customer.getAddress().setZip(Integer.parseInt(new String(ch, start, length)));
            bZip = false;
        } else if (bPhoneNumber) {
            System.out.println("PhoneNumber: " + new String(ch, start, length));
            customer.getContactdetails().setPhoneNumber(new String(ch, start, length));
            bPhoneNumber = false;
        } else if (bAltPhoneNumber) {
            System.out.println("AltPhoneNumber: " + new String(ch, start, length));
            customer.getContactdetails().setAltPhoneNumber(new String(ch, start, length));
            bAltPhoneNumber = false;
        } else if (bEmail) {
            System.out.println("Email: " + new String(ch, start, length));
            customer.getContactdetails().setEmail(new String(ch, start, length));
            bEmail = false;
        } else if (bFaxNumber) {
            System.out.println("FaxNumber: " + new String(ch, start, length));
            customer.getContactdetails().setFaxNumber(Integer.parseInt(new String(ch, start, length)));
            bFaxNumber = false;
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
