package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import services.validation.ValidationInterface;
import services.validation.exeptions.NullException;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
            result = matcher.hasMatch();

        } catch (PatternSyntaxException e) {

            errors.add(new ErrorsDto(ErrorCoding.E_400, "Email validation failed"));
            return false;

        } catch (NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Request is null"));
            return false;
        }
        if (result) {
            errors.add(new ErrorsDto(ErrorCoding.E_200, "Email is valid"));

        } else {

            errors.add(new ErrorsDto(ErrorCoding.E_401, "Email format is not valid"));
        }
        return result;
    }
}
