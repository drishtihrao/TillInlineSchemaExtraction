package xsd.text.conversion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ChangingXsdHeader {
	public static void XsdHeaderEditor(String directorypath, String filename) throws IOException {
		System.out.println("in xsd editor");

		String line, txtFilePath;

		txtFilePath = directorypath + "//" + filename + ".txt";

		// Construct the file object from existing file.
		File file = new File(txtFilePath);

		RandomAccessFile file1 = new RandomAccessFile(new File(txtFilePath), "rw");

		StringBuffer inputBuffer = new StringBuffer();

		while ((line = file1.readLine()) != null) {
			// System.out.println(line);

			if (line.trim().startsWith("<xs:schema")) {
				line = line.replace(line, "");
				inputBuffer.append(System.lineSeparator()).append(line);
			}

			if (!line.trim().startsWith("<?xml version")
//					&& (!line.endsWith(".xsd>") || !line.endsWith("qualified\">")
//					|| !line.endsWith("unqualified\">"))
			) {
				// file1.writeBytes(line);
				inputBuffer.append(System.lineSeparator()).append(line);
			} else {
				inputBuffer.append(System.lineSeparator())
						.append("<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" "
								+ "elementFormDefault=\"qualified\" attributeFormDefault=\"unqualified\">");
			}

			if (line.trim().startsWith("<xsd:")) {
				inputBuffer.append(System.lineSeparator()).append("<xs:");
			}

			if (line.trim().endsWith("<xsd:")) {
				inputBuffer.append(System.lineSeparator()).append("</xs:");
			}

		} // while loop ends

		FileOutputStream fileOut = new FileOutputStream(new File(directorypath + "\\" + filename + ".xsd"));
		fileOut.write(inputBuffer.toString().getBytes());
		file1.close();

		System.out.println("exit\r\n");

	}

}
