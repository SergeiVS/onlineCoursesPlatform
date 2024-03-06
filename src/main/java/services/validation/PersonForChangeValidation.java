package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.PersonForChangeDto;
import services.validation.exeptions.NullException;

import java.util.List;

public class PersonForChangeValidation implements ValidationInterface<PersonForChangeDto> {
    @Override
    public boolean validate(PersonForChangeDto personForChangeDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            Integer personId = personForChangeDto.getPersonId();
            Integer courseId = personForChangeDto.getCourseId();
            String accessType = personForChangeDto.getAccessType();

            if (personId == 0 || courseId == 0 || accessType.isEmpty()) {

                errors.add(new ErrorsDto(ErrorCoding.E_400, "Fields can not be empty"));
                isValid = false;
            }
            if (!accessType.equals("admin") && !accessType.equals("isStudent") && !accessType.equals("wasStudent")) {

                errors.add(new ErrorsDto(ErrorCoding.E_400, "access type can only be equal: admin, " +
                        "isStudent or wasStudent"));
                isValid = false;
            }

        } catch (NumberFormatException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Number input failed"));
            isValid = false;
        } catch (
                NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "No null value alloyed"));
            isValid = false;
        }
        return isValid;
    }
}