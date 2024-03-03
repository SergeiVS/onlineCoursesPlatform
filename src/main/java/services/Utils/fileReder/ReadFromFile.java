package services.Utils.fileReder;

import java.io.IOException;

public interface ReadFromFile<T, E> {

    T readFromFile(String path, E proofValue) throws IOException;
}
