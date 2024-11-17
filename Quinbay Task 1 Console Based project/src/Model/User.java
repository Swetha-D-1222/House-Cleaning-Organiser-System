package Model;

//import Controller.UserOperation;

public abstract class User 
{
	String user_name;
	protected String user_email;
	protected String user_password;
//	public User(String user_name,String user_email,String user_password)
//	{
//		this.user_name=user_name;
//		this.user_email=user_email;
//		this.user_password=user_password;
//	}
	public abstract Object Login(String user_email,String user_password);
}
