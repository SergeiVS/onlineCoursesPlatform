package services.Utils.fileReder;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReader <T> {

    T readFromFile(String path) throws IOException;
}
