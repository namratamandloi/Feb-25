public class Question23{
	public static void main(String args[]){
		int[][] matrix1 = {{1,2,3},{1,2,3},{1,2,3}};
		int[][] matrix2 = {{1,2,3},{1,2,3},{1,2,3}};	
		int[][] res = new int[matrix1.length][matrix1[0].length];
		for(int i=0; i<matrix1.length; i++){
			for(int j=0; j<matrix1.length; j++){
				for(int k=0; k<matrix1.length; k++){
					res[i][j] = res[i][j] + (matrix1[i][k] + matrix2[k][j]);
				}
			}
		}
		for(int i=0; i<res.length; i++){
			for(int j=0; j<res.length; j++){	
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}