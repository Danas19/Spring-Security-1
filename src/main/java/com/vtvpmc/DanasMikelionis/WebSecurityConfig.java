package com.vtvpmc.DanasMikelionis;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	Set<UserDetails> users = new HashSet<UserDetails>();
    	
    	UserDetails admin1 =
    			User.withDefaultPasswordEncoder()
    			.username("Mantas")
    			.password("1025B")
    			.roles("USER", "ADMIN")
    			.build();
    	
        UserDetails admin2 =
             User.withDefaultPasswordEncoder()
                .username("userAdmin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                   .username("Petras")
                   .password("slaptaz_dis")
                   .roles("USER")
                   .build();
        
        users.add(admin1);
        users.add(admin2);
        users.add(user3);
        
        return new InMemoryUserDetailsManager(users);
    }
}
