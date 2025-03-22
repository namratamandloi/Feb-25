
public class Question9{
	public static void main(String[] args){
		int arr1[] = {2,1,4,5,0};
		System.out.println("Missing Number: " + missingNumber(arr1));
	}
	public static int missingNumber(int[] arr){
		int xor1 = 0, xor2 = 0;
		for(int i=0; i<arr.length; i++){
			xor1 = xor1 ^ arr[i];
		}
		for(int i=0; i<=arr.length; i++){
			xor2 = xor2 ^ i;
		}
		return xor1 ^ xor2;
	}
}