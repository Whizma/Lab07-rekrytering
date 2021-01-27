package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.7;

	public static void main(String[] args) {

		Applicant[] CandidateList = FileReader.readFromFile("applications_all.txt", 6969);
		Applicant[] bestCandidateList = findBestCandidates(CandidateList);
		Arrays.sort(bestCandidateList);
		System.out.println("Kandidater med högre snittbetyg än" + " " +MIN_AVG_GRADE + ":");
		for (int g = 0; g < bestCandidateList.length; g++) {
			System.out.println(bestCandidateList[g].toString());
		}

		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor

		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor

		// Printa resultatet från findBestCandidates
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		int k = 0;
		for (int i = 0; i < applicants.length; i++) {
			if (applicants[i].getAvgGrade() > MIN_AVG_GRADE) {
				k++;
			}
		}
		Applicant[] candidate = new Applicant[k];
		int c = 0;
		for (int j = 0; j < applicants.length; j++) {
			if (applicants[j].getAvgGrade() > MIN_AVG_GRADE) {
				candidate[c] = applicants[j];
				c++;

			}
		}
		return candidate;
	}
}
