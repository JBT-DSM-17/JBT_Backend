package hello.jbtbe.global.exception;

import hello.jbtbe.global.ResponseWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.io.IOException;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ResponseWriter responseWriter;

    @ExceptionHandler(GlobalException.class)
    void handleGlobalException(final GlobalException ex, final HttpServletResponse response)
            throws IOException {
        responseWriter.writeExceptionResponse(
                response,
                new ExceptionResponse(
                        ex.getStatus().value(),
                        ex.getMessage()
                )
        );
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    void handleHandlerMethodValidationException(final HandlerMethodValidationException ex, final HttpServletResponse response)
            throws IOException {
        responseWriter.writeExceptionResponse(
                response,
                new ExceptionResponse(
                        400,
                        ex.getMessage()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    void handleException(final Exception ex, final HttpServletResponse response) throws IOException {
        ex.printStackTrace();
        responseWriter.writeExceptionResponse(
                response,
                new ExceptionResponse(
                        500,
                        ex.getMessage()
                )
        );
    }
}
