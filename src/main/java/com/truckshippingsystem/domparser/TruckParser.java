package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Drivers;
import com.truckshippingsystem.domain.Truck;
import com.truckshippingsystem.services.EntityWrapperService;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TruckParser {

    private Truck tList;
    private Drivers[] ddriver;
    //  private List<Truck> tTruck;
    private List<Drivers> dDriver;
    private boolean flag = false;

    public void truckParse() {
        try {
            File fXmlFile = new File(".//xml//Trucks.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfTruck = doc.getElementsByTagName("Truck");

            for (int i = 0; i < listOfTruck.getLength(); i++) {
                Node firstTruckNode = listOfTruck.item(i);
                if (firstTruckNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element truckElement = (Element) firstTruckNode;
                    String truckid = truckElement.getAttribute("id");
                    System.out.println("Truck Id : " + truckid);
                    NodeList truckNameList = truckElement.getElementsByTagName("TruckMake");
                    Element truckNameElement = (Element) truckNameList.item(0);
                    NodeList textTDList = truckNameElement.getChildNodes();
                    System.out.println("Truck Make : "
                            + ((Node) textTDList.item(0)).getNodeValue().trim());
                    NodeList truckVinList = truckElement.getElementsByTagName("Vin");
                    Element truckVinElement = (Element) truckVinList.item(0);
                    NodeList textTDList1 = truckVinElement.getChildNodes();
                    System.out.println("Truck Vin : "
                            + ((Node) textTDList1.item(0)).getNodeValue().trim());
                    NodeList truckColorList = truckElement.getElementsByTagName("Color");
                    Element truckColorElement = (Element) truckColorList.item(0);
                    NodeList textTDList2 = truckColorElement.getChildNodes();
                    System.out.println("Truck Color : "
                            + ((Node) textTDList2.item(0)).getNodeValue().trim());
                    NodeList truckYearList = truckElement.getElementsByTagName("Year");
                    Element truckYearElement = (Element) truckYearList.item(0);
                    NodeList textTDList3 = truckYearElement.getChildNodes();
                    System.out.println("Truck Year : "
                            + ((Node) textTDList3.item(0)).getNodeValue().trim());
                    NodeList truckCapacityList = truckElement.getElementsByTagName("Capacity");
                    Element truckCapacityElement = (Element) truckCapacityList.item(0);
                    NodeList textTDList4 = truckCapacityElement.getChildNodes();
                    System.out.println("Truck Capacity : "
                            + ((Node) textTDList4.item(0)).getNodeValue().trim());
                    NodeList truckTypeList = truckElement.getElementsByTagName("Type");
                    Element truckTypeElement = (Element) truckTypeList.item(0);
                    NodeList textTDList5 = truckTypeElement.getChildNodes();
                    System.out.println("Truck Type : "
                            + ((Node) textTDList5.item(0)).getNodeValue().trim());
                    NodeList truckLicensePlateNoList = truckElement.getElementsByTagName("LicensePlateNo");
                    Element truckLicensePlateNoElement = (Element) truckLicensePlateNoList.item(0);
                    NodeList textTDList6 = truckLicensePlateNoElement.getChildNodes();
                    System.out.println("Truck LicensePlateNo : "
                            + ((Node) textTDList6.item(0)).getNodeValue().trim());

                    String truckMake = ((Node) textTDList.item(0)).getNodeValue().trim();
                    String vin = ((Node) textTDList1.item(0)).getNodeValue().trim();
                    String color = ((Node) textTDList2.item(0)).getNodeValue().trim();
                    String year = ((Node) textTDList3.item(0)).getNodeValue().trim();
                    String capacity = ((Node) textTDList4.item(0)).getNodeValue().trim();
                    String type = ((Node) textTDList5.item(0)).getNodeValue().trim();
                    String licensePlateNo = ((Node) textTDList6.item(0)).getNodeValue().trim();

                    tList = new Truck();
                    tList.setMake(truckMake);
                    tList.setVin(vin);
                    tList.setColor(color);
                    tList.setYear(year);
                    tList.setCapacity(Integer.parseInt(capacity));
                    tList.setType(type);
                    tList.setLicPlateNo(licensePlateNo);
                    //----
                    NodeList listOfDriverNames = truckElement.getElementsByTagName("Driver");
                    dDriver = new ArrayList<>();

                    for (int j = 0; j < listOfDriverNames.getLength(); j++) {
                        ddriver = new Drivers[listOfDriverNames.getLength()];
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

                            ddriver[j] = new Drivers();
                            ddriver[j].setName(drivername);
                            ddriver[j].setLicense(driverlicense);
                            ddriver[j].setLicenseState(driverState);
                            ddriver[j].setDriverType(driverType);
                            dDriver.add(ddriver[j]);

                        }
                    }
                    insertData(tList, dDriver);

                }
            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Truck tList, List<Drivers> dDriver) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(this.tList);
        for (int j = 0; j < dDriver.size(); j++) {
                tList.addDrivers(dDriver.get(j));
                em.persist(dDriver.get(j));
            }
        transc.commit();
    }
}
