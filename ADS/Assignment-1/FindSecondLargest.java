import java.util.*;

public class FindSecondLargest{
	
	public static int secondLargest(int array[]){
		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;
		
		for(int i=0; i<array.length; i++){
			if(array[i]>largest){
				secondlargest = largest;
				largest = array[i];
			}
		}
		return secondlargest;
	}
	
	public static void main(String args[]){
		int arr[] = {10, 0, 5, 20, 0, 8, 15};
		Arrays.sort(arr);
		
		int result = secondLargest(arr);
		
		System.out.println(result);
	}
}