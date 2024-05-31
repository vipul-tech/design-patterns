package j2ee.design.pattern;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;

class DataSource
{
	Connection connection = null;
	BasicDataSource bdSource   = new BasicDataSource();

	public DataSource()
	{
		bdSource.setDriverClassName("com.mysql.jdbc.Driver");
		bdSource.setUrl("jdbc:mysql://localhost:3306/RamJ2EE");
		bdSource.setUsername("root");
		bdSource.setPassword("root");
	}

	public Connection createConnection()
	{
		Connection con = null;
		try
		{
			if( connection != null )
			{
				System.out.println("Cant create a New Connection");
			}
			else
			{
				con = bdSource.getConnection();
			}
		}
		catch( Exception e )
		{
			System.out.println("Error Occured " + e.toString());
		}
		return con;
	}
}

class Employee
{
	private int    employeeId;
	private String name;
	private int    age;

	public int getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId( int employeeId )
	{
		this.employeeId = employeeId;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge( int age )
	{
		this.age = age;
	}

}

interface EmployeeDao
{
	public List<Employee> getAllEmployees();

	public void addEmployee( Employee employee );

	public Employee getEmployee( int employeeId );

	public void updateEmployee( Employee employee );

	public void deleteEmployee( int employeeId );
}

class EmployeeDaoImpl implements EmployeeDao
{
	@Override
	public List<Employee> getAllEmployees()
	{
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try
		{
			String query = "SELECT * FROM employee";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while( rs.next() )
			{
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("Employee_Id"));
				employee.setName(rs.getString("Name"));
				employee.setAge(rs.getInt("age"));
				employeeList.add(employee);
			}
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				if( con != null )
				{
					con.close();
				}
				if( stmt != null )
				{
					stmt.close();
				}
				if( rs != null )
				{
					rs.close();
				}
			}
			catch( Exception exe )
			{
				exe.printStackTrace();
			}

		}
		return employeeList;
	}

	@Override
	public void addEmployee( Employee employee )
	{
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "insert into employee values(" + employee.getEmployeeId() + "," + "'" + employee.getName()
		+ "'" + "," + employee.getAge() + ")";

		try
		{
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is inserted into Employee table for Employee : " + employee.getName());

		}
		catch( SQLException e )
		{

			e.printStackTrace();

		}
		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public Employee getEmployee( int employeeId )
	{
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			String query = "SELECT * FROM employee where employee_id="+employeeId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while( rs.next() )
			{
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("Employee_Id"));
				employee.setName(rs.getString("Name"));
				employee.setAge(rs.getInt("age"));
				return employee;
			}
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				if( con != null )
				{
					con.close();
				}
				if( stmt != null )
				{
					stmt.close();
				}
				if( rs != null )
				{
					rs.close();
				}
			}
			catch( Exception exe )
			{
				exe.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public void updateEmployee( Employee employee )
	{
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "update employee set name=" + "'" + employee.getName() + "'" + "where employee_id="
				+ employee.getEmployeeId();

		try
		{
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is updated into Employee table for Employee id : "
					+ employee.getEmployeeId());

		}
		catch( SQLException e )
		{

			e.printStackTrace();

		}
		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void deleteEmployee( int  employeeId )
	{
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "delete from employee where employee_Id="+ employeeId;

		try
		{
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is deleted from Employee table for Employee id : "
					+ employeeId);

		}
		catch( SQLException e )
		{

			e.printStackTrace();

		}
		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}
	}

}

public class DAOPattern {

	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		// Add new Employees

		Employee employeeDavid = new Employee();
		employeeDavid.setEmployeeId(1);
		employeeDavid.setName("David");
		employeeDavid.setAge(23);

		employeeDao.addEmployee(employeeDavid);

		Employee employeeJohn= new Employee();
		employeeJohn.setEmployeeId(2);
		employeeJohn.setName("John");
		employeeJohn.setAge(34);

		employeeDao.addEmployee(employeeJohn);

		System.out.println();
		System.out.println("-------------------------Print all the Employees-------------------------------- Start");

		// print all Employees
		for( Employee employee : employeeDao.getAllEmployees() )
		{
			System.out.println("employee: [Employee Id : " + employee.getEmployeeId() + ", Name : "
					+ employee.getName() + ",age :" + employee.getAge()+" ]");
		}

		System.out.println("-------------------------Print all the Employees-------------------------------- End");
		System.out.println();

		System.out.println("-------------------------Get one Employee based in employee Id =1 ----------- Start");

		Employee employee= employeeDao.getEmployee(1);
		System.out.println("employee: [Employee Id : " + employee.getEmployeeId() + ", Name : "
				+ employee.getName() + ",age :" + employee.getAge()+" ]");


		System.out.println("-------------------------Get one Employee based in employee Id =1 ----------- End");
		System.out.println();


		System.out.println("-------------------------update the employee whose employee Id =1 ----------- Start");

		Employee employeeRohan= new Employee();
		employeeRohan.setEmployeeId(1);
		employeeRohan.setName("Rohan");

		employeeDao.updateEmployee(employeeRohan);

		System.out.println("-------------------------update the employee whose employee Id =1 ----------- End");
		System.out.println();

		System.out.println("-------------------------Delete the employee whose employee Id =2 ----------- Start");

		employeeDao.deleteEmployee(2);

		System.out.println("-------------------------Delte the employee whose employee Id =2 ----------- End");	
	}

}
