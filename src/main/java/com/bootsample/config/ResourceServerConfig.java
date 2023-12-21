package com.bootsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig{
    

    @Autowired
    private JwtExceptionFilter JwtExceptionFilter;

    


    //private static final String[] SWAGGER_PATHS = {"/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/swagger-ui/**"};
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                //.requestMatchers(SWAGGER_PATHS).permitAll()
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer()
            .authenticationEntryPoint(new CustomOAuth2AuthenticationEntryPoint())
            .jwt();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
     // antMatchers 부분도 deprecated 되어 requestMatchers로 대체
        return (web) -> web.ignoring().requestMatchers("/v2/api-docs","/v1/api-docs","/v3/api-docs/**" ,"/swagger-resources/**",
                "/swagger-ui/index.html", "/swagger-ui/**", "/v3/auth/token");
    }
}


