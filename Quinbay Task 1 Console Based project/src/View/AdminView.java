package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Admin;
import Model.Appointment;
import Model.Customer;
import Model.DailyRoutine;
import Model.Payment;
import Model.Staff;

public class AdminView {
	
	public void viewAdmin() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" ------Admin Login------");
		System.out.println("Enter Mail Id :");
		String mail=sc.nextLine();
		//System.out.println(mail);
		System.out.println("Enter Password :");
		String pass=sc.nextLine();
		Admin admin =new Admin();
		admin=admin.Login(mail,pass);
		if(admin!=null)
		{
			if(Admin.getAdmin_Email().equals(mail))
			{
				if(Admin.getAdmin_Password().equals(pass))
				{
					int choice=1;
					do
					{
					System.out.println("Enter the task you need to perform :");
					System.out.println("1 ---> Add Staff\n2 ---> Remove Staff\n3 ---> View Transaction\n4 ---> View all Customers\n5 ---> View Staff Members\n6 ---> View All Work Done\n7 ---> View Appointments");
					choice =sc.nextInt();
					Staff staff=new Staff();
					ArrayList<Staff> sta=new ArrayList<Staff>();
					switch(choice)
					{
						case 1:
							System.out.println("You are here to add a staff member\nEnter the required details");
							sc.nextLine();
							System.out.println("Enter Staff name :");
							String staffName=sc.nextLine();
							System.out.println(staffName);
							System.out.println("Enter Staff Gender :");
							String staffGender=sc.next();
							System.out.println("Enter Staff Phone Number :");
							long staffPhNo=sc.nextLong();
							System.out.println("Enter Staff Aadhaar Number :");
							long staffAadhaar=sc.nextLong();
							System.out.println("Enter Staff PAN Number :");
							String staffPan=sc.next();
							String staffMail=(staffName.substring(0,4)+""+staffAadhaar%10000)+"@gmail.com";
							String staffPassword=staffName.substring(0,4)+""+staffAadhaar%10000;
							staff.setStaff_name(staffName);
							staff.setStaff_gender(staffGender);
							staff.setStaff_email(staffMail);
							staff.setStaff_password(staffPassword);
							staff.setStaff_phno(staffPhNo);  
							staff.setStaff_Aadhaar(staffAadhaar);
							staff.setStaff_pan(staffPan);
							staff=admin.registerStaff(staff);
	//						System.out.println(staff.getStaff_id());
							if(staff!=null)
							{
								ArrayList<Staff> sta2=new ArrayList<Staff>();
								sta2=admin.viewStaffMembers(staff);
								int staff_id=0;
								for(Staff s:sta2)
								{
									staff_id=s.getStaff_id();
								}
								admin.setStatus(staff_id,"yes");
								System.out.println("Staff added successfully...");
							}
							break;
						case 2:
							System.out.println("You are here to remove Staff Member");
							System.out.println();
							sta=admin.viewStaffMembers(staff);
							for(Staff s:sta)
							{
								System.out.println("Staff_id : "+s.getStaff_id()+
										" -|- Staff_name :"+s.getStaff_name()+
										" -|- Staff_gender :"+s.getStaff_gender()+
										" -|- Staff_EmailId :"+s.getStaff_email()+
										" -|- Staff_Password :"+s.getStaff_password()+
										" -|- Staff_PhoneNumber :"+s.getStaff_phno());
								System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
	
							}
							System.out.println("Enter staff Id to remove :");
							int staffId=sc.nextInt();
							admin.removeStaff(staffId);
							break;
						case 3:
							System.out.println("- - - - -All Payments made- - - - -");
							System.out.println();
							ArrayList<Payment> pay=admin.viewAllPayments();
							for(Payment p:pay)
							{
								System.out.println("Payment_id : "+p.getPayment_id()+
										" -|- Appointment_id : "+p.getAppointment_id()+
										" -|- Payment_Mode : "+p.getPayment_method()+
										" -|- Payment_Amount : "+p.getAmount_payed()+
										" -|- Payment_Date : "+p.getPayment_date());
								System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
							}
							break;
						case 4:
							System.out.println("- - - - -Our Customers- - - - -");
							System.out.println();
							ArrayList<Customer> cus=admin.viewCustomer();
							for(Customer c:cus)
							{
								System.out.println("Customer_id : "+c.getCustomer_id()+
										" -|- Customer_name :"+c.getCustomer_name()+
										" -|- Customer_EmailId :"+c.getCustomer_email()+
										" -|- Customer_Password :"+c.getCustomer_password()+
										" -|- Customer_PhoneNumber :"+c.getCustomer_phoneNo());
								System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
							}
							break;
						case 5:
							System.out.println("- - - - -Staff Members- - - - -");
							System.out.println();
							ArrayList<Staff> sta1=admin.viewStaffMembers(staff);
							if (sta1 != null && !sta1.isEmpty()) {
								for(Staff s:sta1)
								{
									System.out.println("Staff_id : "+s.getStaff_id()+
											" -|-Staff_name :"+s.getStaff_name()+
											" -|- Staff_EmailId :"+s.getStaff_email()+
											" -|- Staff_Password :"+s.getStaff_password()+
											" -|- Staff_PhoneNumber :"+s.getStaff_phno());
									System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
								}
							}
							else
							{
								System.out.println("No staff found");
							}
							break;
						case 6:
							System.out.println("- - - - -Daily Work Print- - - - -");
							System.out.println();
							DailyRoutine dailyroutine=new DailyRoutine();
							ArrayList<DailyRoutine> dr=admin.getDailyRoutine(dailyroutine);
							for(DailyRoutine d:dr)
							{
								System.out.println("Appointment_id  : "+d.getAppointment_id()+
										" -|- Staff_id  : "+d.getStaff_id()+
										" -|- Date of Work : "+d.getDate_of_work()+
										" -|- Time In : "+d.getTime_in()+
										" -|- Time Out : "+d.getTime_out()+
										" -|- Work Status : "+d.getWork_status());
								System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
							}
							break;
						case 7:
							System.out.println("- - - - -Appointments- - - - -");
							System.out.println();
							Appointment appointment=new Appointment();
							ArrayList<Appointment> app=admin.viewAllAppointments(appointment);
							if(app!=null && !app.isEmpty())
							{
								for(Appointment a:app)
								{
									System.out.println("Appointment_id : "+a.getAppointment_id()+
											" -|- Appointment_Address : "+a.getAddress()+
											" -|- Appointment_status : "+a.getWork_status()+
											" -|- Customer_id : "+a.getCustomer_id()+
											" -|- Staff_id : "+a.getStaff_id());
									System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
								}
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
		sc.close();
	}

}


