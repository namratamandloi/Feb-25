abstract class CourseStructure{
	abstract void showCourseSubjects();
}

class Student extends CourseStructure{
	private int id;
	private String name;
	private int age;
	private String course;
	protected double baseFee;
	public Student(int id, String name, int age, String course, double baseFee) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
		this.baseFee = baseFee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(double baseFee) {
		this.baseFee = 0;
	}
	 
	public void displayDetails() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Course: " + course);
		System.out.println("Base Fee: " + baseFee);
	}
	
	public double totalFee() {
		return baseFee;
		
	}
	public void showCourseSubjects() {
		System.out.println("Course Subject..");
	}
	
}

class DayScholar extends Student{

	public DayScholar(int id, String name, int age, String course, double baseFee, double transportFee) {
		super(id, name, age, course, baseFee);
		this.transportFee = transportFee;
	}
	private double transportFee;
	
	@Override
	public double totalFee() {
		return baseFee + transportFee;
	}
	@Override
	public void showCourseSubjects() {
		System.out.println("Course Stubject: " + getCourse());
	}
	
}
class Hosteller extends Student{
	
	private double hostelFee;
	
	public Hosteller(int id, String name, int age, String course, double baseFee, double hostelFee) {
		super(id, name, age, course, baseFee);
		this.hostelFee = hostelFee;
	}

	@Override
	public double totalFee() {
		return baseFee + hostelFee;
	}
	
	@Override
	public void showCourseSubjects() {
		System.out.println("Course Stubject: " + getCourse());
	}
	
}

public class StudentManagementSystem {
	public static void main(String[] args) {
		System.out.println("----------First Person----------");
		DayScholar ds = new DayScholar(101,"Nidhi Mehendale", 23, "PG-DAC", 700000, 5000);
		ds.displayDetails();
		ds.showCourseSubjects();
		System.out.println("Total fee: " + ds.totalFee());
		
		System.out.println("----------Second Person----------");
		DayScholar ds1 = new DayScholar(102,"Nidhi Navandar", 24, "PG-DAC", 700000, 5000);
		ds1.displayDetails();
		ds1.showCourseSubjects();
		System.out.println("Total fee: " + ds1.totalFee());
		
		System.out.println("----------Third Person----------");
		Hosteller hs = new Hosteller(103,"Namrata Mandloi", 25, "PG-DAC", 700000, 5000);
		hs.displayDetails();
		hs.showCourseSubjects();
		System.out.println("Total fee: " + hs.totalFee());
		
	}
}