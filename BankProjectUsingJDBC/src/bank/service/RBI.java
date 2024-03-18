package bank.service;

import java.sql.SQLException;

public interface RBI {
	
	public void createAccount() throws ClassNotFoundException, java.sql.SQLException;
	public void viewAccountDetails() throws ClassNotFoundException, java.sql.SQLException; 
	public void depositeMoney() throws ClassNotFoundException, SQLException;
	public void withdrawMoney() throws ClassNotFoundException, SQLException;
	public void Showbalance() throws ClassNotFoundException, SQLException;
	public void updateDetails() throws ClassNotFoundException, java.sql.SQLException;

}
