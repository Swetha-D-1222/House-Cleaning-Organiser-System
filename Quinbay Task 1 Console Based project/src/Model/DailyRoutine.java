package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Controller.AdminOperation;
import Controller.StaffOperation;

public class DailyRoutine 
{
	int appointment_id;
	int staff_id;
	Date date_of_work;
	Time time_in;
	Time time_out;
	String work_status;
	public DailyRoutine()
	{
		appointment_id = 0;
		staff_id = 0;
		date_of_work = null;
		time_in = null;
		time_out = null;
		work_status = null;
	}
	public DailyRoutine(int appointment_id, int staff_id, Date date_of_work, Time time_in, Time time_out,String work_status) {
		this.appointment_id = appointment_id;
		this.staff_id = staff_id;
		this.date_of_work = date_of_work;
		this.time_in = time_in;
		this.time_out = time_out;
		this.work_status = work_status;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public Date getDate_of_work() {
		return date_of_work;
	}
	public void setDate_of_work(Date date_of_work) {
		this.date_of_work = date_of_work;
	}
	public Time getTime_in() {
		return time_in;
	}
	public void setTime_in(Time time_in) {
		this.time_in = time_in;
	}
	public Time getTime_out() {
		return time_out;
	}
	public void setTime_out(Time time_out) {
		this.time_out = time_out;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public static void enterTimeIn(int appointment_id) 
	{
		StaffOperation.enterTimeIn(appointment_id);
		
	}
	public static void enterTimeOut(int app_id) 
	{
		StaffOperation.enterTimeOut(app_id);
	}
	public static void changeWorkStatus(int appointment_id) 
	{
		StaffOperation.changeWorkStatus(appointment_id);
		
	}
	public static ArrayList<DailyRoutine> getDailyRoutine() {
		// TODO Auto-generated method stub
		return AdminOperation.getDailyRoutine();
	}
	
	

}
