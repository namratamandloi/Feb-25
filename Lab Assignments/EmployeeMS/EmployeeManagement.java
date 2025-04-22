import java.util.*;

class Employee {
    String name;
    int empID;
    String empDept;
    final String companyName = "GlobalTech";
    static int employeeCount = 0; 

    public Employee(String name, int empID, String empDept) {
        this.name = name;
        this.empID = empID;
        this.empDept = empDept;
        employeeCount++;
    }

    public void displayDetails() {
        System.out.println("\nEmployee Name: " + name);
        System.out.println("Employee ID: " + empID);
        System.out.println("Department: " + empDept);
        System.out.println("Company Name: " + companyName);
    }

    public static void displayEmployeeCount() {
        System.out.println("\nTotal Employees: " + employeeCount);
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("\nEnter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int empID = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Department: ");
        String empDept = sc.nextLine();

        employees.add(new Employee(name, empID, empDept));
        System.out.println("Employee added successfully!");
    }

    public static void deleteEmployee() {
        System.out.print("\nEnter Employee ID to delete: ");
        int empID = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).empID == empID) {
                employees.remove(i);
                Employee.employeeCount--;
                found = true;
                System.out.println("Employee deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Employee ID not found.");
        }
    }

    public static void updateEmployee() {
        System.out.print("\nEnter Employee ID to update: ");
        int empID = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.empID == empID) {
                System.out.print("Enter New Name: ");
                emp.name = sc.nextLine();
                System.out.print("Enter New Department: ");
                emp.empDept = sc.nextLine();
                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee ID not found.");
        }
    }

    public static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("\nNo employees found.");
        } else {
            System.out.println("\n--- Employee List ---");
            for (Employee emp : employees) {
                emp.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Employee Management Menu -----");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Display Total Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    Employee.displayEmployeeCount();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}