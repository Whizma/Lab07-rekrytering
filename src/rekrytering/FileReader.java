package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		String[] Applicant = new String[nbrOfRows];
		int k = 0;
		while (scan.hasNextLine() && k < nbrOfRows) {
			String row = scan.next();
			Applicant[k] = row;
			k++;
			System.out.print(Applicant);
		}
		// Här kan du använda Scannern för att läsa från filen fileName.
		// Varje rad motsvarar en Applicant.
		// Applicants konstruktor kräver name och grades i stringform
		// Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en
		// Applicant-vektor och returneras på slutet
		return null; // Byt ut denna rad mot hela lösningen
	}
}
