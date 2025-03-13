package com.udigo.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Spring Security 활성화
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (개발 중)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**","/reservations/**","/acm/**").permitAll() // 정적 리소스 접근 허용
                        .requestMatchers("/member/signup", "/member/api/**").permitAll() // 회원가입 관련 모든 요청 허용
                        .anyRequest().authenticated() // 그 외 요청은 로그인 필요
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
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호 암호화용 PasswordEncoder 빈 등록
    }
}
