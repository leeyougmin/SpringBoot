package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.common.Url;
import com.example.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** The custom user details service. */
	@Autowired 
    private CustomUserDetailsService customUserDetailsService;

	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()   // Any Request has Auth Check
        .and()
            .formLogin()
            .loginPage( Url.AUTH.LOGIN_JSP )
            .loginProcessingUrl( Url.AUTH.PROC )
            .successHandler(null)
            .failureHandler(null)
            .usernameParameter("id")
            .passwordParameter("pw")
        .and()
            .logout()
            .logoutUrl( Url.AUTH.LOG_OUT )
            .logoutSuccessUrl( Url.AUTH.LOGIN )
            .invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
        .and()
            .sessionManagement()
            .maximumSessions(3)
            .expiredUrl( Url.AUTH.LOGIN )
            .maxSessionsPreventsLogin(true)

        ;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    private AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
        impl.setUserDetailsService(customUserDetailsService);
		impl.setPasswordEncoder(new BCryptPasswordEncoder());
		impl.setHideUserNotFoundExceptions(false);
		return impl;
    }

}
