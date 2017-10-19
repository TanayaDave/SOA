/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.domain.Address;
import com.truckshippingsystem.domain.ContactDetails;
import com.truckshippingsystem.domain.Employee;
import com.truckshippingsystem.domain.Location;
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
public class LocationParser {

    public static void ParseLocation() {

        try {
            File inputFile = new File(".//XML//Locations.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            LocationUserHandler userhandler = new LocationUserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class LocationUserHandler extends DefaultHandler {

    private boolean bLocName = false;
    private boolean bLocCode = false;
    private boolean bCustId = false;
    private boolean bAddressLine1 = false;
    private boolean bAddressLine2 = false;
    private boolean bCity = false;
    private boolean bState = false;
    private boolean bZip = false;
    private boolean bPhoneNumber = false;
    private boolean bAltPhoneNumber = false;
    private boolean bEmail = false;
    private boolean bFaxNumber = false;
    private Location location;

    public LocationUserHandler() {
        this.location = new Location();
        this.location.setAddress(new Address());
        this.location.setCotactDetails(new ContactDetails());
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Location")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Location Id: " + rollNo);
        } else if (qName.equalsIgnoreCase("LocName")) {
            bLocName = true;
        } else if (qName.equalsIgnoreCase("LocCode")) {
            bLocCode = true;
        } else if (qName.equalsIgnoreCase("CustId")) {
            bCustId = true;
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

        if (qName.equalsIgnoreCase("Location")) {
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.location);
            transc.commit();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bLocName) {
            System.out.println("LocName: " + new String(ch, start, length));
            location.setLocName(new String(ch, start, length));
            bLocName = false;
        } else if (bLocCode) {
            System.out.println("LocCode: " + new String(ch, start, length));
            location.setLocCode(new String(ch, start, length));
            bLocCode = false;
        } else if (bAddressLine1) {
            location.getAddress().setAddressLine1(new String(ch, start, length));
            System.out.println("AddressLine1: " + location.getAddress().getAddressLine1());
            bAddressLine1 = false;
        } else if (bAddressLine2) {
            System.out.println("AddressLine2: " + new String(ch, start, length));
            location.getAddress().setAddressLine2(new String(ch, start, length));
            bAddressLine2 = false;
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
            location.getAddress().setCity(new String(ch, start, length));
            bCity = false;
        } else if (bState) {
            System.out.println("State: " + new String(ch, start, length));
            location.getAddress().setState(new String(ch, start, length));
            bState = false;
        } else if (bZip) {
            System.out.println("Zip: " + new String(ch, start, length));
            location.getAddress().setZip(Integer.parseInt(new String(ch, start, length)));
            bZip = false;
        } else if (bPhoneNumber) {
            System.out.println("PhoneNumber: " + new String(ch, start, length));
            location.getCotactDetails().setPhoneNumber(new String(ch, start, length));
            bPhoneNumber = false;
        } else if (bAltPhoneNumber) {
            System.out.println("AltPhoneNumber: " + new String(ch, start, length));
            location.getCotactDetails().setAltPhoneNumber(new String(ch, start, length));
            bAltPhoneNumber = false;
        } else if (bEmail) {
            System.out.println("Email: " + new String(ch, start, length));
            location.getCotactDetails().setEmail(new String(ch, start, length));
            bEmail = false;
        } else if (bFaxNumber) {
            System.out.println("FaxNumber: " + new String(ch, start, length));
            location.getCotactDetails().setFaxNumber(Integer.parseInt(new String(ch, start, length)));
            bFaxNumber = false;
        }
    }
}