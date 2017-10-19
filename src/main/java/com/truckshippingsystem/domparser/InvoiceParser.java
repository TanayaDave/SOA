/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truckshippingsystem.domparser;

/**
 *
 * @author user
 */
import com.truckshippingsystem.domain.Invoice;
import com.truckshippingsystem.utility.EntityWrapperService;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class InvoiceParser {
    
    private Invoice invoice;
    
    public void invoiceParse(){
        
         try {
            File fXmlFile = new File(".//xml//Invoices.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            
             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
             
              NodeList listOfInvoiceNames = doc.getElementsByTagName("Invoice");
              for(int i=0; i< listOfInvoiceNames.getLength(); i++){
                  Node firstInvoiceNode = listOfInvoiceNames.item(i);
                  
                   if (firstInvoiceNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element invoiceElement = (Element) firstInvoiceNode;
                    NodeList invoiceOrderList = invoiceElement.getElementsByTagName("OrderId");
                    Element invoiceOrderElement = (Element) invoiceOrderList.item(0);
                    NodeList textDRVNMList = invoiceOrderElement.getChildNodes();
                    System.out.println("Order Id : "
                            + ((Node) textDRVNMList.item(0)).getNodeValue().trim());
                    NodeList invoiceCustId = invoiceElement.getElementsByTagName("CustId");
                    Element invoiceCustElement1 = (Element) invoiceCustId.item(0);
                    NodeList textDRLCList1 = invoiceCustElement1.getChildNodes();
                    System.out.println("Cust Id : "
                            + ((Node) textDRLCList1.item(0)).getNodeValue().trim());
                    NodeList LocIdList1 = invoiceElement.getElementsByTagName("LocId");
                    Element locIdElement1 = (Element) LocIdList1.item(0);
                    NodeList textDRSTList1 = locIdElement1.getChildNodes();
                    System.out.println("Loc Id : "
                            + ((Node) textDRSTList1.item(0)).getNodeValue().trim());
                    NodeList tranDateList1 = invoiceElement.getElementsByTagName("Date");
                    Element tranDateElement1 = (Element) tranDateList1.item(0);
                    NodeList textDRTYList1 = tranDateElement1.getChildNodes();
                    System.out.println("Date : "
                            + ((Node) textDRTYList1.item(0)).getNodeValue().trim());
                    NodeList totalList1 = invoiceElement.getElementsByTagName("Total");
                    Element totalElement1 = (Element) totalList1.item(0);
                    NodeList textDRTYList2 = totalElement1.getChildNodes();
                    System.out.println("Total : "
                            + ((Node) textDRTYList2.item(0)).getNodeValue().trim());
                    String orderId = ((Node) textDRVNMList.item(0)).getNodeValue().trim();
                    String custId = ((Node) textDRLCList1.item(0)).getNodeValue().trim();
                    String locId = ((Node) textDRSTList1.item(0)).getNodeValue().trim();
                    String date = ((Node) textDRTYList1.item(0)).getNodeValue().trim();
                    String total = ((Node) textDRTYList2.item(0)).getNodeValue().trim();
                    
                     invoice = new Invoice();
                    invoice.setOrderId(Integer.parseInt(orderId));
                    invoice.setCustId(Integer.parseInt(custId));
                    invoice.setLocId(Integer.parseInt(locId));
                    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                    Date startDate = df.parse(date);
                    invoice.setDate(startDate);
                    invoice.setTotal(Double.parseDouble(total));
                  
              }
                    insertData(invoice);
             
         }
               EntityWrapperService.closeEntityManager();
         }

         catch (Exception e) {
            e.printStackTrace();
        }
        
    }
                  
        private void insertData(Invoice invoice) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(invoice);

        transc.commit();
    }

   
    
}
