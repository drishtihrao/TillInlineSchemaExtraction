package xsd.parser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SourceXsdListFromTxtFile {

	public static void main(String args[]) {
		String sourceXSD = "D:\\XmlAndXsds\\ref\\com\\Processes\\Onboarding.txt";
		ArrayList<ArrayList<String>> xsdLists = Listmain(sourceXSD);

		System.out.println("XSDLists =" + xsdLists);
	}

	protected static String[] xsdElement = null;
	protected String[] type = null;



	public static ArrayList<ArrayList<String>> Listmain(String sourceXSD) {

		String nameAttribute = "";
		String typAttribute = "";

		String dataType = "";
		String pureDataType = "";

		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<String> typesList = new ArrayList<String>();

		ArrayList<ArrayList<String>> xsdLists = new ArrayList<ArrayList<String>>();

		try {
			// parse the document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(sourceXSD));

			// Get tag name

			NodeList list = doc.getElementsByTagName("element");
			System.out.println(" list.getLength() =" + list.getLength());

			// loop to print data
			for (int i = 0; i < list.getLength(); i++) {
				System.out.println(" ************3*******************");
				Element element = (Element) list.item(i);
				if (element.hasAttributes()) {
					nameAttribute = element.getAttribute("name");
					System.out.println(" nameAttribute =[" + nameAttribute + "]");
					namesList.add(nameAttribute);
					System.out.println(namesList);

					// typAttribute = element.getAttribute("type");
					// System.out.println(" typAttribute =["+typAttribute+"]");

					dataType = (String) element.getAttribute("type");
					pureDataType = (dataType.substring(dataType.indexOf(':') + 1, dataType.length()));
					typesList.add(pureDataType);
				}
			}

			xsdLists.add(namesList);
			xsdLists.add(typesList);

		} catch (Exception ed) {
			ed.printStackTrace();
		}

		return xsdLists;

	}

}
