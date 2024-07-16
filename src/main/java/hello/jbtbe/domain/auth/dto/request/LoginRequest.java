package hello.jbtbe.domain.auth.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @Size(min = 3, max = 20)
    private String userId;

    @Size(min = 5, max = 30)
    private String password;
}
