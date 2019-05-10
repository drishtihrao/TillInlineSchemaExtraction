package com.cg.bw6_structures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Sorting5xFiles {
	public static void FilesSorter(String directoryPath, String driveName) throws IOException {
		String tempDirectoryPath, folderToBeCreated, sourceDirectory;
		boolean status;

		Scanner scanner = new Scanner(System.in);

		tempDirectoryPath = driveName + ":\\" + directoryPath;

		folderToBeCreated = tempDirectoryPath.replace('.', '\\');

		Path path = Paths.get(folderToBeCreated);
		File file = new File(folderToBeCreated);

		// checking if the directory exists
		if (!Files.exists(path)) {
			status = file.mkdirs();

			if (status)
				System.out.println("Directory created");
			else
				System.out.println("Some error occured");

		} else {
			System.out.println("Directory already exists");
		}

		// creating all other folders
		tempDirectoryPath = folderToBeCreated + "\\.settings";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\.WebResources";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\META-INF";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\Policies";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\Processes";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\Resources";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\Schemas";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\Service Descriptors";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		tempDirectoryPath = folderToBeCreated + "\\EXTRA";
		file = new File(tempDirectoryPath);
		file.mkdirs();

		// reading the existing files
		System.out.println("Enter the source directory");
		sourceDirectory = scanner.nextLine();
		ReadFilePOC.FilesToBeMoved(sourceDirectory, folderToBeCreated);
		System.out.println("......");

	}

}
