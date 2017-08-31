package helloWorldPackage;

public class HelloWorldKyle {	
	private String message;
	
	static long epoch = System.currentTimeMillis()/1000;
	static String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch*1000));
	
	public HelloWorldKyle(String m) {
		message = m;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getTime(){
		return date;
	}
	
	public String greet(){
		String greet;
		return greet = message + " the time is " + date;
	}
}
