package services.Utils.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AddPasswordToIntoFile implements IntoFileWriter<Map.Entry<Integer, Integer>> {
    @Override
    public void saveIntoFile(String path, Map.Entry<Integer, Integer> objForSave) throws IOException, NullPointerException {
        FileWriter writer = new FileWriter(path);

       if(objForSave != null) {
           StringBuilder string = new StringBuilder(objForSave.getKey() + " : " + objForSave.getValue());
           writer.append(string);
       }
       writer.close();

    }
}
