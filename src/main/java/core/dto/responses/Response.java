package core.dto.responses;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Используется для передачи информации от сервиса внешнему пользователю. В качестве параметра может быть использован
//объект ДТО или переменная другого типа если нужно передавать только один параметр.
public class Response <T> {
    // Типизация определяется в конкретном сервисе
    private final Optional<T>  response;
    private final List<ErrorsDto> errors;

    public Response(T response, List<ErrorsDto> errors) {
        this.response = (Optional<T>) response;
        this.errors = errors;
    }

    public T getResponse() {
        return (T) response;
    }

    public List<ErrorsDto> getErrors() {
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
