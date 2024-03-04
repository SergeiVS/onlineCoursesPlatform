package core.dto.responses;

import java.util.List;
//используется для возврата пользователю информацию об прогрессе прохождения курса студентом его оценках.
public class ResponsePersonProgress {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Integer courseId;
    private final String courseName;
    private final List<Integer> grades;
    private final Integer progress;

    public ResponsePersonProgress(Integer id, String firstName, String lastName, Integer courseId, String courseName,
                                  List<Integer> grades, Integer progress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.grades = grades;
        this.progress = progress;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return "ResponsePersonProgress{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", grades=" + grades +
                ", progress=" + progress +
                '}';
    }
}
