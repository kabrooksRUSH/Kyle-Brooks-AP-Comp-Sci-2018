package chapter4ExercisesPackage;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
				
		System.out.print("Which app would you like to run: ");
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		
		switch (selection){
			case 1: Printing_1 print1 = new Printing_1();
					print1.getCopies();
					print1.calcCost();
					break;
//////////////////////////////////////////////^^Printing^^////////////////////////////////////
					
			case 2: PackageCheck_2 packageCheck1 = new PackageCheck_2();
					packageCheck1.getSize();
					packageCheck1.analyzePackage();
					break;
//////////////////////////////////////////////^^PackageCheck^^////////////////////////////////////
					
			case 3: Eggs_3 eggs1 = new Eggs_3();
					eggs1.getEggs();
					eggs1.calcCost();
					break;
			
			case 4: CarRecall_4 car1 = new CarRecall_4();
					car1.getModel();
					car1.testModel();
					break;
					
			case 5: Grade_5 grade1 = new Grade_5();
					grade1.getPercent();
					grade1.calcLetterGrade();
					break;
					
			case 6: MathTutor_6 tutor1 = new MathTutor_6();
					tutor1.genProblem();
					tutor1.getInput();
					tutor1.checkAnswer();
					break;
					
			case 7: EquivalentFractions_7 equivFrac1 = new EquivalentFractions_7();
					equivFrac1

			case 9: GuessingGame_9 game1 = new GuessingGame_9();
					game1.genNumber();
					game1.guessNumber();
					break;
						
				
				
			}
		}
}
