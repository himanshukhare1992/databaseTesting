package databaseConnecting;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseConnectionWithSQLServer 
{
	
	@Test(enabled=false)
	public void TestDB() throws Exception
	{
		// load the driver into JVM. It requires fully qualified path & require sqljdbc jar file
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
		System.out.println("===Driver loaded===");
		
		// to get Connection with the database
		//syntax: 	jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]

		//Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=Selenium", "sa", "1432");
		
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=Selenium; user=sa; password=1432;");
		
		
		System.out.println("==== Connection Established: Database Connected Successfully !==== "+con);
		 
		Statement st = con.createStatement();
		
		ResultSet rs = 	st.executeQuery("select * from selenium");
		
		while(rs.next())
		{
			System.out.println("==="+rs.getString(1)+"==="+rs.getString("fname")+"==="+rs.getString(3)+"===");
		}
			
	}
	
	
	
	@Test
	public void SQLServerDBConnection() throws Exception
	{
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL= "jdbc:sqlserver://localhost;";
		String databaseName="Selenium;";
		String username="sa;";
		String password="1432;";
		
		//load the sqlserver driver
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(connectionURL+"databaseName="+databaseName+"user="+username+"password="+password);
		
		
		Statement st = con.createStatement();
		
		ResultSet rs =	st.executeQuery("Select * from Selenium");
		
		while (rs.next())
		{
			System.out.println("==First Name=="+rs.getString("fname"));
		}
	
	}
	

}
