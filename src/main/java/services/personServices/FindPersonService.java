package services.personServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import core.entity.Person;
import repository.PersonRepository;
import services.utils.converters.Converters;
import services.validation.IntegerRequestValidation;
import services.validation.StringRequestValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindPersonService {

    private final PersonRepository personRepository;

    public FindPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Response<List<ResponsePerson>> findAll() {

        List<ErrorsDto> errors = new ArrayList<>();
        List<ResponsePerson> personsForReturn = new ArrayList<>();

        try {
            List<Person> foundPersons = personRepository.findAll();

            personsForReturn = foundPersons.stream()
                    .map(Converters::personToResponseConverter)
                    .collect(Collectors.toList());

            if (personsForReturn.isEmpty()) {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_200, "Database did found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Internal database error"));
        }
        return new Response<>(personsForReturn, errors);
    }

    public Response<ResponsePerson> findById(Request<Integer> personId) {
        List<ErrorsDto> errors = new ArrayList<>();
        ResponsePerson personForReturn = null;
        IntegerRequestValidation validation = new IntegerRequestValidation();
        boolean isValid = false;
        Person foundPerson = null;

        try {
            isValid = validation.validate(personId, errors);

            if (isValid) {
                foundPerson = personRepository.findById(personId.getRequest());
                personForReturn = Converters.personToResponseConverter(foundPerson);
            }

            if (foundPerson == null) {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "User did not found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_200, "User found"));

            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Internal database error"));
        }
        return new Response<>(personForReturn, errors);
    }


    public Response<List<ResponsePerson>> findByName(Request<String> lastName) {

        List<ErrorsDto> errors = new ArrayList<>();
        List<ResponsePerson> personsForReturn = new ArrayList<>();
        StringRequestValidation validation = new StringRequestValidation();
        boolean isValid = false;
        List<Person> foundPersons = new ArrayList<>();

        try {
            isValid = validation.validate(lastName, errors);

            if (isValid) {
                foundPersons = personRepository.findByName(lastName.getRequest());
            }
            if (!foundPersons.isEmpty()) {
                personsForReturn = foundPersons.stream()
                        .filter(person -> person.getLastName().equals(lastName.getRequest()))
                        .map(Converters::personToResponseConverter)
                        .collect(Collectors.toList());
            }
            if (personsForReturn.isEmpty()) {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_200, "Database did found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Internal database error"));
        }
        return new Response<>(personsForReturn, errors);
    }
}
