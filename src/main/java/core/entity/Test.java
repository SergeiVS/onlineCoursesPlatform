package core.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private Integer courseId;
    private String testName;
    private boolean isActive;
    private List<Question> questions;

    // Конструктор
    public Test(Integer courseId, String testName, boolean isActive) {
        this.courseId = courseId;
        this.testName = testName;
        this.isActive = isActive;
        this.questions = new ArrayList<>();
    }

    // Метод добавления вопроса
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Геттеры
    public String getTestName() {
        return testName;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "courseId=' " + courseId + '\'' +
                "testName='" + testName + '\'' +
                ", isActive=" + isActive +
                ", questions=" + questions +
                '}';
    }

    // Внутренний класс "Question"
    public class Question {
        private String question;
        private String answer_a;
        private String answer_b;
        private String answer_c;
        private String proofValue;

        // Конструктор
        public Question(String question, String answer_a, String answer_b, String answer_c, String proofValue) {
            this.question = question;
            this.answer_a = answer_a;
            this.answer_b = answer_b;
            this.answer_c = answer_c;
            this.proofValue = proofValue;
        }

        // Геттеры
        public String getQuestion() {
            return question;
        }

        public String getAnswer_a() {
            return answer_a;
        }

        public String getAnswer_b() {
            return answer_b;
        }

        public String getAnswer_c() {
            return answer_c;
        }

        public String getProofValue() {
            return proofValue;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "question='" + question + '\'' +
                    ", answer_a='" + answer_a + '\'' +
                    ", answer_b='" + answer_b + '\'' +
                    ", answer_c='" + answer_c + '\'' +
                    ", proofValue='" + proofValue + '\'' +
                    '}';
        }
    }



}

