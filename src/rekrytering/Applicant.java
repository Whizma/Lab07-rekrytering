package rekrytering;

import java.util.Arrays;

public class Applicant implements Comparable<Applicant> {
	// Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal. Allt som inte är 1-5 blir 0.
		for (int i = 0; i < g.length; i++) {

			switch (g[i]) {
			case "1":
				grades[i] = Integer.parseInt(g[i]);
				break;
			case "2":
				grades[i] = Integer.parseInt(g[i]);
				break;
			case "3":
				grades[i] = Integer.parseInt(g[i]);
				break;
			case "4":
				grades[i] = Integer.parseInt(g[i]);
				break;
			case "5":
				grades[i] = Integer.parseInt(g[i]);
				break;
			default:
				grades[i] = 0;
				break;
			}

		}
	}

	public double getAvgGrade() {
		// average = sum of grades / number of courses
		
		double sumGrades = 0;
		double average = 0;
		for (int i = 0; i < grades.length; i++) {
			sumGrades = sumGrades + grades[i];
		}

		average = sumGrades / grades.length;
		return average;
	}

	// Implementera denna när labbeskrivningen kräver det
	public String toString() {
		// getAvgGrade, name, grades
		// Rut Andreasson[5, 5, 5, 4, 3](avg: 4.4)

		String s = name + Arrays.toString(grades) + "(avg: " + Double.toString(getAvgGrade()) + ")";

		return s;

	}

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar
	 * något < 0 om other är störst och returnerar 0 om objekten är lika. Används av
	 * javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
