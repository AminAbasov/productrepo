package az.spring.rest.springdatarest;

public enum ErrorCodeEnum {

    VALIDATION_ERROR(1001,"is not valid"),
    ARQUMENT_TYPE(1002,"arqument duz daxil edilmeyib");
    private final int code;

    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
