package services.validation.exeptions;

public class NumberException extends RuntimeException {
NumberFormatException exception = new NumberFormatException("The value is not a number");
}
