import java.util.*;

public class Question14{
	public static void main(String[] args){
		int n = 20;
		Scanner sc = new Scanner(System.in);
		int[] even = new int[n];
		int[] odd = new int[n];
		int arr[] = new int[n];
		int evencount=0, oddcount=0;
		for(int i=0; i<arr.length; i++){
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[i]%2==0){
				even[evencount++] = arr[i];
			} else {
				odd[oddcount++] = arr[i];
			}
		}
		System.out.println("Odd Numbers: ");
		for(int i=0;i<oddcount; i++){
			System.out.print(odd[i] + " ");
		}
		
		System.out.println("\nEven Numbers: ");
		for(int i=0;i<evencount; i++){
			System.out.print(even[i] + " ");
		}
	}
}