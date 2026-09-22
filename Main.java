import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int choice;

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        do
        {
            System.out.println("===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:

                    int n;

                    do
                    {
                        System.out.println("How Many Employees: ");
                        n = sc.nextInt();

                        if(n <= 0)
                        {
                            System.out.println(
                                "Please enter a number greater than 0."
                            );
                        }

                    } while(n <= 0);

                    for(int i = 1; i <= n; i++)
                    {
                        int id;
                        boolean idExists;

                        do
                        {
                            System.out.println("Enter ID: ");
                            id = sc.nextInt();

                            if(id <= 0)
                            {
                                System.out.println(
                                    "ID must be greater than 0. "
                                    + "Please enter a valid ID."
                                );

                                idExists = false;
                            }
                            else
                            {
                                idExists = manager.isIdExists(id);

                                if(idExists)
                                {
                                    System.out.println(
                                        "ID already exists. "
                                        + "Please enter a unique ID."
                                    );
                                }
                            }

                        } while(id <= 0 || idExists);

                        sc.nextLine(); // Consume newline

                        String name;

                        do
                        {
                            System.out.println("Enter Name: ");
                            name = sc.nextLine();

                            if(name.isBlank())
                            {
                                System.out.println(
                                    "Name cannot be Empty."
                                );
                            }

                        } while(name.isBlank());

                        String department;

                        do
                        {
                            System.out.println("Enter Department: ");
                            department = sc.nextLine();

                            if(department.isBlank())
                            {
                                System.out.println(
                                    "Department cannot be Empty."
                                );
                            }

                        } while(department.isBlank());

                        double salary;

                        do
                        {
                            System.out.println("Enter Salary: ");
                            salary = sc.nextDouble();

                            if(salary <= 0)
                            {
                                System.out.println(
                                    "Salary must be greater than 0."
                                );
                            }

                        } while(salary <= 0);

                        Employee employee =
                            new Employee(
                                id,
                                name,
                                department,
                                salary
                            );

                        manager.addEmployee(employee);
                    }

                    break;

                case 2:

                    manager.viewEmployees();

                    break;

                case 3:

                    System.out.println("Enter ID to Search: ");

                    int searchedId = sc.nextInt();

                    manager.searchEmployee(searchedId);

                    break;

                case 4:

                    System.out.println("Enter ID to Update: ");

                    int updateId = sc.nextInt();

                    if(!manager.isIdExists(updateId))
                    {
                        System.out.println(
                            "Employee with ID "
                            + updateId
                            + " not found."
                        );

                        break;
                    }

                    sc.nextLine();

                    String newName;

                    do
                    {
                        System.out.println("Enter New Name: ");

                        newName = sc.nextLine();

                        if(newName.isBlank())
                        {
                            System.out.println(
                                "Name cannot be Empty."
                            );
                        }

                    } while(newName.isBlank());

                    String newDepartment;

                    do
                    {
                        System.out.println(
                            "Enter New Department: "
                        );

                        newDepartment = sc.nextLine();

                        if(newDepartment.isBlank())
                        {
                            System.out.println(
                                "Department cannot be Empty."
                            );
                        }

                    } while(newDepartment.isBlank());

                    double newSalary;

                    do
                    {
                        System.out.println("Enter New Salary: ");

                        newSalary = sc.nextDouble();

                        if(newSalary <= 0)
                        {
                            System.out.println(
                                "Salary must be greater than 0."
                            );
                        }

                    } while(newSalary <= 0);

                    manager.updateEmployee(
                        updateId,
                        newName,
                        newDepartment,
                        newSalary
                    );

                    break;

                case 5:

                    System.out.println("Enter ID to Delete: ");

                    int deleteId = sc.nextInt();

                    manager.deleteEmployee(deleteId);

                    break;

                case 6:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println(
                        "Invalid choice.."
                        + "Please Enter choice from 1 to 6"
                    );
            }

        } while(choice != 6);

        sc.close();
    }
}