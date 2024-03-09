package services.Utils.fileReder;

import core.entity.Person;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// В этом классе считываются данные пользователей из файла и преобразуются в объекты типа Person.
// Возвращаются в виде Списка объектов типа Person.
public class ReadPersonDatabaseFromFile implements ReadFromFile<List<Person>> {


    @Override
    public List<Person> readFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<Person> database = new ArrayList<>();
        String readLine;

        try {

            while ((readLine = reader.readLine()) != null) {

                if (readLine.contains("##")) {

                    readLine = reader.readLine();
                    Integer personId = 0;
                    String firstName = null;
                    String lastName = null;
                    String eMail = null;
                    Integer courseId = 0;
                    String accessType = null;

                    personId = Integer.valueOf((Objects.requireNonNull(getStringText(readLine, "person_id"))));
                    readLine = reader.readLine();
                    firstName = getStringText(readLine, "first_name");
                    readLine = reader.readLine();
                    lastName = getStringText(readLine, "last_name");
                    readLine = reader.readLine();
                    eMail = getStringText(readLine, "email");
                    readLine = reader.readLine();
                    courseId = Integer.valueOf((Objects.requireNonNull(getStringText(readLine, "course_id"))));
                    readLine = reader.readLine();
                    accessType = getStringText(readLine, "access_type");

                    database.add(new Person(personId, firstName, lastName, eMail, courseId, accessType));
                }
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Input output failed");
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return database;
    }
// Вспомогательный метод для считывания значения из строки в файле
    private static String getStringText(String readLine, String s) {
        if (readLine.contains(s)) {
            return readLine.split("=")[1].trim();
        }
        return null;
    }
}
