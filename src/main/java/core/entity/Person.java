package core.entity;

import java.util.Objects;

public class Person {
    private Integer personId;
    private String firstName;
    private String lastName;
    private String eMail;
    private Integer courseId;
    private String accessType;

    public Person(Integer personId, String firstName, String lastName, String eMail) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public Person(Integer personId, String firstName, String lastName, String eMail, Integer courseId, String accessType) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.courseId = courseId;
        this.accessType = accessType;
    }

    public Integer getId() { return personId; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(),
                person.getFirstName()) && Objects.equals(getLastName(),
                person.getLastName()) && Objects.equals(geteMail(), person.geteMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), geteMail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", courseName='" + courseId + '\'' +
                ", accessType='" + accessType + '\'' +
                '}';
    }
}
