package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.LogInDto;
import services.validation.exeptions.NullException;

import java.util.List;

public class LogInValidation implements ValidationInterface<LogInDto> {
    EmailFormatValidation emailValidation = new EmailFormatValidation();

    @Override
    public boolean validate(LogInDto logInDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {

            String email = logInDto.geteMail();
            Integer passHash = logInDto.getPasswordHash();

            if (email.isEmpty() || passHash == null) {

                errors.add(new ErrorsDto(ErrorCoding.E_400, "Fields can not be empty"));
                isValid = false;
            }
            if (!(emailValidation.validate(email, errors))) {
                isValid = false;
            }

        } catch (NumberFormatException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Number input failed"));
            isValid = false;
        } catch (NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "No null value alloyed"));
            isValid = false;
        }
        return isValid;
    }

}
