package repository;

import core.entity.Test;

import java.util.List;
import java.util.Map;

public interface TestsRepositoryInterface {
    Map<Integer, Test> findAll();
    List<Test> findTestsByCourseId(Integer courseId);
    void addCourse(Integer courseId);
    void addTest(Integer courseId, Test test);
}
