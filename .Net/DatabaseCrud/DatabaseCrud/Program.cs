using System;
using System.Collections.Generic;
using System.Data;
using Microsoft.Data.SqlClient;

namespace DatabaseCrud
{
    public class Program
    {
        static string connectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

        static void Main()
        {
            // Create a sample employee
            Employee emp = new Employee { EmpNo = 1, Name = "Anay", Basic = 5000, DeptNo = 10 };

            InsertEmployeeUsingSP(emp);

            //emp.Name = "Updated";
            emp.Basic = 7000;
            //UpdateEmployeeUsingSP(emp);

            var fetched = GetEmployeeById(emp.EmpNo);
            Console.WriteLine($"Fetched: {fetched.EmpNo}, {fetched.Name}, {fetched.Basic}, {fetched.DeptNo}");

            var all = GetAllEmployees();
            Console.WriteLine("\nAll Employees:");
            foreach (var e in all)
                Console.WriteLine($"{e.EmpNo}, {e.Name}, {e.Basic}, {e.DeptNo}");

            //DeleteEmployeeUsingSP(emp.EmpNo);
        }

        static void InsertEmployeeUsingSP(Employee emp)
        {
            using SqlConnection cn = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("InsertEmployee", cn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@EmpNo", emp.EmpNo);
            cmd.Parameters.AddWithValue("@Name", emp.Name);
            cmd.Parameters.AddWithValue("@Basic", emp.Basic);
            cmd.Parameters.AddWithValue("@DeptNo", emp.DeptNo);

            cn.Open();
            cmd.ExecuteNonQuery();
            Console.WriteLine("Inserted successfully.");
        }

        static void UpdateEmployeeUsingSP(Employee emp)
        {
            using SqlConnection cn = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("UpdateEmployee", cn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@EmpNo", emp.EmpNo);
            cmd.Parameters.AddWithValue("@Name", emp.Name);
            cmd.Parameters.AddWithValue("@Basic", emp.Basic);
            cmd.Parameters.AddWithValue("@DeptNo", emp.DeptNo);

            cn.Open();
            cmd.ExecuteNonQuery();
            Console.WriteLine("Updated successfully.");
        }

        static void DeleteEmployeeUsingSP(int empNo)
        {
            using SqlConnection cn = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("DeleteEmployee", cn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@EmpNo", empNo);

            cn.Open();
            cmd.ExecuteNonQuery();
            Console.WriteLine("Deleted successfully.");
        }

        static Employee GetEmployeeById(int empNo)
        {
            Employee emp = null;
            using SqlConnection cn = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("SELECT * FROM Employees WHERE EmpNo = @EmpNo", cn);
            cmd.Parameters.AddWithValue("@EmpNo", empNo);

            cn.Open();
            using SqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                emp = new Employee
                {
                    EmpNo = Convert.ToInt32(reader["EmpNo"]),
                    Name = reader["Name"].ToString(),
                    Basic = Convert.ToDecimal(reader["Basic"]),
                    DeptNo = Convert.ToInt32(reader["DeptNo"])
                };
            }
            return emp;
        }

        static List<Employee> GetAllEmployees()
        {
            List<Employee> employees = new List<Employee>();
            using SqlConnection cn = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("SELECT * FROM Employees", cn);

            cn.Open();
            using SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                employees.Add(new Employee
                {
                    EmpNo = Convert.ToInt32(reader["EmpNo"]),
                    Name = reader["Name"].ToString(),
                    Basic = Convert.ToDecimal(reader["Basic"]),
                    DeptNo = Convert.ToInt32(reader["DeptNo"])
                });
            }
            return employees;
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}