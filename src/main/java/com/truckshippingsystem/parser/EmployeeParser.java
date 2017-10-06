/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

/**
 *
 * @author shrikantjesu
 */
import com.truckshippingsystem.domain.Address;
import com.truckshippingsystem.domain.ContactDetails;
import com.truckshippingsystem.domain.Employee;
import com.truckshippingsystem.services.EntityWrapperService;
import com.truckshippingsystem.services.Utility;
import java.io.File;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeParser {

    public static void ParseEmployee() {

        try {
            File inputFile = new File(".//XML//Employees.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    private boolean bEmpFirstName = false;
    private boolean bEmpLastName = false;
    private boolean bRole = false;
    private boolean bSSN = false;
    private boolean bDOB = false;
    private boolean bDateHired = false;
    private boolean bAddressLine1 = false;
    private boolean bAddressLine2 = false;
    private boolean bCity = false;
    private boolean bState = false;
    private boolean bZip = false;
    private boolean bPhoneNumber = false;
    private boolean bAltPhoneNumber = false;
    private boolean bEmail = false;
    private boolean bFaxNumber = false;
    private Employee employee;

    public UserHandler() {
        this.employee = new Employee();
        this.employee.setAddress(new Address());
        this.employee.setCotactDetails(new ContactDetails());
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Employee Id: " + rollNo);
        } else if (qName.equalsIgnoreCase("EmpFirstName")) {
            bEmpFirstName = true;
        } else if (qName.equalsIgnoreCase("EmpLastName")) {
            bEmpLastName = true;
        } else if (qName.equalsIgnoreCase("Role")) {
            bRole = true;
        } else if (qName.equalsIgnoreCase("SSN")) {
            bSSN = true;
        } else if (qName.equalsIgnoreCase("DateOfBirth")) {
            bDOB = true;
        } else if (qName.equalsIgnoreCase("DateHired")) {
            bDateHired = true;
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
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + employee.toString());
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.employee);
            transc.commit();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bEmpFirstName) {
            System.out.println("EmpFirstName: " + new String(ch, start, length));
            employee.setEmpFirstName(new String(ch, start, length));
            bEmpFirstName = false;
        } else if (bEmpLastName) {
            System.out.println("EmpLastName: " + new String(ch, start, length));
            employee.setEmpLastName(new String(ch, start, length));
            bEmpLastName = false;
        } else if (bRole) {
            System.out.println("Role: " + new String(ch, start, length));
            employee.setRole(new String(ch, start, length));
            bRole = false;
        } else if (bSSN) {
            System.out.println("SSN: " + new String(ch, start, length));
            employee.setSsn(Integer.valueOf(new String(ch, start, length)));
            bSSN = false;
        } else if (bDOB) {
            System.out.println("DOB: " + new String(ch, start, length));
            employee.setDob(Utility.formatDate(new String(ch, start, length)));
            bDOB = false;
        } else if (bDateHired) {
            System.out.println("DateHired: " + new String(ch, start, length));
            employee.setDateHired(Utility.formatDate(new String(ch, start, length)));
            bDateHired = false;
        } else if (bAddressLine1) {
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
        } else if (bPhoneNumber) {
            System.out.println("PhoneNumber: " + new String(ch, start, length));
            employee.getCotactDetails().setPhoneNumber(new String(ch, start, length));
            bPhoneNumber = false;
        } else if (bAltPhoneNumber) {
            System.out.println("AltPhoneNumber: " + new String(ch, start, length));
            employee.getCotactDetails().setAltPhoneNumber(new String(ch, start, length));
            bAltPhoneNumber = false;
        } else if (bEmail) {
            System.out.println("Email: " + new String(ch, start, length));
            employee.getCotactDetails().setEmail(new String(ch, start, length));
            bEmail = false;
        } else if (bFaxNumber) {
            System.out.println("FaxNumber: " + new String(ch, start, length));
            employee.getCotactDetails().setFaxNumber(Integer.parseInt(new String(ch, start, length)));
            bFaxNumber = false;
        }
    }
}
