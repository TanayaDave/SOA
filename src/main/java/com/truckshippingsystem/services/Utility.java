/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author shrikantjesu
 */
public class Utility {

    public static Date formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date formattedDate = new Date();
        try {
            formattedDate = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getStackTrace());
        }
        return formattedDate;
    }

    public static SAXParser getSAXParserObject() throws ParserConfigurationException,SAXException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        return saxParser;
    }
}
