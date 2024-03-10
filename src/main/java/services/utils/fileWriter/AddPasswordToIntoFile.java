package services.utils.fileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
// Метод добавляет пароль нового пользователя в файл для сохранения копии. Исключения в Классе не обрабатываются,
// а переадресуются методу который этот класс вызвал и должны обрабатываться там. На входе Map.Entry<Integer, Integer>
// хешкоды логина и пароля соответственно.
public class AddPasswordToIntoFile implements IntoFileWriter<Map.Entry<Integer, Integer>> {
    @Override
    public void saveIntoFile(String path, Map.Entry<Integer, Integer> objForSave) throws IOException, NullPointerException {

        try (FileWriter writer = new FileWriter(path)) {

            writer.write(objForSave.getKey() + " = " + objForSave.getValue());

        }
    }
}