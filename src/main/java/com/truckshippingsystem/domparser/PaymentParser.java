package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Payment;
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

public class PaymentParser {

    private Payment payment;

    public void paymentParse() {

        try {
            File fXmlFile = new File(".//xml//Payments.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfPayment = doc.getElementsByTagName("Payment");

            for (int i = 0; i < listOfPayment.getLength(); i++) {
                Node firstMaintNode = listOfPayment.item(i);
                if (firstMaintNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element maintainElement = (Element) firstMaintNode;
                    String maintaind = maintainElement.getAttribute("id");
                    System.out.println(" Id : " + maintaind);
                    NodeList orderIdList = maintainElement.getElementsByTagName("OrderId");
                    Element orderIdElement = (Element) orderIdList.item(0);
                    NodeList textTDList = orderIdElement.getChildNodes();
                    System.out.println("OrderId : "
                            + ((Node) textTDList.item(0)).getNodeValue().trim());
                    NodeList AmountList = maintainElement.getElementsByTagName("Amount");
                    Element amountElement = (Element) AmountList.item(0);
                    NodeList textTDList1 = amountElement.getChildNodes();
                    System.out.println("Amount : "
                            + ((Node) textTDList1.item(0)).getNodeValue().trim());
                    NodeList dateList = maintainElement.getElementsByTagName("Date");
                    Element dateElement = (Element) dateList.item(0);
                    NodeList textTDList2 = dateElement.getChildNodes();
                    System.out.println("Date : "
                            + ((Node) textTDList2.item(0)).getNodeValue().trim());
                    NodeList typeList = maintainElement.getElementsByTagName("Type");
                    Element typeElement = (Element) typeList.item(0);
                    NodeList textTDList3 = typeElement.getChildNodes();
                    System.out.println("Type: "
                            + ((Node) textTDList3.item(0)).getNodeValue().trim());
                    NodeList cardNoList = maintainElement.getElementsByTagName("CardNo");
                    Element cardElement = (Element) cardNoList.item(0);
                    NodeList textTDList4 = cardElement.getChildNodes();
                    System.out.println("CardNo: "
                            + ((Node) textTDList4.item(0)).getNodeValue().trim());

                    NodeList statusList = maintainElement.getElementsByTagName("ExpiryDate");
                    Element statusElement = (Element) statusList.item(0);
                    NodeList textTDList5 = statusElement.getChildNodes();
                    System.out.println("ExpiryDate: "
                            + ((Node) textTDList5.item(0)).getNodeValue().trim());

                    String orderId = ((Node) textTDList.item(0)).getNodeValue().trim();
                    String amt = ((Node) textTDList1.item(0)).getNodeValue().trim();
                    double amount = Double.parseDouble(amt);
                    String date = ((Node) textTDList2.item(0)).getNodeValue().trim();
                    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                    Date startDate = df.parse(date);
                    String type = ((Node) textTDList3.item(0)).getNodeValue().trim();
                    String CardNo = ((Node) textTDList4.item(0)).getNodeValue().trim();
                    String ExpiryDate = ((Node) textTDList5.item(0)).getNodeValue().trim();

                    payment = new Payment();
                    payment.setOrderId(Integer.parseInt(orderId));
                    payment.setAmount(amount);
                    payment.setDate(date);
                    payment.setPayType(type);
                    payment.setCardNo(CardNo);
                    payment.setExpDate(ExpiryDate);

                    insertData(payment);

                }
            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Payment payment) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();

        em.persist(payment);

        transc.commit();
    }

}
