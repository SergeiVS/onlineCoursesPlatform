package core.dto.responses;

import java.util.HashMap;

// используется для передачи пользователю информации ИД и названия всех курсов
public class ResponseAllCourses{
    private final HashMap<Integer, String> coursesMap;

    public ResponseAllCourses(HashMap<Integer, String> coursesMap) {
        this.coursesMap = coursesMap;
    }


    public HashMap<Integer, String> getCoursesMap() {
        return coursesMap;
    }

    @Override
    public String toString() {
        return "ResponseAllCourses{" +
                "coursesMap=" + coursesMap +
                '}';
    }
}
