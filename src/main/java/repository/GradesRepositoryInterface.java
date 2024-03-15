package repository;

import java.util.List;
import java.util.Map;

public interface GradesRepositoryInterface {
    void addCourse(Integer courseId);
    void addStudentGrade(Integer courseId, Integer personId, Integer grade);
    List<Integer> findGradesById(Integer courseId, Integer personId);
    Map<Integer, List<Integer>> findAllGradesByCourse(Integer courseId);


}
