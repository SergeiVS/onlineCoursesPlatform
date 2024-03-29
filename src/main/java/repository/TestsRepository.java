package repository;

import core.entity.Test;

import java.util.*;

public class TestsRepository implements TestsRepositoryInterface {
    private Map<Integer, List<Test>> tests;

    public TestsRepository() {
        this.tests = new HashMap<>();
    }

    @Override
    public Map<Integer, List<Test>> findAll() {
        return tests;
    }

    @Override
    public List<Test> findTestsByCourseId(Integer courseId) {
        List<Test> testsByCourseId = tests.getOrDefault(courseId, Collections.emptyList());

        return testsByCourseId;
    }

    @Override
    public void addCourse(Integer courseId) {
        // Проверяем, не содержит ли уже карта такой ключ
        if (!tests.containsKey(courseId)) {
            // Добавляем идентификатор курса как ключ в карту
            tests.put(courseId, new ArrayList<>()); // При этом можно использовать null в качестве значения, или установить значение как угодно
        }

    }

    @Override
    public void addTest(Integer courseId, Test test) {
        //проверяем есть ли для данного ид уже список тестов, если нет, то создаем новый
        tests.get(courseId).add(test);
                 //добавляем в список новый тест
    }

    public Test findTestByName(String testName) {
        for (List<Test> courseTests : tests.values()) {
            for (Test test : courseTests) {
                if (test.getTestName().equals(testName)) {
                    return test;
                }
            }
        }
        return null;
    }

    public Map<Integer, List<Test>> getTests() {
        return tests;
    }

}
