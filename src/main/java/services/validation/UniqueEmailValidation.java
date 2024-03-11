package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.entity.Person;
import repository.PersonRepository;

import java.util.List;

public class UniqueEmailValidation implements ValidationInterface<String>{
private final PersonRepository repository;

    public UniqueEmailValidation(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean validate(String email, List<ErrorsDto> errors) {
        try {
            Person checkPerson = repository.findByEmail(email);
            if (checkPerson == null){
                return true;
            }
            else {
                errors.add(new ErrorsDto(ErrorCoding.E_400, "Such email is already exist"));
                return false;
            }
        }catch (RuntimeException e){
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            return false;
        }
    }
}
