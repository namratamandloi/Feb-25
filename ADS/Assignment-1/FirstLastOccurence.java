public class FirstLastOccurence{
	public static int[] findOccurances(int[] arr, int key){
		int firstIndex=-1, lastIndex=-1;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == key){
				if(firstIndex==-1)
					firstIndex = i;  	
				lastIndex=i;
			}
		}
		return new int[]{firstIndex, lastIndex};
	}
	
	public static void main(String args[]){
		int arr[] = {1, 3, 3, 3, 5, 6, 8};
		findOccurances(arr, key);
	}
}