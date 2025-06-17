using System;

internal class Employee
{
    public int EmpNo { get; set; }
    public string Name { get; set; }
    public decimal Salary { get; set; }

    public void AcceptDetails()
    {
        Console.Write("Enter EmpNo: ");
        EmpNo = int.Parse(Console.ReadLine());

        Console.Write("Enter Name: ");
        Name = Console.ReadLine();

        Console.Write("Enter Salary: ");
        Salary = decimal.Parse(Console.ReadLine());
    }

    public void DisplayDetails()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
    }
}

class Program
{
    static void Main()
    {
        Console.Write("Enter number of employees: ");
        int n = int.Parse(Console.ReadLine());

        Employee[] employees = new Employee[n];

        // Accept employee details
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine($"\nEnter details for Employee {i + 1}:");
            employees[i] = new Employee();
            employees[i].AcceptDetails();
        }

        // Find employee with highest salary
        Employee highestSalaryEmp = employees[0];
        for (int i = 1; i < n; i++)
        {
            if (employees[i].Salary > highestSalaryEmp.Salary)
            {
                highestSalaryEmp = employees[i];
            }
        }

        Console.WriteLine("\nEmployee with highest salary:");
        highestSalaryEmp.DisplayDetails();

        // Search employee by EmpNo
        Console.Write("\nEnter EmpNo to search: ");
        int searchEmpNo = int.Parse(Console.ReadLine());
        bool found = false;

        foreach (var emp in employees)
        {
            if (emp.EmpNo == searchEmpNo)
            {
                Console.WriteLine("Employee found:");
                emp.DisplayDetails();
                found = true;
                break;
            }
        }

        if (!found)
        {
            Console.WriteLine("Employee with given EmpNo not found.");
        }
    }
}
