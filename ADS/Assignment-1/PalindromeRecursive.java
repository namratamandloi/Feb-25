import java.util.*;
public class PalindromeRecursive{
	public static boolean ispalindrome(String str, int left, int right){
		if (str.charAt(left) == str.charAt(right)) {
            return true; 
        }
		
		if(str.charAt(left) != str.charAt(right)){
			return false;
		}
		
		return ispalindrome(str, left+1, right-1);
	}
	
	public static void main(String args[]){
		String string = "racecar";
		boolean result = ispalindrome(string, 0, string.length()-1);
		System.out.println("Is " + string + " a palindrom? " + result);
	}
}