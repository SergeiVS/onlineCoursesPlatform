package services.utils.inputOutput;

import java.util.Map;

public class PrintCoursesMap {

    public static void printMap(Map<Integer, String> map){
        map.entrySet().forEach(entry -> System.out.println("course id: " + entry.getKey() + " " + entry.getValue()));
    }
}
