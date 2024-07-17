package hello.jbtbe.global.security.access;

import hello.jbtbe.global.ResponseWriter;
import hello.jbtbe.global.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ResponseWriter responseWriter;

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) {
        accessDeniedException.printStackTrace();

        responseWriter.writeExceptionResponse(
                response,
                new ExceptionResponse(
                        response.getStatus(),
                        accessDeniedException.getMessage()
                )
        );
    }
}
