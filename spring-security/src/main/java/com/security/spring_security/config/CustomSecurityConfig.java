package com.security.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author sahil.sharma
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class CustomSecurityConfig {

  final DataSource dataSource;

  public CustomSecurityConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    //http.formLogin(withDefaults());
    http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user1 = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
    UserDetails user2 = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();


    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    if (!jdbcUserDetailsManager.userExists(user1.getUsername())) {
        jdbcUserDetailsManager.createUser(user1);
    }
    if (!jdbcUserDetailsManager.userExists(user2.getUsername())) {
        jdbcUserDetailsManager.createUser(user2);
    }
    return jdbcUserDetailsManager;
    //return new InMemoryUserDetailsManager(user1, user2);
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
