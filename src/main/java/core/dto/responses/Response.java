package core.dto.responses;

import core.dto.errors.ErrorCoding;

import java.util.List;
//Используется для передачи информации от сервиса внешнему пользователю. В качестве параметра может быть использован
//объект ДТО или переменная другого типа если нужно передавать только один параметр.
public class Response <T> {
    // Типизация определяется в конкретном сервисе
    private final T response;
    private final List<ErrorCoding> errors;

    public Response(T response, List<ErrorCoding> errors) {
        this.response = response;
        this.errors = errors;
    }

    public T getResponse() {
        return response;
    }

    public List<ErrorCoding> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "Response{" +
                "response=" + response +
                ", errors=" + errors +
                '}';
    }
}
