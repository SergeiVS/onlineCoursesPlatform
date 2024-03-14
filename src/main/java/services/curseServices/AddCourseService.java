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
import services.utils.inputOutput.PrintErrors;
import services.validation.AddCourseDtoValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

                materialSource = courseDto.getRequest().getMaterialSource();


                Optional<List<String>> course = Optional.ofNullable(courseFromFile.readFromFile(materialSource));

                if (course.isPresent()) {

                    courseId = Integer.parseInt(course.get().get(0));
                    courseName = course.get().get(1);
                    isActive = courseDto.getRequest().isActive();

                    listOverWrite(course, courseMaterial);

                    coursesRepository.add(new Course(courseId, courseName, isActive, courseMaterial));
                    errors.add(new ErrorsDto(E_201, "New course data are added"));
                }
            }

        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
            PrintErrors.printErrorsList(errors);
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
        }
        return new Response<ResponseCourse>(new ResponseCourse(courseId, courseName, courseMaterial), errors);
    }

    private static void listOverWrite(Optional<List<String>> course, List<String> courseMaterial) {
        for (int i = 2; i < course.get().size(); i++) {
            courseMaterial.add(String.valueOf(course.get()));
        }
    }

}
