import java.util.Arrays;
public class Question16{
	public static void main(String[] args){
		int[] A = {1, 5, 6, 7, 8, 10}; 
		int[] B = { 2, 4, 9 };
		int[] res = new int[A.length];
		int i = 0, j = 0, track = 0; 
		while(track<res.length){
			if(A[i]<B[j]){
				res[track++] = A[i++];
			} else {
				res[track++] = B[j++];
			}
		}
		track = 0;
		while(j<B.length){
			B[track++] = B[j++];
		}
		while(i<A.length){
			B[track++] = A[i++];
		}
		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(B));	
	}
}