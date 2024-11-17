package Model;

import java.sql.Date;
import java.util.ArrayList;

import Controller.AdminOperation;
import Controller.StaffOperation;

public class Payment 
{
	int payment_id;
	int appointment_id;
	String payment_method;
	float amount_payed;
	Date payment_date;
	
	public Payment(int payment_id, int appointment_id, String payment_method, float amount_payed, Date payment_date) 
	{
		this.payment_id = payment_id;
		this.appointment_id = appointment_id;
		this.payment_method = payment_method;
		this.amount_payed = amount_payed;
		this.payment_date = payment_date;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public float getAmount_payed() {
		return amount_payed;
	}

	public void setAmount_payed(float amount_payed) {
		this.amount_payed = amount_payed;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public static void addPayment(int appointment_id, String mode, float totalAmount) 
	{
		 StaffOperation.addPayment(appointment_id,mode,totalAmount);
	}

	public static ArrayList<Payment> viewAllPayments() 
	{
		
		return AdminOperation.viewAllPayments();
	}
	 

}
