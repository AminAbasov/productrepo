package az.spring.rest.springdatarest.exception;

import az.spring.rest.springdatarest.ErrorCodeEnum;
import az.spring.rest.springdatarest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse validationHandler(MethodArgumentNotValidException e){

        String paramMessage=e.getBindingResult().getFieldError().getField();

        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(paramMessage + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse arqumentTypeHandler(MethodArgumentTypeMismatchException e){

        return ErrorResponse.builder()
                .code(ErrorCodeEnum.ARQUMENT_TYPE.getCode())
                .message(ErrorCodeEnum.ARQUMENT_TYPE.getMessage())
                .build();
    }
}
