package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.NewPersonDto;
import services.validation.exeptions.NullException;

import java.util.List;

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

        } catch (NumberFormatException | NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}
