package controllers;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLParser {

	public static void main(String ...str) {
		
		try {
		DocumentBuilder dbf = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc =dbf.parse(new File("test.xml"));
		
		doc.getDocumentElement().normalize();
		
		NodeList nd = doc.getElementsByTagName("staff");
		
		System.out.println("Node List Goes like - " + nd.toString());
		
		for(int temp =0;temp <nd.getLength();temp++) {
			Node n = nd.item(temp);
			System.out.println("Node Goes like - " + n.toString());
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) n;
				
				System.out.println("Element Goes like - " + ele.toString());
				String id= ele.getAttribute("id");
				System.out.println("ID Goes like - " + id);
				
				
				String cntent = ele.getTextContent();
				
				System.out.println(cntent);
				
				String firstName = ele.getElementsByTagName("firstname").item(0).getTextContent();
				
				System.out.println(firstName);
			}
		}
		
		}catch (Exception e) {
		e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
}
