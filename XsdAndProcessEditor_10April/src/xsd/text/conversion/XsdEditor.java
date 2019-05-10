package xsd.text.conversion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XsdEditor {
	public static void main(String args[]) throws IOException {
		String directorypath, filename;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the main directory path");
		directorypath = scanner.nextLine();

		Path pathToBeMovedTo = Paths.get(directorypath);
		List<Path> files = Files.walk(pathToBeMovedTo).filter(Files::isRegularFile).collect(Collectors.toList());

		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).toString().endsWith(".xsd")) {
				System.out.println(files.get(i).getFileName() + "             " + files.get(i).getParent().toString());
				filename = files.get(i).getFileName().toString();

				filename = filename.replaceFirst("[.][^.]+$", "");

				XsdToText.XsdToTextConverter(directorypath, filename);

				ChangingXsdHeader.XsdHeaderEditor(directorypath, filename);

			} // If loop ends

		} // For loop ends

		// Deleting text files
		File folder = new File(directorypath);
		Arrays.stream(folder.listFiles((f, p) -> p.endsWith(".txt"))).forEach(File::delete);

	}
}