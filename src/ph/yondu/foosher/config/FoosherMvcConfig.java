/**
 * 
 */
package ph.yondu.foosher.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author S.FORTUNATO
 *
 */
@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "ph.yondu.foosher")
public class FoosherMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//	@Bean(name = "viewResolver")
//	public InternalResourceViewResolver getViewResolver() {
//	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	    viewResolver.setPrefix("/WEB-INF/views/");
//	    viewResolver.setSuffix(".jsp");
//	    return viewResolver;
//	}
	
	@Bean(name="viewResolver")
	public UrlBasedViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	
	@Bean(name="tilesConfigurer")
	public TilesConfigurer getTilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/tiles/tiles-def.xml");
		return tilesConfigurer;
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
	    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
	    dataSource.setUser("root");
	    dataSource.setPassword("root");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("ph.yondu.foosher");
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "create");
		sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	}
	
}
