public class LongestWord{
	public static String findLongestWord(String sentence){
		String[] words = sentence.split("\\s+");//split sentence into words
		String longestWord = "";
		
		for(String word : words){
			if(word.length() > longestWord.length()){
				longestWord = word;
			}
		}
		return longestWord;
	}
	
	public static void main(String args[]){
		String sentence = "Practice makes a man perfect";
		String longestWord = findLongestWord(sentence);
		System.out.print("Longest word: " + longestWord);
	}
}