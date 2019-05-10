package xsd.text.conversion;

import java.io.File;

public class XsdToText {
	public static void XsdToTextConverter(String directorypath, String filename) {
		
		System.out.println("*******");

		// Construct the file object from existing file.
		File file = new File(directorypath + "\\" + filename + ".xsd");

		// Rename it
		file.renameTo(new File(directorypath + "\\" + filename + ".txt"));

	}

}
