package com.k1.spitter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

// This configuration creates a Servlet Filter known as the
// springSecurityFilterChain which is responsible for all the security
// (protecting the application URLs, validating submitted username and
// passwords, redirecting to the log in form, etc) within our application.
public class SecurityMvcConfiguration extends WebSecurityConfigurerAdapter {

	// Method configureGlobalSecurity in above class configures
	// AuthenticationManagerBuilder with user credentials and allowed roles.
	// This AuthenticationManagerBuilder creates AuthenticationManager which is
	// responsible for processing any authentication request. Notice that in
	// above example, we have used in-memory authentication while you are free
	// to choose from JDBC, LDAP and other authentications.
	@Autowired
	public void configureGlobalSecutiry(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("one").password("111").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("dba").roles("ADMIN", "DBA");

	}

	// The overridden Method Configure configures HttpSecurity which allows
	// configuring web based security for specific http requests. By default it
	// will be applied to all requests, but can be restricted using
	// requestMatcher(RequestMatcher)/antMathchers or other similar methods
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URL’s ‘/’ & ‘/home’ are not secured, anyone can access them
				.antMatchers("/", "/home").permitAll()

				// URL ‘/admin/**’ can only be accessed by someone who have
				// ADMIN role
				.antMatchers("/admin/**").access("hasRole('ADMIN')")

				// URL ‘/db/**’ can only be accessed by someone who have both
				// ADMIN and DBA roles
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")

				// Method formLogin provides support for form based
				// authentication and will generate a default form asking for
				// user credentials
				.and().formLogin()

				// We have also used exceptionHandling().accessDeniedPage()
				// which in this case will catch all 403 [http access denied]
				// exceptions and display our user defined page instead of
				// showing default HTTP 403 page [ which is not so helpful
				// anyway]
				.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}


///// FOR XML //////////////////////

// <beans:beans xmlns="http://www.springframework.org/schema/security"
// xmlns:beans="http://www.springframework.org/schema/beans"
// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// xsi:schemaLocation="http://www.springframework.org/schema/beans
// http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
// http://www.springframework.org/schema/security
// http://www.springframework.org/schema/security/spring-security-4.0.xsd">
//
// <http auto-config="true" >
// <intercept-url pattern="/" access="permitAll" />
// <intercept-url pattern="/home" access="permitAll" />
// <intercept-url pattern="/admin**" access="hasRole('ADMIN')" />
// <intercept-url pattern="/dba**" access="hasRole('ADMIN') and hasRole('DBA')"
// />
// <form-login authentication-failure-url="/Access_Denied" />
// </http>
//
// <authentication-manager >
// <authentication-provider>
// <user-service>
// <user name="bill" password="abc123" authorities="ROLE_USER" />
// <user name="admin" password="root123" authorities="ROLE_ADMIN" />
// <user name="dba" password="root123" authorities="ROLE_ADMIN,ROLE_DBA" />
// </user-service>
// </authentication-provider>
// </authentication-manager>
//
//
// </beans:beans>