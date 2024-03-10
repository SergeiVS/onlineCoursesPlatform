package test;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.LogInDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Passwords;
import repository.PersonRepository;
import services.LogInService;
import services.Utils.fileReder.ReadPassesFromFile;
import services.Utils.fileReder.ReadPersonDatabaseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInServiceTest {

    Passwords passwords;
    String pathPasswords = "src/main/resources/PassesDatabase";
    PersonRepository persons;

    ReadPersonDatabaseFromFile personsFileReader = new ReadPersonDatabaseFromFile();
    ReadPassesFromFile passesFileReader = new ReadPassesFromFile();
    String pathPersons = "src/main/resources/persons/PersonsDatabase.txt";

    @BeforeEach
    void setUp() {
        try {
            passwords = new Passwords(passesFileReader.readFromFile(pathPasswords));
            persons = new PersonRepository(personsFileReader.readFromFile(pathPersons));

        }catch (RuntimeException | IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void logIn() {
        LogInService service = new LogInService(persons, passwords);
//        List<ErrorsDto> errors = new ArrayList<>();
//        errors.add(new ErrorsDto(ErrorCoding.E_200, "Access alloyed"));
        ResponsePerson expectedPerson;
        expectedPerson = (new ResponsePerson(11, "John", "Dow", 0, "admin"));
        LogInDto dto = new LogInDto("john@dow.ee", 1537139031);
        Request<LogInDto> logInDto = new Request<>(dto);
        ResponsePerson actualPerson = service.logIn(logInDto).getResponse();
        assertEquals(expectedPerson, actualPerson);
    }
}