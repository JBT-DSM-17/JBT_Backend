package hello.jbtbe.domain.auth.service;

import hello.jbtbe.domain.auth.dto.request.SignUpRequest;
import hello.jbtbe.domain.user.entity.UserJpaEntity;
import hello.jbtbe.domain.user.repository.UserRepository;
import hello.jbtbe.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;

    public void signUp(SignUpRequest signUpRequest) {
        Optional<UserJpaEntity> userJpaEntity = userRepository.findByUsername(signUpRequest.getUserId());

        if (userJpaEntity.isPresent()) {
            throw new GlobalException(HttpStatus.CONFLICT, "User already exists");
        }

        userRepository.save(
                UserJpaEntity.builder()
                        .username(signUpRequest.getUserId())
                        .nickname(signUpRequest.getNickname())
                        .phone(signUpRequest.getPhone())
                        .password(signUpRequest.getPassword())
                        .introduce(null)
                        .build());
    }

}
