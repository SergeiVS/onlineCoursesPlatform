package UI;

import core.dto.responses.Response;
import core.dto.responses.ResponseAllCourses;
import services.curseServices.FindCourseServices;
import services.utils.inputOutput.PrintCoursesMap;
import services.utils.inputOutput.PrintErrors;

import java.util.Map;
import java.util.Optional;

public class PrintCoursesMenu implements UIInterface{

   private final FindCourseServices services;


    public PrintCoursesMenu(FindCourseServices services) {
        this.services = services;
    }

    @Override
    public int execute() {

        Response<ResponseAllCourses> allCoursesResponse = services.findAll();
        Optional<Map<Integer, String>> courses = Optional.ofNullable(allCoursesResponse.getResponse().getCoursesMap());

        if (courses.isPresent()){
            PrintCoursesMap.printMap(courses.get());
            return 0;

        }else {
            PrintErrors.printErrorsList(allCoursesResponse.getErrors());
            return 0;
        }

    }

    @Override
    public void printActionName() {
        System.out.println("List of courses");
    }
}
