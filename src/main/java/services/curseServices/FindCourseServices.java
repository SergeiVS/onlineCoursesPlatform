package services.curseServices;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.responses.Response;
import core.dto.responses.ResponseAllCourses;
import core.entity.Course;
import repository.CoursesRepository;
import services.utils.converters.Converters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
                coursesForReturn = (HashMap<Integer, String>) courses.stream()
                        .collect(Collectors.toMap(Course::getCourseId, Course::getCourseName));

                errors.add(new ErrorsDto(ErrorCoding.E_200, "Database found"));
            } else {
                errors.add(new ErrorsDto(ErrorCoding.E_404, "Database did not found"));
            }
        } catch (RuntimeException e) {
            errors.add(new ErrorsDto(ErrorCoding.E_400, e.getMessage()));
        }
        return new Response<>(new ResponseAllCourses(coursesForReturn), errors);
    }

}
