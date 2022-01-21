package Respository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Config.MyConnection;
import Model.Accountdetails;

public class AccountDetailsDaoRes 
{
	
				Connection connection=null;
				Statement statement=null;
				ResultSet resultSet=null;

public AccountDetailsDaoRes() throws SQLException
{
	connection=MyConnection.getConnection();
	statement=connection.createStatement();
}

public boolean deposite( int account_no,int amount) throws SQLException 
{
	ResultSet rs=statement.executeQuery("select *from account where account_no="+account_no+"");
	while(rs.next())
	{
	int balance=rs.getInt("amount");
	balance=balance+amount;
	int r=statement.executeUpdate("update account set amount="+balance+"  where  account_no="+account_no+"");
	if(r==1)
	return true;

	}
			return false;
	
}

public boolean withdraw( int account_no,int amount) throws SQLException 
{
	ResultSet rs=statement.executeQuery("select *from account where account_no="+account_no+"");
	while(rs.next())
	{
	int balance=rs.getInt("amount");

	
	balance=balance-amount;
	int r=statement.executeUpdate("update account set amount="+balance+"  where  account_no="+account_no+"");
	if(r==1)
	
		return true;
	}
		
	return false;
	
}

public int checkbalance(int account_no) throws SQLException 
{
	ResultSet rs=statement.executeQuery("select *from account where account_no="+account_no+"");
	while(rs.next())
	{
	int  balance=rs.getInt("amount");
	if(balance>0)
	{
	int r=statement.executeUpdate("update account set amount="+balance+" where account_no="+account_no+"");
	
}
	
return balance;
	}
	return account_no;
	}}

  

	
	