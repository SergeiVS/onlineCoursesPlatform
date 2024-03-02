package core.dto.requests;

//Используется для передачи информации от внешнего пользователя в систему. В качестве параметра может быть использован
//объект ДТО  или переменная другого типа если нужно передавать только один параметр.
public class Request <T> {

    private final T request;

    // Типизация определяется в конкретном сервисе
    public Request(T request) {
        this.request = request;
    }

    public T getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request=" + request +
                '}';
    }
}
