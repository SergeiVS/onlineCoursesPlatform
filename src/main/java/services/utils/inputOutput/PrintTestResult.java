package services.utils.inputOutput;

import java.util.Map;

public class PrintTestResult {
    public static void printMap(Map<Integer, Boolean> map){
        map.forEach((key, value) -> System.out.println("Answer: " + key + ", course title " + value));
    }
}
