package com.dsk.trackmyexpense.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dsk.trackmyexpense.constants.TrackMyExpenseConstants;

/**
 * 
 * @author Krishna
 *
 */
@Configuration
@PropertySource("classpath:/database/database.properties") // Load the database properties file
@ComponentScan(basePackages = {"com.dsk.trackmyexpense"})
@EnableJpaRepositories (basePackages={"com.dsk.trackmyexpense"}) // Activate Spring Data JPA repositories 
@EnableTransactionManagement
public class PersistenceConfig {

	@Autowired
    Environment env;
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(TrackMyExpenseConstants.DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(TrackMyExpenseConstants.DATABASE_URL));
		dataSource.setUsername(env.getProperty(TrackMyExpenseConstants.DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(TrackMyExpenseConstants.DATABASE_PASSWORD));
		
		return dataSource;
	 }
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		/* 
		 * We use a new Spring 3.1 feature that allows us to completely abstain from creating a persistence.xml file to declare the entity classes.
		 * This will trigger Spring to scan for classes annotated with @Entity and @MappedSuperclass and automatically add those to the JPA PersistenceUnit.
		 */
		entityManagerFactoryBean.setPackagesToScan("com.dsk.trackmyexpense");
		
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaProperties(additionalProperties());
		entityManagerFactoryBean.afterPropertiesSet();
		
		return entityManagerFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		
		return txManager;
	}
	
	Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("eclipselink.ddl-generation", "create-or-extend-tables");
	      properties.setProperty("eclipselink.weaving", "false");
	      // DDL will be generated and written to the database only.
	      properties.setProperty("eclipselink.ddl-generation.output-mode", "database");
	      properties.setProperty("eclipselink.logging.level", "FINE");
	      properties.setProperty("eclipselink.logging.file", "C:\\apps\\apache-tomcat-8.0.32\\logs\\eclipse-link.log");
	      
	      return properties;
	   }
	
}
