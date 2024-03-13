package services.testing;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestForPassing;
import core.entity.Person;
import core.entity.Test;
import repository.Grades;
import repository.RepositoryInterface;
import repository.TestsRepository;
import services.validation.IntegerRequestValidation;
import services.validation.ValidationInterface;

import java.util.ArrayList;
import java.util.List;

public class TestForPassing {
    private final RepositoryInterface<Person> persons;
    private final Grades grades;
    private final TestsRepository tests;

    public TestForPassing(RepositoryInterface<Person> persons, Grades grades, TestsRepository tests) {
        this.persons = persons;
        this.grades = grades;
        this.tests = tests;
    }


    public Response<ResponseTestForPassing> initiateTest(Request<Integer> personIdRequest) {

        List<ErrorsDto> errors = new ArrayList<>();
        List<ResponseTestForPassing.ResponseQuestion> questions = new ArrayList<>();
        String nextTestName = "name";
        try {
            ValidationInterface<Request<Integer>> intValid = new IntegerRequestValidation();
            boolean isValid = intValid.validate(personIdRequest, errors);
            if (!isValid) {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            } else {
                // Получаем personId из запроса
                Integer personId = personIdRequest.getRequest();
                // находим через репозиторий персон ид курса
                Integer searchedCourseId = persons.findById(personId).getCourseId();
                List<Integer> personGrades = grades.findGradesById(searchedCourseId, personId);
                Integer lastGrade = personGrades.size();
                List<Test> testsOfCourse = tests.findTestsByCourseId(searchedCourseId);
                Test nextTest = testsOfCourse.get(lastGrade);
                nextTestName = nextTest.getTestName();
                // Создаем список для хранения вопросов для следующего теста
                questions = getQuestions(nextTest);

            }

        } catch (Exception e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Internal database error"));
        }
        return new Response<>(new ResponseTestForPassing(nextTestName, questions), errors);
    }

    private static List<ResponseTestForPassing.ResponseQuestion> getQuestions(Test nextTest) {
        List<ResponseTestForPassing.ResponseQuestion> questions = new ArrayList<>();
        // Перебираем вопросы из следующего теста и создаем для каждого объект ResponseQuestion
        for (int i = 0; i < nextTest.getQuestions().size(); i++) {
            Test.Question question = nextTest.getQuestions().get(i);
            ResponseTestForPassing.ResponseQuestion responseQuestion = new ResponseTestForPassing.ResponseQuestion(
                    i + 1,
                    question.getQuestion(),
                    question.getAnswerA(),
                    question.getAnswerB(),
                    question.getAnswerC()
            );
            // Добавляем созданный объект ResponseQuestion в список вопросов для следующего теста
            questions.add(responseQuestion);
        }
        return questions;
    }

}

