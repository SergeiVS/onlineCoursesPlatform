package services.Utils.fileWriter;

import services.validation.FileReadingException;
import services.validation.NullException;
import services.validation.NumberException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AddPasswordToIntoFile implements IntoFileWriter<Map.Entry<Integer, Integer>> {
    @Override
    public void saveIntoFile(String path, Map.Entry<Integer, Integer> objForSave) throws IOException, NullPointerException {

        try (FileWriter writer = new FileWriter(path)) {

            writer.write(objForSave.getKey() + " = " + objForSave.getValue());

        }
    }
}