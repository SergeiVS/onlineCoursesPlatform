package core.entity;

public class Question {

    private String question;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;
    private String proofValue;

    public Question(String question, String answer_a, String answer_b, String answer_c, String answer_d, String proofValue) {
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.proofValue = proofValue;
    }

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

    public String getAnswer_d() {
        return answer_d;
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
                ", answer_d='" + answer_d + '\'' +
                ", proofValue='" + proofValue + '\'' +
                '}';
    }
}
