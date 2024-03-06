package repository;

import core.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository implements Repository <Person> {
    private List<Person> persons;
    private Map<Integer, Person> personMap;
    private int idCounter;
    public PersonRepository() {
        this.persons = new ArrayList<>();
        this.personMap = new HashMap<>();
        this.idCounter = 1;
    }
    @Override
    public void add(Person person) {
        int id = idGenerator();
        person.setId(id);
        persons.add(person);
        personMap.put(id,person);
        return id;
    }
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }
    public List<Person> findByName(String lastName) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                result.add(person);
            }
        }
        return result;
    }
    public Person findById(Integer id) {
        return personMap.get(id);
    }
    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.geteMail().equals(email)) {
                return person;
            }
        }
        return null;
    }
    public List<Person> findByCourse(String courseName) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCourseName().contains (courseName)) {
                result.add(person);
            }
        }
        return result;
    }
    public List<Person> findByAccessType(String accessType) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAccessType().equals(accessType)) {
                result.add(person);
            }
        }
        return result;
    }
    private int idGenerator() {
        return idCounter++;
    }
    public List<Person> getPersons() {
        return persons;
    }
}
