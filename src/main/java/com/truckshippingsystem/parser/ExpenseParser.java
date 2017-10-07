/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.domain.Expense;
import com.truckshippingsystem.services.EntityWrapperService;
import com.truckshippingsystem.services.Utility;
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
public class ExpenseParser {

    public static void ParseExpense() {

        try {
            File inputFile = new File(".//XML//Expenses.xml");
            SAXParser saxParser = Utility.getSAXParserObject();
            ExpenseUserHandler userhandler = new ExpenseUserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class ExpenseUserHandler extends DefaultHandler {

    private boolean bCategory = false;
    private boolean bDesc = false;
    private boolean bAmount = false;
    private boolean bDate = false;
    private boolean bPaymentType = false;
    private boolean bEmpId = false;

    private Expense expense;

    public ExpenseUserHandler() {

        this.expense = new Expense();
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Expense")) {
            String addId = attributes.getValue("id");
            System.out.println("Expense Id : " + addId);
        } else if (qName.equalsIgnoreCase("Category")) {
            bCategory = true;
        } else if (qName.equalsIgnoreCase("Desc")) {
            bDesc = true;
        } else if (qName.equalsIgnoreCase("Amount")) {
            bAmount = true;
        } else if (qName.equalsIgnoreCase("Date")) {
            bDate = true;
        } else if (qName.equalsIgnoreCase("PaymentType")) {
            bPaymentType = true;
        } else if (qName.equalsIgnoreCase("EmpId")) {
            bEmpId = true;
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("Expense")) {
            EntityManager em = EntityWrapperService.createEntityManager();
            EntityTransaction transc = em.getTransaction();
            transc.begin();
            em.persist(this.expense);
            transc.commit();

        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bCategory) {
            System.out.println("Category: " + new String(ch, start, length));
            expense.setCategory(new String(ch, start, length));
            bCategory = false;
        } else if (bDesc) {
            System.out.println("Desc: " + new String(ch, start, length));
            expense.setDesc(new String(ch, start, length));
            bDesc = false;
        } else if (bAmount) {
            System.out.println("Amount: " + new String(ch, start, length));
            expense.setAmount(Double.parseDouble(new String(ch, start, length)));
            bAmount = false;
        } else if (bDate) {
            System.out.println("Date: " + new String(ch, start, length));
            expense.setDate(Utility.formatDate(new String(ch, start, length)));
            bDate = false;
        } else if (bPaymentType) {
            System.out.println("PaymentType: " + new String(ch, start, length));
            expense.setPaymentType(new String(ch, start, length));
            bPaymentType = false;
        } else if (bEmpId) {
            System.out.println("EmpId: " + new String(ch, start, length));
            expense.setEmpId(Integer.parseInt(new String(ch, start, length)));
            bEmpId = false;
        }
    }
}
