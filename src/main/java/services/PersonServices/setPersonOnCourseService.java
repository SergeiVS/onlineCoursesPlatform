package services.PersonServices;

import core.dto.errors.ErrorsDto;
import core.dto.requests.PersonForChangeDto;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import core.entity.Person;
import repository.PersonRepository;
import services.validation.PersonForChangeValidation;

import java.util.ArrayList;
import java.util.List;

import static core.dto.errors.ErrorCoding.E_200;
import static core.dto.errors.ErrorCoding.E_400;

public class setPersonOnCourseService {
    private final PersonRepository personRepository;

    public setPersonOnCourseService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public Response<ResponsePerson> setCourseForPerson(PersonForChangeDto personDto){

        PersonForChangeValidation validation = new PersonForChangeValidation();
        ResponsePerson personForReturn = null;
        List<ErrorsDto> errors = new ArrayList<>();

        try {

            var personId = personDto.getPersonId();
            var courseId = personDto.getCourseId();
            var accessType = personDto.getAccessType();
            int returnedId = 0;

            boolean isValid = validation.validate(personDto, errors);

            if (isValid){
                Person personDataForChange = new Person(personId, courseId, accessType);
                returnedId = personRepository.add(personDataForChange);
            }

                Person newPersonData = personRepository.findById(returnedId);
                personForReturn = new ResponsePerson(newPersonData.getPersonId(),
                        newPersonData.getFirstName(), newPersonData.getLastName(),
                        newPersonData.getCourseId(), newPersonData.getAccessType());
                errors.add(new ErrorsDto(E_200, "Data was changed successfully"));

        }catch (RuntimeException e){
            errors.add(new ErrorsDto(E_400, "Fail by data changing"));
        }
return new Response<>(personForReturn, errors);
    }

}
