namespace Interface_Employee
{
    class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public double Salary { get; set; }

        public void Display()
        {
            Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
        }
    }

    class Program
    {
        static void Main()
        {
            List<Employee> employees = new List<Employee>();
            string choice;

            // Accept employee details in a loop
            do
            {
                Employee emp = new Employee();

                Console.Write("Enter EmpNo: ");
                emp.EmpNo = int.Parse(Console.ReadLine());

                Console.Write("Enter Name: ");
                emp.Name = Console.ReadLine();

                Console.Write("Enter Salary: ");
                emp.Salary = double.Parse(Console.ReadLine());

                employees.Add(emp);

                Console.Write("Do you want to add another employee? (yes/no): ");
                choice = Console.ReadLine().ToLower();
            }
            while (choice == "yes");

            // Display employee with highest salary
            if (employees.Count > 0)
            {
                Employee highestSalaryEmp = employees.OrderByDescending(e => e.Salary).First();
                Console.WriteLine("\nEmployee with highest salary:");
                highestSalaryEmp.Display();
            }

            // Search by EmpNo
            Console.Write("\nEnter EmpNo to search: ");
            int searchEmpNo = int.Parse(Console.ReadLine());

            Employee searchEmp = employees.FirstOrDefault(e => e.EmpNo == searchEmpNo);

            if (searchEmp != null)
            {
                Console.WriteLine("Employee found:");
                searchEmp.Display();
            }
            else
            {
                Console.WriteLine("Employee not found.");
            }

            // Display Nth Employee
            Console.Write("\nEnter position (N) to display that employee (1-based index): ");
            int n = int.Parse(Console.ReadLine());

            if (n > 0 && n <= employees.Count)
            {
                Console.WriteLine($"Details of Employee at position {n}:");
                employees[n - 1].Display();
            }
            else
            {
                Console.WriteLine("Invalid position.");
            }
        }
    }
}