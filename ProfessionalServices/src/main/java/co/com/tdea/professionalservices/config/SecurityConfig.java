package co.com.tdea.professionalservices.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author andreslo
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    static final Logger logger = LogManager.getLogger(SecurityConfig.class);

    static final String[] AUTH_WHITELIST = {
             // -- login
            "/**/login",
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /**http//.addFilterAfter(AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.OPTIONS, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.PUT, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.DELETE, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.HEAD, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.PATCH, AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .csrf(
                        csrf ->
                                csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .headers(
                        headers ->
                                headers
                                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin
                                        )
                                        .httpStrictTransportSecurity(
                                                hsts ->
                                                        hsts.maxAgeInSeconds(31536000)
                                                                .preload(true)
                                                                .includeSubDomains(true)
                                        )
                );
        http.headers().frameOptions().disable();**/
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.OPTIONS, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.PUT, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.DELETE, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.HEAD, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.PATCH, AUTH_WHITELIST).permitAll()
                .and().cors();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

    }


}
