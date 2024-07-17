package hello.jbtbe.domain.auth.controller;

import hello.jbtbe.domain.auth.dto.request.LoginRequest;
import hello.jbtbe.domain.auth.dto.request.SignUpRequest;
import hello.jbtbe.domain.auth.dto.response.LoginResponse;
import hello.jbtbe.domain.auth.service.LoginService;
import hello.jbtbe.domain.auth.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public void signUp(
            @Valid
            @RequestBody
            SignUpRequest signUpRequest
    ) {
        signUpService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid
            @RequestBody
            LoginRequest loginRequest
    ) {
        return loginService.login(loginRequest);
    }
}
