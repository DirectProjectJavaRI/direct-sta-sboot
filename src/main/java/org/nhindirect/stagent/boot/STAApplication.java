package org.nhindirect.stagent.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"org.nhindirect.gateway.springconfig", "org.nhindirect.gateway.streams", "org.nhind.xdm.springconfig", "org.nhindirect.stagent.springconfig", "org.nhind.xd.springconfig", "org.nhind.xd.streams"})
@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, 
		HibernateJpaAutoConfiguration.class, R2dbcAutoConfiguration.class})
public class STAApplication extends SpringBootServletInitializer
{
    public static void main(String[] args) 
    {
    	SpringApplication.run(STAApplication.class, args);
    }  
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{
	    return application.sources(STAApplication.class);
	}	    
}
