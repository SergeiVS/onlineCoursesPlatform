package UI;

import core.dto.requests.NewPersonDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import services.personServices.AddPersonService;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.PrintUser;
import services.utils.inputOutput.UserInput;

import java.util.Objects;
import java.util.Optional;

public class RegisterNewUser implements UIInterface{
    private final AddPersonService service;

    private final StudentMenu studentMenu;
    private final StartMenu startMenu;



    public RegisterNewUser(AddPersonService service, StudentMenu studentMenu, StartMenu startMenu) {
        this.service = service;
        this.studentMenu = studentMenu;
        this.startMenu = startMenu;
    }

    @Override
    public void execute() {
        System.out.println("We are glad you chose our course platform");
        String fName = UserInput.insertString("Insert your first name: ");
        String lName = UserInput.insertString("Insert your last name:");
        String email = UserInput.insertString("Insert your email:");
        int courseId = UserInput.insertInt("If you did chose a course please insert it' s id, else insert '0':");
        int passHash = passCompare();
        Response<ResponsePerson> responsePerson = service.addPerson(new Request<>(new NewPersonDto(fName,lName,email,
                courseId, passHash)));
        Optional<ResponsePerson> person = Optional.ofNullable(responsePerson.getResponse());
        if (person.isPresent()) {
            System.out.println(person.get().getFirstName() + " WELLCOME!\n ");
            PrintUser.userPrintOut(person.get());

            if (Objects.equals(person.get().getAccessType(), "is_student")) {
                studentMenu.execute();
            }

        } else {
            PrintErrors.printErrorsList(responsePerson.getErrors());
            studentMenu.execute();
        }


    }

    @Override
    public void printActionName() {
        System.out.println("Register new student");
    }
    private int passCompare(){
        int passHash1 = UserInput.insertString("Please insert your password").hashCode();
        int passHash2 = UserInput.insertString("Please insert your password once more").hashCode();

        while (passHash1 != passHash2) {
            System.out.println("Inserted passwords are not equal");
            passHash1 = UserInput.insertString("Please insert your password").hashCode();
            passHash2 = UserInput.insertString("Please insert your password once more").hashCode();
        }
        return passHash1;
    }
}
