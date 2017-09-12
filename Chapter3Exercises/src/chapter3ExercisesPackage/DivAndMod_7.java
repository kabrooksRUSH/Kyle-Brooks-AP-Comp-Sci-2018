package chapter3ExercisesPackage;

import java.util.Scanner;

public class DivAndMod_7 {
	
	int input1;
	int	input2;
	
	public DivAndMod_7(){
		System.out.print("Please give 2 integers: ");
	}
	
	public void calculateDivAndMod(){
		System.out.print("          " + input1 + " / " + input2 + " = " + input1/input2);
		System.out.print("\n" + "          " +  + input1 + " % " + input2 + " = " + input1%input2);
		System.out.print("\n");
		System.out.print("\n" + "          " + input2 + " / " + input1 + " = " + input2/input1);
		System.out.print("\n" + "          " + input2 + " % " + input1 + " = " + input2%input1);
	}
	
	public void setIntegers(){
		setInt1();
		setInt2();
	}
	public void setInt1(){
		Scanner int1 = new Scanner(System.in);		
		input1 = int1.nextInt();
	}
	public void setInt2(){
		System.out.print("Second integer: ");
		Scanner int2 = new Scanner(System.in);
		input2 = int2.nextInt();
	}
}
