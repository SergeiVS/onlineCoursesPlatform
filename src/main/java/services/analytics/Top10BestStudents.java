//package services.analytics;
//import java.util.List;
//
//import core.entity.Person;
//import repository.CoursesRepository;
//import repository.Grades;
//import repository.GradesRepositoryInterface;
//import repository.PersonRepository;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class Top10BestStudents {
//    private final PersonRepository personRepository;
//
//    public Top10BestStudents(PersonRepository personRepository, Grades gradesRepository, CoursesRepository coursesRepository) {
//        this.personRepository = personRepository;
//        this.gradesRepository = gradesRepository;
//        this.coursesRepository = coursesRepository;
//    }
//
//    private final Grades gradesRepository;
//    private final CoursesRepository coursesRepository;
//
//    public List<Person> findTop10BestStudents() {
//        List<Person> allStudents = personRepository.findAll();
//        List<Double> averageGrades = new ArrayList<>();
//        for (Person person : allStudents) {
//            List<Integer> studentGrades = gradesRepository.findGradesById(person.getCourseId(), person.getPersonId());
//            double averageGrade = calculateAverageGrade(person);
//            averageGrades.add(averageGrade);
//        }
//        return findBestStudentsOnCourse(allStudents,)
//    }
//    public List<Person> findTop10BestStudents(List<Person> persons, int topCount) {
//        persons.sort(Comparator.comparingDouble(this::calculateAverageGrade).reversed());
//        return persons.stream().limit(topCount).toList();
//    }
//
//    private double calculateAverageGrade(Person person) {
//        List<Integer> grades = gradesRepository.findGradesById(person.getCourseId(), person.getPersonId());
//        int sum = 0;
//        for (int grade : grades) {
//            sum += grade;
//        }
//        return (double) sum / grades.size();
//    }
//
//    public List<Person> findBestStudentsOnCourse(List<Person> persons, int courseId, int topCount) {
//        List<Person> courseStudents = new ArrayList<>();
//        for (Person person : persons) {
//            if (person.getCourseId() == courseId) {
//                courseStudents.add(person);
//            }
//        }
//        return findTop10BestStudents(courseStudents, topCount);
//    }
//}