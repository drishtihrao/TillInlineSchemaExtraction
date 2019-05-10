package inline.text.read.element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

//inputBuffer.append(System.lineSeparator()).append(line);

public class SourceXsdList {
	public static void ElementExtractor(String directorypath, String filename) throws IOException {
		System.out.println("in SchemaCreator");
		/* ArrayList<ArrayList<String>> Listmain */
		String line, txtFilePath;

		txtFilePath = directorypath + "//" + filename + ".txt";

		/*
		 * String nameAttribute = ""; String typAttribute = "";
		 * 
		 * String dataType = ""; String pureDataType = "";
		 * 
		 * ArrayList<String> namesList = new ArrayList<String>(); ArrayList<String>
		 * typesList = new ArrayList<String>();
		 * 
		 * ArrayList<ArrayList<String>> xsdLists = new ArrayList<ArrayList<String>>();
		 */

		// Construct the file object from existing file.
		File file = new File(txtFilePath);

		RandomAccessFile file1 = new RandomAccessFile(new File(txtFilePath), "rw");

		StringBuffer inputBuffer = new StringBuffer();

		while ((line = file1.readLine()) != null) {
			// System.out.println(line);
			if (!line.trim().startsWith("<xsd:element") && !line.trim().startsWith("<xsd:complexType>")
					&& !line.trim().startsWith("<xsd:sequence>")) {
				// file1.writeBytes(line);
				inputBuffer.append(System.lineSeparator()).append("");
			} else {
				inputBuffer.append(System.lineSeparator()).append(line);
			}

			/* return xsdLists; */

		}
	}
}
