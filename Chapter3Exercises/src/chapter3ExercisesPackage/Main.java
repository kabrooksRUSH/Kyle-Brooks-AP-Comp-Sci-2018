package chapter3ExercisesPackage;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.print("Which app would you like to run: ");
		Scanner select = new Scanner(System.in);
		int selection = select.nextInt();
		
		switch (selection){
			case 1: ObjectHeight_1 cliff1 = new ObjectHeight_1();
					cliff1.setTime();
					cliff1.calcHeight();
					break;
	//////////////////////////////////////////////^^Object Height^^////////////////////////////////////
			case 2: PizzaCost_2 pizza1  = new PizzaCost_2();
					pizza1.setDiameter();
					pizza1.calcCost();
					break;
	//////////////////////////////////////////////^^Pizza Cost^^////////////////////////////////////
			case 3: CollegeCalculator_3 calc1 = new CollegeCalculator_3();
					calc1.setCollegeCosts();
					calc1.calcCost();
					break;
	//////////////////////////////////////////////^^College Cost^^////////////////////////////////////
			case 4: Energy_4 energyCalc1 = new Energy_4();
					energyCalc1.setWeight();
					energyCalc1.calcEnergy();
					energyCalc1.calcBulbs();
					break;
	//////////////////////////////////////////////^^Energy^^////////////////////////////////////		
			case 5: Change_5 coins1 = new Change_5();
					coins1.setChange();
					coins1.calcChange();
					break;
	//////////////////////////////////////////////^^Change^^////////////////////////////////////
			case 6: Digits_6 num1 = new Digits_6();
					num1.setDividend();
					num1.calcChange();
					break;
	//////////////////////////////////////////////^^Digits^^////////////////////////////////////
			case 7: DivAndMod_7 divmod1 = new DivAndMod_7();
					divmod1.setIntegers();
					divmod1.calculateDivAndMod();
					break;
	//////////////////////////////////////////////^^DivAndMod^^////////////////////////////////////
			case 8: TimeConversion_8 convert1 = new TimeConversion_8();
					convert1.setTime();
					convert1.calcTime();
					break;
	//////////////////////////////////////////////^^TimeConversion^^////////////////////////////////////
			case 9: Sleep_9 sleep1 = new Sleep_9();
					sleep1.getBirthDate();
					sleep1.getTodayDate();
					sleep1.calcSleep();
					break;
	//////////////////////////////////////////////^^Sleep^^////////////////////////////////////
			case 10: Order_10 order1 = new Order_10();
					 order1.getBurgers();
					 order1.getFries();
					 order1.getPop();
					 order1.calcCost();
					 order1.getTended();
					 order1.calcChange();
					 break;
	 //////////////////////////////////////////////^^Order^^////////////////////////////////////
			case 11: Project_11 project1 = new Project_11();
					 project1.getTimes();
					 project1.calcPercent();
					 break;
	 //////////////////////////////////////////////^^Project^^////////////////////////////////////
			case 12: Spending_12 spending1 = new Spending_12();
					 spending1.getCosts();
					 spending1.calcPercent();
					 break;
	 //////////////////////////////////////////////^^Spending^^////////////////////////////////////
			case 13: SimpleInterest_13 interest1 = new SimpleInterest_13();
				 	 interest1.getValsA();
				 	 interest1.calcEndValA();
				 	 interest1.getValsP();
					 interest1.calcEndValP();
					 break;
	 //////////////////////////////////////////////^^SimpleInterst^^////////////////////////////////////
			case 14: Election_14 election1 = new Election_14();
					 election1.getElectionResult();
					 election1.calcElectionResults();
					 break;
	 //////////////////////////////////////////////^^Election^^////////////////////////////////////
		}
	}
}
