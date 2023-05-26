package Shopping.Dao;

import java.sql.*;

public class DbConnection {

	// CONNECTED JAVA WITH DATA BASE::
	public static  Connection getconnection()
	{
		String str="oracle.jdbc.OracleDriver";
		String Url="jdbc:oracle:thin:@localhost:1521:XE";
		String Uname="System";
		String password="123456789";

		Connection con=null;
		try {
			// LOADED DRIVER
			Class.forName(str);
			
               // CONNECTION WITH DATABASE
			con=DriverManager.getConnection(Url, Uname, password);
		} 
		    
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
