package com.cg.bw6_structures;

import java.io.IOException;
import java.util.Scanner;

public class MigratingCode {
	public static void main(String[] args) throws IOException {
		// Declaring variables
		String driveName, continueLoop, directoryPath;
		boolean loopInput = true;

		Scanner scanner = new Scanner(System.in);

		while (loopInput) {
			// Asking User which Drive they want the folder to be in
			// Asking user the name of the project to be created
			System.out.println(
					"Enter the Drive name where you want the folder to be in and" + " directory path to be created");

			driveName = scanner.nextLine();
			directoryPath = scanner.nextLine();

			Sorting5xFiles.FilesSorter(directoryPath, driveName);

			// Asking user if they want to continue
			System.out.println("Do you wish to continue? Y or N");
			continueLoop = scanner.nextLine();
			if (continueLoop.equalsIgnoreCase("y")) {
				loopInput = true;
			} else {
				loopInput = false;
			}
		} // while loop ends
	}
}