package com.Tshirts.ekart.db_configuration;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Bean;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.Tshirts.ekart")
public class Mainfile {
	@Bean(name={"dataSource"})
	public DataSource getdataSource()
	{
	BasicDataSource datasource = new BasicDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUsername("sa");
	datasource.setPassword("jagadish");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
	return datasource;
	}
	@Bean
	public SessionFactory sessionFactory(DataSource datasource)
	{ 
	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(datasource);
	localSessionFactoryBuilder.scanPackages("com.Tshirts.ekart");
	localSessionFactoryBuilder.addProperties(getProperties());
	return localSessionFactoryBuilder.buildSessionFactory();
	}
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Bean
	public HibernateTransactionManager TransactionalManager(SessionFactory sessionFactory)
	{
	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
	return hibernateTransactionManager;
	}
}
