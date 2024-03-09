package repository;

import core.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements RepositoryInterface<Person> {
    private List<Person> persons;
    private int idGenerator = 30;

    public PersonRepository() {
        this.persons = new ArrayList<>();
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public List<Person> findByName(String lastName) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findById(Integer id) {
        for (Person person : persons) {
            if (person.getPersonId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> findByCourse(Integer courseId) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCourseId().equals(courseId)) {
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
        return result.isEmpty() ? null : result;
    }

    public Integer add(Person person) {
        int personId = (person.getPersonId() == 0) ? idGenerate() : person.getPersonId();
        String fName = person.getFirstName();
        String lName = person.getLastName();
        String email = person.getEmail();
        int courseId = person.getCourseId();
        String accessType = person.getAccessType();

        persons.add(new Person(personId, fName, lName, email, courseId, accessType));
        return personId;
    }

    private int idGenerate() {
        return idGenerator++;
    }

}

