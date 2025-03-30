import java.util.*;

public class Peek{
	public static int findLargest(int[] array) {
        int largest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
}
	
	public static void main(String args[]){
	    int arr[] = {1, 3, 3, 3, 5, 6, 8};
		int largest = findLargest(arr);
		System.out.println("The largest element of given array: " + largest);
	}
}