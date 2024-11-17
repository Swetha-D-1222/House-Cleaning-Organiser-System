package Model;

import java.util.ArrayList;

import Controller.AdminOperation;

public class Admin extends User
{
	int admin_Id=0;
	static String admin_Name="";
	long admin_PhoneNo=0;
	static String admin_Email="";
	static String admin_Password="";
	public Admin()
	{
		this.admin_Id=0;
		this.admin_Name=null;
		this.admin_PhoneNo=0;
		this.admin_Email=null;
		this.admin_Password=null;
	}
	public Admin(int admin_Id, String admin_Name, String admin_Email,String admin_Password, long admin_PhoneNo)
	{
//		super(admin_Name,admin_Email,admin_Password);
		this.admin_Id=admin_Id;
		this.admin_Name=admin_Name;
		this.admin_PhoneNo=admin_PhoneNo;
		this.admin_Email=admin_Email;
		this.admin_Password=admin_Password;
	}
	
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public static String getAdmin_Name() {
		return admin_Name;
	}
	public static void setAdmin_Name(String admin_Name) {
		Admin.admin_Name = admin_Name;
	}
	public long getAdmin_PhoneNo() {
		return admin_PhoneNo;
	}
	public void setAdmin_PhoneNo(long admin_PhoneNo) {
		this.admin_PhoneNo = admin_PhoneNo;
	}
	public static String getAdmin_Email() {
		return admin_Email;
	}
	public static void setAdmin_Email(String admin_Email) {
		Admin.admin_Email = admin_Email;
	}
	public static String getAdmin_Password() {
		return admin_Password;
	}
	public static void setAdmin_Password(String admin_Password) {
		Admin.admin_Password = admin_Password;
	}
	public Admin Login(String mail, String pass) 
	{
		return AdminOperation.adminLogin(mail,pass);
	}
	public void removeStaff(int staffId) 
	{
		AdminOperation.removeStaff(staffId);
	}
	
	public ArrayList<Staff> viewStaffMembers(Staff staff)
	{
		
		return Staff.viewAllStaff(staff);
		
	}
	
	public ArrayList<Customer> viewCustomer() 
	{
		
		return Customer.viewAllCustomer();
		
	}
	
	public Staff registerStaff(Staff staff) 
	{
		
		return Staff.registerStaff(staff);
		
	}
	
	public ArrayList<Staff> checkStaff(String gender)
	{	
		
		return AdminOperation.checkStaff(gender);
		
	}
	
	public void setStatus(int staff_id, String string) 
	{
		
		AdminOperation.setStatus(staff_id,string);
			
	}
	public void changeStatus(int staff_id) 
	{
		
		AdminOperation.changeStatus(staff_id);
		
	}
	public ArrayList<Appointment> viewAllAppointments(Appointment appointment)
	{
		
		return AdminOperation.viewAllAppointments(appointment);
		
	}
	public void addRoutine(int appointment_id, int staff_id, String status) 
	{
		
		AdminOperation.addRoutine(appointment_id,staff_id,status);
		
	}
	public void updateStaffAndDailyRoutine(int s_id, int app_id) 
	{
		
		AdminOperation.updateStaffAndDailyRoutine(s_id,app_id);
		
	}
	public void changeStaffStatus(int staff_id1, String string) 
	{
		
		AdminOperation.changeStaffStatus(staff_id1,string);
		
	}
	public ArrayList<Payment> viewAllPayments() 
	{
		
		return Payment.viewAllPayments();
		
	}
	public ArrayList<DailyRoutine> getDailyRoutine(DailyRoutine dailyroutine) 
	{
	
		return DailyRoutine.getDailyRoutine();
		
	}
}
