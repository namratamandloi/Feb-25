public class Question1{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,25,0,8};
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
			if(min>arr[i])
				min = arr[i];
		}
		
		for(int i=0; i<arr.length; i++){
			if(max<arr[i])
				max = arr[i];
		}
		
		System.out.println("MIN: " + min + ", MAX: " + max);
	}
}