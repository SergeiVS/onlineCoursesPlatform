package UI;

import core.dto.requests.AddChangeCourseDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseCourse;
import services.curseServices.AddCourseService;
import services.utils.inputOutput.PrintCourseInformation;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.UserInput;

import java.util.Optional;

public class AddChangeCourseMenu implements UIInterface{
    private final AddCourseService addCourseService;

    public AddChangeCourseMenu(AddCourseService addCourseService) {
        this.addCourseService = addCourseService;
    }

    @Override
    public int execute() {
        printActionName();
        try {


        int courseId = UserInput.insertInt("Insert course id for change, new course insert 0");
        String courseName = UserInput.insertString("Please insert course name");
        boolean isActive = UserInput.insertBoolean("Please mark is course active");
        String path = UserInput.insertString("Please insert information file path");

        Response<ResponseCourse> courseResponse = addCourseService.addChangeCourse(new Request<>(new AddChangeCourseDto(courseId,courseName,isActive, path)));
        Optional<ResponseCourse> course = Optional.ofNullable(courseResponse.getResponse());

        if (course.isPresent()){
            System.out.println("Course added/changed successfully");
            PrintCourseInformation.printCourseInfo(course.get());
            return 5;
        }else {
            PrintErrors.printErrorsList(courseResponse.getErrors());
            return 5;
        }
    }catch (RuntimeException e){

            e.printStackTrace();
            return 5;
        }
    }

    @Override
    public void printActionName() {
        System.out.println("Add or change course");
    }
}
