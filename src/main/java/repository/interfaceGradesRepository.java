package repository;

import java.util.List;
import java.util.Map;

public interface interfaceGradesRepository {
    void addCourse(Integer courseId);
    Map<Object, Object> addStudentGrade(Integer courseId, Integer id, Integer grade);
    List<Integer> findGradesById(Integer courseId, Integer id);
    Map<Integer, List<Integer>> findAllGradesByCourse(Integer courseId);


}
