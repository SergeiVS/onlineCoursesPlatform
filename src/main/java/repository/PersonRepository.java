package repository;

import core.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository implements Repository<Person> {
    public List<Person> persons;
    public PersonRepository(List<Person> persons) {
        this.persons = persons;
        this.idGenerator = 1;
    }
    @Override
    public List<Person> getAll() {
        return persons;
    }
    public void register(Person person) {
        if (person.getPersonId() == 0) {
            person.setPersonId(idGenerator++);
        }
        persons.add(person);
    }
    public void registerAll(List<Person> newPersons) {
        for (Person person : newPersons) {
            if (person.getPersonId() == 0) {
                person.setPersonId(idGenerator++);
            }
        }
        persons.addAll(newPersons);
    }
    public List<Person> findByName(String lastName) {
        return persons.stream().filter(person -> person.getLastName().equals(lastName)).collect(Collectors.toList());
    }
    public List<Person> findByEmail(String email) {
        return persons.stream().filter(person -> person.getEmail().equals(email)).collect(Collectors.toList());
    }
    public List<Person> findByCourse(Integer CourseId) {
        return persons.stream().filter(person -> person.getCourseId().equals(courseId)).collect(Collectors.toList());
    }
    public List<Person> findByAccessType(String accessType) {
        return persons.stream().filter(person -> person.getAccessType().equals(accessType)).collect(Collectors.toList());
    }
}