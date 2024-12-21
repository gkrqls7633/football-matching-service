package com.mateam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static javax.management.Query.and;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/", "/login", "/admin/login").permitAll()
////                        .requestMatchers("/admin").hasRole("ADMIN")
////                        .anyRequest().authenticated()
////                )
////                .csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/", "/login", "/public/**").permitAll()  // 로그인 페이지와 공개 페이지는 모두 허용
                    .antMatchers("/admin/**").hasRole("ADMIN")  // /admin/** 경로는 ADMIN 권한을 가진 사용자만 접근 가능
                    .anyRequest().authenticated()  // 나머지 요청은 인증된 사용자만 접근 가능
                .and()
                    .formLogin()
                    .loginPage("/login")  // 로그인 페이지 URL 설정
                    .loginProcessingUrl("/login")  // 로그인 처리 URL 설정
                    .defaultSuccessUrl("/match/main", true)  // 로그인 성공 후 리디렉션할 URL 설정
                    .failureUrl("/login?error=true")  // 로그인 실패 시 리디렉션할 URL 설정
                .and()
                    .logout()
                    .logoutUrl("/logout")  // 로그아웃 URL 설정
                    .logoutSuccessUrl("/login?logout=true")  // 로그아웃 후 리디렉션할 URL 설정
                    .invalidateHttpSession(true)  // 세션 무효화 설정
                    .deleteCookies("JSESSIONID")  // 세션 쿠키 삭제
                .and()
                    .csrf().disable();  // CSRF 보호 비활성화 (비추천)

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 안전한 비밀번호 인코딩 방식
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // In-memory 사용자 설정 (실제 프로젝트에서는 DB 등에서 사용자 정보를 가져오도록 구현)
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("password")) // 비밀번호 인코딩
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin123")) // 비밀번호 인코딩
                .roles("ADMIN")
                .build());
        return manager;
    }



}
