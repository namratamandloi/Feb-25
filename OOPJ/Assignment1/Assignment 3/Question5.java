public class Question5{
	public static void main(String[] args){
		int arr[] = {2,3,4,5,6,7,8,67};
		for(int a : arr)	
			System.out.print(a + " ");
		System.out.println("\nSum: " + sum((arr)));
		System.out.printf("Average: %.2f",avg((arr)));
	}
	
	public static int sum(int[] arr){
		int sum=0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}	
		return sum;
	}
	
	public static float avg(int[] arr){
		float sum = (float) sum(arr);
		float avg= sum/arr.length;
		return avg;
	}
}