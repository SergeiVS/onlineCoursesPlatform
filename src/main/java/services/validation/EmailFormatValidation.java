package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// проверяет входящую строку на соответствие формату емайла, на наличие информации, на Исключения
public class EmailFormatValidation implements ValidationInterface<String> {
    @Override
    public boolean validate(String string, List<ErrorsDto> errors) {

        boolean result;

        try {
            if (string == null) {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "request can not be null"));
                return false;
            }

            String regex = "^[A-Za-z0-9+._-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            result = matcher.matches();
            if (!result) {
                errors.add(new ErrorsDto(ErrorCoding.E_401, "Email format is not valid"));
                return false;
            } else return true;

        } catch (PatternSyntaxException e) {

            errors.add(new ErrorsDto(ErrorCoding.E_400, "Email validation failed"));
            return false;

        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            return false;
        }
//        if (!result) {
//            errors.add(new ErrorsDto(ErrorCoding.E_401, "Email format is not valid"));
//
//        }
      //  return result;
    }
}
