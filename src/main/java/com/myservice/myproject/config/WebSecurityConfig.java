package com.myservice.myproject.config;

//import com.myservice.myproject.config.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
//    private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

    private static final String[] WHITE_LIST_USER={
            "/hello", "/register", "/sendVerificationToken*","/verifyUser*"
    };


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
//                .antMatchers("/login","/home","/home/*").permitAll()
//                .antMatchers("/static/**", "/dist/**", "/css/**", "/fonts/**", "/js/**", "/images/**", "/ie8-panel/**").permitAll()
                .antMatchers(WHITE_LIST_USER).permitAll()
//                .anyRequest().authenticated()
//                .antMatchers("/api/**").authenticated()
//                .and()
//                .oauth2Login(oauth2login ->
//                        oauth2login.loginPage("/oauth2/authorization/api-client-oidc"))
//                .oauth2Client(Customizer.withDefaults())
        ;
//                .and().formLogin().loginPage("/login").permitAll()
//                .successForwardUrl("/loginsuccess")
//                .and().logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login").permitAll()
//                .and().exceptionHandling().accessDeniedHandler(loggingAccessDeniedHandler);

        return http.build();
    }

}
