package repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CoursesRepository<Course> implements Repository<Course> {

    private List<Course> course;

    public CoursesRepository() {
        this.course = new ArrayList<>();
    }
    @Override
    public int idGenerator() {
        int nextId = 1;
        return nextId++;
    }

    @Override
    public Integer addCourse(Course course){
        int courseID = idGenerator();
        course.setCourseId(courseID);
        course.add(course);
        return courseID;
    }
    @Override
    public List<Course> findAll(){
        return  new ArrayList<>(course);
    }

    @Override
    public Course finById(Integer courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)){
                return  course;
            }
        }

        return null;
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