package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.ActivateDeactivateCourseDto;

import java.util.List;

public class ActivateDeactivateCourseValidation  implements ValidationInterface<ActivateDeactivateCourseDto>{
    @Override
    public boolean validate(ActivateDeactivateCourseDto dto, List<ErrorsDto> errors) {

        boolean isValid = true;
        try {
            if(dto == null){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Request must not be empty"));
                return false;
            }
            var id = dto.getCourseId();
            var isActive = dto.isActive();

            if (id <= 0){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Id can not be 0 or negative"));
                isValid = false;
            }
        } catch (RuntimeException e){
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }

        return isValid;
    }
}
