package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
		return connection;
		
		
	}
	public int signUp(Employee emp) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1,emp.getId());
		preparedStatement.setString(2,emp.getName());
	
		preparedStatement.setLong(3, emp.getPhone());
		preparedStatement.setString(4, emp.getAddress());
		preparedStatement.setString(5, emp.getEmail());
		preparedStatement.setString(6, emp.getPassword());
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		return count;
	}
	public String getEmployee(String email) throws Exception 
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where email=?");
		preparedStatement.setString(1, email);
	    ResultSet resultSet=preparedStatement.executeQuery();
	    String password=null;
	    while(resultSet.next())
	    {
	    	password=resultSet.getString("password");
	    }
		connection.close();
		return password;
		
		
	}
	public List<Employee> getAllEmployee() throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee");
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Employee> list=new ArrayList<>();
		while(resultSet.next())
		{
			Employee employee=new Employee();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setAddress(resultSet.getString("address"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPassword(resultSet.getString("password"));
			list.add(employee);
		}
		connection.close();
		
		return list;
	}
	public int deleteEmployee(int id) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=?");
	    preparedStatement.setInt(1, id);
	    int result=preparedStatement.executeUpdate();
	    connection.close();
	    return result;
	    
	}
	public Employee getEmployee(int id) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where id=?");
		preparedStatement.setInt(1, id);
	    ResultSet resultSet=preparedStatement.executeQuery();
	    Employee employee=new Employee();
	    
	    while(resultSet.next())
	    {
	    	employee.setId(resultSet.getInt("id"));
	    	employee.setName(resultSet.getString("name"));
	    	employee.setPhone(resultSet.getLong("phone"));
	    	employee.setAddress(resultSet.getString("address"));
	    	employee.setEmail(resultSet.getString("email"));
	    	employee.setPassword(resultSet.getString("password"));
	    	
	    }
		connection.close();
		return employee;
	}
	public int updateEmployee(Employee employee) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set name=?,phone=?,address=?,email=?,password=? where id=?");

		preparedStatement.setString(1,employee.getName());
	
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6,employee.getId());
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		return count;
	}
		

}
