package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Drivers;
import com.truckshippingsystem.services.EntityWrapperService;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DriverParser {

    private Drivers ddriver;

    public void driverParse() {
        try {
            File fXmlFile = new File(".//xml//Drivers.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfDriverNames = doc.getElementsByTagName("Driver");
            for (int j = 0; j < listOfDriverNames.getLength(); j++) {
                Node firstDriverNode = listOfDriverNames.item(j);
                if (firstDriverNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element driverElement = (Element) firstDriverNode;
                    NodeList driverNameList = driverElement.getElementsByTagName("DriverName");
                    Element driverNameElement = (Element) driverNameList.item(0);
                    NodeList textDRVNMList = driverNameElement.getChildNodes();
                    System.out.println("Driver Name : "
                            + ((Node) textDRVNMList.item(0)).getNodeValue().trim());
                    NodeList driverLicenseList1 = driverElement.getElementsByTagName("DriverLicenseNo");
                    Element driverLicenseElement1 = (Element) driverLicenseList1.item(0);
                    NodeList textDRLCList1 = driverLicenseElement1.getChildNodes();
                    System.out.println("Driver license : "
                            + ((Node) textDRLCList1.item(0)).getNodeValue().trim());
                    NodeList driverStateList1 = driverElement.getElementsByTagName("DriverLicenseState");
                    Element driverStateElement1 = (Element) driverStateList1.item(0);
                    NodeList textDRSTList1 = driverStateElement1.getChildNodes();
                    System.out.println("Driver State : "
                            + ((Node) textDRSTList1.item(0)).getNodeValue().trim());
                    NodeList driverTypeList1 = driverElement.getElementsByTagName("DriverType");
                    Element driverTypeElement1 = (Element) driverTypeList1.item(0);
                    NodeList textDRTYList1 = driverTypeElement1.getChildNodes();
                    System.out.println("Driver Type : "
                            + ((Node) textDRTYList1.item(0)).getNodeValue().trim());

                    String drivername = ((Node) textDRVNMList.item(0)).getNodeValue().trim();
                    String driverlicense = ((Node) textDRLCList1.item(0)).getNodeValue().trim();
                    String driverState = ((Node) textDRSTList1.item(0)).getNodeValue().trim();
                    String driverType = ((Node) textDRTYList1.item(0)).getNodeValue().trim();
                    ddriver = new Drivers();
                    ddriver.setName(drivername);
                    ddriver.setLicense(driverlicense);
                    ddriver.setLicenseState(driverState);
                    ddriver.setDriverType(driverType);

                }
                insertData(ddriver);
            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Drivers dDriver) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(dDriver);

        transc.commit();
    }

    public static void main(String argv[]) {
        DriverParser driver = new DriverParser();
        driver.driverParse();
    }

}
