package services;

import core.dto.requests.Request;
import core.dto.requests.TestResultDto;
import core.dto.responses.Response;
import core.dto.responses.ResponseTestForPassing;
import core.dto.responses.ResponseTestResult;

public class TestingService {
    Response<ResponseTestForPassing> initiateTest(Request<Integer> personId){
        return null ;
    }

    Response<ResponseTestResult> validateTestResult(Request<TestResultDto> result){
        return null;
    }



}
