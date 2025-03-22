import java.util.*;
public class Question15{
	public static void main(String[] args){
		
		int A[] = {1, 3, -7, -3, 2, 4, 1, -3, -2, 5};
		System.out.println(Arrays.toString(A));
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			list.removeAll(list);
			int sum =0;
			for(int j=i; j<A.length; j++){
				sum += A[j];
				list.add(A[j]);
				if(sum==0){
					System.out.println(list.toString());
				}
			}
		}
	}
}