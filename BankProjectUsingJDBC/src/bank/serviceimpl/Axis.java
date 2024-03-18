package bank.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Configure.DButil;
import bank.model.Account;
import bank.service.RBI;


public class Axis implements RBI{
	Scanner sc=new Scanner(System.in);
	Account ac=new Account();
	
	public void createAccount() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Account Number : ");
		long Acno=sc.nextLong();
		System.out.println("Enter Account holder Name :");
		String AcName=sc.next()+sc.nextLine();
		System.out.println("Enter your Address :");
		String Address=sc.next();
		System.out.println("Enter Your MobileNo :");
		long Mobile=sc.nextLong();
		System.out.println("Enter your Aadhar No :");
		long aadhar=sc.nextLong();
		System.out.println("Enter Your PAN no: ");
		String PAN=sc.next();
		System.out.println("Enter Your Gender");
		String gender=sc.next();
		System.out.println("Enter your Opening Balance :");
		float balance=sc.nextFloat();
		
		Connection con = DButil.getconnection();
		
		String sql="insert into Account values("+Acno+",'"+AcName+"','"+Address+"','"+Mobile+"',"+aadhar+",'"+PAN+"','"+gender+"',"+balance+")";
		
		Statement smt = con.createStatement();
		smt.execute(sql);
		con.close();
		smt.close();
		System.out.println("**********************************");
		System.out.println("Account Created Successfully....!");
		System.out.println("**********************************");
		System.out.println();
		
	}
public void viewAccountDetails() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Your Account Number to see details : ");
		long Acno = sc.nextLong();
		
		Connection con = DButil.getconnection();
		String sql="select * from Account where Acno="+Acno+"";
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(sql);
		
		if(rs.next())
		{
			System.out.println("Welcome to Account Section ");
			System.out.println("********************");
			System.out.println();
			System.out.println("Account Number : "+rs.getLong(1));
			System.out.println("Account Name "+rs.getString(2));
			System.out.println("Address : "+rs.getString("AcAddress"));
			System.out.println("MobileNo : "+rs.getLong(4));
			System.out.println("AadharNO : "+rs.getLong("AdharNo"));
			System.out.println("PAN :"+rs.getString("PanNo"));
			System.out.println("Gender : "+rs.getString(7));
			System.out.println("Account Balance :"+rs.getFloat("Balance"));
			System.out.println();
			System.out.println("******THANK YOU**********");
			System.out.println();
			
		}
		else {
			System.out.println("Invalid Account Number : ");
			System.out.println();
		}
		
		con.close();
		smt.close();
		
	}
	public void depositeMoney() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		
		if(ac!=null)
		{
			double avbal = ac.getBalance();
			
			System.out.println("Enter Amount for Deposite money");
			double DepoAmt = sc.nextDouble();
			ac.setBalance(avbal+DepoAmt);
			
			System.out.println("Amount deposited Successfully.....!");
			System.out.println();
			
		}
		
		else {
			System.out.println("Create Account then come back");
		}
		con.close();
		smt.close();
	}
	public void withdrawMoney() throws ClassNotFoundException, SQLException 
	{
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		
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
		else {
				System.out.println("Create Account then come back");
			
			}
		con.close();
		smt.close();	
	}
		
	

	@Override
	public void Showbalance() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		

		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Your Saving Account Balance is :"+ac.getBalance());
			System.out.println();
		}
		else {
			System.out.println("Create Account then come back");
		}
		
		con.close();
		smt.close();
	}

	@Override
	public void updateDetails()throws ClassNotFoundException, SQLException {
		
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
	private void updateAcNo() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Your Account Number to Update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new Account number to update");
			String newAcNo=sc.next();
			
		    String sql2="update Account set Acno="+newAcNo+" where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("Account number Updated Successfully...!");
				
			con.close();
			smt.close();
		}	
	}
	private void updateName() throws SQLException, ClassNotFoundException {
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new Account Name to update");
			String newName=sc.next();
			
		String sql2="update Account set AcName='"+newName+"6' where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("Your Name Updated Successfully...!");
				
			con.close();
			smt.close();
		}
		
}
	
	private void updateAddress()throws ClassNotFoundException, SQLException{
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new Address to update");
			String newAddress=sc.next();
			
		String sql2="update Account set AcAddress='"+newAddress+"' where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("Address Updated Successfully...!");
				
			con.close();
			smt.close();
		}
		
	}
	private void updateAdharNo()throws ClassNotFoundException, SQLException{
		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new Adhar no to update");
			String newAdharNo=sc.next();
			
		String sql2="update Account set AdharNo="+newAdharNo+" where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("Adhar number Updated Successfully...!");
				
			con.close();
			smt.close();
		}
		
	}

	private void updatePanNo() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Your Account Number to Update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new PAN number to update");
			String newPanNo=sc.next();
			
		String sql2="update Account set PanNO='"+newPanNo+"' where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("PAN number Updated Successfully...!");
				
			con.close();
			smt.close();
		}
				
		
	}

	
	
	
	private void updateMobileNo() throws ClassNotFoundException, SQLException {
		

		System.out.println("Enter Your Account Number to update details : ");
		long Acno = sc.nextLong();
		Connection con = DButil.getconnection();
		Statement smt = con.createStatement();
		String sql="select Acno from Account where Acno="+Acno;
		ResultSet rs = smt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter Your new mobile no to update");
			String newmobile=sc.next();
			
		String sql2="update Account set Mobile="+newmobile+" where Acno ="+Acno+"";
			 smt.execute(sql2);
			 System.out.println("Mobile number Updated Successfully...!");
				
			con.close();
			smt.close();
				
					
		}
	}

	
	
	
		


}