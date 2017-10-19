package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Pricing;
import com.truckshippingsystem.utility.EntityWrapperService;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PricingParser {

    private Pricing pricing;

    public void pricingParse() {
        try {
            File fXmlFile = new File(".//xml//Pricings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfPricingNames = doc.getElementsByTagName("Pricing");
            for (int j = 0; j < listOfPricingNames.getLength(); j++) {
                Node firstPricingNode = listOfPricingNames.item(j);
                if (firstPricingNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pricingElement = (Element) firstPricingNode;
                    NodeList LocIdList = pricingElement.getElementsByTagName("LocIdFrom");
                    Element locIdElement = (Element) LocIdList.item(0);
                    NodeList textDRVNMList = locIdElement.getChildNodes();
                    System.out.println("LocId From : "
                            + ((Node) textDRVNMList.item(0)).getNodeValue().trim());
                    NodeList locTo = pricingElement.getElementsByTagName("LocIdTo");
                    Element locToElement1 = (Element) locTo.item(0);
                    NodeList textDRLCList1 = locToElement1.getChildNodes();
                    System.out.println("LocId To : "
                            + ((Node) textDRLCList1.item(0)).getNodeValue().trim());
                    NodeList LocCodeFromList1 = pricingElement.getElementsByTagName("LocCodeFrom");
                    Element LocCodeFromElement1 = (Element) LocCodeFromList1.item(0);
                    NodeList textDRSTList1 = LocCodeFromElement1.getChildNodes();
                    System.out.println("LocCode From : "
                            + ((Node) textDRSTList1.item(0)).getNodeValue().trim());
                    NodeList locToList1 = pricingElement.getElementsByTagName("LocCodeTo");
                    Element LocCodeToElement1 = (Element) locToList1.item(0);
                    NodeList textDRTYList1 = LocCodeToElement1.getChildNodes();
                    System.out.println("LocCode To : "
                            + ((Node) textDRTYList1.item(0)).getNodeValue().trim());
                    NodeList LocNameFromList1 = pricingElement.getElementsByTagName("LocNameFrom");
                    Element LocNameFromElement1 = (Element) LocNameFromList1.item(0);
                    NodeList textDRTYList2 = LocNameFromElement1.getChildNodes();
                    System.out.println("LocName From : "
                            + ((Node) textDRTYList2.item(0)).getNodeValue().trim());
                    NodeList LocNameToList1 = pricingElement.getElementsByTagName("LocNameTo");
                    Element LocNameToElement1 = (Element) LocNameToList1.item(0);
                    NodeList textDRTYList3 = LocNameToElement1.getChildNodes();
                    System.out.println("LocName To : "
                            + ((Node) textDRTYList3.item(0)).getNodeValue().trim());
                    NodeList custNoList1 = pricingElement.getElementsByTagName("CustId");
                    Element custNoElement1 = (Element) custNoList1.item(0);
                    NodeList textDRTYList4 = custNoElement1.getChildNodes();
                    System.out.println("Customer Id : "
                            + ((Node) textDRTYList4.item(0)).getNodeValue().trim());

                    String locIdFrom = ((Node) textDRVNMList.item(0)).getNodeValue().trim();
                    String locIdTo = ((Node) textDRLCList1.item(0)).getNodeValue().trim();
                    String locCodeFrom = ((Node) textDRSTList1.item(0)).getNodeValue().trim();
                    String locCodeTo = ((Node) textDRTYList1.item(0)).getNodeValue().trim();
                    String locNameFrom = ((Node) textDRTYList2.item(0)).getNodeValue().trim();
                    String locNameTo = ((Node) textDRTYList3.item(0)).getNodeValue().trim();
                    String CustId = ((Node) textDRTYList4.item(0)).getNodeValue().trim();

                    pricing = new Pricing();
                    pricing.setLocIdFrom(locCodeFrom);
                    pricing.setLocCodeTo(Integer.parseInt(locIdFrom));
                    pricing.setLocCodeFrom(Integer.parseInt(locIdTo));
                    pricing.setLocIdTo(locCodeTo);
                    pricing.setLocNameFrom(locNameFrom);
                    pricing.setLocNameTo(locNameTo);
                    pricing.setCustId(Integer.parseInt(CustId));
                }
                insertData(pricing);

            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Pricing pricing) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(pricing);
        transc.commit();
    }
}
