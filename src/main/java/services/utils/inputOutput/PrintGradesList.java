package services.utils.inputOutput;

import java.util.List;

public class PrintGradesList {
    public static void printGrades(List<Integer> grades){

        for (int i = 0; i < grades.size(); i++) {
            System.out.println("Module " + (i+1) + grades.get(i));
        }
    }
}
