package chapter3ExercisesPackage;

import java.util.Scanner;

public class Election_14 {
	
	int awbreyNY;
	int awbreyNJ;
	int awbreyCN;
	
	int martinezNY;
	int martinezNJ;
	int martinezCN;
	
	double awbreyT;
	double martinezT;
	
	double totalVotes;
	
	Scanner fieldScanner = new Scanner(System.in);
	
	public Election_14(){
		
	}
	
	public void getNYResult(){
		System.out.print("Election results for New York: " + "\n");
		
		System.out.print("Awbrey: ");
		awbreyNY = fieldScanner.nextInt();
		
		System.out.print("Martinez: ");
		martinezNY = fieldScanner.nextInt();
	}
	public void getNJResult(){
System.out.print("Election results for New Jersey: " + "\n");
		
		System.out.print("Awbrey: ");
		awbreyNJ = fieldScanner.nextInt();
		
		System.out.print("Martinez: ");
		martinezNJ = fieldScanner.nextInt();
	}
	public void getCNResult(){
System.out.print("Election results for Conneticut: " + "\n");
		
		System.out.print("Awbrey: ");
		awbreyCN = fieldScanner.nextInt();
		
		System.out.print("Martinez: ");
		martinezCN = fieldScanner.nextInt();
	}
	
	public void getElectionResult(){
		getNYResult();
		getNJResult();
		getCNResult();
	}
	
	public void calcElectionResults(){
		awbreyT = awbreyNY + awbreyNJ + awbreyCN;
		martinezT = martinezNY + martinezNJ + martinezCN;
		totalVotes = martinezT + awbreyT;
		
		System.out.print("Candidate             Votes      Percentage" + "\n");		
		System.out.print("Awbrey               " + awbreyT + "         " + (awbreyT/totalVotes)*100 + "\n");
		System.out.print("Martinez             " + martinezT + "         " + (martinezT/totalVotes)*100);
	}
	
}
