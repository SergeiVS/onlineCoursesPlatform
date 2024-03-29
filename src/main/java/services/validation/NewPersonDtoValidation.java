package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.NewPersonDto;


import java.util.List;
// проверяет входные данные нового пользователя на нуль, на наличие информации в полях, на Исключения.
public class NewPersonDtoValidation implements ValidationInterface<NewPersonDto> {
    EmailFormatValidation emailValidation = new EmailFormatValidation();

    @Override
    public boolean validate(NewPersonDto newPersonDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            if (newPersonDto == null) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "request can not be null"));
                return false;
            }
            String fName = newPersonDto.getFirstName();
            String lName = newPersonDto.getLastName();
            String email = newPersonDto.geteMail();

            if (fName.isEmpty() || lName.isEmpty() || email.isEmpty()) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Fields: name and email can not be empty"));
                isValid = false;
            }
            if (!(emailValidation.validate(email, errors))) {
                isValid = false;
            }

        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}
