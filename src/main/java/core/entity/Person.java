package core.entity;

import java.util.Objects;

public class Person {
    private Integer personId;



    private String firstName;
    private String lastName;
    private String email;
    private Integer courseId;
    private String accessType;

    public Person(Integer personId, String firstName, String lastName, String email) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(Integer personId, String firstName, String lastName, String email, Integer courseId, String accessType) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseId = courseId;
        this.accessType = accessType;
    }

    public Integer getPersonId() { return personId; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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
        return Objects.equals(getPersonId(), person.getPersonId()) && Objects.equals(getFirstName(),
                person.getFirstName()) && Objects.equals(getLastName(),
                person.getLastName()) && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + email + '\'' +
                ", courseName='" + courseId + '\'' +
                ", accessType='" + accessType + '\'' +
                '}';
    }
}
