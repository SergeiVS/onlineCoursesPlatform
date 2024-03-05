package services.validation.exeptions;

import java.io.IOException;

public class InputOutputException extends RuntimeException{

    IOException exception = new IOException("Input/Output failed");
}
