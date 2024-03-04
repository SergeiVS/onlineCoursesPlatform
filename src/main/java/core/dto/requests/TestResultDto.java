package core.dto.requests;

import java.util.List;

// Передаёт в систему ответы пользователя на вопросы теста. поля ИД и название теста служат для проверки
// принадлежности ответа
public class TestResultDto {
    private final Integer personId;
    private final String testName;
    private final List<Character> answers;

    public TestResultDto(Integer personId, String testName, List<Character> answers) {
        this.personId = personId;
        this.testName = testName;
        this.answers = answers;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getTestName() {
        return testName;
    }

    public List<Character> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "TestResultDto{" +
                "personId=" + personId +
                ", testName='" + testName + '\'' +
                ", answers=" + answers +
                '}';
    }
}
