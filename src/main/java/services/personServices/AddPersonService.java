package services.personServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.NewPersonDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import core.entity.Person;
import repository.Passwords;
import repository.PersonRepository;
import services.utils.converters.Converters;
import services.utils.fileWriter.AddPasswordToIntoFile;
import services.utils.fileWriter.AddPersonIntoFile;
import services.validation.NewPersonDtoValidation;
import services.validation.UniqueEmailValidation;

import java.util.ArrayList;
import java.util.List;

public class AddPersonService {

    private final PersonRepository personRepository;
    private final Passwords passwords;
//    private final AddPersonIntoFile addPersonIntoFile;
//    private final AddPasswordToIntoFile passwordIntoFile;


    public AddPersonService(PersonRepository personRepository, Passwords passwords) {
        this.personRepository = personRepository;
        this.passwords = passwords;
//        this.addPersonIntoFile = addPersonIntoFile;
//        this.passwordIntoFile = passwordIntoFile;
    }

    // Добавляет нового пользователя
// на входе метод получает NewPersonDto где может быть не указан ид выбранного курса
    public Response<ResponsePerson> addPerson(Request<NewPersonDto> dtoRequest) {

        ResponsePerson personForReturn;
        NewPersonDtoValidation dtoValidation = new NewPersonDtoValidation();
        UniqueEmailValidation emailValidation = new UniqueEmailValidation(personRepository);
        List<ErrorsDto> errors = new ArrayList<>();
        ResponsePerson person = null;
        boolean isValid = false;
        int personId = 0;

        try {
            var request = dtoRequest.getRequest();
            var fName = request.getFirstName();
            var lName = request.getLastName();
            var email = request.geteMail();
            var courseId = request.getCourseId();
            var passHash = request.getPasswordHash();
            //
            //Валидация входящих данных
            isValid = dtoValidation.validate(request, errors);
            Person newPerson;
            // Если переданный емайл уже имеется в базе данных, то новый пользователь не добавляется.
            if (!emailValidation.validate(email, errors)) {
                return new Response<ResponsePerson>(null, errors);
            }
            // Если входные данные валидны создаётся новый пользователь с полными или неполными данными.
            if (isValid) {

                    newPerson = new Person(0, fName, lName, email, courseId, "is_student");
                    personId = personRepository.add(newPerson);
                    passwords.getPasswords().put(email.hashCode(), passHash);
                    errors.add(new ErrorsDto(ErrorCoding.E_201, "Person added"));
                    person = Converters.personToResponseConverter(newPerson, personId);

                //если данные не прошли проверку то добавление нового пользователя не происходит.
            } else {
                return new Response<ResponsePerson>(null, errors);
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Incoming data is not correct"));
        }
        return new Response<ResponsePerson>(person, errors);
    }
}
