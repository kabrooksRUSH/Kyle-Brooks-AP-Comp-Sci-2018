
public class HiddenWord_2015_2 {
	
	static String HidWord;

	
	public static void HiddenWord(String word){
		HidWord = word;
	}
	
	public static String getHint(String guess){
		String Hint = "";
		 for (int g = 0; g < guess.length(); g++){
			 if(guess.substring(g, g + 1).equals(HidWord.substring(g, g + 1))){
				 Hint += guess.substring(g , g+1);
			 }
			 else if(HidWord.indexOf(guess.substring(g, g + 1))> -1){
				 Hint += "+";
			 }
			 else{
				 Hint += "*";
			 }
		 }
		 return Hint;
	}
	
	public static void main (String[] args){
		
		HiddenWord("pknos");
		System.out.print(getHint("pknos"));
		
	}
}
