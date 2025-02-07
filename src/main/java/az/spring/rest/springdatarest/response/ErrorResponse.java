package az.spring.rest.springdatarest.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private final int code;

    private final String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
