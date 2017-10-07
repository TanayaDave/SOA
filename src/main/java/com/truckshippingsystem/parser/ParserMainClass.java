/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.parser;

import com.truckshippingsystem.domparser.DriverParser;
import com.truckshippingsystem.domparser.InvoiceParser;
import com.truckshippingsystem.domparser.MaintenanceParser;
import com.truckshippingsystem.domparser.PricingParser;
import com.truckshippingsystem.domparser.TransactionParser;
import com.truckshippingsystem.domparser.TruckParser;
import com.truckshippingsystem.domparser.VehicleParser;

/**
 *
 * @author shrikantjesu
 */
public class ParserMainClass {

    public static void main(String[] args) {
        EmployeeParser.ParseEmployee();
        CommentParser.ParseComment();
        TicketParser.ParseTicket();
        CustomerParser.ParseEmployee();
        ExpenseParser.ParseExpense();
        LocationParser.ParseLocation();
        OrderParser.ParseOrder();
        
        TruckParser truck = new TruckParser();
        truck.truckParse();

        DriverParser driver = new DriverParser();
        driver.driverParse();

        MaintenanceParser maintain = new MaintenanceParser();
        maintain.maintenanceParse();

        PricingParser pricing = new PricingParser();
        pricing.pricingParse();

        TransactionParser transaction = new TransactionParser();
        transaction.transactionParse();

        VehicleParser vehicle = new VehicleParser();
        vehicle.vehicleParse();
        
        InvoiceParser invoice=new InvoiceParser();
        invoice.invoiceParse();
    }
}
