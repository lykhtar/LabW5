package labw5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Tariff {

    private String name, operatorname, payroll, inside, outside, landline, fav, con, prom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operatorname;
    }

    public void setOperator(String operatorname) {
        this.operatorname = operatorname;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public String getInside() {
        return inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }

    public String getOutside() {
        return outside;
    }

    public void setOutside(String outside) {
        this.outside = inside;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getProm() {
        return prom;
    }

    public void setProm(String prom) {
        this.prom = prom;
    }

    @Override
    public String toString() {
        return "\n Tariff: Name = " + this.name + " Operator= " + this.operatorname + " Payroll= " + this.payroll
                + "\nCall prices" + "\n Insidenetworkcalls=" + this.inside
                + "\n Outsidenetworkcalls=" + this.outside + "\n Landlinecalls=" + this.landline + "\nParametrs"
                + "\n Favorite number= " + this.fav + "\n Connectioncost" + this.con + "\n Promisedpayment=" + this.prom;
    }
}

public class DOMxmlReader {

    public static void main(String[] args) {
        String filepath = "filex.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            // получаем узлы с именем Tariff
            // теперь XML полностью загружен в память 
            // в виде объекта Document
            NodeList nodeList = document.getElementsByTagName("tariff");

            // создадим из него список объектов Tariffs
            List<Tariff> tList = new ArrayList<Tariff>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                tList.add(getTariff(nodeList.item(i)));
            }

            // печатаем в консоль информацию по каждому объекту 
            for (Tariff t : tList) {
                System.out.println(t.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    // создаем из узла документа объект 
    private static Tariff getTariff(Node node) {
        Tariff t = new Tariff();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            t.setName(getTagValue("name", element));
            t.setOperator(getTagValue("operatorname", element));
            t.setPayroll(getTagValue("payroll", element));
            t.setInside(getTagValue("insidenetworkcalls", element));
            t.setOutside(getTagValue("outsidenetworkcalls", element));
            t.setLandline(getTagValue("landlinecalls", element));
            t.setFav(getTagValue("favoritenumber", element));
            t.setCon(getTagValue("connectioncost", element));
            t.setProm(getTagValue("promisedpayment", element));

        }

        return t;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
