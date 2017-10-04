/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.operations;

/**
 *
 * @author shrikantjesu
 */
import com.truckshippingsystem.Address;
import com.truckshippingsystem.Employee;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File(".//xsd//employee.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    private boolean bAddressLine1 = false;
    private boolean bAddressLine2 = false;
    private boolean bCity = false;
    private boolean bState = false;
    private boolean bTruckId = false;
    private boolean bZip = false;
    private boolean bName = false;
    private boolean bRole = false;
    private Employee employee;

    public UserHandler() {
        this.employee =new Employee();
        this.employee.setAddress(new Address());
    }

    
    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("p:employee")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Employee Id: " + rollNo);
        } else if (qName.equalsIgnoreCase("p1:address")) {
            String addId = attributes.getValue("addId");
            System.out.println("Add Id : " + addId);
        } else if (qName.equalsIgnoreCase("addressLine1")) {
            bAddressLine1 = true;
        } else if (qName.equalsIgnoreCase("addressLine2")) {
            bAddressLine2 = true;
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("state")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("zip")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("role")) {
            bRole = true;
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("p:employee")) {
            System.out.println("End Element :" + employee.toString());
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bAddressLine1) {
            
            employee.getAddress().setAddressLine1(new String(ch, start, length));
            System.out.println("AddressLine1: " + employee.getAddress().getAddressLine1());
            bAddressLine1 = false;
        } else if (bAddressLine2) {
            System.out.println("AddressLine2: " + new String(ch, start, length));
            employee.getAddress().setAddressLine2(new String(ch, start, length));
            bAddressLine2 = false;
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
            employee.getAddress().setCity(new String(ch, start, length));
            bCity = false;
        } else if (bState) {
            System.out.println("State: " + new String(ch, start, length));
            employee.getAddress().setState(new String(ch, start, length));
            bState = false;
        } else if (bZip) {
            System.out.println("Zip: " + new String(ch, start, length));
            employee.getAddress().setZip(Integer.parseInt(new String(ch, start, length)));
            bZip = false;
        } else if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            employee.setName(new String(ch, start, length));
            bName = false;
        } else if (bRole) {
            System.out.println("Role: " + new String(ch, start, length));
            employee.setRole(new String(ch, start, length));
            bRole = false;
        }
    }
}
