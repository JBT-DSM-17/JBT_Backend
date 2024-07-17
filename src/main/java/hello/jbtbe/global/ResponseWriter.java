package hello.jbtbe.global;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.jbtbe.global.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResponseWriter {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void writeExceptionResponse(final HttpServletResponse response, final ExceptionResponse exceptionResponse) {
        response.setStatus(exceptionResponse.status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        exceptionResponse
                )
        );
    }
}
