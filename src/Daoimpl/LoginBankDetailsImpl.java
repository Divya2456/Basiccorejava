package Daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.LoginBankDetailsDao;
import Model.Accountdetails;
import Model.UserDetailsBank;
import Respository.LoginDetailsDaoRes;

public class LoginBankDetailsImpl implements LoginBankDetailsDao{

LoginDetailsDaoRes loginDetailsDaoRes=null;

public LoginBankDetailsImpl()
{
	try {
		loginDetailsDaoRes=new LoginDetailsDaoRes();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("problem in repository"+e.getMessage());
	}
}

@Override
public boolean signUp(UserDetailsBank user) {
	// TODO Auto-generated method stub
	
	try {
		return loginDetailsDaoRes.signUp(user);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("problem in sign up"+e.getMessage());
		return false;
	}
}

@Override
public boolean signIn(UserDetailsBank user) {
	// TODO Auto-generated method stub
	try {
		return loginDetailsDaoRes.signIn(user);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}


@Override
public ArrayList<UserDetailsBank> findAll() 
{
	try {
		return loginDetailsDaoRes.findAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return null;
}

}
