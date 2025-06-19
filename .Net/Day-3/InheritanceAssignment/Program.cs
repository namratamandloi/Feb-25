using System;

namespace InheritanceAssignment
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public abstract class Employee : IDbFunctions
    {
        private static int counter = 1;
        private string name;
        private short deptNo;

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

        public int EmpNo { get; } // Readonly & Auto-generated

        public short DeptNo
        {
            get => deptNo;
            set
            {
                if (value <= 0)
                    throw new ArgumentException("DeptNo must be > 0.");
                deptNo = value;
            }
        }

        public abstract decimal Basic { get; set; }

        public abstract decimal CalcNetSalary();

        protected Employee(string name, short deptNo)
        {
            EmpNo = counter++;
            Name = name;
            DeptNo = deptNo;
        }

        public virtual void Insert() => Console.WriteLine("Insert operation executed.");
        public virtual void Update() => Console.WriteLine("Update operation executed.");
        public virtual void Delete() => Console.WriteLine("Delete operation executed.");
    }

    public class Manager : Employee
    {
        private string designation;
        private decimal basic;

        public string Designation
        {
            get => designation;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("Designation cannot be blank.");
                designation = value;
            }
        }

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value < 10000 || value > 100000)
                    throw new ArgumentException("Basic must be between 10000 and 100000 for Manager.");
                basic = value;
            }
        }

        public override decimal CalcNetSalary()
        {
            return Basic + Basic * 0.4M;
        }

        public Manager(string name, short deptNo, string designation, decimal basic)
            : base(name, deptNo)
        {
            Designation = designation;
            Basic = basic;
        }
    }

    public class GeneralManager : Manager
    {
        public string Perks { get; set; }

        public GeneralManager(string name, short deptNo, string designation, decimal basic, string perks)
            : base(name, deptNo, designation, basic)
        {
            Perks = perks;
        }

        public override decimal CalcNetSalary()
        {
            return Basic + Basic * 0.5M;
        }
    }

    public class CEO : Employee
    {
        private decimal basic;

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value < 20000 || value > 200000)
                    throw new ArgumentException("Basic must be between 20000 and 200000 for CEO.");
                basic = value;
            }
        }

        public sealed override decimal CalcNetSalary()
        {
            return Basic + Basic * 0.6M;
        }

        public CEO(string name, short deptNo, decimal basic)
            : base(name, deptNo)
        {
            Basic = basic;
        }
    }

    class Program
    {
        static void Main()
        {
            try
            {
                Manager m = new Manager("Alice", 1, "Project Manager", 50000);
                GeneralManager gm = new GeneralManager("Bob", 2, "GM", 80000, "Car, House");
                CEO ceo = new CEO("Charlie", 3, 150000);

                Console.WriteLine($"Manager: {m.Name}, EmpNo: {m.EmpNo}, Net Salary: {m.CalcNetSalary()}");
                Console.WriteLine($"General Manager: {gm.Name}, EmpNo: {gm.EmpNo}, Net Salary: {gm.CalcNetSalary()}");
                Console.WriteLine($"CEO: {ceo.Name}, EmpNo: {ceo.EmpNo}, Net Salary: {ceo.CalcNetSalary()}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}
