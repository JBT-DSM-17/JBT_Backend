package hello.jbtbe.global.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.io.IOException;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(GlobalException.class)
    void handleGlobalException(final GlobalException ex, final HttpServletResponse response)
            throws IOException {
        writeResponse(
                new ExceptionResponse(
                        ex.getStatus().value(),
                        ex.getMessage()
                ),
                response
        );
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    void handleHandlerMethodValidationException(final HandlerMethodValidationException ex, final HttpServletResponse response)
            throws IOException {
        writeResponse(
                new ExceptionResponse(
                        400,
                        ex.getMessage()
                ),
                response
        );
    }

    @ExceptionHandler(Exception.class)
    void handleException(final Exception ex, final HttpServletResponse response) throws IOException {
        ex.printStackTrace();
        writeResponse(
                new ExceptionResponse(
                        500,
                        ex.getMessage()
                ),
                response
        );
    }

    private void writeResponse(final ExceptionResponse vo, final HttpServletResponse response) throws IOException {
        response.setStatus(vo.status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(
                objectMapper.writeValueAsString(vo)
        );
    }
}
