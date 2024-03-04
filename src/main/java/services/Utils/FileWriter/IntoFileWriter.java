package services.Utils.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IntoFileWriter<T> {
    boolean saveIntoFile(String path, T objForSave) throws IOException;
}
