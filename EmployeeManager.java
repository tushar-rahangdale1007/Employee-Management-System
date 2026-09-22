import java.util.ArrayList;

public class EmployeeManager
{
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public void viewEmployees()
    {
        if (employees.isEmpty())
        {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees)
        {
            employee.displayEmployee();
        }
    }

    public void searchEmployee(int id)
    {
        boolean found = false;

        for (Employee employee : employees)
        {
            if (employee.getId() == id)
            {
                found = true;

                System.out.println(
                    "Employee ID Found: "
                    + employee.getId() + " "
                    + employee.getName() + " "
                    + employee.getDepartment() + " "
                    + employee.getSalary()
                );

                break;
            }
        }

        if (!found)
        {
            System.out.println("Employee is not found.");
        }
    }

    public void updateEmployee(
        int id,
        String newName,
        String newDepartment,
        double newSalary
    )
    {
        boolean found = false;

        for (Employee employee : employees)
        {
            if (employee.getId() == id)
            {
                found = true;

                employee.setName(newName);
                employee.setDepartment(newDepartment);
                employee.setSalary(newSalary);

                System.out.println("Employee Updated successfully.");

                break;
            }
        }

        if (!found)
        {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(int id)
    {
        Employee employeeToDelete = null;

        for (Employee employee : employees)
        {
            if (employee.getId() == id)
            {
                employeeToDelete = employee;
                break;
            }
        }

        if (employeeToDelete != null)
        {
            employees.remove(employeeToDelete);
            System.out.println("Employee Deleted successfully.");
        }
        else
        {
            System.out.println("Employee not found.");
        }
    }

    public boolean isIdExists(int id)
    {
        for (Employee employee : employees)
        {
            if (employee.getId() == id)
            {
                return true;
            }
        }

        return false;
    }
}