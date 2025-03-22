import java.util.InputMismatchException;
import java.util.Scanner;
public class Student{
	String name;
	int rollNo;
	static int[] marks =  new int[5];
	float average;
	char grade;
	
	Student(String name, int rollNo, int[] marks){
		this.name = name;
		this.rollNo =  rollNo;
		this.marks = marks;
	}
	
	void calculateAverage(){
		int total=0;
		for(int i=0; i<marks.length; i++){
			total += marks[i];
		}
		average = total/marks.length;
	}
	
	void calculateGrade(){
		if(average>=90) grade = 'A';
		else if(average>=80 && average<90) grade = 'B';	
		else if(average>=70 && average<80) grade = 'C';
		else if(average>=60 && average<70) grade = 'D';	
		else grade = 'F';		
	}
	
	void displayStudentInfo(){
		System.out.println("Name: " + name);
		System.out.println("Roll No: " + rollNo);
		System.out.println("Marks: ");
		for(int m:marks){
			System.out.print(" " + m + " ");
		}
		System.out.println("\nAverage: " + average);
		System.out.println("Grade: " + grade);
	}
	
	public static void main(String[] args){
	     Student s1 = null;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name, Roll No: ");
			String name = sc.nextLine();
			int rollNo = sc.nextInt();
			System.out.println("Enter marks in 5 subjects: ");
			for(int i=0; i<marks.length; i++){
				marks[i] = sc.nextInt();
			if(marks[i]<0 || marks[i]>100) throw new IllegalArgumentException();
			}
			s1 = new Student(name, rollNo, marks);
			s1.calculateAverage();
			s1.calculateGrade();
			s1.displayStudentInfo();
		} catch (InputMismatchException e){
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		} finally{ 
			System.out.println("Release Resources...");
		}
	}
}