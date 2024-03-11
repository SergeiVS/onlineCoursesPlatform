package core.dto.errors;

import java.util.Objects;

public class ErrorsDto {

    private ErrorCoding errorCode;

    private String message;

    public ErrorCoding getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public ErrorsDto(ErrorCoding errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorsDto errorsDto = (ErrorsDto) o;
        return errorCode == errorsDto.errorCode && Objects.equals(message, errorsDto.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, message);
    }

    @Override
    public String toString() {
        return "ErrorsDto{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
