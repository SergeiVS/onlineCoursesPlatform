package services.utils.inputOutput;

import core.dto.responses.ResponseTestForPassing;

public class PrintQuestion {

    public static void printQuestion(ResponseTestForPassing.ResponseQuestion question){
        System.out.println(question.getQuestion());
        System.out.println("a. " + question.getAnswerA());
        System.out.println("b. " + question.getAnswerB());
        System.out.println("c. " + question.getAnswerC());
    }
}
