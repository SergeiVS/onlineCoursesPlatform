package core.dto.responses;

import java.util.ArrayList;
import java.util.List;

public class ResponseTestForPassing {
    private final String testName;
    private final List<ResponseQuestion> questions = new ArrayList<>();

    public ResponseTestForPassing(String testName, List<ResponseQuestion> questions) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public List<ResponseQuestion> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "ResponseTestForPassing{" +
                "testName='" + testName + '\'' +
                ", questions=" + questions +
                '}';
    }

    public static class ResponseQuestion {
        // нумерация вопросов происходит в сервисе который заполняет дто
        private final int questionNumber;
        private final String question;
        private final String answerA;
        private final String answerB;
        private final String answerC;


        public ResponseQuestion(int questionNumber, String question, String answerA, String answerB, String answerC) {

            this.questionNumber = questionNumber;
            this.question = question;
            this.answerA = answerA;
            this.answerB = answerB;
            this.answerC = answerC;

        }

        public int getQuestionNumber() {
            return questionNumber;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswerB() {
            return answerB;
        }

        public String getAnswerC() {
            return answerC;
        }

        @Override
        public String toString() {
            return "ResponseQuestion{" +
                    "questionNumber=" + questionNumber +
                    ", question='" + question + '\'' +
                    ", answerA='" + answerA + '\'' +
                    ", answerB='" + answerB + '\'' +
                    ", answerC='" + answerC + '\'' +
                    '}';
        }
    }
}
