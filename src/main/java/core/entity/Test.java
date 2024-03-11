package core.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private Integer courseId;
    private String testName;
    private boolean isActive;
    private List<Question> questions;
    private Map<Integer, String> correctAnswers;

    // Конструктор
    public Test(Integer courseId, String testName, boolean isActive) {
        this.courseId = courseId;
        this.testName = testName;
        this.isActive = isActive;
        this.questions = new ArrayList<>();
        this.correctAnswers = new HashMap<>();
    }

    // Метод добавления вопроса
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Геттеры
    public String getTestName() {
        return testName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Map<Integer, String> getCorrectAnswers() { return correctAnswers; }

    @Override
    public String toString() {
        return "Test{" +
                "courseId=' " + courseId + '\'' +
                "testName='" + testName + '\'' +
                ", isActive=" + isActive +
                ", questions=" + questions +
                ", correctAnswers=" + correctAnswers +
                '}';
    }

    // Внутренний класс "Question"
    public static class Question {
        private String question;
        private String answerA;
        private String answerB;
        private String answerC;
        private String proofValue;

        // Конструктор
        public Question(String question, String answerA, String answerB, String answerC, String proofValue) {
            this.question = question;
            this.answerA = answerA;
            this.answerB = answerB;
            this.answerC = answerC;
            this.proofValue = proofValue;
        }

        // Геттеры
        public String getQuestion() {
            return question;
        }

        public String getAnswerA() {
            return answerA;
        }

        public String getAnswerB() {
            return answerB;
        }

        public String getAnswerC() {
            return answerC;
        }

        public String getProofValue() {
            return proofValue;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "question='" + question + '\'' +
                    ", answerA='" + answerA + '\'' +
                    ", answerA='" + answerA + '\'' +
                    ", answerA='" + answerA + '\'' +
                    ", proofValue='" + proofValue + '\'' +
                    '}';
        }
    }



}

