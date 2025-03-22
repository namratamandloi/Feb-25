import java.util.HashSet;
public class Question10{
	public static void main(String[] args){
		int arr1[] = {2,1,4,5};
		int arr2[] = {2,7,3,5};
		int res1[] = intersection(arr1,arr2);
		int res2[] = union(arr1,arr2);
		System.out.println("Intersection: ");
		for(int i : res1){
			System.out.print(i + " ");
		}
		System.out.println("\nUnion: ");
		for(int i : res2){
			System.out.print(i + " ");
		}
	}
	
	public static int[] intersection(int[] arr1,int[] arr2){
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> res = new HashSet<>();
		for(int i=0; i<arr1.length; i++){
				set.add(arr1[i]);
		}
		
		for(int i=0; i<arr2.length; i++){
			if(set.contains(arr2[i]))	
				res.add(arr1[i]);
		}
		
		int i=0;
		int Res[] = new int[res.size()];
		for(int n : res){
			Res[i++] = n;
		}
		return Res;
	}
	
	
	public static int[] union(int[] arr1,int[] arr2){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr1.length; i++){
				set.add(arr1[i]);
		}
		
		for(int i=0; i<arr2.length; i++){
			set.add(arr2[i]);
		}
		
		int i=0;
		int Res[] = new int[set.size()];
		for(int n : set){
			Res[i++] = n;
		}
		return Res;
	}
}