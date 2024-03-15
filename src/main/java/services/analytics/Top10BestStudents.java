package services.analytics;
import java.util.List;

import core.entity.Person;
import repository.CoursesRepository;
import repository.Grades;
import repository.GradesRepositoryInterface;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.Comparator;

public class Top10BestStudents {
    private final PersonRepository personRepository;
    private final GradesRepositoryInterface gradesRepositoryInterface;
    private final CoursesRepository coursesRepository;
    public Top10BestStudents(PersonRepository personRepository, GradesRepositoryInterface gradesRepositoryInterface, CoursesRepository coursesRepository){
        this.personRepository = personRepository;
        this.gradesRepositoryInterface = gradesRepositoryInterface;
        this.coursesRepository = coursesRepository;
    }
    public List<Person> findTop10BestStudents() {
        List<Person> allStudents = personRepository.getAllStudents();
        List<Double> averageGrades = new ArrayList<>();
        for (Person person : allStudents) {
            List<Integer> studentGrades = gradesRepositoryInterface.getGradesByPersontId(person.getPersonId());
            double averageGrade = calculateAverageGrade(person-Grades);
            averageGrades.add(averageGrade);
        }
    }
    public List<Person> findTop10BestStudents(List<Person> persons, int topCount) {
        persons.sort(Comparator.comparingDouble(this::calculateAverageGrade).reversed());
        return persons.subList(0, Math.min(topCount, persons.size()));
    }

    private double calculateAverageGrade(Person person) {
        List<Integer> grades = person.getGrades();
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public List<Person> findBestStudentsOnCourse(List<Person> persons, int courseId, int topCount) {
        List<Person> courseStudents = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCourseId() == courseId) {
                courseStudents.add(person);
            }
        }
        return findTop10BestStudents(courseStudents, topCount);
    }
}