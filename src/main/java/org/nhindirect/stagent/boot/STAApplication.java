package org.nhindirect.stagent.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.r2dbc.autoconfigure.R2dbcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = { R2dbcAutoConfiguration.class})
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
