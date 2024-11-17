package Model;

import java.util.ArrayList;

import Controller.AdminOperation;
import Controller.StaffOperation;

public class Staff extends User 
{
	int staff_id;
	String staff_name;
	String staff_gender;
	String staff_email;
	String staff_password;
	long staff_phno;
	long staff_Aadhaar;
	String staff_pan;
	
	public int getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}


	public String getStaff_name() {
		return staff_name;
	}


	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}


	public String getStaff_gender() {
		return staff_gender;
	}


	public void setStaff_gender(String staff_gender) {
		this.staff_gender = staff_gender;
	}


	public String getStaff_email() {
		return staff_email;
	}


	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}


	public String getStaff_password() {
		return staff_password;
	}


	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}


	public long getStaff_phno() {
		return staff_phno;
	}


	public void setStaff_phno(long staff_phno) {
		this.staff_phno = staff_phno;
	}

	public Staff()
	{
		this.staff_id =0;
		this.staff_name =null;
		this.staff_gender = null;
		this.staff_email = null;
		this.staff_password =null;
		this.staff_phno = 0;
	}
	public long getStaff_Aadhaar() {
		return staff_Aadhaar;
	}


	public void setStaff_Aadhaar(long staff_Aadhaar) {
		this.staff_Aadhaar = staff_Aadhaar;
	}


	public String getStaff_pan() {
		return staff_pan;
	}


	public void setStaff_pan(String staff_pan) {
		this.staff_pan = staff_pan;
	}


	public Staff(int staff_id, String staff_name, String staff_gender, String staff_email, String staff_password,
			long staff_phno) {
//		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_gender = staff_gender;
		this.staff_email = staff_email;
		this.staff_password = staff_password;
		this.staff_phno = staff_phno;
	}


	public Staff(int staff_id,String staff_name, long staff_phno) 
	{
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_phno = staff_phno;
	}


	public static void staffLogin(String user_email, String user_password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Staff Login(String user_email, String user_password) {
		// TODO Auto-generated method stub
		return StaffOperation.staffLogin(user_email,user_password);
	}

	public static ArrayList<Staff> viewAllStaff(Staff staff) {
		// TODO Auto-generated method stub
		return AdminOperation.ViewAllStaff(staff);
	}


	public int fetchStaff_id(int appointment_id) {
		// TODO Auto-generated method stub
		return Appointment.fetchStaff_id(appointment_id);
	}


	public void addPayment(int appointment_id, String string, float totalAmount) {
		// TODO Auto-generated method stub
		Payment.addPayment(appointment_id, string, totalAmount);
		
	}


	public static Staff registerStaff(Staff staff) {
		// TODO Auto-generated method stub
		return AdminOperation.registerStaff(staff);
	}


	public void enterTimeIn(int appointment_id) 
	{
		
		DailyRoutine.enterTimeIn(appointment_id);
		
	}


	public void confirmAppointment(int app_id, String confirm)
	{
		Appointment.confirmAppointment(app_id,confirm);
		
	}


	public void completeAppointment(int app_id, String complete) 
	{
		Appointment.completeAppointment(app_id,complete);
		
	}


	public void enterTimeOut(int app_id) 
	{
		DailyRoutine.enterTimeOut(app_id);
		
	}


	public void changeWorkStatus(int appointment_id) 
	{
		DailyRoutine.changeWorkStatus(appointment_id);
		
	}


//	public static ArrayList<Staff> viewAllStaff(Staff staff) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
