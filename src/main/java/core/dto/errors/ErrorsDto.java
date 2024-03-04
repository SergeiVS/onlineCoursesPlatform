package core.dto.errors;

public class ErrorsDto {

    private ErrorCoding errorCode;

    private String message;

    public ErrorsDto(ErrorCoding errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public void setErrorCode(ErrorCoding errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorsDto{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
