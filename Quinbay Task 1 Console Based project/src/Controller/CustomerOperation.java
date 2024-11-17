package Controller;

import static Model.DBConnection.getPreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Appointment;
import Model.Customer;

public class CustomerOperation 
{
	public static Customer customer_login(String email, String password) {
		// TODO Auto-generated method stub
		String query="select * from customer where customer_email=? and customer_password=?";
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1,email);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b) {
				return new Customer(rs.getInt("customer_id"),
						rs.getString("customer_Name"),
						rs.getString("customer_email"),
						rs.getString("customer_Password"),
						rs.getLong("customer_PhNo"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Customer customerRegistration(Customer customer) 
	{
		String query="insert into customer (customer_name,customer_email,customer_password,customer_phno) values(?,?,?,?)";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
//			System.out.println("Staff Name: " + staff.getStaff_name());
			stmt.setString(1,customer.getCustomer_name());
			stmt.setString(2,customer.getCustomer_email());
			stmt.setString(3,customer.getCustomer_password());
			stmt.setLong(4,customer.getCustomer_phoneNo());
			stmt.execute();
			return customer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Appointment bookAppointment(Appointment appointment) 
	{
		String query="insert into appointment (appointment_address,appointment_status,customer_id,staff_id) values(?,?,?,?)";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
//			System.out.println("Staff Name: " + staff.getStaff_name());
			stmt.setString(1,appointment.getAddress());
			stmt.setString(2,appointment.getWork_status());
			stmt.setInt(3,appointment.getCustomer_id());
			stmt.setInt(4,appointment.getStaff_id());
			stmt.execute();
			return appointment;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static int cancelAppointment(int app_id) 
	{
		String q="select staff_id from appointment where appointment_id=?";
		String query="update appointment set appointment_status='cancelled' where appointment_id=?";
		int staff_id=0;
		try
		{
			PreparedStatement st=getPreparedStatement(q);
			st.setInt(1, app_id);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				staff_id=rs.getInt("staff_id");
			}
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, app_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		return 0;
		return staff_id;
		
	}

}
