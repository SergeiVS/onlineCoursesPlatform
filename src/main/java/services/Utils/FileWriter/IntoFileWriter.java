package services.Utils.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IntoFileWriter<T> {
    void saveIntoFile(String path, T objForSave) throws IOException, NullPointerException;
}
