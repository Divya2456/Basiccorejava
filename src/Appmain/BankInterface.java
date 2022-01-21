package Appmain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import Dao.AccountDetailsDao;
import Dao.LoginBankDetailsDao;
import Daoimpl.AccountDetailsImpl;
import Daoimpl.LoginBankDetailsImpl;
import Model.Accountdetails;
import Model.UserDetailsBank;
import Respository.AccountDetailsDaoRes;
import Respository.LoginDetailsDaoRes;

public class BankInterface 
{

	public static void main(String[] args)  
	{
		// TODO Auto-generated method stub		
		System.out.println("****Welcome to Bank Application*****");
		
		System.out.println("1: Sign up");
		System.out.println("2: Sign In");
		System.out.println("3: Exit");
		System.out.println("*********************");
		char ch=' ';
		char ch1=' ';
		
		LoginBankDetailsDao LoginDao=new LoginBankDetailsImpl();
		AccountDetailsDao  accountDao=new AccountDetailsImpl();
		String username,firstname,lastname,password, location,mobileno,acc_type;
	
		int account_no,account_id,amount;
		boolean flag=true;
		
		
		do
		{
			System.out.println("What you do wish to check from the above list");
		     Scanner sn=new Scanner(System.in);
			  int option=sn.nextInt();
		   
			switch(option)
			{
			 
				case 1:System.out.println("enter the details to signup");
				System.out.println("enter username");
				username=sn.next();
				System.out.println("enter first name");
				firstname=sn.next();
				System.out.println("enter last name");
				lastname=sn.next();
				System.out.println("enter password");
				password=sn.next();
				System.out.println("enter  location");
				location=sn.next();
				System.out.println("enter mobile number");
				mobileno=sn.next();
		        System.out.println("enter account type");
				acc_type=sn.next();
						UserDetailsBank user=new UserDetailsBank();
						user.setUsername(username);
						user.setFirstName(firstname);
						user.setLastName(lastname);
						user.setLocation(location);
						user.setPassword(password);
						user.setMobileno(mobileno);
						user.setAcc_type(acc_type);
							
					LoginDao.signUp(user);
					System.out.println("end of sign up");
                  break;
                  
				case 2: System.out.println("enter the username and password to login");
				String usern=sn.next();
				String pass=sn.next();
				
				UserDetailsBank details=new UserDetailsBank();
				details.setUsername(usern);
				details.setPassword(pass);
				
					
					boolean res=LoginDao.signIn(details);
					if(res)
					{	
						System.out.println("login success");
                  	 	System.out.println("Check Menu");
					    System.out.println("1.Deposit Amount");
					    System.out.println("2.Withdraw Amount");
					    System.out.println("3.Checking balance");
					    System.out.println("4.findall details");
					    System.out.println("5.exit ");
					 
					    int function;
				    	do
				    	{
				    		System.out.println("Select any option from the menu");
						     Scanner sc=new Scanner(System.in);
							  function=sc.nextInt();
							  switch(function)
							  {
							  case 1:
								  System.out.println("Enter the account no");
								  int account_no1=sn.nextInt();
								  System.out.println("Enter the amount to be deposited:");
								  int amount1=sn.nextInt();
								boolean rs1=accountDao.deposit(account_no1,amount1);
							      if(rs1)
								{
							System.out.println("Deposit Successfully");
								}
								else
								{
									System.out.println("Invalid Account Number");
								}
							  break;
							  case 2:
								  System.out.println("Enter the account no");
								  int account_no2=sn.nextInt();
								  System.out.println("Enter the amount to be withdraw");
								  int amount2=sn.nextInt();
								   
								    boolean res4=accountDao.withdraw(account_no2, amount2);
								    if(res4)
								    	System.out.println("Withdraw Successfully");
								    else 
								    	System.out.println("Withdraw failed");
								  
								  break;
							  case 3:
								  System.out.println("Enter the account no");
								  int account_no3=sn.nextInt();
							  System.out.println(accountDao.checkbalance(account_no3));
								
							  break;
							  
							  
							  case 4:
								  System.out.println("find all details");
					
	                             ArrayList<UserDetailsBank> arrayList=LoginDao.findAll();
								 Iterator<UserDetailsBank> it=arrayList.iterator();
									
									while(it.hasNext())
									{
										UserDetailsBank details1= new UserDetailsBank();
										details1=it.next();
										System.out.println("username"+"  "+details1.getUsername());
										System.out.println("firstname"+"  "+details1.getFirstName());
										System.out.println("lastname"+"  "+details1.getLastName());
										System.out.println("password"+"  "+details1.getPassword());
										System.out.println("location"+"  "+details1.getLocation());
										System.out.println("mobileno"+"  "+details1.getMobileno());
										System.out.println("acc_type"+"  "+details1.getAcc_type());
									
									}
									
								  break;
							  case 5:System.out.println("Exit from this");
							  
								    // System.exit(0); 
							break;
							    default: System.out.println("enter the valid option");
						        }
					         System.out.println("do you want to check other menu");
					           ch1=sc.next().charAt(0);
					           
				    	}while(ch1=='p');
						}		
		
				     else
				     {
						System.out.println("login failed");
				     }
					break;
				case 3:
					System.out.println("Exit");
					System.exit(0);
					break;
				    default: System.out.println("enter the valid option");
		}
		         System.out.println("Do you wish to check other options");
		           ch=sn.next().charAt(0);
		 }
		while(ch=='y');			
				
	}	

}

				