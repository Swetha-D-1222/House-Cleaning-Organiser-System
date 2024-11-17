package View;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import Model.Admin;
import Model.Appointment;
import Model.Payment;
import Model.Staff;
public class StaffView 
{
	Scanner sc=new Scanner(System.in);
	public void viewStaff() 
	{
		System.out.println("-----Staff Login-----");
		System.out.println("Enter Mail Id :");
		String mail=sc.nextLine();
		System.out.println("Enter Password :");
		String pass=sc.nextLine();
		Staff staff=new Staff();
		Appointment app=new Appointment();
		Admin admin=new Admin();
		staff=staff.Login(mail, pass);
		if(staff!=null)
		{
			if(staff.getStaff_email().equals(mail))
			{
				if(staff.getStaff_password().equals(pass))
				{
					int choice=1;
					do
					{
						System.out.println("1 ---> Confirm Apointment\n2 ---> Appointment CheckOut");
						choice=sc.nextInt();
						switch(choice)
						{
							case 1:
								System.out.println("-----You are here to confirm Appointment-----");
								System.out.println("Enter Appointment id to confirm appointment");
								int app_id=sc.nextInt();
								staff.confirmAppointment(app_id,"confirmed");
								System.out.println("Enter Staff_id : ");
								int staff_id=sc.nextInt();
	//							int appointment_id=app.getAppointment_id();
	//							String confirm=sc.next(); 
								int s_id=staff.fetchStaff_id(app_id);
								System.out.println(s_id);
								if(s_id==staff_id)
								{
									System.out.println("-----Appointment Confirmed-----");
									staff.enterTimeIn(app_id);
									System.out.println("------|- CALCULATE PAYMENT -|------");
									System.out.println("1 Square feet = 0.2 ruppess");
									System.out.println("Enter the total no of sqft:");
									float sqft=sc.nextFloat();
									float totalAmount=sqft*0.2f;
									System.out.println("your total amount to be payed : Rs. "+totalAmount);
									System.out.println("Enter your choice : \n1 ---> Cash\n2 ---> Online");
									int val=sc.nextInt();
									System.out.println("Type 'yes' if payment is done");
									String pay=sc.next();
									if(pay.equalsIgnoreCase("yes"))
									{ 
										System.out.println("-----Payment Done-----");	
										if(val==1)
										{
											staff.addPayment(app_id,"Cash",totalAmount); 
										}
										if(val==2)
										{
											staff.addPayment(app_id,"Online",totalAmount);
										}
									}
										
								}
								break;
							case 2:
								System.out.println("-----Appointment Checkout-----");
								System.out.println("Enter Appointment id : ");
								int appointment_id=sc.nextInt();
								System.out.println("Enter Staff_id : ");
								int staff_id1=sc.nextInt();
								System.out.println("Completed the work? Type 'yes' to confirm");
								String confirm=sc.next();
								if(confirm.equalsIgnoreCase("yes"))
								{
									//System.out.println(appointment_id);
									staff.completeAppointment(appointment_id,"completed");
									staff.enterTimeOut(appointment_id);
									admin.changeStaffStatus(staff_id1,"yes");	
									staff.changeWorkStatus(appointment_id);
								}
								System.out.println(" !! ~ Thank you for your work ~ !! ");
								break;
							default:
								choice=0;
								break;
						}
					}while(choice!=0);
				}
			}
		}
		
	}

}
