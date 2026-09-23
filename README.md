> Employee Management System

A console-based Employee Management System developed using Java, JDBC, and MySQL.

> Features

* Add employees
* View all employees
* Search employee by ID
* Update employee details
* Delete employee by ID
* Prevent duplicate employee IDs
* Validate employee name and department
* Validate employee salary
* Handle invalid employee IDs
* Store employee data permanently in MySQL database

> Technologies Used

* Java
* JDBC
* MySQL
* MySQL Connector/J
* Scanner
* Git
* GitHub

> Database

The project uses a MySQL database named `employee_db`.

> Table

```sql
employees
```

Columns:

* `id` - Employee ID
* `name` - Employee name
* `department` - Employee department
* `salary` - Employee salary

> Project Structure

```text
Employee-Management-System
│
├── Employee.java
├── EmployeeManager.java
├── Main.java
├── DBConnection.java
├── .gitignore
└── README.md
```

> CRUD Operations

| Operation       | SQL          |
| --------------- | ------------ |
| Add Employee    | INSERT       |
| View Employees  | SELECT       |
| Search Employee | SELECT WHERE |
| Update Employee | UPDATE       |
| Delete Employee | DELETE       |

> How It Works

The application follows this flow:

```text
Main
  ↓
EmployeeManager
  ↓
DBConnection
  ↓
JDBC
  ↓
MySQL Database
```

`DBConnection` manages the database connection, while `EmployeeManager` performs CRUD operations using JDBC and `PreparedStatement`.

> Security

Database credentials are not stored directly in the Java source code. The database password is read from the `DB_PASSWORD` environment variable.

> How to Run

Compile the project:

```powershell
javac -cp ".;lib\mysql-connector-j-26.7.0.jar" *.java
```

Run the application:

```powershell
java -cp ".;lib\mysql-connector-j-26.7.0.jar" Main
```
