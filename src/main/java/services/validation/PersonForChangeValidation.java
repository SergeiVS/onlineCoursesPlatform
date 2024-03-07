package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.PersonForChangeDto;


import java.util.List;
// проверяет входные данные пользователя на нуль, на наличие информации в полях, на Исключения.
public class PersonForChangeValidation implements ValidationInterface<PersonForChangeDto> {
    @Override
    public boolean validate(PersonForChangeDto personForChangeDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            if (personForChangeDto == null) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "request can not be null"));
                return false;
            }

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

        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}