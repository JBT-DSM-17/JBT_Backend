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
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    private final TokenGenerator tokenGenerator;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println(token);

            Jwt jwt = Jwts.parserBuilder()
                    .setSigningKey(tokenGenerator.getKey())
                    .build()
                    .parse(token);

            Claims claims = (Claims) jwt.getBody();

            if (claims.getExpiration().before(new Date())) {
                throw new GlobalException(HttpStatus.UNAUTHORIZED, "Expired JWT token");
            }

            if (claims.get("type") == "refresh") {
                throw new GlobalException(HttpStatus.UNAUTHORIZED, "No Refresh token");
            }

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            claims.getSubject(),
                            null,
                            new ArrayList<>()
                    )
            );
        }

        filterChain.doFilter(request, response);
    }
}
