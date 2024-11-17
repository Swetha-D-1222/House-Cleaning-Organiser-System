package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection 
{
	private static Connection con=null;
    private DBConnection(){
        String mySQL_Url = "jdbc:mysql://localhost:3308/house_cleaning";
        String mySQL_User = "root";
        String mySQL_Password = "As122205.";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mySQL_Url,mySQL_User,mySQL_Password);
        }
        catch (ClassNotFoundException|SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void createConn()
    {
    	new DBConnection();
    }
    public static PreparedStatement getPreparedStatement(String query) throws SQLException
    {
        return con.prepareStatement(query);
    }
//    public static PreparedStatement getPreparedStatement1(String query,int p) throws SQLException
//    {
//        return con.prepareStatement(query,p);
//    }
    public static void closeConn()
    {
        try
        {
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
