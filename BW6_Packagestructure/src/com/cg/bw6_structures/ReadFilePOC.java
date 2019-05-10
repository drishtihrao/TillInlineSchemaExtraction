package com.cg.bw6_structures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFilePOC {

	/*
	 * public static void main(String a[]) throws IOException {
	 * System.out.println("*****");
	 * ReadFilePOC.FilesToBeMoved("D:\\PocForBridgesAndOauth\\MigrationPOC",
	 * "D:\\com\\cg\\test"); System.out.println("......"); }
	 */

//		// Declaring variables
//		String fileName;
//
//		Path pathToBeMovedTo;
//		List<Path> files = Files.walk(Paths.get("D:\\RestSoapJms\\JMSTEST")).filter(Files::isRegularFile)
//				.filter(path -> path.toString().endsWith(".bwp")).collect(Collectors.toList());
//
//		for (Path path : files) {
//			System.out.println(path);
//			pathToBeMovedTo = Paths.get("D:\\com\\cg\\tibco\\ap19\\test\\"Processes" + "\\" + path.getFileName());
//			Files.copy(path, pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
//		}
//
//	}

	public static void FilesToBeMoved(/* String extention, */ String sourcePath, String targetPath) throws IOException {

		Path pathToBeMovedTo = Paths.get(sourcePath);
		List<Path> files = Files.walk(pathToBeMovedTo).filter(Files::isRegularFile).collect(Collectors.toList());

		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).toString().endsWith(".process") || files.get(i).toString().endsWith(".bwp")
					|| files.get(i).toString().endsWith(".customProcess")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Processes\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} 

			else if (files.get(i).toString().endsWith(".xsd") || files.get(i).toString().endsWith(".xml")
					|| files.get(i).toString().endsWith(".dtd") || files.get(i).toString().endsWith(".aeschema")
					|| files.get(i).toString().endsWith(".javaschema") || files.get(i).toString().endsWith(".xslt")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Schemas\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}

			else if (files.get(i).toString().endsWith(".wsdl") || files.get(i).toString().endsWith(".serviceagent")
					|| files.get(i).toString().endsWith(".json")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Service Descriptors\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}

			else if (files.get(i).toString().endsWith(".substvar") || files.get(i).toString().endsWith(".bwm")
					|| files.get(i).toString().endsWith(".jsv") || files.get(i).toString().endsWith(".msv")
					|| files.get(i).toString().endsWith(".MF")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\META-INF\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}

			else if (files.get(i).toString().endsWith(".contextResource")
					|| files.get(i).toString().endsWith(".sharedparse")
					|| files.get(i).toString().endsWith(".sharedftp")
					|| files.get(i).toString().endsWith(".ftpResource")
					|| files.get(i).toString().endsWith(".sharedhttp")
					|| files.get(i).toString().endsWith(".httpConnResource")
					|| files.get(i).toString().endsWith(".sharedjdbc")
					|| files.get(i).toString().endsWith(".jdbcResource")
					|| files.get(i).toString().endsWith(".sharedjmscon")
					|| files.get(i).toString().endsWith(".sharedjmsapp")
					|| files.get(i).toString().endsWith(".jmsConnResource")
					|| files.get(i).toString().endsWith(".sharedjndiconfig")
					|| files.get(i).toString().endsWith(".jndiConfigResource")
					|| files.get(i).toString().endsWith(".javaGlobalInstanceResource")
					|| files.get(i).toString().endsWith(".httpProxy") || files.get(i).toString().endsWith(".sharedtcp")
					|| files.get(i).toString().endsWith(".tcpResource")
					|| files.get(i).toString().endsWith(".sharednotify")
					|| files.get(i).toString().endsWith(".notifyConfigurationResource")
					|| files.get(i).toString().endsWith(".sharedpartner")
					|| files.get(i).toString().endsWith(".sharedxatmconfig")
					|| files.get(i).toString().endsWith(".rvtransport")
					|| files.get(i).toString().endsWith(".rvResource")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Resources\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}

			else if (files.get(i).getFileName().toString().equalsIgnoreCase(".config")
					|| files.get(i).getFileName().toString().equalsIgnoreCase(".project")
					|| files.get(i).getFileName().toString().equalsIgnoreCase("build.properties")
					|| files.get(i).getFileName().toString().equalsIgnoreCase("vcrepo.dat")) {

				String tempDirectoryPath = targetPath + "\\" + files.get(i).getFileName();
				File file = new File(tempDirectoryPath);
				file.mkdirs();

				pathToBeMovedTo = Paths.get(targetPath + "\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}

			else {
				pathToBeMovedTo = Paths.get(targetPath + "\\EXTRA\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}
		}

	}

}