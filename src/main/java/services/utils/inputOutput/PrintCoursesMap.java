package services.utils.inputOutput;

import java.util.Map;

public class  PrintCoursesMap {



    public static void printMap(Map<Integer, String> map){

        map.forEach((key, value) -> System.out.println("course id: " + key + ", course title " + value));
    }
}
