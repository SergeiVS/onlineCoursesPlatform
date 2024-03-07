package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.TestResultDto;


import java.util.List;
// проверяет входные данные нового пользователя на нуль, на наличие информации в полях, на соответствие
// длинны списка ответов количеству вопросов, на Исключения.
public class TestResultValidation implements ValidationInterface<TestResultDto> {

    boolean isValid = true;


    @Override
    public boolean validate(TestResultDto testResultDto, List<ErrorsDto> errors) {
        boolean isValid = true;

        try {
            if(testResultDto == null){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "request can not be null"));
                return false;
            }
            int personId = testResultDto.getPersonId();
            String testName = testResultDto.getTestName();
            List<Character> answers = testResultDto.getAnswers();

            if (personId == 0 || testName == null || answers.isEmpty()){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "All fields must be filled"));
                isValid = false;
            }

            if (answers.size() != 10){
                errors.add(new ErrorsDto(ErrorCoding.E_400, "All 10 questions must be answered"));
                isValid = false;
            }

        }catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}
