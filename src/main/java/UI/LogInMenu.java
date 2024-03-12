package UI;

import core.dto.requests.LogInDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import services.personServices.LogInService;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.PrintUser;
import services.utils.inputOutput.UserInput;

import java.util.Objects;
import java.util.Optional;

public class LogInMenu implements UIInterface {

    private Response<ResponsePerson> responsePerson;
    private final LogInService service;


    public LogInMenu(LogInService service) {
        this.service = service;

    }

    @Override
    public int execute() {

        printActionName();

        String email = UserInput.insertString("Please insert login/email");
        Integer passHash = UserInput.insertString("Please insert your password").hashCode();
        responsePerson = service.logIn(new Request<>(new LogInDto(email, passHash)));
        Optional<ResponsePerson> person = Optional.ofNullable(responsePerson.getResponse());

        if (person.isPresent()) {
            System.out.println(person.get().getFirstName() + " WELLCOME!\n ");
            PrintUser.userPrintOut(person.get());

            if (Objects.equals(person.get().getAccessType(), "is_student")) {
                return MenuIndexes.I_4.getIndex();

            }

            if (Objects.equals(person.get().getAccessType(), "admin")) {
                return MenuIndexes.I_5.getIndex();
            }
        } else {
            PrintErrors.printErrorsList(responsePerson.getErrors());
            return 0;
        }
        return 0;
    }

    @Override
    public void printActionName() {
        System.out.println("LogIn");
    }
}
