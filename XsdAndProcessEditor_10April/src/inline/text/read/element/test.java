package inline.text.read.element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;

public class test {
	public static void main(String args[]) throws IOException {
		String line, txtFilePath, directorypath, filename;

		directorypath = "D:\\XmlAndXsds\\Newfolder";

		filename = "pqr";

		// Construct the file object from existing file.
		File file = new File(directorypath + "\\" + filename + ".process");

		// Rename it
		file.renameTo(new File(directorypath + "\\" + filename + ".txt"));

		txtFilePath = directorypath + "//" + filename + ".txt";

		// Construct the file object from existing file.
		File newfile = new File(txtFilePath);

		RandomAccessFile file1 = new RandomAccessFile(new File(txtFilePath), "rw");

		StringBuffer inputBuffer = new StringBuffer();

		inputBuffer.append(
				"<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\" attributeFormDefault=\"unqualified\">")
				.append(System.lineSeparator()).toString().getBytes();

		while ((line = file1.readLine()) != null) {
			if (!line.trim().startsWith("<xsd:element") && !line.trim().startsWith("<xsd:complexType>")
					&& !line.trim().startsWith("<xsd:sequence>") && !line.trim().startsWith("</xsd:sequence>")
					&& !line.trim().startsWith("</xsd:complexType>") && !line.trim().startsWith("</xsd:element>")) {
			} else {
				line = lines.replace("xsd:", "xs:");
				inputBuffer.append(line).append(System.lineSeparator());
			}
		}

		inputBuffer.append(System.lineSeparator()).append("</xs:schema>").toString().getBytes();

		FileOutputStream fileOut = new FileOutputStream(new File(directorypath + "\\" + filename + ".xsd"));
		fileOut.write(inputBuffer.toString().getBytes());

		file1.close();

	}

}
