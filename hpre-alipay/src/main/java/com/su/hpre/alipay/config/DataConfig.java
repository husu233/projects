package com.su.hpre.alipay.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = { "classpath:dataSource.properties", "classpath:hibernate.properties" })
@EnableTransactionManagement
public class DataConfig {
	
	@Autowired
	private Environment env;
	
	/**
	 * 配置数据源
	 * */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));
		dataSource.setUrl(env.getProperty("dataSource.url"));
		dataSource.setUsername(env.getProperty("dataSource.username"));
		dataSource.setPassword(env.getProperty("dataSource.password"));
		dataSource.setMaxTotal(Integer.parseInt(env.getProperty("dataSource.maxTotal")));
		dataSource.setMinIdle(Integer.parseInt(env.getProperty("dataSource.minIdle")));
		dataSource.setMaxIdle(Integer.parseInt(env.getProperty("dataSource.maxIdle")));
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("dataSource.initialSize")));
		return dataSource;
	}
	
	/**
	 * 配置 hibernate 会话工厂
	 * */
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.su.hpre.alipay.model");
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current.session.context.class"));
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	/**
	 * hibernate 事务管理
	 * */
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
