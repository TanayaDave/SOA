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
import com.truckshippingsystem.domain.Comments;
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

public class CommentParser {
    
      public static void ParseComment() {

        try {
            File inputFile = new File(".//XML//Comments.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            CommentsHandler commentshandler = new CommentsHandler();
            saxParser.parse(inputFile, commentshandler);
        } catch (ParserConfigurationException | SAXException| IOException e) {
            e.printStackTrace();
        }
    }
    
}

class CommentsHandler extends DefaultHandler {

    private boolean bDate = false;
    private boolean bTime = false;
    private boolean bType = false;
    private boolean bDesc = false;  
    private boolean bCustId = false;
    private Comments comment;

    public CommentsHandler() {
        this.comment = new Comments();
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

         if (qName.equalsIgnoreCase("comment")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Comment Id: " + rollNo);
        } else if (qName.equalsIgnoreCase("Date")) {
            bDate = true;
        } else if (qName.equalsIgnoreCase("Time")) {
            bTime = true;
        } else if (qName.equalsIgnoreCase("Type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Desc")) {
            bDesc = true;
        } else if (qName.equalsIgnoreCase("CustId")) {
            bCustId = true;
        }
}
    
 @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("comment")) {
            System.out.println("End Element :" + comment.toString());
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.comment);
            transc.commit();
        }
    }

 @Override
    public void characters(char ch[], int start, int length) throws SAXException {

       
        
        if (bDate) {
            System.out.println("Date: " + new String(ch, start, length));
            comment.setDate(Utility.formatDate(new String(ch, start, length)));
            bDate = false;
        } else if (bTime) {
            System.out.println("Time: " + new String(ch, start, length));
            comment.setTime(Utility.formatTime(new String(ch, start, length)));
            bTime = false;
        } else if (bType) {
            System.out.println("Type: " + new String(ch, start, length));
            comment.setType(new String(ch, start, length));
            bType = false;
        } else if (bDesc) {
            System.out.println("Desc: " + new String(ch, start, length));
            comment.setDesc(new String(ch, start, length));
            bDesc = false;
        } else if (bCustId) {
            System.out.println("Customer Id: " + new String(ch, start, length));
            comment.setCustId(Integer.parseInt(new String(ch, start, length)));
            bCustId = false;
        }
    }
}