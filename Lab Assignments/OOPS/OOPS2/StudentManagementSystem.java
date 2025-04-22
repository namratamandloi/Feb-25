import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getRole();

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

abstract class Student extends Person {
    protected static int studentCounter = 1001;
    protected int studentId;
    protected String course;
    protected double baseFee;
    protected Mentor mentor;

    public Student(String name, int age, String course, double baseFee, Mentor mentor) {
        super(name, age);
        this.studentId = studentCounter++;
        this.course = course;
        this.baseFee = baseFee;
        this.mentor = mentor;
    }

    public abstract double calculateTotalFee();

    @Override
    public String getRole() {
        return "Student";
    }

    public void displayStudentDetails() {
        displayDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Total Fee: " + calculateTotalFee());
        System.out.println("Mentor: " + mentor.name + " (" + mentor.getRole() + ")");
        System.out.println("Department: " + mentor.department);
    }
}

class DayScholar extends Student {
    private double transportFee;

    public DayScholar(String name, int age, String course, double baseFee, Mentor mentor, double transportFee) {
        super(name, age, course, baseFee, mentor);
        this.transportFee = transportFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + transportFee;
    }
}

class Hosteller extends Student {
    private double hostelFee;

    public Hosteller(String name, int age, String course, double baseFee, Mentor mentor, double hostelFee) {
        super(name, age, course, baseFee, mentor);
        this.hostelFee = hostelFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + hostelFee;
    }
}

interface CourseStructure {
    List<String> getSubjects();
}

class JavaCourse implements CourseStructure {
    @Override
    public List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Core Java");
        subjects.add("Advanced Java");
        subjects.add("Java Frameworks");
        return subjects;
    }
}

class PythonCourse implements CourseStructure {
    @Override
    public List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Python Basics");
        subjects.add("Data Science with Python");
        subjects.add("Machine Learning with Python");
        return subjects;
    }
}

class DataScienceCourse implements CourseStructure {
    @Override
    public List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Introduction to Data Science");
        subjects.add("Statistics for Data Science");
        subjects.add("Machine Learning in Data Science");
        return subjects;
    }
}

class Mentor extends Person {
    protected String department;

    public Mentor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Mentor";
    }
}

public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Mentor mentor1 = new Mentor("Dr. Smith", 45, "CS");
        Mentor mentor2 = new Mentor("Prof. Johnson", 50, "IT");

        CourseStructure javaCourse = new JavaCourse();
        CourseStructure pythonCourse = new PythonCourse();
        CourseStructure dataScienceCourse = new DataScienceCourse();

        while (true) {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Course Subjects");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addStudent(mentor1, mentor2);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    showCourseSubjects(javaCourse, pythonCourse, dataScienceCourse);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent(Mentor mentor1, Mentor mentor2) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("Select Course:");
        System.out.println("1. Java Course");
        System.out.println("2. Python Course");
        System.out.println("3. Data Science Course");
        System.out.print("Enter choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine();  

        String course = "";
        CourseStructure courseStructure = null;
        switch (courseChoice) {
            case 1:
                course = "Java";
                courseStructure = new JavaCourse();
                break;
            case 2:
                course = "Python";
                courseStructure = new PythonCourse();
                break;
            case 3:
                course = "Data Science";
                courseStructure = new DataScienceCourse();
                break;
            default:
                System.out.println("Invalid course choice.");
                return;
        }

        System.out.print("Enter base fee: ");
        double baseFee = scanner.nextDouble();
        scanner.nextLine();  

        System.out.println("Select Student Type:");
        System.out.println("1. Day Scholar");
        System.out.println("2. Hosteller");
        System.out.print("Enter choice: ");
        int studentType = scanner.nextInt();
        scanner.nextLine();  

        Student student = null;
        if (studentType == 1) {
            System.out.print("Enter transport fee: ");
            double transportFee = scanner.nextDouble();
            student = new DayScholar(name, age, course, baseFee, mentor1, transportFee);
        } else if (studentType == 2) {
            System.out.print("Enter hostel fee: ");
            double hostelFee = scanner.nextDouble();
            student = new Hosteller(name, age, course, baseFee, mentor2, hostelFee);
        } else {
            System.out.println("Invalid student type.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        for (Student student : students) {
            student.displayStudentDetails();
            System.out.println("---------------------------------");
        }
    }

    private static void showCourseSubjects(CourseStructure javaCourse, CourseStructure pythonCourse, CourseStructure dataScienceCourse) {
        System.out.println("Select Course to View Subjects:");
        System.out.println("1. Java Course");
        System.out.println("2. Python Course");
        System.out.println("3. Data Science Course");
        System.out.print("Enter choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine(); 

        List<String> subjects = null;
        switch (courseChoice) {
            case 1:
                subjects = javaCourse.getSubjects();
                break;
            case 2:
                subjects = pythonCourse.getSubjects();
                break;
            case 3:
                subjects = dataScienceCourse.getSubjects();
                break;
            default:
                System.out.println("Invalid course choice.");
                return;
        }

        System.out.println("Course Subjects:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }
    }
}
