
package chapter4ExercisesPackage;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame_9 {
		
	int secretNum;
	int guess;
	
	Scanner inputG = new Scanner(System.in);

	
	public GuessingGame_9(){
		System.out.print("Try to guess the number 0 though 100: ");
	}
	
	public void genNumber(){
		Random randoNum = new Random();
		secretNum = randoNum.nextInt(100);
	}
	
	public void guessNumber(){
		guess = inputG.nextInt();
		
		if (guess == secretNum) {
			System.out.print("Congrats!! You win!!    The number was " + secretNum);
		} 
		else if (guess  < secretNum){
			System.out.print("Ooh too low! Try again: ");
			this.guessNumber();
		}
		else {
			System.out.print("Ooh too high! Try again: ");
			this.guessNumber();
		}
	}
}
