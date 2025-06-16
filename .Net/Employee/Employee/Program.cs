using System;

namespace MyApp
{
    class Employee
    {
        // Fields
        private string name;
        private int empNo;
        private decimal basic;
        private short deptNo;

        // Properties with validation
        public string Name
        {
            get => name;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("Name cannot be blank.");
                name = value;
            }
        }

        public int EmpNo
        {
            get => empNo;
            set
            {
                if (value <= 0)
                    throw new ArgumentException("EmpNo must be greater than 0.");
                empNo = value;
            }
        }

        public decimal Basic
        {
            get => basic;
            set
            {
                if (value < 10000 || value > 200000)
                    throw new ArgumentException("Basic salary must be between 10,000 and 2,00,000.");
                basic = value;
            }
        }

        public short DeptNo
        {
            get => deptNo;
            set
            {
                if (value <= 0)
                    throw new ArgumentException("DeptNo must be greater than 0.");
                deptNo = value;
            }
        }

        // Method to calculate net salary
        public decimal GetNetSalary()
        {
            decimal hra = Basic * 0.4M;
            decimal da = Basic * 0.1M;
            decimal pf = Basic * 0.12M;
            return Basic + hra + da - pf;
        }

        // Constructors
        public Employee(int empNo, string name, decimal basic, short deptNo)
        {
            EmpNo = empNo;
            Name = name;
            Basic = basic;
            DeptNo = deptNo;
        }

        public Employee(int empNo, string name, decimal basic) : this(empNo, name, basic, 1) { }

        public Employee(int empNo, string name) : this(empNo, name, 10000, 1) { }

        public Employee(int empNo) : this(empNo, "Default Name", 10000, 1) { }

        public Employee() : this(1, "Default Name", 10000, 1) { }
    }

    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Employee o1 = new Employee(1, "Amol", 123465, 10);
                Employee o2 = new Employee(2, "Sujit", 105000);
                Employee o3 = new Employee(3, "Priya");
                Employee o4 = new Employee(4);
                Employee o5 = new Employee();

                Console.WriteLine($"Net Salary of {o1.Name} (EmpNo {o1.EmpNo}): {o1.GetNetSalary():C}");
                Console.WriteLine($"Net Salary of {o2.Name} (EmpNo {o2.EmpNo}): {o2.GetNetSalary():C}");
                Console.WriteLine($"Net Salary of {o3.Name} (EmpNo {o3.EmpNo}): {o3.GetNetSalary():C}");
                Console.WriteLine($"Net Salary of {o4.Name} (EmpNo {o4.EmpNo}): {o4.GetNetSalary():C}");
                Console.WriteLine($"Net Salary of {o5.Name} (EmpNo {o5.EmpNo}): {o5.GetNetSalary():C}");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
        }
    }
}