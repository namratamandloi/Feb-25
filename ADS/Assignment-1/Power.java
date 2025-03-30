public class Power{
	static int power(int exponent, int base){
		if(base == 0){
			return 1;
		}
		return exponent*power(exponent, base-1);
	}
	
	public static void main(String args[]){
		int base = 2;
		int exponent = 5;
		System.out.print(base + "^" + exponent + "=" + power(base,exponent));
	}
}