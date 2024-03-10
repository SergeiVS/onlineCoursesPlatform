package services.PersonServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.LogInDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import core.entity.Person;
import repository.Passwords;
import repository.PersonRepository;
import services.validation.LogInValidation;

import java.util.ArrayList;
import java.util.List;

public class LogInService {
    private final PersonRepository persons;
    private final Passwords passwords;

    public LogInService(PersonRepository persons, Passwords passwords) {
        this.persons = persons;
        this.passwords = passwords;
    }
// Метод получает на вход запрос на логин, проверяет его на достоверность и ошибки,
// получает данные пользователя из репозитория, проверяет их на ноль и возвращает ответ пользователю
// вместе со списком ошибок.
    public Response<ResponsePerson> logIn(Request<LogInDto> dto) {
        LogInValidation validation = new LogInValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        ResponsePerson responsePerson = null;

        try {

        var email = dto.getRequest().geteMail();
        var passwordHash = dto.getRequest().getPasswordHash();
        boolean isAccepted = false;


        if (validation.validate(dto.getRequest(), errors)) {
            isAccepted = passwords.verifyPass(email.hashCode(), passwordHash);
        } else {
            return new Response<ResponsePerson>(null, errors);
        }

        if (isAccepted) {
            Person foundPerson = persons.findByEmail(email);
            if (foundPerson != null) {
                responsePerson = PersonToDtoConverter(foundPerson);
                errors.add(new ErrorsDto(ErrorCoding.E_200, "Access alloyed"));

            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_401, "User did not found"));
                return new Response<ResponsePerson>(null, errors);
            }
        }
    }  catch (RuntimeException e) {
            e.printStackTrace();
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Incoming data is not correct"));
        }
        return new Response<ResponsePerson>(responsePerson, errors);
    }
// Конвертирует данные пользователя в формат ответа на запрос
    private static ResponsePerson PersonToDtoConverter(Person foundPerson) {

        var id = foundPerson.getPersonId();
        var fName = foundPerson.getFirstName();
        var lName = foundPerson.getLastName();
        var courseId = foundPerson.getCourseId();
        var access = foundPerson.getAccessType();

        return new ResponsePerson(id, fName, lName, courseId, access);
    }
}
