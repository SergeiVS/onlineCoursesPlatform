package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import services.validation.exeptions.NullException;

import java.util.List;

public class StringRequestValidation implements ValidationInterface<Request<String>> {
    @Override
    public boolean validate(Request<String> request, List<ErrorsDto> errors) {

        boolean isValid = true;

        try {

            if (request.getRequest().isEmpty()) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Request must not be empty"));
                return false;
            }

            String s = request.getRequest();

        } catch (NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}
