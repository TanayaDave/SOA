package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Transaction;
import com.truckshippingsystem.domain.Vehicles;
import com.truckshippingsystem.services.EntityWrapperService;
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

public class TransactionParser {

    private Transaction transaction;

    public void transactionParse() {
        try {
            File fXmlFile = new File(".//xml//Transactions.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfTransactionNames = doc.getElementsByTagName("Transaction");
            for (int j = 0; j < listOfTransactionNames.getLength(); j++) {
                Node firstTransactionNode = listOfTransactionNames.item(j);
                if (firstTransactionNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element transactionElement = (Element) firstTransactionNode;
                    NodeList tranOrderList = transactionElement.getElementsByTagName("OrderId");
                    Element tranOrderElement = (Element) tranOrderList.item(0);
                    NodeList textDRVNMList = tranOrderElement.getChildNodes();
                    System.out.println("Order Id : "
                            + ((Node) textDRVNMList.item(0)).getNodeValue().trim());
                    NodeList tranPriceId = transactionElement.getElementsByTagName("PriceId");
                    Element tranPriceElement1 = (Element) tranPriceId.item(0);
                    NodeList textDRLCList1 = tranPriceElement1.getChildNodes();
                    System.out.println("Price Id : "
                            + ((Node) textDRLCList1.item(0)).getNodeValue().trim());
                    NodeList employeeIdlList1 = transactionElement.getElementsByTagName("EmployeeId");
                    Element employeeIdElement1 = (Element) employeeIdlList1.item(0);
                    NodeList textDRSTList1 = employeeIdElement1.getChildNodes();
                    System.out.println("Employee Id : "
                            + ((Node) textDRSTList1.item(0)).getNodeValue().trim());
                    NodeList tranDateList1 = transactionElement.getElementsByTagName("Date");
                    Element tranDateElement1 = (Element) tranDateList1.item(0);
                    NodeList textDRTYList1 = tranDateElement1.getChildNodes();
                    System.out.println("Date : "
                            + ((Node) textDRTYList1.item(0)).getNodeValue().trim());
                    NodeList amountList1 = transactionElement.getElementsByTagName("Amount");
                    Element amountElement1 = (Element) amountList1.item(0);
                    NodeList textDRTYList2 = amountElement1.getChildNodes();
                    System.out.println("Amount : "
                            + ((Node) textDRTYList2.item(0)).getNodeValue().trim());
                    String orderId = ((Node) textDRVNMList.item(0)).getNodeValue().trim();
                    String priceId = ((Node) textDRLCList1.item(0)).getNodeValue().trim();
                    String employeeId = ((Node) textDRSTList1.item(0)).getNodeValue().trim();
                    String date = ((Node) textDRTYList1.item(0)).getNodeValue().trim();
                    String amount = ((Node) textDRTYList2.item(0)).getNodeValue().trim();

                    transaction = new Transaction();
                    transaction.setOrderId(Integer.parseInt(orderId));
                    transaction.setPriceId(Integer.parseInt(priceId));
                    transaction.setEmployeeId(employeeId);
                    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                    Date startDate = df.parse(date);
                    transaction.setDate(startDate);
                    transaction.setAmount(Double.parseDouble(amount));

                }
                insertData(transaction);

            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Transaction transaction) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(transaction);

        transc.commit();
    }

    public static void main(String argv[]) {
        TransactionParser transaction = new TransactionParser();
         transaction.transactionParse();

    }

}
