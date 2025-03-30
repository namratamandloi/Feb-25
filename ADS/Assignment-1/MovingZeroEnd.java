import java.util.*;
public class MovingZeroEnd{
	public static void findMovingZeroEnd(int arr[]){
		int index = 0; //for non-zero element
		//move non-zero to front
		for(int num : arr){
			if(num!=0){
				arr[index++] = num;
			}
		}
		//fill the remaining positions with zeros
		while(index < arr.length){
			arr[index++] = 0;
		}
	}
	
	public static void main(String args[]){
		int arr[] = {10, 0, 5, 20, 0, 8, 15};
		
		findMovingZeroEnd(arr);
		
		System.out.print(Arrays.toString(arr));
	}
}