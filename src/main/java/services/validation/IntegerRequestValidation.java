package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;



import java.util.List;
// Проверяет входящее числовое значение на нуль
public class IntegerRequestValidation implements ValidationInterface<Request<Integer>> {
    @Override
    public boolean validate(Request<Integer> request, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {

            if (request.getRequest() <= 0) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Value can not be 0 or negative number"));
                return false;
            }
            int i = request.getRequest();

        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;

        }
        return isValid;
    }
}
