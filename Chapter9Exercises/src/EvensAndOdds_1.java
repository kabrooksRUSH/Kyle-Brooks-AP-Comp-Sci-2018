import java.util.Random;

public class EvensAndOdds_1 {

	
	
	int[]x = new int[25];
	
	Random randomNum = new Random();
	
	public void genNumbers(){
		for(int i = 0; i<25; i++){
			x[i] = randomNum.nextInt(99);
		}
	}
	
	public void evenOrOdd(){
		System.out.println("Even Numbers:");
		for(int q = 0; q<25; q++){
			if(x[q] % 2 == 0){
				System.out.print(x[q] + " ");
			}
		}
		
		System.out.println("\n" + "Odd Numbers: ");
		for(int w = 0; w<25; w++){
			if(x[w] % 2 != 0){
				System.out.print(x[w] + " ");
				}
		}
	}
}
