package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration          // 宣告這是設定類別（Configuration class）
@EnableWebSecurity      // 啟用 Spring Security 的 Web 安全功能
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // ① CSRF 保護
            .csrf(csrf -> csrf.disable())
            // ⚠️ 教學用途才關閉 CSRF，正式環境 Thymeleaf 會自動處理，
            //    可改為 .csrf(Customizer.withDefaults()) 保留保護

            // ② 請求授權規則
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/register").permitAll()  // 這些路徑不需登入
                .anyRequest().authenticated()                        // 其他全部需要登入
            )

            // ③ 表單登入設定
            .formLogin(form -> form
                .loginPage("/login")                    // 自訂登入頁面的路徑
                .loginProcessingUrl("/login")           // 表單 POST 送出的目標（Spring Security 攔截）
                .defaultSuccessUrl("/welcome", true)    // 登入成功後跳轉（true = 強制跳轉，不管之前在哪頁）
                .failureUrl("/login?error=true")        // 登入失敗後跳轉
                .permitAll()
            )

            // ④ 登出設定
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // 登出路徑（預設是 POST /logout）
                .logoutSuccessUrl("/login?logout=true")   // 登出成功後跳轉
                .invalidateHttpSession(true)              // 明確清除 Session（會話）
                .deleteCookies("JSESSIONID")              // 清除 Cookie
                .permitAll()
            );

        return http.build();
    }

    // 密碼加密器：使用 BCrypt 演算法
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // BCrypt 每次加密結果都不同（加了 salt），但 matches() 仍能驗證
    }
}
