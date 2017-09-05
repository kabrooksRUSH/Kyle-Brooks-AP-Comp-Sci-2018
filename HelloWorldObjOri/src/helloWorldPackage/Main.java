package helloWorldPackage;



public class Main {
	public static void main(String[] args){
		HelloWorldKyle Kyle = new HelloWorldKyle("Hello World Kyle");
		Window Screen1 = new Window("Test", 1500, 1500);		
		
		System.out.print(Kyle.greet());
	}
}
