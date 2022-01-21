package Daoimpl;

import java.sql.SQLException;

import Dao.AccountDetailsDao;
import Model.Accountdetails;
import Respository.AccountDetailsDaoRes;
import Respository.LoginDetailsDaoRes;

public class AccountDetailsImpl implements AccountDetailsDao {
	AccountDetailsDaoRes accountDetailsDaoRes=null;
	public AccountDetailsImpl()
	{
		try {
			accountDetailsDaoRes=new AccountDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}
	
	
	
	@Override
	public boolean deposit(int account_no,int amount)
	{
		
		try {
			return 	accountDetailsDaoRes.deposite( account_no,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean withdraw( int account_no,int amount) 
	{
		
		try {
			return 	accountDetailsDaoRes.withdraw(account_no,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int checkbalance(int account_no) 
	{
		
		try {
			return 	accountDetailsDaoRes.checkbalance(account_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return account_no;
		
	}	

}
