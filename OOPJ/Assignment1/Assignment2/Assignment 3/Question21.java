public class Question21{
	public static void main(String args[]){
		int rowsum = 0, colsum = 0;
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};	
		for(int i=0; i<matrix.length; i++){
			rowsum = 0; 
			colsum = 0;
			for(int j=0; j<matrix[i].length; j++){
				rowsum += matrix[i][j];
				colsum += matrix[j][i];
			}
			System.out.println("Row Sum: " + rowsum + "\tColumn Sum: " + colsum);
		}	
	}
}