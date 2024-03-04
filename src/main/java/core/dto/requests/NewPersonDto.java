package core.dto.requests;

public class NewPersonDto {

    /*
   передаётся в сервис для добавления в репозиторий нового объекта Person
     */
    private final String firstName;
    private final String lastName;
    private final String eMail;
    private final Integer courseId;
    private final Integer passwordHash;

    // пароль сохраняется в отдельный репозиторий в качестве значения, где ключом является emailHash


    public NewPersonDto(String firstName, String lastName, String eMail, Integer courseId, Integer passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.courseId = courseId;
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

    public Integer getPasswordHash() {
        return passwordHash;
    }

    public Integer getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "NewPersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", courseId=" + courseId +
                ", passwordHash=" + passwordHash +
                '}';
    }
}
