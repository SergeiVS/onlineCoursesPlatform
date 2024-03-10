package services.personServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import core.entity.Person;
import repository.PersonRepository;
import services.utils.converters.Converters;

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

    public Response<ResponsePerson> findById(Request<Integer> courseId){
        List<ErrorsDto> errors = new ArrayList<>();
        ResponsePerson personForReturn = null;

        try {
            Person foundPerson = personRepository.findById(courseId.getRequest());
            personForReturn = Converters.personToResponseConverter(foundPerson);
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


    public Response<List<ResponsePerson>> findByName(String lastName) {

        List<ErrorsDto> errors = new ArrayList<>();
        List<ResponsePerson> personsForReturn = new ArrayList<>();

        try {
            List<Person> foundPersons = personRepository.findByName(lastName);

           personsForReturn = foundPersons.stream()
                   .filter(person -> person.getLastName().equals(lastName))
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
}
