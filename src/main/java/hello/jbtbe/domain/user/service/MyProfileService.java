package hello.jbtbe.domain.user.service;

import hello.jbtbe.domain.user.dto.response.ProfileResponse;
import hello.jbtbe.domain.user.entity.UserJpaEntity;
import hello.jbtbe.global.security.currentuser.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyProfileService {
    private final CurrentUser currentUser;

    public ProfileResponse read(){
        UserJpaEntity userJpaEntity = currentUser.get();

        return new ProfileResponse(
                userJpaEntity.getNickname(),
                userJpaEntity.getUsername(),
                userJpaEntity.getPhone(),
                userJpaEntity.getIntroduce());
    }
}
