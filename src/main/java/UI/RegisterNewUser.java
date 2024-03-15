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

public class RegisterNewUser implements UIInterface {
    private final AddPersonService service;

    public RegisterNewUser(AddPersonService service) {
        this.service = service;

    }

    @Override
    public int execute() {
        printActionName();

        System.out.println("We are glad you chose our course platform");

        try {


        String fName = UserInput.insertString("Insert your first name: ");
        String lName = UserInput.insertString("Insert your last name:");
        String email = UserInput.insertString("Insert your email:");
        int courseId = UserInput.insertInt("If you did chose a course please insert it' s id, else insert '0':");
        int passHash = passCompare();
        Response<ResponsePerson> responsePerson = service.addPerson(new Request<>(new NewPersonDto(fName, lName, email,
                courseId, passHash)));
        Optional<ResponsePerson> person = Optional.ofNullable(responsePerson.getResponse());

        if (person.isPresent()) {
            System.out.println(person.get().getFirstName() + " WELLCOME!\n ");
            PrintUser.userPrintOut(person.get());

            return MenuIndexes.I_4.getIndex();

        } else {
            PrintErrors.printErrorsList(responsePerson.getErrors());
            return 0;
        }
    }catch (RuntimeException e){

            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public void printActionName() {
        System.out.println("Register new student");
    }

    private int passCompare() {
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
