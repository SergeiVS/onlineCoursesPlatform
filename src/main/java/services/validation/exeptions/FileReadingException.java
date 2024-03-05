package services.validation.exeptions;

import java.io.FileNotFoundException;

public class FileReadingException extends RuntimeException{

    FileNotFoundException exception = new FileNotFoundException("File not found");
}
