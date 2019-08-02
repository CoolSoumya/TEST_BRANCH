package com.deloitte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueryFileReader {

	public String readQueryFile() {
		try {
			File file = new File("C:/Users/soumyardas/Documents/GIT_PROJECT/JDBC_BASIC/Age_Calculator.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

}
