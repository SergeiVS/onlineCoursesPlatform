package services.validation;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.AddChangeCourseDto;
import services.validation.ValidationInterface;
import services.validation.exeptions.FileReadingException;
import services.validation.exeptions.NullException;
import services.validation.exeptions.NumberException;

import java.io.File;
import java.util.List;

public class AddCourseDtoValidation implements ValidationInterface<AddChangeCourseDto> {
    @Override
    public boolean validate(AddChangeCourseDto addChangeCourseDto, List<ErrorsDto> errors) {
        boolean isValid = true;
        try {
            int courseId = addChangeCourseDto.getCourseId();
            String courseName = addChangeCourseDto.getCourseName();
            String materialSource = addChangeCourseDto.getMaterialSource();
            File file = new File(materialSource);

            if (!(file.exists())) {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "The course material file address is not correct"));
                isValid = false;
            }
        } catch (FileReadingException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_404, "No such file exist"));
            isValid = false;

        } catch (NumberException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "wrong number format"));
            isValid = false;
        } catch (NullException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
            isValid = false;
        }
        return isValid;
    }
}

