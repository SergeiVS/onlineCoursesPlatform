package core.dto.requests;

public class Request <T> {

    private final T request;

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
