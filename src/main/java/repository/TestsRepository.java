package repository;

import core.entity.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestsRepository implements TestsRepositoryInterface{
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
        return tests.entrySet().stream()
                .filter(entry -> entry.getKey().equals(courseId)) //фильтруем по ид
                .flatMap(entry -> entry.getValue().stream())//собираем все тесты
                .collect(Collectors.toList()); //добавляем в список
    }

    @Override
    public void addCourse(Integer courseId) {
        // Проверяем, не содержит ли уже карта такой ключ
        if (!tests.containsKey(courseId)) {
            // Добавляем идентификатор курса как ключ в карту
            tests.put(courseId, null); // При этом можно использовать null в качестве значения, или установить значение как угодно
        }

    }

    @Override
    public void addTest(Integer courseId, Test test) {
        //проверяем есть ли для данного ид уже список тестов, если нет, то создаем новый.
        tests.computeIfAbsent(courseId, k -> new ArrayList<>())
                .add(test); //добавляем в список новый тес
    }



}
