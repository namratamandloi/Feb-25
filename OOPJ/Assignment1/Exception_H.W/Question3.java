public class Question3
{
	public static void main(String args[])
	{
		int[] arr = {2, 4, 3, 5,6};
		try{
		   int a = arr[10];
		   System.out.println("Elements at index 10:" + a);
		  }catch(ArrayIndexOutOfBoundsException e){
		    System.out.println("Index 10 is out of bound for the array");
			}
		}
	}
	