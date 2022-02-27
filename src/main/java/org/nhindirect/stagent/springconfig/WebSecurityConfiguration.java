package org.nhindirect.stagent.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
   @Override
   public void configure(WebSecurity web) throws Exception
   {
      web.ignoring().antMatchers("/actuator/**");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
      http.authorizeRequests().antMatchers("/").permitAll();

      http.csrf().disable();
   }
}

