package services;

import core.dto.requests.Request;
import core.dto.requests.TestResultDto;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestForPassing;
import core.dto.responses.ResponseTestResult;
import core.entity.Test;
import repository.Grades;
import repository.TestsRepository;

import java.util.List;

public class TestingService {
    public Response<ResponseTestForPassing> initiateTest(Request<Integer> personIdRequest) {
        // Получаем personId из запроса
        Integer personId = personIdRequest.getRequest();
        // находим через репозиторий персон ид курса
        Integer courseId = findById(personId).getCourseId();
        Grades grades = new Grades();
        List<Integer> personGrades = grades.findGradesById(courseId, personId);
        Integer lastGrade = personGrades.size();
        TestsRepository tests= new TestsRepository();
        List<Test> testsOfCourse = tests.findTestsByCourseId(courseId);
        Test nextTest = testsOfCourse.get(lastGrade);
        String nextTestName = nextTest.getTestName();
        return new Response<>(new ResponseTestForPassing(nextTestName));

    }



    Response<ResponseTestResult> validateTestResult(Request<TestResultDto> result){
        return null;
    }



}
