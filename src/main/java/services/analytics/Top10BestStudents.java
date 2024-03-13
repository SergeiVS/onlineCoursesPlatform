package services.analytics;
import java.util.List;

import core.entity.Person;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.Comparator;

public class Top10BestStudents {
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