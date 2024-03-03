package services.Utils.fileReder;

import core.entity.Person;
import repository.RepositoryInterface;
import services.validation.NullException;
import services.validation.NumberException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadPersonDatabaseFromFile implements ReadFromFile<List<Person>> {


    @Override
    public List<Person> readFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<Person> database = new ArrayList<>();
        String readLine = null;

        while ((readLine = reader.readLine()) != null) {
            if (readLine.contains("##")) {
                Integer personId = 0;
                String firstName = null;
                String lastName = null;
                String eMail = null;
                Integer courseId = 0;
                String accessType = null;

                personId = Integer.valueOf(Objects.requireNonNull(getStringText(readLine, "person_id")));
                firstName = getStringText(readLine, "first_name");
                lastName = getStringText(readLine, "last_name");
                eMail = getStringText(readLine, "email");
                courseId = Integer.valueOf(Objects.requireNonNull(getStringText(readLine, "course_id")));
                accessType = getStringText(readLine, "access_type");

                database.add(new Person(personId, firstName, lastName, eMail, courseId, accessType));

                throw new NumberException();
            }
        }
        reader.close();

        return database;
    }

    private static String getStringText(String readLine, String s) {
        if (readLine.split("=")[0].trim().toLowerCase().equals(s)) {
            return readLine.split("=")[1].trim();
        } else return null;
    }
}
