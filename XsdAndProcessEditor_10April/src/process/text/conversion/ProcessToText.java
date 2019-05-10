package process.text.conversion;

import java.io.File;

public class ProcessToText {
	public static void ProcessToTextConverter(String directorypath, String filename) {
		
		System.out.println("*******");

		// Construct the file object from existing file.
		File file = new File(directorypath + "\\" + filename + ".process");

		// Rename it
		file.renameTo(new File(directorypath + "\\" + filename + ".txt"));

	}
}