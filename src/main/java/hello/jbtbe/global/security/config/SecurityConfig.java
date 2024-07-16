package hello.jbtbe.global.security.config;

import hello.jbtbe.domain.user.repository.UserRepository;
import hello.jbtbe.global.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChainConfig(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(it -> it.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.addAllowedOrigin("*");
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");

                    return config;
                }))

                .authorizeHttpRequests(
                        it -> {
                            it
                                    .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                                    .requestMatchers(HttpMethod.GET, "/auth/**").permitAll();
                            it.anyRequest().authenticated();
                        }
                )

                .addFilterBefore(
                        new JwtAuthenticationFilter(userRepository),
                        UsernamePasswordAuthenticationFilter.class
                )

                .build();
    }
}
