package hello.jbtbe.global.security.currentuser;

import hello.jbtbe.domain.user.entity.UserJpaEntity;
import hello.jbtbe.domain.user.repository.UserRepository;
import hello.jbtbe.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CurrentUser {

    private final UserRepository userRepository;

    UserJpaEntity get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "WHAT?");
        }

        return userRepository.findByUsername((String) authentication.getPrincipal())
                .orElseThrow(() -> new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "WHAT?"));
    }
}
