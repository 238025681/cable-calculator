	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SiteSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService(this.userService)
//        .passwordEncoder(this.getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http.authorizeRequests().anyRequest().permitAll()
				.and()
				.csrf().disable();// - disable security;

//        http
//                .authorizeRequests()
//                .antMatchers("/", "/register", "/js/**", "/css/**").permitAll()
//                .antMatchers("/user/**").access("hasRole('USER') OR hasRole('ADMIN')")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//                .logout().logoutSuccessUrl("/login?logout").permitAll()
//                .and()
//                .rememberMe()
//                .rememberMeParameter("remember")
//                .key("The Wheel of Time")
//                .rememberMeCookieName("rememberMeCookie")
//                .tokenValiditySeconds(10000)
//                .and()
//                .exceptionHandling().accessDeniedPage("/unauthorized")
//                .and()
//                .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
