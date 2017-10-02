package chapter4ExercisesPackage;

import java.util.Scanner;

public class Volumes_10 {
	
	double length;
	double width;
	double height;
	double radius;
	
	double volume;
	double surfaceA;
	
	String Shape;
	
	Scanner input = new Scanner(System.in);
	
	int shapeSelect;
	
	public Volumes_10(){		
	}
	public void getShape(){
		System.out.print("Is your shape a (1)-rectangular prism, (2)-sphere, (3)-cube, or (4)-triangular prism? ");
		shapeSelect = input.nextInt();
	}
	public void calcVolume(){
		switch (shapeSelect){
		case 1: System.out.println("You have chosen the rectangular prism" + "\n");
				System.out.print("Please enter length: ");
				length = input.nextDouble();
				System.out.print("Please enter width: ");
				width = input.nextDouble();
				System.out.print("Please enter height: ");
				height = input.nextDouble();
				
				volume = length*width*height;
				surfaceA = 2*(width*length + height*length + width*height);
				break;
				
		case 2: System.out.println("You have chosen the sphere" + "\n");
				System.out.print("Please enter the radius: ");
				radius = input.nextDouble();
				
				volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
				surfaceA = 4 * Math.PI * Math.pow(radius, 2);
				break;
				
		case 3: System.out.println("You have chosen the cube" + "\n");
				System.out.print("Please enter the side length: ");
				length = input.nextDouble();
				
				volume = Math.pow(length, 3);
				surfaceA = 6 * Math.pow(length, 2);
				break;
				
		case 4: System.out.println("You have chosen the triangular prism" + "\n");
				System.out.print("Please enter the base: ");
				length = input.nextDouble();
				System.out.print("Please enter the side length: ");
				width = input.nextDouble();
				System.out.print("Please enter the height: ");
				height = input.nextDouble();
				
				double s = (length * 3)/2.0;
				
				volume = height * ((width * length)/2.0);
				surfaceA = (height*(length*3)) + 2*((length*width)/2.0);
		}
		System.out.println("\n" + "The volume is: " + volume);
		System.out.print("Surface area: " + surfaceA);
	}
}