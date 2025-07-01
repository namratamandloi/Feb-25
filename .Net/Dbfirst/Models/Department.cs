using System;
using System.Collections.Generic;

namespace Dbfirst.Models;

public partial class Department
{
    public int DeptNo { get; set; }

    public string? DeptName { get; set; }

    public virtual ICollection<Employee> Employees { get; set; } = new List<Employee>();
}
