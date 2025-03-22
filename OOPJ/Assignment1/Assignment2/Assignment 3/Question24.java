public class Question24{
	public static void main(String[] args){
		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int res[][] = new int[matrix.length][matrix[0].length];
		print(matrix);
		transpose(matrix);
		for(int i=0; i<matrix.length; i++)
			reverse(matrix[i]);
		System.out.println("-----");
		print(matrix);
	}
	
	public static void transpose(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=i+1; j<matrix[i].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	public static void reverse(int[] row){
		int low=0, high=row.length-1;
		while(low<high){
			row[high] = row[high] + row[low];
			row[low] = row[high] - row[low];
			row[high] = row[high] - row[low];
			low++;
			high--;
		}
	}
	
	public static void print(int[][] input){
		for(int i=0; i<input.length; i++){
			for(int j=0; j<input[0].length; j++){
				System.out.print(input[i][j]+ " ");
			}
			System.out.println();
		}
	}
}