public class SumDigit{
	public static int sum(int num){
		if(num == 0) return 0;
		return (num % 10) + sum(num/10);
	}
	
	public static void main(String args[]){
		int num = 1234;
		int result = sum(num);
		System.out.println(result);
	}
}