package core.dto.responses;

import core.dto.errors.ErrorsDto;
import core.entity.Course;

import java.util.List;

//Используется для передачи пользователю информации о курсе;
public class ResponseCourse {
    private final Integer courseId;
    private final String courseName;

    //коллекция строк файла с информацией о курсе
    private final List<String> courseMaterial;



    public ResponseCourse(Integer courseId, String courseName, List<String> courseMaterial) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseMaterial = courseMaterial;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getCourseMaterial() {
        return courseMaterial;
    }

    @Override
    public String toString() {
        return "ResponseCourse{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseMaterial=" + courseMaterial +
                '}';
    }
}
