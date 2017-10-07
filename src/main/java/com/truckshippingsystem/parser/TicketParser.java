/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;



/**
 *
 * @author user
 */

import com.truckshippingsystem.domain.Ticket;
import com.truckshippingsystem.services.EntityWrapperService;
import com.truckshippingsystem.services.Utility;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TicketParser {

    public static void ParseTicket() {

        try {
            File inputFile = new File(".//XML//Tickets.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            TicketsHandler tickethandler = new TicketsHandler();
            saxParser.parse(inputFile, tickethandler);
        } catch (ParserConfigurationException | SAXException| IOException e) {
            e.printStackTrace();
        }
    }
    
    
}

class TicketsHandler extends DefaultHandler {
    
    private boolean bDriverId = false;
    private boolean bDate= false;
    private boolean bFine = false;
    private boolean bDesc = false;
    private boolean bIsPaid = false;
    
    private Ticket ticket;

    public TicketsHandler() {
        this.ticket = new Ticket();
    }
    
     @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

         if (qName.equalsIgnoreCase("ticket")) {
            String tickId = attributes.getValue("id");
            System.out.println("Ticket Id: " + tickId);
        }else if (qName.equalsIgnoreCase("DriverId")) {
            bDriverId = true;
        } else if (qName.equalsIgnoreCase("Date")) {
            bDate = true;
        } else if (qName.equalsIgnoreCase("Fine")) {
            bFine = true;        
        } else if (qName.equalsIgnoreCase("Desc")) {
            bDesc = true;
        } else if (qName.equalsIgnoreCase("IsPaid")) {
            bIsPaid = true;
        }
}
    
 @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("ticket")) {
            System.out.println("End Element :" + ticket.toString());
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.ticket);
            transc.commit();
        }
    }

 @Override
    public void characters(char ch[], int start, int length) throws SAXException {

       
        
        if (bDriverId) {
            System.out.println("Driver Id: " + new String(ch, start, length));
            ticket.setDriverId(Integer.parseInt(new String(ch, start, length)));
            bDriverId = false;
        } else if (bDate) {
            System.out.println("Date: " + new String(ch, start, length));
            ticket.setDate(Utility.formatDate(new String(ch, start, length)));
            bDate = false;
        } else if (bFine) {
            System.out.println("Fine: " + new String(ch, start, length));
            ticket.setFine(Double.parseDouble(new String(ch, start, length)));
            bFine = false;
        } else if (bDesc) {
            System.out.println("Description: " + new String(ch, start, length));
            ticket.setDesc(new String(ch, start, length));
            bDesc = false;
        } else if (bIsPaid) {
            System.out.println("Is Paid: " + new String(ch, start, length));
            ticket.setIsPaid(Boolean.parseBoolean(new String(ch, start, length)));
            bIsPaid = false;
        }
    }
}


