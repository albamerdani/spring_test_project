package springbootproject.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //@Value("${spring.application.username}")
    //private String username;
    //@Value("${spring.application.password}")
    //private String password;

    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;

/*
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    //.headers()
                    .antMatchers("/", "/punonjes", "/punonjes/*", "/departament",  "/departament/*", "/swagger-ui.html", "/v2/api-docs").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    //.loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }
*/
PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser(username).password(encoder.encode(password)).roles("USER");
        }

}
