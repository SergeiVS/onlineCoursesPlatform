package core.dto.responses;

import java.util.Objects;

// возвращается пользователю на добавление, изменение и поиск отдельно или объектом Списка.
public class ResponsePerson {

    private  final Integer personId;
    private final String firstName;
    private final String lastName;
    private final Integer courseId;
    private final String accessType;



    public ResponsePerson(Integer personId, String firstName, String lastName, Integer courseId, String accessType) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
        this.accessType = accessType;
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

    public String getAccessType() {
        return accessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsePerson that = (ResponsePerson) o;
        return Objects.equals(getPersonId(), that.getPersonId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "ResponsePerson{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseId=" + courseId +
                ", accessType='" + accessType + '\'' +
                '}';
    }

}
