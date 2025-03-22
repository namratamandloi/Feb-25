class Student{
	
	String name;
	double marks1,marks2,marks3;
	
	public void assignValues(String name, double marks1, double marks2, double marks3){
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	  }
	  
	public double total(){
		return marks1 + marks2 + marks3;
	}
	
	public double average(){
		return (marks1 + marks2 + marks3)/3;
	}
	
	public void display(){
		double totalMarks  = total();
		System.out.println("Student Name: " +name);
		System.out.println("total Marks: " +totalMarks);
		}
	}
		
	
	class StudentDemo
	{
		public static void main(String args[]){
			Student s1 = new Student();
			s1.assignValues("Namrata", 60.0, 75.5, 85.0);
			s1.display();
			
			double average = s1.average();
			System.out.println("Average Marks: " + average);
			}
	}