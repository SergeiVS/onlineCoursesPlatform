package services.Utils.fileReder;

import java.io.IOException;

public interface ReadFromFile<T> {

    T readFromFile(String path) throws IOException;
}
