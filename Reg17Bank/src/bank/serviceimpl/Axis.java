package bank.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bank.configure.Hbutil;
import bank.model.Account;
import bank.service.RBI;

public class Axis implements RBI{

	Scanner sc =new Scanner(System.in);
	Account ac=null;
	
	public void createAccount() 
	{
		System.out.println("Welcome to Account opening Section");
			ac = new Account();
			
			System.out.println("Enter Account number to register");
			long Acno = sc.nextLong();
			ac.setAcno(Acno);
			
			System.out.println("Enter Account holder name ");
			ac.setAcname(sc.next()+sc.nextLine());
			
			System.out.println("Enter Account holder Address : ");
			ac.setAcAddress(sc.next());
			
			System.out.println("Enter your aadhar No : ");
			ac.setAadharNo(sc.nextLong());
			
			System.out.println("Enter Your PANNo : ");
			ac.setPanNo(sc.next());
			
			System.out.println("Enter your Mobile Number : ");
			ac.setMobileNo(sc.nextLong());
			
			System.out.println("Enter your Gender : ");
			ac.setGender(sc.next());
			
			System.out.println("Enter your balance");
			ac.setBalance(sc.nextDouble());
			
			SessionFactory sf = Hbutil.getSessionfactory();
			Session session = sf.openSession();
			
			session.save(ac);
			
			session.beginTransaction().commit();
			System.out.println("Account created Successfully...!");
			
	}

	public void viewAccountDetails()  {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account Number To See the details"); // 202
		long acno = sc.nextLong();
		
		Account ac = session.get(Account.class, acno);
		
		if(ac!=null)
		{
			System.out.println();
			System.out.println("Account number : "+acno);
			System.out.println("Account name : "+ac.getAcname());
			System.out.println("Account Address : "+ac.getAcAddress());
			System.out.println("Account AadhaNo : "+ac.getAadharNo());
			System.out.println("Account PANNO : "+ac.getPanNo());
			System.out.println("Account MobileNo : "+ac.getMobileNo());
			System.out.println("Account holder Gender : "+ac.getGender());
			System.out.println("Account balance : "+ac.getBalance());
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("Account not found with this Acno : "+acno);
		}
	
		
	}
	public void depositeMoney() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account number to deposite money : ");// 303
		long acno = sc.nextLong();
		
		Account ac = session.get(Account.class, acno);
		
		if(ac!=null)
		{
			double Avbalance = ac.getBalance(); // 876000 
			
			System.out.println("enter Amount To deposite");
			double damo = sc.nextDouble();		// 24000
			
			ac.setBalance(Avbalance+damo);
			
			System.out.println("Money Deposited Done...!");
			session.beginTransaction().commit();
			
		}
		else
		{
			System.out.println();
			System.out.println("Account not found with this Acno : "+acno);
		}
		
		
		
	}

	public void withdrawMoney() {
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account number to Withdraw money : ");// 303
		long acno = sc.nextLong();
		
		Account ac = session.get(Account.class, acno);
		
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
				session.beginTransaction().commit();
				System.out.println();
				
			}
			else {
				System.out.println();
				System.out.println("Please Enter Amount between 100 to 10000 ");
			}
			
		}
		session.save(ac);
		
		session.beginTransaction().commit();
	}

	@Override
	public void Showbalance() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account number to Show Balance : ");// 303
		long acno = sc.nextLong();
		
		Account ac = session.get(Account.class, acno);
		
		
		if(ac!=null)
		{
			System.out.println("Your Saving Account Balance is : rs "+ac.getBalance());
			System.out.println();
		}
		else {
			System.out.println("Create Account then come back");
		}
		session.save(ac);
		
		session.beginTransaction().commit();
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
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		Account ac = session.get(Account.class, Acno);
		if(ac!=null)
		{
			System.out.println("Enter Your new Account no to update");
			long newAcNo=sc.nextLong();
			ac.setMobileNo(newAcNo);
			 
			System.out.println("Account number Updated Successfully...!");
			 session.save(ac);
			session.beginTransaction().commit();
		
		}     
		}
	private void updateMobileNo() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		Account ac = session.get(Account.class, Acno);
		

		if(ac!=null)
		{
			System.out.println("Enter Your new mobile no to update");
			long newmobile=sc.nextLong();
			ac.setMobileNo(newmobile);
			 
			System.out.println("Mobile number Updated Successfully...!");
			
			 session.save(ac);
			session.beginTransaction().commit();
		
		}
	}

	private void updatePanNo() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		Account ac = session.get(Account.class, Acno);
		
		if(ac!=null)
		{
			System.out.println("Enter Your new PAN no to update");
			long newPanNo=sc.nextLong();
			ac.setMobileNo(newPanNo);
			 
			System.out.println("PAN number Updated Successfully...!");
			
			 session.save(ac);
			session.beginTransaction().commit();
		}
		
	}

	private void updateAdharNo() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();

		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		Account ac = session.get(Account.class, Acno);
		
		if(ac!=null)
		{
			System.out.println("Enter Your new Adhar no to update");
			long newAdharNo=sc.nextLong();
			ac.setMobileNo(newAdharNo);
			 
			System.out.println("Adhar number Updated Successfully...!");
			 session.save(ac);
			session.beginTransaction().commit();
		}
		
	}

	private void updateAddress() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		Account ac = session.get(Account.class, Acno);
		
		if(ac!=null)
		{
			System.out.println("Enter Your new Address to update");
			long newAddress=sc.nextLong();
			ac.setMobileNo(newAddress);
			 
			System.out.println("Your Address Updated Successfully...!");
			 session.save(ac);
			session.beginTransaction().commit();
		}
		
	}

	private void updateName() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();

		Account ac = session.get(Account.class, Acno);
		
		if(ac!=null)
		{
			System.out.println("Enter Your new Name to update");
			long newName=sc.nextLong();
			ac.setMobileNo(newName);
			 
			System.out.println("Your Name Updated Successfully...!");
			
			 session.save(ac);
			session.beginTransaction().commit();
			
		}
		
		}

}
