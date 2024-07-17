package hello.jbtbe.domain.user.controller;

import hello.jbtbe.domain.user.dto.request.IntroduceRequest;
import hello.jbtbe.domain.user.dto.response.ProfileResponse;
import hello.jbtbe.domain.user.service.IntroduceService;
import hello.jbtbe.domain.user.service.MyProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final MyProfileService myProfileService;
    private final IntroduceService introduceService;

    @GetMapping
    public ProfileResponse readMyProfile() {
        return myProfileService.read();
    }

    @PatchMapping
    public void updateIntroduce(
            @Valid
            @RequestBody
            IntroduceRequest introduceRequest
    ) {
        introduceService.updateIntroduce(introduceRequest);
    }
}
