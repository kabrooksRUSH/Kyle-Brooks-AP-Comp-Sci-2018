package chapter4ExercisesPackage;

import java.util.Scanner;

public class Grade_5 {
	
	double percent;
	String grade;
	Scanner input = new Scanner(System.in);
	
	public Grade_5(){
		
	}
	public void getPercent(){
		System.out.print("Enter a percentage grade: ");
		percent = input.nextDouble();
	}
	public void calcLetterGrade(){
		if (percent >= 92.5){
			grade = "A";
		} 
		else if (percent < 92.5 && percent >= 89.5){
			grade = "A-";
		}
		else if (percent < 89.5 && percent >= 86.5){
			grade = "B+";
		}
		else if (percent < 86.5 && percent >= 82.5){
			grade = "B";
		}
		else if (percent < 82.5 && percent >= 79.5){
			grade = "B-";
		}
		else if (percent < 79.5 && percent >= 76.5){
			grade = "C+";
		}
		else if (percent < 76.5 && percent >= 72.5){
			grade = "C";
		}
		else if (percent < 72.5 && percent >= 69.5){
			grade = "C-";
		}
		else if (percent < 69.5 && percent >= 66.5){
			grade = "D+";
		}
		else if (percent < 66.5 && percent >= 62.5){
			grade = "D";
		}
		else if (percent < 62.5 && percent >= 59.5){
			grade = "D-";
		}
		else if (percent < 62.5){
			grade = "E";
		}
		
		System.out.print("The letter grade is: " + grade);
	}
}
