package Controller;

import static Model.DBConnection.getPreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Staff;

public class StaffOperation 
{

	public static Staff staffLogin(String email, String password) 
	{
		String query="select * from staff where staff_email=? and staff_password=?";
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1,email);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b) {
				return new Staff(rs.getInt("Staff_Id"),
						rs.getString("Staff_Name"),
						rs.getString("Staff_gender"),
						rs.getString("Staff_Email"),
						rs.getString("Staff_Password"),
						rs.getLong("Staff_PhNo"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int fetchStaff_id(int appointment_id) {
		// TODO Auto-generated method stub
		String query="select staff_id from appointment where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1,appointment_id);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b)
			{
				return rs.getInt("staff_id");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public static void confirmAppointment(int app_id, String confirm) 
	{
		String query="update appointment set appointment_status=? where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1, confirm);
			stmt.setInt(2, app_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void addPayment(int appointment_id, String mode, float totalAmount) {
		// TODO Auto-generated method stub
		String query="insert into payment (appointment_id,payment_mode,payment_amount,payment_date) values(?,?,?,CURRENT_DATE)";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, appointment_id);
			stmt.setString(2,mode);
			stmt.setFloat(3, totalAmount);
//			stmt.setDate(4, GETDATE());
			stmt.execute();
//			while(rs.next())
//			{
//				return new Payment(rs.getInt("payment_id"),
//						rs.getInt("appointment_id"),
//						rs.getString("payment_mode"),
//						rs.getFloat("payment_amount"),
//						rs.getDate("payment_date"));
//			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//return null;
	}

	public static void enterTimeIn(int appointment_id)
	{
		String query="update dailyroutine set time_in=CURRENT_TIME where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, appointment_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void completeAppointment(int app_id, String complete) 
	{
		String query="update appointment set appointment_status=? where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1, complete);
			stmt.setInt(2, app_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void enterTimeOut(int app_id) 
	{
		String query="update dailyroutine set time_out=CURRENT_TIME where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, app_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void changeWorkStatus(int appointment_id) 
	{
		String query="update dailyroutine set work_status='completed' where appointment_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, appointment_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
