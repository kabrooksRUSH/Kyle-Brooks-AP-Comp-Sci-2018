package chapter4ExercisesPackage;

import java.util.Random;
import java.util.Scanner;

public class MathTutor_6 {
	
	boolean running = true;
	
	Scanner input = new Scanner(System.in);
	Random randomNum = new Random();
	
	int x;
	int y;
	int answer;
	int guess;
	int score;
	
	String problem;
	
	public MathTutor_6(){
		
	}
	
	public void genProblem(){
		
		x = randomNum.nextInt(9) + 1;
		y = randomNum.nextInt(9) + 1;
		
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
			System.out.print("Correct!!" + "\n" +"\n");
		}
		else if (answer != guess){
			System.out.println("Sorry the answer is: " + answer);
			System.out.print("You got " + score + " correct!");
			running = false;
		}
	}
	public void gameRun(){
		while (running == true){
			this.genProblem();
			this.getInput();
			this.checkAnswer();
			score ++;
		}
	}
}
