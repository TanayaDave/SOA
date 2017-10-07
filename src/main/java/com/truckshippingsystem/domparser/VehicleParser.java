package com.truckshippingsystem.domparser;

/**
 *
 * @author Manish Vishwakarma
 */
import com.truckshippingsystem.domain.Vehicles;
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

public class VehicleParser {

    private Vehicles vVehicle;

    public void vehicleParse() {
        try {
            File fXmlFile = new File(".//xml//Vehicles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList listOfVehiclesNames = doc.getElementsByTagName("Vehicle");
            for (int j = 0; j < listOfVehiclesNames.getLength(); j++) {
                Node firstVehicleNode = listOfVehiclesNames.item(j);
                if (firstVehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element vehicleElement = (Element) firstVehicleNode;
                    NodeList vehicleNameList = vehicleElement.getElementsByTagName("VehicleMake");
                    Element vehicleNameElement = (Element) vehicleNameList.item(0);
                    NodeList textDRVNMList = vehicleNameElement.getChildNodes();
                    System.out.println("Vehicle make : "
                            + ((Node) textDRVNMList.item(0)).getNodeValue().trim());
                    NodeList vehicleVin = vehicleElement.getElementsByTagName("Vin");
                    Element vehicleElement1 = (Element) vehicleVin.item(0);
                    NodeList textDRLCList1 = vehicleElement1.getChildNodes();
                    System.out.println("Vehicle Vin : "
                            + ((Node) textDRLCList1.item(0)).getNodeValue().trim());
                    NodeList vehiclemodelList1 = vehicleElement.getElementsByTagName("Model");
                    Element vehicleModelElement1 = (Element) vehiclemodelList1.item(0);
                    NodeList textDRSTList1 = vehicleModelElement1.getChildNodes();
                    System.out.println("Vehicle Model : "
                            + ((Node) textDRSTList1.item(0)).getNodeValue().trim());
                    NodeList vehicleColorList1 = vehicleElement.getElementsByTagName("Color");
                    Element vehicleColorElement1 = (Element) vehicleColorList1.item(0);
                    NodeList textDRTYList1 = vehicleColorElement1.getChildNodes();
                    System.out.println("Vehicle Color : "
                            + ((Node) textDRTYList1.item(0)).getNodeValue().trim());
                    NodeList vehicleYearList1 = vehicleElement.getElementsByTagName("Year");
                    Element vehicleYearElement1 = (Element) vehicleYearList1.item(0);
                    NodeList textDRTYList2 = vehicleYearElement1.getChildNodes();
                    System.out.println("Vehicle Year : "
                            + ((Node) textDRTYList2.item(0)).getNodeValue().trim());
                    NodeList vehicleLicenseList1 = vehicleElement.getElementsByTagName("LicensePlateNo");
                    Element vehicleLicenseElement1 = (Element) vehicleLicenseList1.item(0);
                    NodeList textDRTYList3 = vehicleLicenseElement1.getChildNodes();
                    System.out.println("LicensePlateNo : "
                            + ((Node) textDRTYList3.item(0)).getNodeValue().trim());
                    NodeList custNoList1 = vehicleElement.getElementsByTagName("CustId");
                    Element custNoElement1 = (Element) custNoList1.item(0);
                    NodeList textDRTYList4 = custNoElement1.getChildNodes();
                    System.out.println("Customer Id : "
                            + ((Node) textDRTYList4.item(0)).getNodeValue().trim());
                    NodeList orderList1 = vehicleElement.getElementsByTagName("OrderId");
                    Element orderElement1 = (Element) orderList1.item(0);
                    NodeList textDRTYList5 = orderElement1.getChildNodes();
                    System.out.println("Order Id : "
                            + ((Node) textDRTYList5.item(0)).getNodeValue().trim());

                    String VehicleMake = ((Node) textDRVNMList.item(0)).getNodeValue().trim();
                    String Vin = ((Node) textDRLCList1.item(0)).getNodeValue().trim();
                    String Model = ((Node) textDRSTList1.item(0)).getNodeValue().trim();
                    String Color = ((Node) textDRTYList1.item(0)).getNodeValue().trim();
                    String Year = ((Node) textDRTYList2.item(0)).getNodeValue().trim();
                    String LicensePlateNo = ((Node) textDRTYList3.item(0)).getNodeValue().trim();
                    String CustId = ((Node) textDRTYList4.item(0)).getNodeValue().trim();
                    String OrderId = ((Node) textDRTYList5.item(0)).getNodeValue().trim();

                    vVehicle = new Vehicles();
                    vVehicle.setMake(VehicleMake);
                    vVehicle.setVin(Vin);
                    vVehicle.setModel(Model);
                    vVehicle.setColor(Color);
                    vVehicle.setYear(Year);
                    vVehicle.setLicPlateNo(LicensePlateNo);
                    vVehicle.setCustId(Integer.parseInt(CustId));
                    vVehicle.setOrderId(Integer.parseInt(OrderId));
                }
                insertData(vVehicle);

            }
            EntityWrapperService.closeEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertData(Vehicles vVehicle) {
        EntityManager em = EntityWrapperService.createEntityManager();
        EntityTransaction transc = em.getTransaction();
        transc.begin();
        em.persist(vVehicle);

        transc.commit();
    }
}
