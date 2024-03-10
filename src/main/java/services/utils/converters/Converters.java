package services.utils.converters;

import core.dto.responses.ResponsePerson;
import core.entity.Course;
import core.entity.Person;

import java.util.Map;

public class Converters {
    // Конвертирует данные пользователя в формат ответа на запрос
    public static ResponsePerson personToResponseConverter(Person foundPerson) {

        var id = foundPerson.getPersonId();
        var fName = foundPerson.getFirstName();
        var lName = foundPerson.getLastName();
        var courseId = foundPerson.getCourseId();
        var access = foundPerson.getAccessType();

        return new ResponsePerson(id, fName, lName, courseId, access);
    }


}
