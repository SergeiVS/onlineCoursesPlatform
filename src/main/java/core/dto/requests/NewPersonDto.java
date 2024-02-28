package core.dto.requests;

public class NewPersonDto {
    private final String firstName;
    private final String lastName;
    private final String eMail;
    private final String courseName;
// courseName can be empty if user is not sure witch course he/she choosing.


    public NewPersonDto(String firstName, String lastName, String eMail, String courseName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.courseName = courseName;
    }

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

    @Override
    public String toString() {
        return "NewPersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
