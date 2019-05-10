package process.text.conversion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ChangingProcessReference {
	public static void ProcessReferenceEditor(String directorypath, String filename) throws IOException {
		System.out.println("in editor");
		
		String line, txtFilePath;
		
		txtFilePath = directorypath + "//" + filename + ".txt"; 
		
		
		// Construct the file object from existing file.
		File file = new File(txtFilePath);

		RandomAccessFile file1 = new RandomAccessFile(new File(txtFilePath), "rw");

		StringBuffer inputBuffer = new StringBuffer();

		while ((line = file1.readLine()) != null) {
			// System.out.println(line);
			if (!line.trim().contains("<pd:name>")) {
				// file1.writeBytes(line);
				inputBuffer.append(System.lineSeparator()).append(line);
			} else {
				inputBuffer.append(System.lineSeparator())
						.append("    <pd:name>Processes/" + filename + ".process</pd:name>");
			}
		}
		FileOutputStream fileOut = new FileOutputStream(new File(directorypath + "\\" + filename + ".process"));
		fileOut.write(inputBuffer.toString().getBytes());
		file1.close();
		
		System.out.println("exit\r\n");
		
	}

}	