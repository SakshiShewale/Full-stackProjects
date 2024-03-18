package bank.serviceimpl;

import java.util.Scanner;

import bank.model.Account;
import bank.service.RBI;

public class Axis implements RBI{

	Scanner sc =new Scanner(System.in);
	Account ac=null;

	public void createAccount() 
	{
		System.out.println("Welcome to Account opening Section of Axis Bank");
		System.out.println("*****------*******-----****");
		System.out.println();
		ac=new Account();
		
		System.out.println("Enter Account number to create");
		ac.setAcno(sc.nextLong());
		
		System.out.println("Enter your name ");
		ac.setAcname(sc.next()+sc.nextLine());
		
		System.out.println("Enter Your Address");
		ac.setAcAddress(sc.next());
		
		System.out.println("Enter your AadharNo");
		ac.setAadharNo(sc.nextLong());
		
		System.out.println("Enter Your PANNO");
		ac.setPanNo(sc.next());
		
		System.out.println("Enter Your MobileNo");
		ac.setMobileNo(sc.nextLong());
		
		System.out.println("Enter Your Gender");
		ac.setGender(sc.next());
		
		System.out.println("Enter your Balance");
		ac.setBalance(sc.nextDouble());
		
		System.out.println();
		System.out.println("Account created Successfully....!");
		System.out.println("Thank you for Visting");
		System.out.println("********************");
		System.out.println();
		
	}

	public void viewAccountDetails() {
		
		if(ac!=null)
		{
			System.out.println();
			System.out.println("Account Number : "+ac.getAcno());
			System.out.println("Account Holder Name : "+ac.getAcname());
			System.out.println("Account Holder Address :"+ac.getAcAddress());
			System.out.println("Account Aadhar No : "+ac.getAadharNo());
			System.out.println("Account PANNO : "+ac.getPanNo());
			System.out.println("Account MObile No : "+ac.getMobileNo());
			System.out.println("Gender : "+ac.getGender());
			System.out.println("Account Saving balance : "+ac.getBalance());
			
			System.out.println();
		}
		else {System.out.println();
			System.out.println("Create Account first then try again later");
			System.out.println();
		}
		
		
	}

	
	public void depositeMoney() {
		System.out.println("Enter your Account number to deposite money : ");// 303
		long acno = sc.nextLong();
		
		
		
		if(ac!=null)
		{
			double Avbalance = ac.getBalance(); // 876000 
			
			System.out.println("enter Amount To deposite");
			double damo = sc.nextDouble();		// 24000
			
			ac.setBalance(Avbalance+damo);
			
			System.out.println("Money Deposited Done...!");
			
			
		}
		else
		{
			System.out.println();
			System.out.println("Account not found with this Acno : "+acno);
		}
		
		
	}

	public void withdrawMoney() {
		if(ac!=null)
		{
			double avbal = ac.getBalance();
			
			System.out.println("enter Amount to withdraw money");
			double wamo = sc.nextDouble();
			
			if(wamo>100 & wamo<=10000)
			{
				double newbalance = avbal-wamo;
				ac.setBalance(newbalance);
				
				System.out.println("Amount withdraw Successfull.....!");
				System.out.println();
				
			}
			else {
				System.out.println();
				System.out.println("Please Enter Amount between 100 to 10000 ");
			}
			
		}
		
	}

	@Override
	public void Showbalance() {
		
		if(ac!=null)
		{
			System.out.println("Your Saving Account Balance is : rs "+ac.getBalance());
			System.out.println();
		}
		else {
			System.out.println("Create Account then come back");
		}
		
		
	}

	@Override
	public void updateDetails() {
		
	       boolean flag =true;
			
			while(flag)
			{
				System.out.println("which Details You Want tO update....?: ");
				System.out.println("Enter 1 to Update Account Number : ");
				System.out.println("Enter 2 to Update Account Name : ");
				System.out.println("Enter 3 to Update Address : ");
				System.out.println("Enter 4 to Update Adhar Number :");
				System.out.println("Enter 5 to Update Pan Number : ");
				System.out.println("Enter 6 to update Mobile Number : ");
				
				System.out.println("Enter 7 to Exit from Application : ");
				
				System.out.println("********------*******-------******");
				
				int ch = sc.nextInt();
				
		        if(ch==1)	
					
					updateAcNo();
				
				else if(ch==2)	
					
					updateName();
				
				else if(ch==3)	
				     updateAddress();
					
			else if(ch==4)	
					
					updateAdharNo();
			else if(ch==5)	
					
					updatePanNo();
			else if(ch==6)	
					
					updateMobileNo();
		        
			else if(ch==7)
				flag= false;
		        break;
	  		}
	 }		
		private void updateAcNo() {
			System.out.println("Enter Your Account Number to Update details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new Account no to update");
				long newAcNo=sc.nextLong();
				ac.setAcno(newAcNo);
				 
				System.out.println("Account number Updated Successfully...!");
			}
		}
		
		private void updateName() 
		{
			System.out.println("Enter Your Account Number to see details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new Name to update");
				String newName=sc.next();
				ac.setAcname(newName);
				 
				System.out.println("Your Name Updated Successfully...!");
			}
			
		}
		
		private void updateAddress() {
			System.out.println("Enter Your Account Number to see details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new Address to update");
				String newAddress=sc.next();
				ac.setAcAddress(newAddress);
				 
				System.out.println("Your Address Updated Successfully...!");
			}
			
		}

		
		private void updateMobileNo() {
			
			System.out.println("Enter Your Account Number to Update details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new mobile number to update");
				long newmobile=sc.nextLong();
				ac.setMobileNo(newmobile);
				 
				System.out.println("Mobile number Updated Successfully...!");
			}
		}

		private void updateAdharNo() {
			System.out.println("Enter Your Account Number to see details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new Adhar no to update");
				long newAdharNo=sc.nextLong();
				ac.setAadharNo(newAdharNo);
				 
				System.out.println("Adhar number Updated Successfully...!");
			}
			
		}

		
		private void updatePanNo() {
			System.out.println("Enter Your Account Number to see details : ");
			long Acno = sc.nextLong();

			if(ac!=null)
			{
				System.out.println("Enter Your new PAN no to update");
				String newPanNo=sc.next();
				ac.setPanNo(newPanNo);
				 
				System.out.println("PAN number Updated Successfully...!");
			}
			
		}

		
		
		
}
