package Dao;

import Model.Accountdetails;
import Model.UserDetailsBank;

public interface AccountDetailsDao 
{  
	public boolean deposit(int account_no,int amount);
    public boolean withdraw(int account_no,int amount);
    public int checkbalance(int account_no);
   
}
