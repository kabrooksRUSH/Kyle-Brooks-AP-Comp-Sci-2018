package Chapter3ExercisesPackage;

public class ObjectHeight {
	double height;
	double time;
	
	public ObjectHeight(){	
		System.out.print("Input a timeless than 4.5 seconds: ");
		System.out.print("Height of object: " + height + "\n");
	}
	
	public void calcHeight(){
		height = 100-4.9*Math.pow(time, 2);
	}
}