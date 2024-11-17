package Model;

import java.util.ArrayList;

import Controller.AdminOperation;
import Controller.CustomerOperation;

public class Customer extends User
{
	int customer_id;
	String customer_name;
	String customer_email;
	String customer_password;
	long customer_phoneNo;
	
	public Customer(int customer_id, String customer_name, String customer_email, String customer_password,long customer_phoneNo) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_password = customer_password;
		this.customer_phoneNo = customer_phoneNo;
	}

	public Customer() 
	{
		customer_id = 0;
		customer_name = null;
		customer_email = null;
		customer_password = null;
		customer_phoneNo =0;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public long getCustomer_phoneNo() {
		return customer_phoneNo;
	}

	public void setCustomer_phoneNo(long customer_phoneNo) {
		this.customer_phoneNo = customer_phoneNo;
	}

//	public static void customerLogin(String user_email) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public Customer Login(String email, String password) 
	{
		return CustomerOperation.customer_login(email,password);
	}

	public static ArrayList<Customer> viewAllCustomer() 
	{
		return AdminOperation.viewAllCustomer();
		
	}

	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return CustomerOperation.customerRegistration(customer);
	}

	public Appointment bookAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return Appointment.bookAppointment(appointment);
	}

	public int cancelAppointment(int app_id) 
	{
		
		return CustomerOperation.cancelAppointment(app_id);
		
	}

}
