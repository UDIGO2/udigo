package com.udigo.hotel.config;

import com.udigo.hotel.member.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.udigo.hotel")
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    // 생성자 주입
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChainConfigure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/auth/**", "/member/signup", "/member/api/**", "/auth/login").permitAll();
                    auth.requestMatchers("/css/**", "/js/**", "/image/**", "/reservations/**", "/acm/**", "/board/**").permitAll();
                    auth.requestMatchers("/search", "/hotel/**", "/regional-recommendations").permitAll();
                    auth.requestMatchers("/cart", "/payment", "/payList").authenticated();
                    auth.requestMatchers("/mypage").authenticated();
                    auth.requestMatchers("/board/admin/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .anonymous(Customizer.withDefaults())
                .formLogin(login -> {
                    login.loginPage("/auth/login")
                            .loginProcessingUrl("/auth/login")
                            .usernameParameter("memberId")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/", true)
                            .failureUrl("/auth/login?error=true");
                })
                .logout(logout -> {
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                            .deleteCookies("JSESSIONID")
                            .invalidateHttpSession(true)
                            .logoutSuccessUrl("/");
                })
                .csrf(csrf -> csrf.disable())
                .userDetailsService(customUserDetailsService);  // CustomUserDetailsService 직접 지정

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}