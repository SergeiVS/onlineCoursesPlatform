package services.validation;

import core.dto.errors.ErrorsDto;
import core.dto.requests.NewPersonDto;

import java.util.List;

public class NewPersonDtoValidation implements ValidationInterface <NewPersonDto> {

    @Override
    public boolean validate(NewPersonDto newPersonDto, List<ErrorsDto> errors) {
        boolean isValid = true;




        return false;
    }
}
