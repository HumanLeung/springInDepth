package xml.parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlDomParser {

    private static final String FILE_NAME = "src/xml/files/staff.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILE_NAME));
            doc.getDocumentElement().normalize();
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("-----");

            NodeList list = doc.getElementsByTagName("staff");

            for (int temp = 0; temp < list.getLength(); temp++){
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String firstName = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("lastname").item(0).getTextContent();
                    String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

                    NodeList salaryNodeList = element.getElementsByTagName("salary");
                    String salary = salaryNodeList.item(0).getTextContent();

                    String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Staff Id : " + id);
                    System.out.println("First Name : " + firstName);
                    System.out.println("Last Name : " + lastName);
                    System.out.println("Nick Name : " + nickname);
                    System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);

                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
