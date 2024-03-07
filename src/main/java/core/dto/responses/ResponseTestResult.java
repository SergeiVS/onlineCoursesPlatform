package core.dto.responses;

import java.util.Map;

// возвращает пользователю результат прохождения им теста.
public class ResponseTestResult {
     private final Integer personId;
     private final String courseName;
     //Ключом является номер вопроса, а значением правильный или неправильный ответ
     private final Map<Integer, Boolean> results;
     private final Integer grade;
    public ResponseTestResult(Integer personId, String courseName, Map<Integer, Boolean> results, Integer grade) {
        this.personId = personId;
        this.courseName = courseName;
        this.results = results;
        this.grade = grade;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Map<Integer, Boolean> getResults() {
        return results;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ResponseTestResult{" +
                "personId=" + personId +
                ", courseName='" + courseName + '\'' +
                ", results=" + results +
                ", grade=" + grade +
                '}';
    }
}
