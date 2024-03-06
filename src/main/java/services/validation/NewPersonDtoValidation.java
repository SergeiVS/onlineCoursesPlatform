package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.NewPersonDto;
import services.validation.exeptions.NullException;

import java.util.List;

public class NewPersonDtoValidation implements ValidationInterface <NewPersonDto> {
EmailFormatValidation emailValidation = new EmailFormatValidation();
    @Override
    public boolean validate(NewPersonDto newPersonDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            String fName = newPersonDto.getFirstName();
            String lName = newPersonDto.getLastName();
            String email = newPersonDto.geteMail();
            Integer passHash = newPersonDto.getPasswordHash();

            if (fName.isEmpty() || lName.isEmpty() || email.isEmpty()){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Fields: name and email can not be empty"));
                isValid = false;
            }
            if (emailValidation.validate(email, errors)){

            }
            if (passHash <= 0){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Password can not be 0"));
                isValid = false;
            }
        }catch (NumberFormatException e){
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Number input failed"));
            isValid = false;
        }catch (NullException e){
            errors.add(new ErrorsDto(ErrorCoding.E_400, "No null value alloyed"));
            isValid = false;
        }






        return isValid;
    }
}
