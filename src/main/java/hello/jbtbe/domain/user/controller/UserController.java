package hello.jbtbe.domain.user.controller;

import hello.jbtbe.domain.user.dto.response.ProfileResponse;
import hello.jbtbe.domain.user.service.MyProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final MyProfileService myProfileService;

    @GetMapping
    public ProfileResponse readMyProfile(){
       return myProfileService.read();
    }
}
