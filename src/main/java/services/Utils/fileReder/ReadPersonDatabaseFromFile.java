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


            while (!readLine.contains("##")) {

                readLine = reader.readLine();
                Integer personId = 0;
                String firstName = null;
                String lastName = null;
                String eMail = null;
                Integer courseId = 0;
                String accessType = null;

                personId = Integer.valueOf((Objects.requireNonNull(getStringText(readLine, "person_id"))));
                readLine= reader.readLine();
                firstName = getStringText(readLine, "first_name");
                readLine= reader.readLine();
                lastName = getStringText(readLine, "last_name");
                readLine= reader.readLine();
                eMail = getStringText(readLine, "email");
                readLine= reader.readLine();
                courseId = Integer.valueOf((Objects.requireNonNull(getStringText(readLine, "course_id"))));
                readLine= reader.readLine();
                accessType = getStringText(readLine, "access_type");
                readLine= reader.readLine();

                database.add(new Person(personId, firstName, lastName, eMail, courseId, accessType));

              //  throw new NumberException();
        }
        }
        reader.close();

        return database;
    }

    private static String getStringText(String readLine, String s) {
        if (readLine.contains(s)) {
            return readLine.split("=")[1].trim();
        }
return null;
    }
}
