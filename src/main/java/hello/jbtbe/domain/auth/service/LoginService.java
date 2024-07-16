package hello.jbtbe.domain.auth.service;

import hello.jbtbe.domain.auth.dto.request.LoginRequest;
import hello.jbtbe.domain.auth.dto.response.LoginResponse;
import hello.jbtbe.domain.user.entity.UserJpaEntity;
import hello.jbtbe.domain.user.repository.UserRepository;
import hello.jbtbe.global.exception.GlobalException;
import hello.jbtbe.global.security.jwt.TokenGenerator;
import hello.jbtbe.global.security.jwt.vo.TokenPair;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class LoginService {
    private final UserRepository userRepository;

    private final TokenGenerator tokenGenerator;


    public LoginResponse login(LoginRequest loginRequest) {
        UserJpaEntity user = userRepository.findByUsername(loginRequest.getUserId())
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, "USER NOT FOUND"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new GlobalException(HttpStatus.UNAUTHORIZED, "PASSWORD MISSMATCH");
        }

        TokenPair tokenPair = tokenGenerator.generateToken(user.getUsername());

        return new LoginResponse(
                tokenPair.getAccessToken(),
                tokenPair.getRefreshToken()
        );
    }
}
