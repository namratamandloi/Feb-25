public class Question25{
	public static void main(String args[]){
		int diagonalsum=0;
		int[][] matrix = {{11,21,32},{42,2,61},{17,128,3}};	
		for(int i=0; i<matrix.length; i++){
			diagonalsum += matrix[i][i];
		}
		System.out.println("Diagonal Sum: " + diagonalsum);
	}
}