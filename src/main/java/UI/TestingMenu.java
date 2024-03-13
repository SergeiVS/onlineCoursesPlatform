package UI;

import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestForPassing;
import services.testing.TestForPassing;
import services.utils.inputOutput.PrintQuestion;
import services.utils.inputOutput.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestingMenu implements UIInterface{

    private final TestForPassing testResponse;

    public TestingMenu(TestForPassing test) {
        this.testResponse = test;
    }

    @Override
    public int execute() {
        printActionName();
        int personId = UserInput.insertInt("Please insert your personal id");
        Response<ResponseTestForPassing> testForPassing = testResponse.initiateTest(new Request<>(personId));
        Optional<ResponseTestForPassing> test = Optional.ofNullable(testForPassing.getResponse());
        List<Character> answers = new ArrayList<>();

        if (test.isPresent()){
            System.out.println(test.get().getTestName());
            List<ResponseTestForPassing.ResponseQuestion> questions = test.get().getQuestions();
            for (ResponseTestForPassing.ResponseQuestion question : questions){
                PrintQuestion.printQuestion(question);
                char answer = UserInput.insertString("Please mark right answer").charAt(0);
                while (answer != 'a' && answer != 'b' && answer != 'c'){
                    answer = UserInput.insertString("Answer must be 'a', 'b' or 'c'").charAt(0);
                }
                answers.add(answer);
            }

        }
        return 0;
    }

    @Override
    public void printActionName() {
        System.out.println("Test passing");
    }
}
