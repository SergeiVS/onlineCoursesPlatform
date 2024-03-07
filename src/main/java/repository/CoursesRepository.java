package repository;

import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CoursesRepository<Course> implements Repository<Course> {

    private List<Course> course;
    int idGenerator = 1;

    public CoursesRepository() {
        this.course = new ArrayList<>();
    }
    @Override
    public int idGenerator() {

        return idGenerator++;
    }

    @Override
    public Integer addCourse(Course course){
        if (course.getCourseID() == 0){
            course.setCourseId(idGenerator++);
        }
        course.add(course);
    }
    @Override
    public List<Course> findAll(){

        return  new ArrayList<>(course);
    }

    @Override
    public Course finById(Integer courseId) {
        return course.stream().filter(course -> course.getCourseId().equals(courseId)).collect(Collectors.toList());
    }

    public List<Course> getCourse() {

        return course;
    }

    @Override
    public String toString() {
        return "CoursesRepository{" +
                "course=" + course +
                '}';
    }
}