package UI;

import core.dto.requests.Request;
import core.dto.responses.Response;
import core.dto.responses.ResponseCourse;
import services.curseServices.FindCourseServices;
import services.utils.inputOutput.PrintCourseInformation;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.UserInput;

import java.util.Optional;

public class GetCourseInformationMenu implements UIInterface{

 private final FindCourseServices courseServices;

 public GetCourseInformationMenu(FindCourseServices courseServices) {
  this.courseServices = courseServices;
 }

 @Override
    public int execute() {
  printActionName();

  try {

  int courseId = UserInput.insertInt("Please insert course Id");


   Response<ResponseCourse> courseResponse = courseServices.findById(new Request<>(courseId));
   Optional <ResponseCourse> course = Optional.ofNullable(courseResponse.getResponse());

   if (course.isPresent()){
       PrintCourseInformation.printCourseInfo(course.get());
       return 0;
   }else {
       System.out.println("Error! course not found");
       PrintErrors.printErrorsList(courseResponse.getErrors());
       return 0;
   }
 }catch (RuntimeException e){
      e.printStackTrace();
      return 0;
  }
  }


    @Override
    public void printActionName() {
        System.out.println("Get course info");
    }
}
