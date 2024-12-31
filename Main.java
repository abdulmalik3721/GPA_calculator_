package GPA.java;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// total points / total credits
		// points for a class=grade value*credits
		// A=4, B=3...

		Scanner scanner = new Scanner(System.in);
		Integer totalPoints=0;
		Integer totalCredits=0;
		
		boolean moreClasses=false;
		
		do {

		Integer credits = 0;
		boolean validCredits = true;
		do {
			validCredits = true;
			System.out.println("Enter number of credits:");
			String creditsString = scanner.nextLine();

			try {
				credits = Integer.parseInt(creditsString);

			} catch (NumberFormatException nfe) {
				System.out.println("please enter a valid integer");
				validCredits = false;
			}
		} while (!validCredits);

		boolean validGrade = true;

		Integer gradeValue = 0;
		String grades = "";
		do {
			// Integer points=0;
			validGrade = true;
			System.out.println("Enter number of Grades:");
			grades = scanner.nextLine();

			if (grades.equalsIgnoreCase("A")) {
				gradeValue = 4;
			} else if (grades.equalsIgnoreCase("B")) {
				gradeValue = 3;
			} else if (grades.equalsIgnoreCase("C")) {
				gradeValue = 2;
			} else if (grades.equalsIgnoreCase("D")) {
				gradeValue = 1;
			} else if (grades.equalsIgnoreCase("F")) {
				gradeValue = 0;
			} else {
				System.out.println("You didn't enter valid grade:(");
				validGrade = false;
			}
		} while (!validGrade);	
		Integer points = gradeValue * credits;
		totalPoints=totalPoints+points;
		totalCredits+=credits;
		System.out.println("would you like to enter another class (Y/N)");
		String moreClassesString=scanner.nextLine();
		
		moreClasses=moreClassesString.equalsIgnoreCase("Y");
		
		
		}
		while(moreClasses);
		
	
		DecimalFormat df = new DecimalFormat("0.00");
		
		Double  GPA = Double.valueOf(totalPoints) /Double.valueOf(totalCredits) ;

		System.out.println("Credits:" + totalCredits);
		//System.out.println("Grades:" + grades);
		System.out.println("Points:" + totalPoints);
		System.out.println("GPA:" + df.format(GPA));

		scanner.close();

	}

}
