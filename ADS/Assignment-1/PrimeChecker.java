public class PrimeChecker{
	public static boolean isPrime(int num, int divisor){
		if(divisor == 1){ //base case
			return true;
		}
		if(num % divisor == 0){
			return false;
		}
		return isPrime(num, divisor-1);
	}
	
	public static void main(String args[]){
		int num = 7;
			boolean result = isPrime(num, num-1);
			System.out.println(num + (result ? " is a prime number." : " is not a prime number."));
	}
}