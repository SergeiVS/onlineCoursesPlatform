package core.dto.requests;

public class NewPersonDto {

    /*
    will be used for registering of new User
     */
    private final String firstName;
    private final String lastName;
    private final String eMail;
    private final String courseName;
// courseName can be empty if user is not sure which course he/she is like to choose.
private final Integer passwordHash;
// passwordHash will be saved in separate repository as a value for key(emailHash)


    public NewPersonDto(String firstName, String lastName, String eMail, String courseName, Integer passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.courseName = courseName;
        this.passwordHash = passwordHash;
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
    public Integer getPasswordHash() {
        return passwordHash;
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
