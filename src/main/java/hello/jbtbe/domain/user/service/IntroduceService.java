package hello.jbtbe.domain.user.service;


import hello.jbtbe.domain.user.dto.request.IntroduceRequest;
import hello.jbtbe.domain.user.entity.UserJpaEntity;
import hello.jbtbe.global.security.currentuser.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class IntroduceService {
    private final CurrentUser currentUser;

    public void updateIntroduce(IntroduceRequest introduceRequest) {
        UserJpaEntity userJpaEntity = currentUser.get();

        userJpaEntity.setIntroduce(introduceRequest.getIntroduce());
    }
}
