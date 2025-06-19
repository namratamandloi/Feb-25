namespace EmployeeList_1
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Employee[] empArray = new Employee[3];
            empArray[0] = new Employee { EmpNo = 1, Name = "Namrata", Salary = 50000 };
            empArray[1] = new Employee { EmpNo = 2, Name = "Nidhi", Salary = 60000 };
            empArray[2] = new Employee { EmpNo = 3, Name = "Ram", Salary = 55000 };

            List<Employee> empList = new List<Employee>(empArray);


            Console.WriteLine("=== All Employees in the List ===");
            foreach (Employee emp in empList)
            {
                emp.Display();
            }

        }
    }

    class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Salary { get; set; }

        public void Display()
        {
            Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
        }
    }
}
