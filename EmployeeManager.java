import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeManager
{
    // List to store employees
    public void addEmployee(Employee employee)
    {
        String sql =
            "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";

        try
        {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());

            statement.executeUpdate();

            System.out.println("Employee added successfully.");

            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //
   public void viewEmployees()
    {
        String sql = "SELECT * FROM employees";

        try
        {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            var resultSet = statement.executeQuery();

            boolean found = false;

            while (resultSet.next())
            {
                found = true;

                System.out.println("Employee ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
                System.out.println("-------------------------");
            }

            if (!found)
            {
                System.out.println("No employees found.");
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Search for an employee by ID
    public void searchEmployee(int id)
    {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try
        {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setInt(1, id);

            var resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                System.out.println("Employee ID Found: "
                    + resultSet.getInt("id"));

                System.out.println("Name: "
                    + resultSet.getString("name"));

                System.out.println("Department: "
                    + resultSet.getString("department"));

                System.out.println("Salary: "
                    + resultSet.getDouble("salary"));
            }
            else
            {
                System.out.println("Employee is not found.");
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Update an employee's details by ID
    public void updateEmployee(
        int id,
        String newName,
        String newDepartment,
        double newSalary
    )
    {
       String sql =
            "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";

        try
        {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setString(1, newName);
            statement.setString(2, newDepartment);
            statement.setDouble(3, newSalary);
            statement.setInt(4, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0)
            {
                System.out.println("Employee Updated successfully.");
            }
            else
            {
                System.out.println("Employee not found.");
            }

            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Delete an employee by ID
    public void deleteEmployee(int id)
    {
        String sql = "DELETE FROM employees WHERE id = ?";

        try
        {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0)
            {
                System.out.println("Employee Deleted successfully.");
            }
            else
            {
                System.out.println("Employee not found.");
            }

            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Check if an employee ID exists in the database
    public boolean isIdExists(int id)
    {
        String sql = "SELECT id FROM employees WHERE id = ?";

        try
        {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                connection.prepareStatement(sql);

            statement.setInt(1, id);

            var resultSet = statement.executeQuery();

            boolean exists = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();

            return exists;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}