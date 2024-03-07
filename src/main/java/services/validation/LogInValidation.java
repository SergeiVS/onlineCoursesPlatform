package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.LogInDto;
import services.validation.exeptions.NullException;

import java.util.List;
//Проверяет входящий логин на соответствие формату емайла, на наличие информации, на исключения
public class LogInValidation implements ValidationInterface<LogInDto> {
    EmailFormatValidation emailValidation = new EmailFormatValidation();

    @Override
    public boolean validate(LogInDto logInDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            if (logInDto == null) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "request can not be null"));
                return false;
            }
            String email = logInDto.geteMail();
            Integer passHash = logInDto.getPasswordHash();

            if (email.isEmpty() || passHash == null) {

                errors.add(new ErrorsDto(ErrorCoding.E_400, "Fields can not be empty"));
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
