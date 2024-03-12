package UI;

import core.dto.requests.PersonForChangeDto;
import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import services.personServices.SetPersonOnCourseService;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.PrintUser;
import services.utils.inputOutput.UserInput;

import java.util.Optional;

public class RegisterOnCourseMenu implements UIInterface {

    private final SetPersonOnCourseService setPersonOnCourseService;

    public RegisterOnCourseMenu(SetPersonOnCourseService setPersonOnCourseService) {
        this.setPersonOnCourseService = setPersonOnCourseService;

    }

    @Override
    public int execute() {
        printActionName();
        System.out.println();

        int courseId = UserInput.insertInt("Please insert one course id from above");
        int userId = UserInput.insertInt("Please insert your id");
        Response<ResponsePerson> personResponse = setPersonOnCourseService.setCourseForPerson(new PersonForChangeDto
                (userId, courseId, "is_Student"));
        Optional<ResponsePerson> person = Optional.ofNullable(personResponse.getResponse());

        if (person.isPresent()) {
            System.out.println(personResponse.getErrors().get(0).getMessage());
            System.out.println("Your new personal data:");
            PrintUser.userPrintOut(person.get());

            return MenuIndexes.I_4.getIndex();

        } else {
            PrintErrors.printErrorsList(personResponse.getErrors());
            return 0;
        }


    }

    @Override
    public void printActionName() {
        System.out.println("Register on course menu");
    }
}
