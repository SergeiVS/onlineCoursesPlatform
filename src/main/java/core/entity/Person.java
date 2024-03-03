package core.entity;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private Integer personId;
    private String firstName;
    private String lastName;
    private String eMail;
    private String courseName;
    private String accessType;

    public Person(Integer personId, String firstName, String lastName, String eMail) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public Integer getPersonId() { return personId; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getPersonId(), person.getPersonId()) && Objects.equals(getFirstName(),
                person.getFirstName()) && Objects.equals(getLastName(),
                person.getLastName()) && Objects.equals(geteMail(), person.geteMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFirstName(), getLastName(), geteMail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", courseName='" + courseName + '\'' +
                ", accessType='" + accessType + '\'' +
                '}';
    }
}
