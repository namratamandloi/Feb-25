public class ConsonentVowels{
	public static void main(String args[]){
		String sentence = "Practice makes a man perfect";
		int vowelCount = 0;
		int consonantCount = 0;
		
		sentence = sentence.toLowerCase();
		
		for(char ch : sentence.toCharArray()){
			if(Character.isLetter(ch)){
			   if("aeiou".indexOf(ch) != -1){
				 vowelCount++;
			   }else{
				 consonantCount++;
			   }
		    }
		}
		System.out.println("Number of vowels: " + vowelCount);
		System.out.println("Number of consonants: " + consonantCount);
	}
}