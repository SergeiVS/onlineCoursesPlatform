package services.validation.exeptions;

public class NullException extends RuntimeException {
    NullPointerException exception = new NullPointerException("Given value is null");
}
