package core.dto.requests;

public class LogInDto {
    /*
    will be used for logIn data
    */
    private final String eMail;
    private final Integer passwordHash;

    public LogInDto(String eMail, Integer passwordHash) {
        this.eMail = eMail;
        this.passwordHash = passwordHash;
    }

    public String geteMail() {
        return eMail;
    }

    public Integer getPasswordHash() {
        return passwordHash;
    }
}
