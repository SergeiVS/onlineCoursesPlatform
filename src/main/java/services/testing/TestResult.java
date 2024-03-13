package services.testing;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.requests.TestResultDto;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestResult;
import core.entity.Person;
import core.entity.Test;
import repository.Grades;
import repository.RepositoryInterface;
import repository.TestsRepository;
import services.validation.TestResultValidation;
import services.validation.ValidationInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {
    private final RepositoryInterface<Person> persons;
    private final Grades grades;
    private final TestsRepository tests;

    public TestResult(RepositoryInterface<Person> persons, Grades grades, TestsRepository tests) {
        this.persons = persons;
        this.grades = grades;
        this.tests = tests;
    }

    public Response<ResponseTestResult> validateTestResult(Request<TestResultDto> result) {
        List<ErrorsDto> errors = new ArrayList<>();
        Integer personId = null;
        Integer courseId = null;
        Map<Integer, Boolean> results = new HashMap<>();
        Integer grade = null;

        try {
            TestResultDto testResultDto = result.getRequest();
            personId = testResultDto.getPersonId();
            String testName = testResultDto.getTestName();

            // Проверяем валидность входных данных
            ValidationInterface<TestResultDto> testResultValid = new TestResultValidation();
            boolean isValid = testResultValid.validate(testResultDto, errors);

            if (!isValid) {
                // Возвращаем сообщение о невалидности входных данных
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            } else {

                // Получаем courseId из запроса
                courseId = persons.findById(personId).getCourseId();

                // Получаем список ответов пользователя
                List<Character> userAnswers = testResultDto.getAnswers();

                // Ищем тест по его имени
                Test test = tests.findTestByName(testName);

                // Получаем правильные ответы для этого теста
                Map<Integer, Character> correctAnswers = test.getCorrectAnswers();

                // Подсчитываем количество правильных ответов
                int correctAnswersCount = 0;
                for (int i = 0; i < userAnswers.size(); i++) {
                    Character userAnswer = userAnswers.get(i);
                    Character correctAnswer = correctAnswers.get(i + 1); // Индексы в карте начинаются с 1

                    if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                        correctAnswersCount++;
                    }
                    boolean isCorrect = correctAnswer != null && correctAnswer.equals(userAnswer);
                    results.put(i + 1, isCorrect); // Индексы в results также начинаются с 1
                }

                // Добавляем оценку в базу данных
                grade = correctAnswersCount;
                grades.addStudentGrade(courseId, personId, grade);
            }

        } catch (Exception e) {
            // Обрабатываем возникшее исключение
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Internal database error"));
        }
        return new Response<>(new ResponseTestResult(personId, courseId, results, grade), errors);
    }
}