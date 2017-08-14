package DAOImplementation;

import java.util.ArrayList;

import DAO.PersonDAO;
import Model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO_MYSQL implements PersonDAO
{
    Connection conn = null;
    Statement statement = null;
    ResultSet res = null;
    
    public ArrayList<Person> pp=new ArrayList<Person>();

    private void startwork()// throws ClassNotFoundException,SQLException
    {
    	try
    	{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/persons","root","");
            statement=conn.createStatement();
    	}
    	catch(ClassNotFoundException|SQLException e)
    	{
    		e.printStackTrace();
    	}
    }

	@Override
	public void create(Person p)
	{
    	try
    	{
    		startwork();
    		statement.executeUpdate("insert into person(id,fname,lname,age)values("+p.id+",'"+p.fname+"','"+p.lname+"',"+p.age+")");
    		finishwork();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> result=new ArrayList<Person>();
		Person personbuffer=null;
    	try
    	{
    		startwork();
			res=conn.prepareStatement("select * from person").executeQuery();

			while(res.next())
			{
				personbuffer=new Person(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
				result.add(personbuffer);
			}
			finishwork();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		return result;
	}

	@Override
	public void update(Person p)
	{
		try
		{
			startwork();
			statement.executeUpdate("update person set fname='"+p.fname+"',lname='"+p.lname+"',age="+p.age+" where id="+p.id);
			finishwork();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p)
	{
		try
		{
			startwork();
			statement.executeUpdate("delete from person where id="+p.id);
			finishwork();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	private void finishwork()
	{
		try{
		  if (statement != null) statement.close();
		  if (conn != null) conn.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}


}
