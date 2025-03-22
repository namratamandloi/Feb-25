public class Question17{
	public static void main(String args[]){
		int nums[] = { 2, 3, 5, 7, -7, 5, 8, -5 };
		int first=Integer.MIN_VALUE, second=Integer.MIN_VALUE;
		int firstmin=Integer.MAX_VALUE, secondmin=Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++){
			if(nums[i]>first){
				second = first;
				first = nums[i];
			} else if(nums[i]>second){
				second = nums[i];
			}
			
			if(nums[i]<firstmin){
				secondmin = firstmin;
				firstmin = nums[i];
			} else if(nums[i]<secondmin){
				secondmin = nums[i];
			}
		}
		int prod2=firstmin * secondmin;
		int prod1=first * second;
		int maxprod = Math.max(prod1,prod2);
		
		if(prod1==maxprod)
			System.out.println("Pair is (" + first + "," + second  + "), Maximum Product: " + maxprod);
		else
			System.out.println("Pair is (" + firstmin + "," + secondmin  + "), Maximum Product: " + maxprod);
	}
}	