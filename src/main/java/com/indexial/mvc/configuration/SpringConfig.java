package com.indexial.mvc.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("com.indexial.mvc.*")
@PropertySource("classpath:constants.properties")
public class SpringConfig {

	@Value("${spring.db.url}")
	String DB_URL;
	@Value("${spring.db.uername}")
	String DB_USERNAME;
	@Value("${spring.db.password}")
	String DB_PASSWORD;
	@Value("${spring.db.driverclass}")
	String DB_DRIVER_CLASS;
	@Value("${spring.db.dialect}")
	String DB_DIALECT;
	@Value("${spring.db.package}")
	String DB_PACKAGE;
	@Value("${spring.db.show_sql}")
	String DB_SHOW_SQL;
	@Value("${spring.hibernate.db.hbm2ddl_auto}")
	String DB_HBM2DDL_AUTO;

	@Bean
	public BasicDataSource createDataSource() {
		BasicDataSource db = new BasicDataSource();
		db.setUrl(DB_URL);
		db.setUsername(DB_USERNAME);
		db.setPassword(DB_PASSWORD);
		db.setDriverClassName(DB_DRIVER_CLASS);
		return db;
	}

	@Bean
	public LocalSessionFactoryBean createSession() {
		LocalSessionFactoryBean sfactory = new LocalSessionFactoryBean();
		sfactory.setDataSource(createDataSource());
		sfactory.setPackagesToScan(DB_PACKAGE);
		sfactory.setHibernateProperties(createHbProp());
		return sfactory;
	}

	private Properties createHbProp() {
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, DB_DIALECT);
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put(Environment.SHOW_SQL, DB_SHOW_SQL);
		
		return prop;
	}

	@Bean
	public InternalResourceViewResolver createViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/");
		view.setSuffix(".jsp");
		return view;
	}

}
