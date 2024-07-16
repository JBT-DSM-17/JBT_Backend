package hello.jbtbe.global.security.jwt;

import hello.jbtbe.global.security.jwt.env.JwtProperties;
import hello.jbtbe.global.security.jwt.vo.TokenPair;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class TokenGenerator {

    private final JwtProperties jwtProperties;

    private Key key;

    public TokenPair generateToken(String username) {
        if (key == null) {
            key = new SecretKeySpec(jwtProperties.getSecret().getBytes(), SignatureAlgorithm.HS256.getJcaName());
        }

        return new TokenPair(
                generateAccessToken(username),
                generateRefreshToken(username)
        );
    }

    private String generateAccessToken(String username) {
        return "Bearer " + Jwts.builder()
                .signWith(key)
                .setSubject(username)
                .addClaims(Map.of("type", "access"))
                .setExpiration(new Date(new Date().getTime() + 60 * 60 * 3))
                .setIssuedAt(new Date())
                .compact();
    }

    private String generateRefreshToken(String username) {
        return "Bearer " + Jwts.builder()
                .signWith(key)
                .setSubject(username)
                .addClaims(Map.of("type", "refresh"))
                .setExpiration(new Date(new Date().getTime() + 60 * 60 * 10))
                .setIssuedAt(new Date())
                .compact();
    }
}
