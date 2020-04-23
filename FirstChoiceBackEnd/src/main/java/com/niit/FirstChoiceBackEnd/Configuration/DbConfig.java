package com.niit.FirstChoiceBackEnd.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class DbConfig 
{
		@Bean
	    public DataSource myDataSource()
	   {
	  BasicDataSource basicDataSource = new BasicDataSource();
	  basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  basicDataSource.setUrl("jdbc:mysql://localhost:3306/fc_customer");
	  basicDataSource.setUsername("root");
	  basicDataSource.setPassword("");
	  return basicDataSource;
	  }

	   Properties myDBProperties()
	   {
	   Properties prop = new Properties();
	   prop.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
	   prop.setProperty(Environment.HBM2DDL_AUTO,"update");
	   prop.setProperty(Environment.SHOW_SQL,"true");
	   return prop;  
	    }

	   @Bean(name = "sessionfactory")
		LocalSessionFactoryBean mySessionFactory() 
	   {
			LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
			localSessionFactoryBean.setDataSource(myDataSource());
			localSessionFactoryBean.setHibernateProperties(myDBProperties());
			localSessionFactoryBean.setPackagesToScan("com.niit.FirstChoiceBackEnd.Model");
			return  localSessionFactoryBean;
		}

	   @Autowired
	   @Bean
	HibernateTransactionManager enableTransaction(SessionFactory sessionfactory)
	{
	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
	hibernateTransactionManager.setSessionFactory(sessionfactory);
	return hibernateTransactionManager;
	}

}