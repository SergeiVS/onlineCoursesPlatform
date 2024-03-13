package services.utils.inputOutput;

import core.dto.responses.ResponseCourse;

public class PrintCourseInformation {
    public static  void printCourseInfo(ResponseCourse course){

        System.out.println("Course id: " + course.getCourseId());
        System.out.println("Course title: " + course.getCourseName());
        course.getCourseMaterial()
                .forEach(System.out::println);
    }
}
