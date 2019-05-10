package xsd.parser;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;

import java.io.*;
import java.util.*;

public class XsdParser {

	protected String[] xsdElement = null;
	protected String[] type = null;
	protected String[] minOccurs = null;
	protected String[] maxOccurs = null;

	public String[] getXsdElement() {
		return xsdElement;
	}

	public void setXsdElement(String[] xsdElement) {
		this.xsdElement = xsdElement;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String[] getMinOccurs() {
		return minOccurs;
	}

	public void setMinOccurs(String[] minOccurs) {
		this.minOccurs = minOccurs;
	}

	public String[] getMaxOccurs() {
		return maxOccurs;
	}

	public void setMaxOccurs(String[] maxOccurs) {
		this.maxOccurs = maxOccurs;
	}

	public void xsdParser(String sourceXSD) {

		String nm = "";
		String typ = "";
		String minOcc = "";
		String maxOcc = "";
		String[] names = new String[4];
		String[] types = new String[4];
		String[] minOccs = new String[4];
		String[] maxOccs = new String[4];
		try {
			// parse the document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(sourceXSD));
			NodeList list = doc.getElementsByTagName("element");

			// loop to print data
			for (int i = 0; i < list.getLength(); i++) {
				Element first = (Element) list.item(i);
				if (first.hasAttributes()) {
					nm = first.getAttribute("name");
					// System.out.println(nm);
					names[i] = nm;

					// List ls = new ArrayList();
					// ls.add(nm);
					// System.out.println(ls);

					typ = first.getAttribute("type");
					// System.out.println(nm1);
					types[i] = typ;

					minOcc = first.getAttribute("minOccurs");
					// System.out.println(nm1);
					minOccs[i] = minOcc;

					maxOcc = first.getAttribute("maxOccurs");
					// System.out.println(nm1);
					maxOccs[i] = maxOcc;

				}

				xsdElement = names;
				type = types;
				minOccurs = minOccs;
				maxOccurs = maxOccs;

			}

		}

		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException ed) {
			ed.printStackTrace();
		}
	}
}
