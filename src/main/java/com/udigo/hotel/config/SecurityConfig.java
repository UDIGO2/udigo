package com.udigo.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // Spring Security 활성화
@ComponentScan(basePackages = "com.udigo.hotel")

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/cart","/payment","/payList", "/css/**", "/js/**", "/image/**","/reservations/**","/acm/**").permitAll() // 메인 페이지와 정적 리소스 접근 허용
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
        return new BCryptPasswordEncoder(); // 비밀번호 암호화용 PasswordEncoder 빈 등록
    }
}
