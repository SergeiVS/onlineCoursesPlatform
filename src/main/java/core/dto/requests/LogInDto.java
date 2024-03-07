package core.dto.requests;
// используется для передачи lodIn информации для идентификации пользователя и входа в систему
public class LogInDto {

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
