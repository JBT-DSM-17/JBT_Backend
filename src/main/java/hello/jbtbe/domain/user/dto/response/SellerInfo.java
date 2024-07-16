package hello.jbtbe.domain.user.dto.response;

import hello.jbtbe.domain.user.entity.UserJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SellerInfo {
    private String nickname;
    private String introduce;

    public static SellerInfo from(UserJpaEntity user) {
        return new SellerInfo(
                user.getNickname(),
                user.getIntroduce()
        );
    }
}
