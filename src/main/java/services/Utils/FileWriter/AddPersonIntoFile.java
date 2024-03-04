package services.Utils.FileWriter;



import core.entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//Добавляет данные нового пользователя в конец файла
public class AddPersonIntoFile implements IntoFileWriter<Person>{

    @Override
    public void saveIntoFile(String path, Person objForSave) throws IOException, NullPointerException, NumberFormatException, ClassCastException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.append("##");
        writer.append("user_id = " + objForSave.getId());
        writer.append("first_name : "+ objForSave.getFirstName());
        writer.append("last_name : "+ objForSave.getLastName());
        writer.append("email : " + objForSave.geteMail());
        writer.append("course_id : " + objForSave.getCourseId());
        writer.append("access_type : "+ objForSave.getAccessType());

        writer.close();

    }
}
