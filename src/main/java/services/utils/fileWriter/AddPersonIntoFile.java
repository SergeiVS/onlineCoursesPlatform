package services.utils.fileWriter;


import core.entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Добавляет данные нового пользователя в конец файла. Исключения в Классе не обрабатываются,
// а переадресуются методу который этот класс вызвал и должны обрабатываться там. На входе Объект типа Person.
public class AddPersonIntoFile implements IntoFileWriter<Person> {

    @Override
    public void saveIntoFile(String path, Person objForSave) throws IOException, NullPointerException, NumberFormatException, ClassCastException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.append("##")
                    .append("user_id = ").append(String.valueOf(objForSave.getPersonId())).append("\n")
                    .append("first_name : ").append(objForSave.getFirstName()).append("\n")
                    .append("last_name : ").append(objForSave.getLastName()).append("\n")
                    .append("email : ").append(objForSave.getEmail()).append("\n")  // Исправлено geteMail на getEmail
                    .append("course_id : ").append(String.valueOf(objForSave.getCourseId())).append("\n")
                    .append("access_type : ").append(objForSave.getAccessType()).append("\n");
        }
    }
}