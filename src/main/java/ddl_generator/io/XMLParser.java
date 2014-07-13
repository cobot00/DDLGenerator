package ddl_generator.io;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class XMLParser {

    public Map<String, String> parse(String filePath) {
        final Map<String, String> result = new HashMap<String, String>();
        try {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            factory.setIgnoringComments(true);
            factory.setValidating(true);
            final Document doc = builder.parse(new File(filePath));

            System.out.println("doc.getChildNodes().getLength() = " + doc.getChildNodes().getLength());
            for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
                final Element root = (Element) doc.getChildNodes().item(i);

                System.out.println("root.getChildNodes().getLength() = " + root.getChildNodes().getLength());
                for (int j = 0; j < root.getChildNodes().getLength(); j++) {
                    final Node node = root.getChildNodes().item(j);
                    if (node.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    System.out.println(node.getNodeName() + " -> " + node.getFirstChild().getNodeValue());
                    result.put(node.getNodeName(), node.getFirstChild().getNodeValue());
                }
            }

        } catch (ParserConfigurationException e0) {
            System.out.println(e0.getMessage());
        } catch (SAXException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        return result;
    }

    public List<Map<String, String>> parseLevel2(String filePath) {
        final List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        try {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            factory.setIgnoringComments(true);
            factory.setValidating(true);
            final Document doc = builder.parse(new File(filePath));

            for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
                final Element root = (Element) doc.getChildNodes().item(i);

                for (int j = 0; j < root.getChildNodes().getLength(); j++) {
                    final Node node = root.getChildNodes().item(j);
                    if (node.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    result.add(findChild(node));
                }
            }

        } catch (ParserConfigurationException e0) {
            System.out.println(e0.getMessage());
        } catch (SAXException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        return result;
    }

    private Map<String, String> findChild(Node node) {
        final Map<String, String> result = new HashMap<String, String>();
        for (int j = 0; j < node.getChildNodes().getLength(); j++) {
            final Node child = node.getChildNodes().item(j);
            if (child.getNodeType() != Node.ELEMENT_NODE)
                continue;

            //System.out.println(child.getNodeName() + " -> " + child.getFirstChild().getNodeValue());
            final String value = child.getFirstChild() == null ? "" : child.getFirstChild().getNodeValue();
            result.put(child.getNodeName(), value);
        }

        return result;
    }
}
