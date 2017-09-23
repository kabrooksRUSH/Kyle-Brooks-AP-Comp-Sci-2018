package chapter4ExercisesPackage;

import java.util.Random;
import java.util.Scanner;

public class MathTutor_6 {
	
	Scanner input = new Scanner(System.in);
	Random randomNum = new Random();
	
	int x;
	int y;
	int answer;
	int guess;
	
	String problem;
	
	public MathTutor_6(){
		
	}
	
	public void genProblem(){
		
		x = randomNum.nextInt(10);
		y = randomNum.nextInt(10);
		
		int z = randomNum.nextInt(3);
		if (z == 0){
			problem = "Solve: " + x + " + " + y;
			answer = x+y;
		}
		else if(z == 1){
			problem = "Solve: " + x + " * " + y;
			answer = x*y;
		}
		else if(z == 2){
			problem = "Solve: " + x + " / " + y;
			answer = x/y;
		}
		else if(z == 3){
			problem = "Solve: " + x + " - " + y;
			answer = x-y;
		}
		System.out.print(problem + "\n");
	}
	public void getInput(){
		System.out.print("Your answer: ");
		guess = input.nextInt();
	}
	
	public void checkAnswer(){
		if (answer == guess){
			System.out.print("Correct!!");
		}
		else if (answer != guess){
			System.out.print("Sorry the answer is: " + answer);
		}
	}
}
