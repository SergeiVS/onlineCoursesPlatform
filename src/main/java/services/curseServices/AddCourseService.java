package services.curseServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.AddChangeCourseDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseCourse;
import core.entity.Course;
import repository.CoursesRepository;
import services.utils.fileReder.ReadCourseFromFile;
import services.validation.AddCourseDtoValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static core.dto.errors.ErrorCoding.E_201;

public class AddCourseService {
    private final CoursesRepository coursesRepository;
    private final ReadCourseFromFile courseFromFile;

    public AddCourseService(CoursesRepository coursesRepository, ReadCourseFromFile courseFromFile) {
        this.coursesRepository = coursesRepository;
        this.courseFromFile = courseFromFile;
    }

    public Response<ResponseCourse> addChangeCourse(Request<AddChangeCourseDto> courseDto) {

        AddCourseDtoValidation validation = new AddCourseDtoValidation();
        int courseId = 0;
        String courseName = null;
        String materialSource = null;
        boolean isActive = false;
        List<String> courseMaterial = new ArrayList<>();
        List<ErrorsDto> errors = new ArrayList<>();

        try {
            if (validation.validate(courseDto.getRequest(), errors)) {

                courseId = courseDto.getRequest().getCourseId();
                courseName = courseDto.getRequest().getCourseName();
                isActive = courseDto.getRequest().isActive();
                materialSource = courseDto.getRequest().getMaterialSource();
                courseMaterial = courseFromFile.readFromFile(materialSource);
                coursesRepository.add(new Course(courseId, courseName, isActive, courseMaterial));
                errors.add(new ErrorsDto(E_201, "New course data are added"));
            }

        }catch (RuntimeException | IOException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
        }
        return new Response<ResponseCourse>(new ResponseCourse(courseId,courseName,courseMaterial), errors);
    }

}
