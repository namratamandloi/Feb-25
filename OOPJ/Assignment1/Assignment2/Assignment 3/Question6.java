public class Question6{
	public static void main(String[] args){
		int arr[] = {2,2,3,3,3,4,5,5,6,7,8,67};
		print(arr);
		removeDuplicates(arr);
		System.out.println();
		print(arr);
	}
	
	public static void removeDuplicates(int[] arr){
		int track=1;
		for(int i=1; i<arr.length; i++){
			if(arr[i]!=arr[i-1])
				arr[track++] = arr[i];
		}
		for(int i=track; i<arr.length; i++){
			if(arr[i]!=arr[i-1])
				arr[track++] = 0;
		}
	}
	
	public static void print(int[] arr){
		for(int n: arr)
			System.out.print(n + " ");
	}
}