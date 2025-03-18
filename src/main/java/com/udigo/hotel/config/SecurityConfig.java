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
                    auth.requestMatchers("/", "/auth/**", "/member/signup", "/auth/login").permitAll();
                    auth.requestMatchers("/css/**", "/js/**", "/image/**", "/reservations/**", "/acm/**", "/board/**").permitAll();

                    //  권한 설정
                    auth.requestMatchers("/member/useCoupon", "/changepassword").permitAll();
                    auth.requestMatchers("/search", "/hotel/**", "/regional-recommendations").permitAll();

                    //  게시판 관련 권한 설정
                    auth.requestMatchers("/board/notice", "/board/FAQ").permitAll();  // 공지사항 & FAQ는 모두 접근 가능
                    auth.requestMatchers("/board/ask/**").authenticated();  // 1:1 문의는 로그인 필요
                    auth.requestMatchers("/board/admin/**").hasRole("ADMIN");  // 관리자 전용

                    //  예약 관련 권한 설정
                    auth.requestMatchers("/reservations/list").permitAll();  // 예약 목록 조회는 가능
                    auth.requestMatchers("/reservations/**").authenticated();  // 예약 관련 기능은 로그인 필요

                    //  관리자 페이지 설정
                    auth.requestMatchers("/admin/**").hasRole("ADMIN");  // 관리자는 /admin/** 경로 접근 가능
                    auth.requestMatchers("/member/admin/**", "/adminList").hasRole("ADMIN");  // ✅ 관리자 전용 회원 관리 페이지 설정

                    // 기타 인증 필요 페이지
                    auth.requestMatchers("/cart", "/payList", "/payment").authenticated();
                    auth.requestMatchers("/member/mypage", "/member/myinfo").authenticated();

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
                // CSRF 설정 (필요한 경우 활성화)
                .csrf(csrf -> csrf.disable())
                // CustomUserDetailsService 설정
                .userDetailsService(customUserDetailsService);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}