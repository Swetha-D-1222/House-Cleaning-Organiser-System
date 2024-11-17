package View;
import java.util.*;

import Model.DBConnection;
public class HouseCleaningOrganiser 
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to HOUSE CLEANING ORGANISER SYSTEM");
		DBConnection.createConn();
		System.out.println("1 ---> Admin \n2 ---> Customer\n3 ---> Staff");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		do
		{
			switch(choice)
			{
				case 1 :
					AdminView av=new AdminView();
					av.viewAdmin();
					break;
				case 2:
					CustomerView cv=new CustomerView();
					cv.viewCustomer();
					break;
				case 3:
					StaffView st=new StaffView();
					st.viewStaff();
					break;
				default:
					choice=0;
					break;
			}
		}while(choice!=0);
		sc.close();
	}
}
