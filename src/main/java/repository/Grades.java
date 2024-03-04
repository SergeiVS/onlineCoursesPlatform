package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grades {
    private Map<Integer, Map<Integer, List<Integer>>> grades = new HashMap<>();

    //(Первый ключ- courseId, Ключ в значении- personId, Лист из Integer- результаты тестов.)
    public Grades(Map<Integer, Map<Integer, List<Integer>>> grades) {
        this.grades = grades;
    }

    public Map<Integer, Map<Integer, List<Integer>>> getGrades() {
        return grades;
    }

    public void addCourse(Integer courseId){
            grades.put(courseId, new HashMap<>());

    }
    public void addStudentGrade(Integer courseId, Integer studentId, Integer grade){

        if (grades.containsKey(courseId)) {
            Map<Integer, List<Integer>> courseGrades = grades.get(courseId);
            // Проверяем, существует ли студент в данном курсе
            if (courseGrades.containsKey(studentId)) {
                // Если студент найден, добавляем оценку в список его оценок
                courseGrades.get(studentId).add(grade);
            } else {
                // Если студент не найден, создаем новый список оценок и добавляем оценку
                List<Integer> studentGrades = List.of(grade);
                courseGrades.put(studentId, studentGrades);
            }
            }

    }
    public List<Integer> findGradesById(Integer courseId, Integer studentId) {

        if (grades.containsKey(courseId)) {
            Map<Integer, List<Integer>> courseGrades = grades.get(courseId);
            if (courseGrades.containsKey(studentId)) {
                return courseGrades.get(studentId);
            }
        }
        return List.of(); // Возвращаем пустой список, если курс или студент не найдены
    }


    public	Map<Integer, List<Integer>> findAllGradesByCourse(Integer courseId){
        return grades.getOrDefault(courseId, Map.of());
    }


}
