package Controller;

import static Model.DBConnection.getPreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Admin;
import Model.Appointment;
import Model.Customer;
import Model.DailyRoutine;
import Model.Payment;
import Model.Staff;

public class AdminOperation 
{
	public static Admin adminLogin(String email,String pass){
		String query="select * from admin where admin_email=? and admin_password=?";
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1,email);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b) {
				return new Admin(rs.getInt("Admin_Id"),
						rs.getString("Admin_Name"),
						rs.getString("Admin_Email"),
						rs.getString("Admin_Password"),
						rs.getLong("Admin_PhNo"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Staff registerStaff(Staff staff) 
	{
		String query="insert into staff (staff_name,staff_gender,staff_email,staff_password,staff_phno) values(?,?,?,?,?)";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
//			System.out.println("Staff Name: " + staff.getStaff_name());
			stmt.setString(1,staff.getStaff_name());
			stmt.setString(2,staff.getStaff_gender());
			stmt.setString(3,staff.getStaff_email());
			stmt.setString(4,staff.getStaff_password());
			stmt.setLong(5,staff.getStaff_phno());
			stmt.execute();
			registerStaffProof(staff);
			return staff;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

//	public static Object registerStaff1(Staff staff) 
//	{
//		String query="insert into staffProof (staff_aadhaar,staff_pan) values(?,?)";
//		try
//		{
//			PreparedStatement stmt=getPreparedStatement(query);
//			stmt.setLong(1,staffAadhaar);
//			stmt.setString(2,staffPan);
//			int rows=stmt.executeUpdate(query);
//			if(rows==1)
//			{
//				System.out.println("Staff Proof attached successfully");
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//	}

	public static ArrayList<Customer> viewAllCustomer() 
	{
		String query="select * from customer";
		ArrayList<Customer> cust=new ArrayList<Customer>();
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b) {
				cust.add( new Customer(rs.getInt("customer_Id"),
						rs.getString("customer_Name"),
						rs.getString("customer_Email"),
						rs.getString("customer_Password"),
						rs.getLong("customer_PhNo")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

	

	public static void registerStaffProof(Staff staff)
	{
		String q="select * from staff";
		String query="insert into staffProof (staff_id,staff_aadhaar,staff_pan) values(?,?,?)";
		try
		{
			PreparedStatement st=getPreparedStatement(q);
			ResultSet rs=st.executeQuery();
			int staff_id=0;
			while(rs.next())
			{
				staff_id=rs.getInt("staff_id");
			}
//			System.out.println(staff_id);
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, staff_id);
			stmt.setLong(2, staff.getStaff_Aadhaar());
	        stmt.setString(3, staff.getStaff_pan());
			int rows=stmt.executeUpdate();
			if(rows==1)
			{
				System.out.println("Staff Proof attached successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Staff> checkStaff(String gender) 
	{
		String query="select * from staff where staff_gender=? and removed_staff!='yes'";
		ArrayList<Staff> sta=new ArrayList<Staff>();
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1,gender);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				if(checkStaffAvailable(rs.getInt("staff_id")))
				{
					sta.add( new Staff(rs.getInt("staff_id"),
							rs.getString("staff_name"),
							rs.getLong("staff_phno")));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sta;
	}

	private static boolean checkStaffAvailable(int staff_id) 
	{
		String query="select active_status from staffStatus where staff_id=? order by staff_id limit 1";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1,staff_id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("active_status").equalsIgnoreCase("yes"))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static void setStatus(int staff_id, String string) 
	{
		String query="insert into staffStatus values(?,?)";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1,staff_id);
			stmt.setString(2, string);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void changeStatus(int staff_id) 
	{
		String query="update staffstatus set active_status='no' where staff_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, staff_id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static ArrayList<Staff> ViewAllStaff(Staff staff) 
	{
		String query="select * from staff";
		ArrayList<Staff> sta=new ArrayList<Staff>();
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				
				sta.add(new Staff(rs.getInt("staff_Id"),
						rs.getString("staff_Name"),
						rs.getString("staff_gender"),
						rs.getString("staff_Email"),
						rs.getString("staff_Password"),
						rs.getLong("staff_PhNo")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sta;
	}
	public static ArrayList<Appointment> viewAllAppointments(Appointment appointment) 
	{
		String query="select * from appointment";
		ArrayList<Appointment> appo=new ArrayList<Appointment>();
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				appo.add(new Appointment(rs.getInt("appointment_id"),
						rs.getString("appointment_address"),
						rs.getString("appointment_status"),
						rs.getInt("customer_id"),
						rs.getInt("staff_id")));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return appo;
	}

	public static void addRoutine(int appointment_id, int staff_id, String status) 
	{
		String query="insert into dailyroutine(appointment_id,staff_id,date_of_work,work_status) values(?,?,CURRENT_DATE,?)";
		try(PreparedStatement stmt=getPreparedStatement(query))
		{
			stmt.setInt(1, appointment_id);
			stmt.setInt(2, staff_id);
			stmt.setString(3, status);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void updateStaffAndDailyRoutine(int s_id, int app_id) 
	{
		String q1="update staffstatus set active_status='yes' where staff_id=?";
		String q2="update dailyroutine set work_status='cancelled' where appointment_id=?";
		try
		{
			PreparedStatement stmt1=getPreparedStatement(q1);
			PreparedStatement stmt2=getPreparedStatement(q2);
			stmt1.setInt(1, s_id);
			stmt2.setInt(1, app_id);
			stmt1.execute();
			stmt2.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void changeStaffStatus(int staff_id1, String string) 
	{
		
		String query="update staffstatus set active_status=? where staff_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1, string);
			stmt.setInt(2, staff_id1);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Payment> viewAllPayments() 
	{
		String query="select * from payment";
		ArrayList<Payment> pay=new ArrayList<Payment>();
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				pay.add(new Payment(rs.getInt("payment_id"),
						rs.getInt("appointment_id"),
						rs.getString("payment_mode"),
						rs.getFloat("payment_amount"),
						rs.getDate("payment_date")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pay;
	}

	public static ArrayList<DailyRoutine> getDailyRoutine() 
	{
		String query="select * from dailyroutine";
		ArrayList<DailyRoutine> routine=new ArrayList<DailyRoutine>();
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				routine.add(new DailyRoutine(rs.getInt("appointment_id"),
						rs.getInt("staff_id"),
						rs.getDate("date_of_work"),
						rs.getTime("Time_in"),
						rs.getTime("time_out"),
						rs.getString("work_status")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return routine;
	}

	public static void removeStaff(int staffId) 
	{
		String query="update staff set removed_staff='yes' where staff_id=?";
		try
		{
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setInt(1, staffId);
			int row=stmt.executeUpdate();
			if(row==1)
			{
				System.out.println("Staff removed Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
