package core.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final String name;
    private final boolean isActive;
    private final List<Question> questions = new ArrayList<>();

    // Конструктор
    public Test(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;

    }

    // Геттеры
    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Question> getQuestions() {
        return questions;
    }
    public void addQuestion(Question question) {questions.add(question);}
    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                ", questions=" + questions +
                '}';
    }


    public static class Question {
        // Метод добавления вопроса
        private final String question;
        private final String answer_a;
        private final String answer_b;
        private final String answer_c;
        private final String proofValue;

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

