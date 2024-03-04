package services.Utils.FileWriter;

import java.io.*;

//метод позволяет создавать файлы на локальной машине и переносить их в проект
public class WriteFileFromLocalToAppResources implements IntoFileWriter<String>{

    // Здесь path это адрес файла приложения в который планируется записать информацию. А objForSave
    //адрес на локальной машине из которого копируются данные.
    @Override
    public void saveIntoFile(String path, String objForSave) throws IOException, NullPointerException {
        BufferedReader reader = new BufferedReader(new FileReader(objForSave));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        String line;

        while ((line = reader.readLine()) != null){
            writer.append(line);
        }
        writer.close();
        reader.close();
    }
}
