import java.util.*;
public class Question11{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A[] = {1, 3, -7, 3, 2, 3, 1, -3, -2, -2};
		System.out.println(Arrays.toString(A));
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			list.removeAll(list);
			int sum =0;
			for(int j=i; j<A.length; j++){
				sum += A[j];
				list.add(A[j]);
				if(sum==n){
					System.out.println(list.toString());
				}
			}
		}
	}
}