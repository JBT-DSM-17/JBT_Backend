package hello.jbtbe.domain.auth.controller;

import hello.jbtbe.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final SignUpService signUpService;
}
