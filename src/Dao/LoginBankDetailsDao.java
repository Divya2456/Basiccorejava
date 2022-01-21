package Dao;

import java.util.ArrayList;



import Model.Accountdetails;
import Model.UserDetailsBank;

public interface LoginBankDetailsDao 
{
	public boolean signUp(UserDetailsBank user);
	public boolean signIn(UserDetailsBank user);
	public ArrayList<UserDetailsBank> findAll();
	
}



