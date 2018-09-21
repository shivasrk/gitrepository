package com.ecommerce.web;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.ecommerce.web.model"})
@EnableJpaRepositories(basePackages= {"com.ecommerce.web.model"})
public class PersistanceConfig {
	

	 @Bean
     public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername( "system" );
        dataSource.setPassword( "manager" );
        return dataSource;
     }		
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean =
				new LocalContainerEntityManagerFactoryBean();
		
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setPackagesToScan("com.ecommerce.web.model");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());		
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
	
	@Bean
	public Properties hibernateProperties()
	{
		Properties props = new Properties();
		props.put("hibernate.dialect	", "org.hibernate.diaelect.Oracle10gDialect");
		props.put("hibernate.hbm2ddl.auto", "create");
		props.put("show_sql", true);
		props.put("hibernate.max_fetch_depth",3);
		props.put("hibernate.jdbc.batch_size", 10);
		props.put("hibernate.jdbc.fetch_size", 50);
		return props;
	}
	
	@Bean
	public PlatformTransactionManager paltformTransactionManager() {
	JpaTransactionManager txm=	new JpaTransactionManager();
	txm.setEntityManagerFactory(entityManagerFactory());
	return txm;

}
}
