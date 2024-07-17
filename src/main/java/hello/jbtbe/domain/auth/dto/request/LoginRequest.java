package hello.jbtbe.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @Size(min = 3, max = 20)
    @NotBlank
    private String userId;

    @Size(min = 5, max = 30)
    @NotBlank
    private String password;
}
