package core.dto.responses;

// возвращается пользователю на добавление, изменение и поиск отдельно или объектом Списка.
public class ResponsePerson {

    private  final Integer personId;
    private final String firstName;
    private final String lastName;
    private final Integer courseId;

    public ResponsePerson(Integer personId, String firstName, String lastName, Integer courseId) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
    }

    public Integer getPersonId() {
        return personId;
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

    @Override
    public String toString() {
        return "ResponsePerson{" +
                "personId=" + personId + '\n' +
                " firstName='" + firstName +
                " lastName='" + lastName + '\n' +
                "courseId=" + courseId +
                '}';
    }
}
