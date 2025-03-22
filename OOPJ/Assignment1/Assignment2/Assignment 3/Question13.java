import java.util.Scanner;
public class Question13{
	public static void main(String[] args){
		int n = 20;
		Scanner sc = new Scanner(System.in);
		int Chemistry[] = new int[n];
		int Physics[] = new int[n];
		int Maths[] = new int[n];
		for(int i=0; i<n; i++){
			System.out.print("Chemistry marks of student " + (i+1) + ": ");
			Chemistry[i] = sc.nextInt();
			System.out.print("Physics marks of student " + (i+1) + ": ");
			Physics[i] = sc.nextInt();
			System.out.print("Mathematics marks of student " + (i+1) + ": ");
			Maths[i] = sc.nextInt();
		} 
		int count1=0, count2=0;
		for(int i=0; i<n; i++){
			double avgp=((Chemistry[i]+Physics[i]+Maths[i])/300.0)*100;
			if(avgp>=75){
				count1++;
			} else if(avgp<=40){
				count2++;
			}
		}
		System.out.println(" Number of students securing 75% and above in aggregate: " + count1);
		System.out.println(" Number of students securing 40% and below in aggregate: " + count2);
	}
}	