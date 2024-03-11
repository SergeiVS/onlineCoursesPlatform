package services.curseServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseAllCourses;
import core.dto.responses.ResponseCourse;
import core.entity.Course;
import repository.CoursesRepository;
import services.utils.converters.Converters;
import services.validation.IntegerRequestValidation;
import services.validation.StringRequestValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindCourseServices {
    private final CoursesRepository coursesRepository;

    public FindCourseServices(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Response<ResponseAllCourses> findAll() {

        List<ErrorsDto> errors = new ArrayList<>();
        HashMap<Integer, String> coursesForReturn = new HashMap<>();

        try {

            List<Course> courses = coursesRepository.findAll();

            if (!courses.isEmpty()) {

                coursesForReturn = getAllCoursesMap(courses);

                errors.add(new ErrorsDto(ErrorCoding.E_200, "Database found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
        }
        return new Response<>(new ResponseAllCourses(coursesForReturn), errors);
    }

    public Response<ResponseCourse> findById(Request<Integer> courseId) {
        IntegerRequestValidation validation = new IntegerRequestValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        ResponseCourse responseCourse = null;
        boolean isValid = false;
        Course foundCourse = null;

        try {

            isValid = validation.validate(courseId, errors);

            if (isValid) {
                foundCourse = coursesRepository.findById(courseId.getRequest());
            }
            if (foundCourse != null) {
                var id = foundCourse.getCourseId();
                var name = foundCourse.getCourseName();
                var material = foundCourse.getMaterial();
                responseCourse = new ResponseCourse(id, name, material);
                errors.add(new ErrorsDto(ErrorCoding.E_200, "Course found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Course did not found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Database error"));
        }
        return new Response<>(responseCourse, errors);
    }

    public Response<List<ResponseCourse>> findByName(Request<String> courseName) {

        StringRequestValidation validation = new StringRequestValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        List<ResponseCourse> responseCourses = new ArrayList<>();
        List<Course> foundCourses = new ArrayList<>();
        boolean isValid = false;

        try {
            isValid = validation.validate(courseName, errors);

            if (isValid) {
                foundCourses = coursesRepository.findByName(courseName.getRequest());
            }

            if (foundCourses != null) {

                Converters.courseToResponseCourse(foundCourses, responseCourses);

                errors.add(new ErrorsDto(ErrorCoding.E_200, "Course found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Course did not found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, "Database error"));
        }
        return new Response<>(responseCourses, errors);
    }


    private static HashMap<Integer, String> getAllCoursesMap(List<Course> courses) {
        HashMap<Integer, String> coursesForReturn;
        coursesForReturn = (HashMap<Integer, String>) courses.stream()
                .collect(Collectors.toMap(Course::getCourseId, Course::getCourseName));
        return coursesForReturn;
    }

}
