package hello.jbtbe.global.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(GlobalException.class)
    void handleGlobalException(final GlobalException ex, final HttpServletResponse response)
            throws IOException {
        response.setStatus(ex.getStatus().value());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ExceptionResponse(
                                response.getStatus(),
                                ex.getMessage()
                        )
                )
        );
    }
}
