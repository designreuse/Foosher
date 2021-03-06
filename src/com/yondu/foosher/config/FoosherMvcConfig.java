/**
 * 
 */
package com.yondu.foosher.config;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author S.FORTUNATO
 *
 */
@Configuration
@ComponentScan(basePackages = "com.yondu.foosher")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import({FoosherPropertiesConfig.class, FoosherSecurityConfig.class})
public class FoosherMvcConfig extends WebMvcConfigurerAdapter {
	
	@Value("${db.url}") private String dbUrl;
	@Value("${db.user}") private String dbUser;
	@Value("${db.password}") private String dbPass;
	@Value("${db.jdbc.driver}") private String dbJdbcDriver;
	@Value("${db.acquire.increment}") private Integer dbAcquireIncrement;
	@Value("${db.min.pool.size}") private Integer dbMinPoolSize;
	@Value("${db.max.pool.size}") private Integer dbMaxPoolSize;
	@Value("${db.idle.connection.test.period}") private Integer dbIdleConnectionTestPeriod;
	@Value("${db.max.idle.time.excess.connections}") private Integer dbMaxIdleTimeExcessConnections;
	@Value("${db.package.to.scan}") private String dbPackageToScan;
	@Value("${db.show.sql}") private String dbShowSql;
	@Value("${db.hbm2ddl.auto}") private String dbHbm2DdlAuto;
	@Value("${db.sql.dialect}") private String dbDialect;
	@Value("${file.max.upload.size}") private Integer maxUploadSize;
	@Value("${message.source.base.name}") private String messageSourceBaseName;
	@Value("${mail.host}") private String mailHost;
	@Value("${mail.port}") private Integer mailPort;
	@Value("${mail.username}") private String mailUsername;
	@Value("${mail.password}") private String mailPassword;
	@Value("${mail.smtp.auth}") private Boolean mailSmtpAuth;
	@Value("${mail.smtp.starttls.enable}") private Boolean mailSmtpStarttlsEnable;
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	@Bean(name="jasperViewResolver")
	public JasperReportsViewResolver getJasperReportsViewResolver() {
	  JasperReportsViewResolver viewResolver = new JasperReportsViewResolver();
	  viewResolver.setPrefix("/WEB-INF/jasper/");
	  viewResolver.setSuffix(".jasper");
	  viewResolver.setReportDataKey("datasource");
//	  viewResolver.setViewNames("rpt_*");
	  viewResolver.setViewClass(JasperReportsMultiFormatView.class);
	  viewResolver.setOrder(1);
	  return viewResolver;
	}  
	
	@Bean(name="viewResolver")
	public UrlBasedViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(0);
		return viewResolver;
	}
	
	@Bean(name="tilesConfigurer")
	public TilesConfigurer getTilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/tiles/*.xml");
		tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(dbJdbcDriver);
	    dataSource.setJdbcUrl(dbUrl);
	    dataSource.setUser(dbUser);
	    dataSource.setPassword(dbPass);
	    
	    dataSource.setAcquireIncrement(dbAcquireIncrement);
	    dataSource.setMinPoolSize(dbMinPoolSize);
	    dataSource.setMaxPoolSize(dbMaxPoolSize);
	    dataSource.setIdleConnectionTestPeriod(dbIdleConnectionTestPeriod);
	    dataSource.setMaxIdleTimeExcessConnections(dbMaxIdleTimeExcessConnections);
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages(dbPackageToScan);
		sessionBuilder.setProperty("hibernate.show_sql", dbShowSql);
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", dbHbm2DdlAuto);
		sessionBuilder.setProperty("hibernate.dialect", dbDialect);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getMultipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(maxUploadSize);
		return commonsMultipartResolver;
	}
	
	@Bean(name="messageSource")
	public MessageSource getMessageSource(){
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename(messageSourceBaseName);
		return resourceBundleMessageSource;
	}
	
	@Bean(name="mailSender")
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailHost);
		mailSender.setPort(mailPort);
		mailSender.setUsername(mailUsername);
		mailSender.setPassword(mailPassword);
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", mailSmtpAuth);
		javaMailProperties.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	
}
