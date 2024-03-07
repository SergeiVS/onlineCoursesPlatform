package services.Utils.fileWriter;

import java.io.IOException;

public interface IntoFileWriter<T> {
    void saveIntoFile(String path, T objForSave) throws IOException, NullPointerException;
}
