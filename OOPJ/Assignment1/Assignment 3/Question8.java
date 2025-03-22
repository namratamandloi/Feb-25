public class Question8{
	public static void main(String[] args){
		int arr1[] = {2,6,8,9,0,0,0,0,0};
		int arr2[] = {1,3,5,7,10};
		mergesort(arr1, arr2);
		print(arr1);
	}
	
	public static void mergesort(int[] arr1, int[] arr2){
		int m=3, n=arr2.length-1, track=arr1.length-1;
		while(m>=0 && n>=0){
			if(arr1[m]>arr2[n])
				arr1[track--]=arr1[m--];
			else
				arr1[track--]=arr2[n--];
		}
		while(m>=0){
			arr1[track--]=arr1[m--];
		}
		while(n>=0){
			arr1[track--]=arr2[n--];
		}
	}
	
	public static void print(int[] arr){
		for(int n: arr)
			System.out.print(n + " ");
	}
}