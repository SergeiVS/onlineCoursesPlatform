package services.testing;

import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestForPassing;
import core.entity.Person;
import core.entity.Test;
import repository.CoursesRepository;
import repository.Grades;
import repository.RepositoryInterface;
import repository.TestsRepository;
import services.validation.IntegerRequestValidation;
import services.validation.ValidationInterface;

import java.util.ArrayList;
import java.util.List;

public class TestForPassing {
    private final RepositoryInterface<Person> persons;
    private final CoursesRepository courses;
    private final Grades grades;
    private final TestsRepository tests;

    private final Test testToDo;
    public TestForPassing(RepositoryInterface<Person> persons, CoursesRepository courses, Grades grades, TestsRepository tests, Test testToDo) {
        this.persons = persons;
        this.courses = courses;
        this.grades = grades;
        this.tests = tests;
        this.testToDo = testToDo;
    }
    public Response<ResponseTestForPassing> initiateTest(Request<Integer> personIdRequest) {
        List<ErrorsDto> errors = new ArrayList<>();
        ValidationInterface<Request<Integer>> intValid = new IntegerRequestValidation();
        boolean isValid = intValid.validate(personIdRequest, errors);
        // Получаем personId из запроса
        Integer personId = personIdRequest.getRequest();
        // находим через репозиторий персон ид курса
        Integer searchedCourseId = persons.findById(personId).getCourseId();
        List<Integer> personGrades = grades.findGradesById(searchedCourseId, personId);
        Integer lastGrade = personGrades.size();
        List<Test> testsOfCourse = tests.findTestsByCourseId(searchedCourseId);
        Test nextTest = testsOfCourse.get(lastGrade);
        String nextTestName = nextTest.getTestName();
        // Создаем список для хранения вопросов для следующего теста
        List<ResponseTestForPassing.ResponseQuestion> questions = getQuestions(nextTest);
        return new Response<>(new ResponseTestForPassing(nextTestName, questions),errors);

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

