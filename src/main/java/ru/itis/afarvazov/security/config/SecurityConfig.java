package ru.itis.afarvazov.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(@Qualifier("customUserDetailsService") UserDetailsService userDetailsService,
                          DataSource dataSource,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}
