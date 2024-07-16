package hello.jbtbe.global.security.jwt;

import hello.jbtbe.global.security.jwt.vo.TokenPair;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class TokenGenerator {

    public TokenPair generateToken(String username) {
        return new TokenPair(
                generateAccessToken(username),
                generateRefreshToken(username)
        );
    }

    private String generateAccessToken(String username) {
        return "Bearer " + Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of("type", "access"))
                .setExpiration(new Date(new Date().getTime() + 60 * 60 * 3))
                .setIssuedAt(new Date())
                .compact();
    }

    private String generateRefreshToken(String username) {
        return "Bearer " + Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of("type", "refresh"))
                .setExpiration(new Date(new Date().getTime() + 60 * 60 * 10))
                .setIssuedAt(new Date())
                .compact();
    }
}
