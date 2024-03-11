package services.utils.converters;

import core.dto.responses.ResponseCourse;
import core.dto.responses.ResponsePerson;
import core.entity.Course;
import core.entity.Person;

import java.util.List;
import java.util.Map;

public class Converters {
    // Конвертирует данные пользователя в формат ответа на запрос
    public static ResponsePerson personToResponseConverter(Person foundPerson) throws RuntimeException {

        var id = foundPerson.getPersonId();
        var fName = foundPerson.getFirstName();
        var lName = foundPerson.getLastName();
        var courseId = foundPerson.getCourseId();
        var access = foundPerson.getAccessType();

        return new ResponsePerson(id, fName, lName, courseId, access);
    }


    public static void courseToResponseCourse(List<Course> foundCourses, List<ResponseCourse> responseCourses) {
        for (Course course : foundCourses) {
            responseCourses.add(new ResponseCourse(course.getCourseId(),
                    course.getCourseName(), course.getMaterial()));
        }
    }
}
