public class Question1
{
public static void main(String args[])
{
	System.out.println("Execution started");
	String s = null;
	try{
	System.out.println(s.length());
	}catch(NullPointerException e){
	 e.printStackTrace();
	 System.out.println("can not call length() on a null String");
	}
}
}