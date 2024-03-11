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

    private final StartMenu startMenu;
    private final StudentMenu studentMenu;
    private final AdminMenu adminMenu;
    private final OldStudentMenu oldStudentMenu;

    public LogInMenu(LogInService service, StartMenu startMenu, StudentMenu studentMenu, AdminMenu adminMenu, OldStudentMenu oldStudentMenu) {
        this.service = service;
        this.startMenu = startMenu;
        this.studentMenu = studentMenu;
        this.adminMenu = adminMenu;
        this.oldStudentMenu = oldStudentMenu;
    }

    @Override
    public void execute() {
        String email = UserInput.insertString("Please insert login/email");
        Integer passHash = UserInput.insertString("Please insert your password").hashCode();
        responsePerson = service.logIn(new Request<>(new LogInDto(email, passHash)));
        Optional<ResponsePerson> person = Optional.ofNullable(responsePerson.getResponse());
        if (person.isPresent()) {
            System.out.println(person.get().getFirstName() + " WELLCOME!\n ");
            PrintUser.userPrintOut(person.get());

            if (Objects.equals(person.get().getAccessType(), "is_student")) {
                studentMenu.execute();
            }
            if (Objects.equals(person.get().getAccessType(), "was_student")) {
                oldStudentMenu.execute();
            }
            if (Objects.equals(person.get().getAccessType(), "admin")) {
                adminMenu.execute();
            }
        }else {
            PrintErrors.printErrorsList(responsePerson.getErrors());
            studentMenu.execute();
        }
    }

    @Override
    public void printActionName() {
        System.out.println("LogIn");
    }
}
