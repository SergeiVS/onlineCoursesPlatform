package core.dto.errors;

public enum ErrorCoding {
// Коды из таблицы HTTP
    E_200(200, "Ok"),
    E_201(201, "Created"),
    E_202(202, "Accepted"),
    E_302(302,"Found"),
    E_400(400, "Bad request"),
    E_401(401, "Authorization failed"),
    E_403(403, "Access denied"),
    E_404(404, "File not found");

   final int errorCode;

    private final String message;

    ErrorCoding(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
