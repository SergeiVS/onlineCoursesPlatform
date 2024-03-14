package UI;

import core.dto.requests.Request;
import core.dto.responses.Response;
import services.TestRepositoryService;
import services.utils.inputOutput.UserInput;

import java.io.IOException;
import java.util.Optional;

public class AddTestMenu implements UIInterface{
    private final TestRepositoryService service;

    public AddTestMenu(TestRepositoryService service) {
        this.service = service;
    }

    @Override
    public int execute(){

        printActionName();
        String path = UserInput.insertString("Please insert test file path");
try {


        Response<String> response = service.addTestFromFile(new Request<>(path));
        Optional<String> message = response.getResponse().describeConstable();
        if(message.isPresent()){
            System.out.println(message.get());
            System.out.println(response.getErrors());
        }else {
            System.out.println(response.getErrors());
        }
}catch (IOException e){
    e.getMessage();
    return 5;
}
        return 5;
    }

    @Override
    public void printActionName() {
        System.out.println("Add test menu");
    }
}
