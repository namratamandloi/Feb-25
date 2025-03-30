class ReverseString{
   static String reverseString(String str)
   {
	if(str.isEmpty()){
		return str;
	}
	return reverseString(str.substring(1)) + str.charAt(0);
}

 public static void main(String args[])
 {
	String s1 = "CDACMumbai";
	String s2 = "Alice";
	
	System.out.println("s1: " + s1);
	System.out.println("s1: " + reverseString(s1));
	
	System.out.println("s2: " + s2);
	System.out.println("s1: " + reverseString(s2));
	
	}
}
	
	