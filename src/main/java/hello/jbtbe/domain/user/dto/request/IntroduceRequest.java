package hello.jbtbe.domain.user.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IntroduceRequest {
    @Size(min = 1, max = 300)
    private String introduce;
}
