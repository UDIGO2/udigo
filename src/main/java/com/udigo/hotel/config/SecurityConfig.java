package com.udigo.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // Spring Security 활성화
@ComponentScan(basePackages = "com.udigo.hotel")

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/cart","/payment","/payList", "/css/**", "/js/**", "/image/**","/reservations/**","/acm/**","/board/**").permitAll() // 메인 페이지와 정적 리소스 접근 허용
                        // 결제페이지 실제 진행 시, 로그인 후에 되도록 없애기
                        .requestMatchers("/member/signup", "/member/api/**").permitAll() // 회원가입 관련 모든 요청 허용
                        .anyRequest().authenticated() // 나머지는 로그인 필요
                )
                .formLogin(login -> login
                        .loginPage("/login") // 로그인 페이지 지정
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 메인 페이지로 이동
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 URL 지정
                        .logoutSuccessUrl("/") // 로그아웃 후 메인 페이지 이동
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // CSRF 보호 비활성화 (개발 중)


        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChainConfigure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> {
            // 🔹 회원가입 및 로그인 페이지는 인증 없이 접근 허용
            auth.requestMatchers("/member/signup", "/member/api/**", "/auth/login").permitAll();
            auth.requestMatchers("/", "/cart", "/payment", "/payList").permitAll();
            auth.requestMatchers("/css/**", "/js/**", "/image/**", "/reservations/**", "/acm/**").permitAll(); // 정적 리소스 허용
            auth.anyRequest().authenticated(); // 나머지는 로그인 필요
        }).formLogin(login -> {
            // 🔹 로그인 페이지 설정
            login.loginPage("/auth/login")  // 로그인 페이지 URL
                    .usernameParameter("login_id")  // Spring Security 기본 필드명(`username`)이 아니라면 변경 필요
                    .passwordParameter("password")
                    .defaultSuccessUrl("/main", true)  // 로그인 성공 후 이동할 페이지
                    .failureUrl("/auth/login?error=true");  // 로그인 실패 시 error 파라미터 추가
        }).logout(logout -> {
            // 🔹 로그아웃 설정
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/auth/login"); // 로그아웃 후 로그인 페이지로 이동
        }).sessionManagement(session -> {
            // 🔹 세션 관리
            session.invalidSessionUrl("/auth/login")  // 세션 만료 시 로그인 페이지로 이동
                    .maximumSessions(1);  // 동시 로그인 제한
        }).csrf(csrf -> csrf.disable());  // 🔹 CSRF 비활성화 (필요한 경우 활성화 가능)

        return http.build();
    }
}
