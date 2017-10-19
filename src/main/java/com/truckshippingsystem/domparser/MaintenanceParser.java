package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Maintenance;
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

public class MaintenanceParser {

    private Maintenance maintain;
    public void maintenanceParse() {

        try {
            File fXmlFile = new File(".//xml//Maintenances.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfMaintenance = doc.getElementsByTagName("Maintenance");

            for (int i = 0; i < listOfMaintenance.getLength(); i++) {
                Node firstMaintNode = listOfMaintenance.item(i);
                if (firstMaintNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element maintainElement = (Element) firstMaintNode;
                    String maintaind = maintainElement.getAttribute("id");
                    System.out.println("Truck Id : " + maintaind);
                    NodeList maintainDateList = maintainElement.getElementsByTagName("Date");
                    Element maintainDateElement = (Element) maintainDateList.item(0);
                    NodeList textTDList = maintainDateElement.getChildNodes();
                    System.out.println("Date : "
                            + ((Node) textTDList.item(0)).getNodeValue().trim());
                    NodeList costList = maintainElement.getElementsByTagName("Cost");
                    Element costElement = (Element) costList.item(0);
                    NodeList textTDList1 = costElement.getChildNodes();
                    System.out.println("Cost : "
                            + ((Node) textTDList1.item(0)).getNodeValue().trim());
                    NodeList descriptionList = maintainElement.getElementsByTagName("Description");
                    Element descriptionElement = (Element) descriptionList.item(0);
                    NodeList textTDList2 = descriptionElement.getChildNodes();
                    System.out.println("Description : "
                            + ((Node) textTDList2.item(0)).getNodeValue().trim());
                    NodeList statusList = maintainElement.getElementsByTagName("Status");
                    Element statusElement = (Element) statusList.item(0);
                    NodeList textTDList3 = statusElement.getChildNodes();
                    System.out.println("Status: "
                            + ((Node) textTDList3.item(0)).getNodeValue().trim());
                    String date = ((Node) textTDList.item(0)).getNodeValue().trim();
                    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                    Date startDate = df.parse(date);
                    String cost = ((Node) textTDList1.item(0)).getNodeValue().trim();
                    double mcost = Double.parseDouble(cost);
                    String description = ((Node) textTDList2.item(0)).getNodeValue().trim();
                    String status = ((Node) textTDList3.item(0)).getNodeValue().trim();

                    maintain = new Maintenance();
                    maintain.setDate1(startDate);
                    maintain.setCost(mcost);
                    maintain.setDesc(description);
                    maintain.setStatus(status);
                    insertData(maintain);

                }
            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Maintenance maintain1) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        
        em.persist(maintain1);
        
        transc.commit();
    }
}
