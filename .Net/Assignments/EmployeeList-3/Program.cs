namespace EmployeeList_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Employee> empList = new List<Employee>
            {
                new Employee { EmpNo = 11, Name = "Nidhi", Salary = 50000 },
                new Employee { EmpNo = 12, Name = "Namrata", Salary = 60000 },
                new Employee { EmpNo = 13, Name = "Mandloi", Salary = 70000 }
            };

            Employee[] empArray = empList.ToArray();


            Console.WriteLine("All employees of array");
            foreach (Employee emp in empArray)
            {
                emp.Display();
            }
        }

        class Employee
        {
            public int EmpNo { get; set; }
            public string Name { get; set; }
            public decimal Salary { get; set; }

            public void Display()
            {
                Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary} ");
            }
        }
    }
}

