package View;
import java.util.*;

import Model.Admin;
import Model.Appointment;
import Model.Customer;
import Model.Staff;
public class CustomerView {

	Scanner sc=new Scanner(System.in);
	public void viewCustomer() 
	{
		int n=1;
		do
		{
			System.out.println("Are you a new Customer? \nEnter 1 to register \n         (or)\nEnter 2 to login");
			n=sc.nextInt();
			Customer customer=new Customer();
			Admin admin=new Admin();
			if(n==0)
			{
				break;
			}
			if(n==1)
			{
				System.out.println("-----Customer Registration-----");
				System.out.println("Enter your Name :");
				String customer_name=sc.next();
				sc.nextLine();
				System.out.println("Enter your Email Id :");
				String customer_email=sc.nextLine();
				System.out.println("Enter your password :");
				String customer_password=sc.nextLine();
				String cust_pass="";
				do
				{
					System.out.println("Re-enter your password to confirm");
					cust_pass=sc.nextLine();
					if(!customer_password.equals(cust_pass))
					{
						System.out.println("Password and confirm password incorrect!");
					}
				}while(!customer_password.equals(cust_pass));
				System.out.println("-----Password set-----");
				System.out.println("Enter your Phone Number :");
				long customer_phoneNo=sc.nextLong();
				customer.setCustomer_name(customer_name);
				customer.setCustomer_email(customer_email);
				customer.setCustomer_password(customer_password);
				customer.setCustomer_phoneNo(customer_phoneNo);
				customer=customer.registerCustomer(customer);
				if(customer!=null)
				{
					System.out.println("Customer registered successfully");
				}
			}
			if(n==2)
			{
				System.out.println(" ______Customer Login______");
				System.out.println("Enter Mail Id :");
				String mail=sc.next();
				sc.nextLine();
				System.out.println("Enter Password :");
				String pass=sc.nextLine();
				customer=customer.Login(mail, pass);
				if(customer!=null)
				{
					if(customer.getCustomer_email().equals(mail))
					{
						if(customer.getCustomer_password().equals(pass))
						{
							int choice=1;
							do 
							{
								System.out.println("Enter the task you need to perform :");
								System.out.println("1 ---> Book an appointment\n2 ---> Cancel appointment");
								choice=sc.nextInt();
								switch(choice)
								{
									case 1:
										Appointment appointment=new Appointment();
										int customer_id=customer.getCustomer_id();
										sc.nextLine();
										System.out.println("-----You are here to Book an Appointment-----");
										System.out.println("Enter the address :");
										String address=sc.nextLine();
										System.out.println("Enter your requirement : M for male staff / F for female staff");
										String req=sc.next();
										int staff_id=0;
										ArrayList<Staff> st=new ArrayList<Staff>();
										if(req.equalsIgnoreCase("M"))
										{
											st=admin.checkStaff("male");
											if(st!=null && !st.isEmpty())
											{
												for(Staff s:st)
												{
													System.out.println("Staff assigned : "+s.getStaff_name()+" || Staff Phone Number : "+s.getStaff_phno());
													staff_id=s.getStaff_id();
												}
											}
											else
											{
												System.out.println("No staffs Available at this moment");
												break;
											}
											System.out.println();
										}
										if(req.equalsIgnoreCase("F"))
										{
											st=admin.checkStaff("female");
											if(st!=null && !st.isEmpty())
											{
												for(Staff s:st)
												{
													System.out.println("Staff assigned : "+s.getStaff_name()+" || Staff Phone Number : "+s.getStaff_phno());
													staff_id=s.getStaff_id();
												}
											}
											else
											{
												System.out.println("No staffs Available at this moment");
												break;
											}
											System.out.println();
										}
										System.out.println("Do you want to book the appointment ? Type 'yes' to book");
										String book=sc.next();
										appointment.setAddresss(address);
										appointment.setWork_status("booked");
										appointment.setCustomer_id(customer_id);
										appointment.setStaff_id(staff_id);
										if(book.equalsIgnoreCase("yes"))
										{
											
											appointment=customer.bookAppointment(appointment);
											ArrayList<Appointment> app=admin.viewAllAppointments(appointment);
											int appointment_id=0;
											//int staff_id1=0;
											if(app!=null && !app.isEmpty())
											{
												for(Appointment a:app)
												{
													appointment_id=a.getAppointment_id();
												}
											}
											admin.changeStatus(staff_id);
											System.out.println("-----Appointment Booked-----");
											System.out.println("Your Appointment_id is : "+appointment_id);
											admin.addRoutine(appointment_id,staff_id,"booked");
										}
										break;
									case 2:
										System.out.println("Do ypu want to cancel your appointment ? Type 'yes' to confirm");
										String y=sc.next();
										if(y.equalsIgnoreCase("yes"))
										{
											System.out.println("Enter appointment_id to cancel your appointment :");
											int app_id=sc.nextInt();
											int s_id=customer.cancelAppointment(app_id);
											//System.out.println(s_id);
											admin.updateStaffAndDailyRoutine(s_id,app_id);
											System.out.println("-----Your Appointment has been cancelled-----");
										}
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
		}while(n!=0);
	}

}


