#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    double empSalary;
public:
    Employee(int id, string name, double salary) {
        empID = id;
        empName = name;
        empSalary = salary;
    }
    int getEmpID() const { return empID; }
    string getEmpName() const { return empName; }
    double getEmpSalary() const { return empSalary; }
    void setEmpName(const string& name) { empName = name; }
    void setEmpSalary(double salary) { empSalary = salary; }
    double calculateGrossSalary() const {
        double bonus = 0.0;
        if (empSalary <= 5000) bonus = 0.10 * empSalary;
        else if (empSalary <= 10000) bonus = 0.15 * empSalary;
        else bonus = 0.20 * empSalary;
        return empSalary + bonus;
    }
    void displayEmployeeDetails() const {
        cout << "\n--- Employee Details ---\n";
        cout << "ID: " << empID << endl;
        cout << "Name: " << empName << endl;
        cout << "Salary: " << empSalary << endl;
        cout << "Gross Salary: " << calculateGrossSalary() << endl;
    }
};

bool isUniqueID(const vector<Employee>& employees, int id) {
    for (const auto& emp : employees) {
        if (emp.getEmpID() == id) return false;
    }
    return true;
}

int main() {
    vector<Employee> employees;
    int choice;
    do {
        cout << "\n===== Employee Payroll Menu =====\n";
        cout << "1. Add New Employee\n";
        cout << "2. Calculate Gross Salary\n";
        cout << "3. Display Employee Details\n";
        cout << "4. Update Employee Information\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                int id;
                string name;
                double salary;
                cout << "Enter Employee ID: ";
                cin >> id;
                if (!isUniqueID(employees, id)) {
                    cout << "Employee ID must be unique!\n";
                    break;
                }
                cin.ignore();
                cout << "Enter Employee Name: ";
                getline(cin, name);
                cout << "Enter Employee Salary: ";
                cin >> salary;
                employees.emplace_back(id, name, salary);
                cout << "Employee added successfully!\n";
                break;
            }
            case 2: {
                int id;
                cout << "Enter Employee ID to calculate gross salary: ";
                cin >> id;
                bool found = false;
                for (const auto& emp : employees) {
                    if (emp.getEmpID() == id) {
                        cout << "Gross Salary: " << emp.calculateGrossSalary() << endl;
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "Employee not found!\n";
                break;
            }
            case 3: {
                int id;
                cout << "Enter Employee ID to display details: ";
                cin >> id;
                bool found = false;
                for (const auto& emp : employees) {
                    if (emp.getEmpID() == id) {
                        emp.displayEmployeeDetails();
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "Employee not found!\n";
                break;
            }
            case 4: {
                int id;
                cout << "Enter Employee ID to update: ";
                cin >> id;
                bool found = false;
                for (auto& emp : employees) {
                    if (emp.getEmpID() == id) {
                        string name;
                        double salary;
                        cin.ignore();
                        cout << "Enter new name: ";
                        getline(cin, name);
                        cout << "Enter new salary: ";
                        cin >> salary;
                        emp.setEmpName(name);
                        emp.setEmpSalary(salary);
                        cout << "Employee information updated!\n";
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "Employee not found!\n";
                break;
            }
            case 5:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 5);
    return 0;
}
