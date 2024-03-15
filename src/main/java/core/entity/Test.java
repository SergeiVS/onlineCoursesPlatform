package core.entity;

import java.util.*;

public class Test {

    private Integer courseId;
    private String testName;
    private boolean isActive;
    private List<Question> questions = new ArrayList<>();
    private final Map<Integer, Character> correctAnswers = new HashMap<>();

    // Конструктор


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

    public Map<Integer, Character> getCorrectAnswers() { return correctAnswers; }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Question question)) return false;
            return Objects.equals(getAnswerA(), question.getAnswerA()) && Objects.equals(getAnswerB(), question.getAnswerB()) && Objects.equals(getAnswerC(), question.getAnswerC()) && Objects.equals(getProofValue(), question.getProofValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAnswerA(), getAnswerB(), getAnswerC(), getProofValue());
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

