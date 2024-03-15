package UI;

import core.dto.requests.Request;
import core.dto.responses.Response;
import services.analytics.GetStudentGrades;
import services.utils.inputOutput.PrintErrors;
import services.utils.inputOutput.PrintGradesList;
import services.utils.inputOutput.UserInput;

import java.util.List;
import java.util.Optional;

public class GetGradesMenu implements UIInterface {
    private final GetStudentGrades grades;

    public GetGradesMenu(GetStudentGrades grades) {
        this.grades = grades;
    }

    @Override
    public int execute() {
        printActionName();
        try {
            int personId = UserInput.insertInt("Insert user id");
            Response<List<Integer>> gradesResponse = grades.studentsGrades(new Request<>(personId));
            Optional<List<Integer>> gradesList = Optional.ofNullable(gradesResponse.getResponse());
            if (gradesList.isPresent()){
                PrintGradesList.printGrades(gradesList.get());
            }else {
                PrintErrors.printErrorsList(gradesResponse.getErrors());
            }
        }catch (RuntimeException e){
            e.getMessage();
        }


        return 4;
    }

    @Override
    public void printActionName() {
        System.out.println("Get students grades");
    }
}
