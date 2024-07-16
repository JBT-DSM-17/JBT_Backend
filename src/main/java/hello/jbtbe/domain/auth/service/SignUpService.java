package hello.jbtbe.domain.auth.service;

import hello.jbtbe.domain.auth.dto.request.SignUpRequest;
import hello.jbtbe.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;

    public void signUp(SignUpRequest signUpRequest) {
    }
}
