package UI;

import core.dto.responses.Response;
import core.dto.responses.ResponsePerson;
import services.personServices.FindPersonService;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.PrintUser;

import java.util.List;
import java.util.Optional;

public class GetAllPersonsMenu implements UIInterface {

    private final FindPersonService personService;

    public GetAllPersonsMenu(FindPersonService personService) {
        this.personService = personService;
    }


    @Override
    public int execute() {

        Response<List<ResponsePerson>> personsResponse = personService.findAll();
        Optional<List<ResponsePerson>> persons = Optional.ofNullable(personsResponse.getResponse());

        if (persons.isPresent()) {
            persons.get().forEach(PrintUser::userPrintOut);
            return 5;
        }else {
            PrintErrors.printErrorsList(personsResponse.getErrors());
            return 5;
        }
    }

    @Override
    public void printActionName() {
        System.out.println("Get all users");
    }
}
