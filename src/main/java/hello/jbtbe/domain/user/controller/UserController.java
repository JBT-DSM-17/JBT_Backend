package hello.jbtbe.domain.user.controller;

import hello.jbtbe.domain.user.dto.request.IntroduceRequest;
import hello.jbtbe.domain.user.dto.response.ProfileResponse;
import hello.jbtbe.domain.user.service.IntroduceService;
import hello.jbtbe.domain.user.service.MyProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final MyProfileService myProfileService;
    private final IntroduceService introduceService;

    @GetMapping
    public ProfileResponse readMyProfile(){
       return myProfileService.read();
    }

    @PatchMapping
    public void updateIntroduce(@RequestBody IntroduceRequest introduceRequest) {
        introduceService.updateIntroduce(introduceRequest);
    }
}
