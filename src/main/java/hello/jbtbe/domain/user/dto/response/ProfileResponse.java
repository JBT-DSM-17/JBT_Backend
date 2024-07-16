package hello.jbtbe.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileResponse {
    private String nickname;
    private String userId;
    private String phone;
    private String introduce;
}
