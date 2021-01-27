package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). Returnerar null om filen inte finns.
	 * 
	 * Lade till rowScan vars uppgift är att läsa antalet Applicantsrader. (Rader som innehåller Applicants) 
	 * Om användaren endast vill se 5 Applicants är det möjligt, om användaren vill se fler Applicants än vad
	 * som finns i listan craschar inte programmet. 
	 * 
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		Scanner rowScan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
			rowScan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		int fullLines = 0;
		while (rowScan.hasNextLine() && !rowScan.nextLine().isEmpty()) {
			fullLines++;	
		}
		if (nbrOfRows > fullLines) {
			nbrOfRows = fullLines;
		}
		Applicant[] applicants = new Applicant[nbrOfRows];
		int k = 0;
		while (k < nbrOfRows) {
			String s = scan.nextLine();
			String[] res = s.split(" ");
			applicants[k] = new Applicant(res[0] + " " + res[1], res[2]);

			k++;
		}
		// Här kan du använda Scannern för att läsa från filen fileName.
		// Varje rad motsvarar en Applicant.
		// Applicants konstruktor kräver name och grades i stringform
		// Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en
		// Applicant-vektor och returneras på slutet
		return applicants; // Byt ut denna rad mot hela lösningen
	}
}

