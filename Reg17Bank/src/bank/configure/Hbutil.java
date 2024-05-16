package bank.configure;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import bank.model.Account;
public class Hbutil {
	
	public static SessionFactory getSessionfactory()
	
	{
		Map<String, String> map = new HashMap<>();
		map.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/bank_project");
		map.put(Environment.USER,"root");
		map.put(Environment.PASS, "root");
		
		map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		map.put(Environment.HBM2DDL_AUTO, "update");
		map.put(Environment.SHOW_SQL,"true");
		map.put(Environment.FORMAT_SQL, "true");
	
		StandardServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(map).build();
		
		MetadataSources mds=new MetadataSources(reg);
		
		mds.addAnnotatedClass(Account.class);
		
		Metadata md = mds.getMetadataBuilder().build();
		
		SessionFactory sf = md.getSessionFactoryBuilder().build();
			
		return sf;
		
	}
	
}
