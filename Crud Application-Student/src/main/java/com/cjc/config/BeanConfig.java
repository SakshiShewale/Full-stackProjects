package com.cjc.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cjc.model.Student;


@Configuration @ComponentScan(basePackages = "com.cjc")
public class BeanConfig {

@Bean 
public DriverManagerDataSource ds() 
{
	DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
	dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 
	dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcwebproject"); 
	dataSource.setUsername("root"); 
	dataSource.setPassword("root");
    return dataSource;
}
@Bean 
public LocalSessionFactoryBean sf() {
    
	LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	factoryBean.setDataSource(ds());
    Properties prop = new Properties(); 
    prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
    prop.put(Environment.HBM2DDL_AUTO, "update");
    prop.put(Environment.SHOW_SQL, true);
    prop.put(Environment.FORMAT_SQL, true);
    factoryBean.setHibernateProperties(prop);

    factoryBean.setAnnotatedClasses(Student.class);
    return factoryBean;
  }
 @Bean 
 public InternalResourceViewResolver getResolver() 
  {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/Views/");
      resolver.setSuffix(".jsp");
      return resolver;
 }
}
