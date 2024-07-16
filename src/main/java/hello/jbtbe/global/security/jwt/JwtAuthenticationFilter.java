package hello.jbtbe.global.security.jwt;

import hello.jbtbe.domain.user.repository.UserRepository;
import hello.jbtbe.global.exception.GlobalException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            Jwt jwt = Jwts.parserBuilder()
                    .requireAudience("string")
                    .build()
                    .parse(token);

            Claims claims = (Claims) jwt.getBody();

            if (claims.getExpiration().after(new Date())) {
                throw new GlobalException(HttpStatus.UNAUTHORIZED, "Expired JWT token");
            }

            if (claims.get("type") == "refresh") {
                throw new GlobalException(HttpStatus.UNAUTHORIZED, "No Refresh token");
            }

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            claims.getSubject(),
                            null
                    )
            );
        }

        filterChain.doFilter(request, response);
    }
}
