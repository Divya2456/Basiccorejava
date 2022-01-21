package Respository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;



import Config.MyConnection;
import Model.Accountdetails;
import Model.UserDetailsBank;

public class LoginDetailsDaoRes {
	
Connection connection=null;
Statement statement=null;
ResultSet resultSet=null;
public LoginDetailsDaoRes() throws SQLException
{
	connection=MyConnection.getConnection();
	statement=connection.createStatement();
}

public boolean signUp(UserDetailsBank user) throws SQLException {
	// TODO Auto-generated method stub

	int r=statement.executeUpdate("insert into bankdetails values('"+user.getUsername()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPassword()+"','"+user.getLocation()+"','"+user.getMobileno()+"','"+user.getAcc_type()+"')");
if(r==1)
{
return true;
}else
	return false;

}
public boolean signIn(UserDetailsBank user) throws SQLException {
	// TODO Auto-generated method stub
	
	
	String tuser=user.getUsername();
	String pass=user.getPassword();
	resultSet=statement.executeQuery("select *from bankdetails where username='"+tuser+"' and password='"+pass+"'");
	if(resultSet.next())
	{
		
	return true;
	}else
		return false;
}



public ArrayList<UserDetailsBank> findAll() throws SQLException 
{
	ArrayList<UserDetailsBank> arrayList=new ArrayList();
		try {
			resultSet = statement.executeQuery("select *from bankdetails");
			
			while(resultSet.next())
			{
				UserDetailsBank db=new UserDetailsBank();
				db.setUsername(resultSet.getString("username"));
				db.setFirstName(resultSet.getString("firstname"));
				db.setLastName(resultSet.getString("lastname"));
				db.setPassword(resultSet.getString("password"));
				db.setLocation(resultSet.getString("location"));
				db.setMobileno(resultSet.getString("mobileno"));
				db.setAcc_type(resultSet.getString("acc_type"));
				
				arrayList.add(db);
		
			}
			
			System.out.println(arrayList);
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}}

		

