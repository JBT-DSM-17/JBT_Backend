package hello.jbtbe.global.security.jwt.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenPair {

    private String accessToken;

    private String refreshToken;
}