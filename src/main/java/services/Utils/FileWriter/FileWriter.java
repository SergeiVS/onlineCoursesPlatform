package services.Utils.FileWriter;

public interface FileWriter<T> {
    boolean saveIntoFile(String path, T objForSave);
}
