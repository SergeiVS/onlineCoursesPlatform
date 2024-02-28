package core.dto;

import core.dto.errors.ErrorCoding;

import java.util.List;

public class Response <T> {

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
