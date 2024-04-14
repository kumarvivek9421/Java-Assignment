package net.journalevents.payload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails normalDetails= User.withUsername("Vivek")
//                                    .password(passwordEncoder()
//                                            .encode("vivek123"))
//                                                .roles("NORMAL")
//                                                    .build();
//
//        UserDetails adminDetails= User.withUsername("rahul")
//                                    .password(passwordEncoder()
//                                            .encode("rahul123"))
//                                                .roles("ADMIN")
//                                                    .build();
//
//        InMemoryUserDetailsManager inMemoryUserDetailsManager= new InMemoryUserDetailsManager(normalDetails, adminDetails);
//
//        return inMemoryUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/event/api/admin").hasRole("ADMIN")
//                .requestMatchers("/event/api/normal").hasRole("NORMAL")
//                .requestMatchers("/event/api/public").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//
//
//        return new HttpSecurity().build();
//    }
}
