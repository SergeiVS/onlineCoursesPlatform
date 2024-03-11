package UI;

import core.dto.responses.Response;
import core.dto.responses.ResponseAllCourses;
import services.curseServices.FindCourseServices;
import services.utils.inputOutput.PrintCoursesMap;

import java.util.Map;
import java.util.Optional;

public class PrintCoursesMenu implements UIInterface{

   private final FindCourseServices services;
   private final StartMenu startMenu;

   private int userid = 0;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public PrintCoursesMenu(FindCourseServices services, StartMenu startMenu) {
        this.services = services;
        this.startMenu = startMenu;
    }

    @Override
    public void execute() {

        Response<ResponseAllCourses> allCoursesResponse = services.findAll();
        Optional<Map<Integer, String>> courses = Optional.ofNullable(allCoursesResponse.getResponse().getCoursesMap());

        if (courses.isPresent()){
            PrintCoursesMap.printMap(courses.get());

        }else {
            startMenu.execute();
        }

    }

    @Override
    public void printActionName() {
        System.out.println("List of courses");
    }
}
