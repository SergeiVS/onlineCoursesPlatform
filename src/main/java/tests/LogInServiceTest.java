package tests;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.LogInDto;
import core.dto.requests.Request;
import core.dto.responses.ResponsePerson;
import org.testng.annotations.Test;
import repository.Passwords;
import repository.PersonRepository;
import services.personServices.LogInService;
import services.utils.fileReder.ReadPassesFromFile;
import services.utils.fileReder.ReadPersonDatabaseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.testng.AssertJUnit.assertEquals;

class LogInServiceTest { Passwords passwords;
    String pathPasswords = "src/main/resources/PassesDatabase";
    PersonRepository persons;

    ReadPersonDatabaseFromFile personsFileReader = new ReadPersonDatabaseFromFile();
    ReadPassesFromFile passesFileReader = new ReadPassesFromFile();
    String pathPersons = "src/main/resources/persons/PersonsDatabase.txt";

    void setUp() {
        try {
            passwords = new Passwords(passesFileReader.readFromFile(pathPasswords));
            persons = new PersonRepository(personsFileReader.readFromFile(pathPersons));

        }catch (RuntimeException | IOException e){
            e.printStackTrace();
        }
    }
    // Тестируется генерация ответа на запрос.
    @Test
    void logIn() {
        LogInService service = new LogInService(persons, passwords);
        List<ErrorsDto> errors = new ArrayList<>();
        errors.add(new ErrorsDto(ErrorCoding.E_200, "Access alloyed"));
        ResponsePerson expectedPerson;
        expectedPerson = (new ResponsePerson(11, "John", "Dow", 0, "admin"));

        LogInDto dto = new LogInDto("john@dow.ee", 1537139031);
        Request<LogInDto> logInDto = new Request<>(dto);
        ResponsePerson actualPerson = service.logIn(logInDto).getResponse();
        assertEquals(expectedPerson, actualPerson);
    }
    @Test
    void logInErrors() {
        LogInService service = new LogInService(persons, passwords);
        List<ErrorsDto> expextedErrors = new ArrayList<>();
        expextedErrors.add(new ErrorsDto(ErrorCoding.E_200, "Access alloyed"));
        LogInDto dto = new LogInDto("john@dow.ee", 1537139031);
        Request<LogInDto> logInDto = new Request<>(dto);
        List<ErrorsDto> actualErrors = service.logIn(logInDto).getErrors();
        assertEquals(expextedErrors, actualErrors);
    }

}