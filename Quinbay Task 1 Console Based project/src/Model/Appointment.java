package Model;

import Controller.CustomerOperation;
import Controller.StaffOperation;

public class Appointment 
{
	int appointment_id;
	String address;
	String work_status;
	int customer_id;
	int staff_id;
	public Appointment()
	{
		appointment_id =0;
		address = null;
		work_status = null;
		customer_id = 0;
		staff_id = 0;
	}
	public Appointment(int appointment_id, String address, String work_status, int customer_id, int staff_id) {
		this.appointment_id = appointment_id;
		this.address = address;
		this.work_status = work_status;
		this.customer_id = customer_id;
		this.staff_id = staff_id;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddresss(String address) {
		this.address = address;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public static int fetchStaff_id(int appointment_id) 
	{
		return StaffOperation.fetchStaff_id(appointment_id);
	}
	
	public static Appointment bookAppointment(Appointment appointment) 
	{
		return CustomerOperation.bookAppointment(appointment);
	}
	
	public static void confirmAppointment(int app_id, String confirm) 
	{
		StaffOperation.confirmAppointment(app_id,confirm);	
	}
	
	public static void completeAppointment(int app_id, String complete) 
	{
		StaffOperation.completeAppointment(app_id,complete);
	}
	
}
