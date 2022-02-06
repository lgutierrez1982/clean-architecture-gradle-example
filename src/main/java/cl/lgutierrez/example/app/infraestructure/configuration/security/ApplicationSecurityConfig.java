package cl.lgutierrez.example.app.infraestructure.configuration.security;

import cl.lgutierrez.example.app.infraestructure.auth.adapter.LoginAdapterRepository;
import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtConfig;
import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtSecretKey;
import cl.lgutierrez.example.app.infraestructure.auth.filter.CustomAuthenticationFilter;
import cl.lgutierrez.example.app.infraestructure.auth.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final LoginAdapterRepository loginAdapterRepository;
    private final JwtSecretKey jwtSecretKey;
    private final JwtConfig jwtConfig;

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     LoginAdapterRepository loginAdapterRepository,
                                     JwtSecretKey jwtSecretKey,
                                     JwtConfig jwtConfig,
                                     UserDetailsService userDetailsService,
                                     BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.loginAdapterRepository = loginAdapterRepository;
        this.jwtSecretKey = jwtSecretKey;
        this.jwtConfig = jwtConfig;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers( "/h2-console/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean(), jwtConfig, jwtSecretKey));
        http.addFilterBefore(new CustomAuthorizationFilter(jwtConfig, jwtSecretKey), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(loginAdapterRepository);
//        return provider;
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
