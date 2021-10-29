/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author chiranjeevi
 *
 */
public class DataBaseConnection 
{
	public Connection con;
	PreparedStatement psmt;
	Statement st;
	ResultSet rs;
	
		
	public DataBaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy","root","admin");
			System.out.println("Connected");
		}
		catch(Exception e)
		{
			System.out.println("Inside DataBase Class Error:\nError in DataBaseConnection Constructor\n"+e);
		}
	}
	
	public int Insert(String Query) 
	{
		int i=0;
		try
		{
			con=new DataBaseConnection().con;
			st=con.createStatement();
			i=st.executeUpdate(Query);
			st.close();
			con.close();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in Insert Database Class" + ex);
		}
		return i;
	}
	
public int Update(String Query) 
{
	int i=0;
	try
	{
		con=new DataBaseConnection().con;
		st=con.createStatement();
		i=st.executeUpdate(Query);
		st.close();
		con.close();
		
	}
	catch(Exception ex)
	{
		System.out.println("Error in Update Database Class" + ex);
	}
	return i;
}

public int  Delete(String Query) 
{
	int i=0;
	try
	{
		con=new DataBaseConnection().con;
		st=con.createStatement();
		i=st.executeUpdate(Query);
		st.close();
		con.close();
		
	}
	catch(Exception ex)
	{
		System.out.println("Error in Delete Database Class" + ex);
	}
	return i;
}


public ResultSet Select(String Query)
{
try
{
	if(st!=null && con!=null)
	{
		st.close();
		psmt.close();
	}
	con=new DataBaseConnection().con;
	st=con.createStatement();
	rs=st.executeQuery(Query);
}
catch(Exception e)
{
	e.printStackTrace();
}
return rs;
}
}