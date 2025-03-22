public class Question2
{
	public static void main(String args[])
	{
		int n = 8;
		int d = 0;
		try{
		int result = n/d;
		System.out.println("Result: " + result);
		}catch(ArithmeticException e){
			//e.printStackTrace();
			System.out.println("can not divide by zero....");
		}
	}
}