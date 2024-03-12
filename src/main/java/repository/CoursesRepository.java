package repository;

import core.entity.Course;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//Управляет хранилищем Курсов добавляет/изменяет, поиск по имени, по ид и всех Курсов.
public class CoursesRepository implements RepositoryInterface<Course> {
//Список курсов
    private List<Course> courses;
    int idGenerator = 1;

       public CoursesRepository() {
        this.courses = new ArrayList<>();
    }

    // Генератор новых ИД
    public int idGenerate() {
        return idGenerator++;
    }
// Метод добавляет/изменяет Данные курса. Проверяет входящие данные на наличие ИД, если надо вызывает генератор ИД.
// Проверяет на наличие такого Ид в базе если оно есть изменяет поля, если такого ИД нет, то создаётся новый объект Курс
    @Override
    public Integer add(Course course) {

        int courseId = (course.getCourseId() == 0) ? idGenerate() : course.getCourseId();
        String courseName = course.getCourseName();
        boolean isActive = course.isActive();
        List<String> material = course.getMaterial();
        Course courseForAdd = findById(courseId);

        if (courseForAdd != null) {
            courseForAdd.setActive(isActive);
            courseForAdd.setMaterial(material);

        } else {
            courses.add(new Course(courseId, courseName, isActive, material));

        }
        return courseId;
    }
//Возвращает все курсы из базы данных
    @Override
    public List<Course> findAll() {

        return courses;
    }
// Ищет курс по ИД. В сервисе проверять на ноль!
    @Override
    public Course findById(Integer courseId) {

        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findAny()
                .orElse(null);

    }
// поиск по Имени В сервисе проверять полученный список на наличие записей.
    @Override
    public List<Course> findByName(String name) {
        return courses.stream()
                .filter(course -> course.getCourseName().equals(name))
                .collect(Collectors.toList());

    }


    @Override
    public String toString() {
        return "CoursesRepository{" +
                "courses=" + courses +
                '}';
    }
}