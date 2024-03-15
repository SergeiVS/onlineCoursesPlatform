package services.analytics;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.entity.Person;
import repository.Grades;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetStudentGrades {
    private final Grades grades;
    private final PersonRepository personRepository;

    public GetStudentGrades(Grades grades, PersonRepository personRepository) {
        this.grades = grades;
        this.personRepository = personRepository;
    }

    public Response<List<Integer>> studentsGrades(Request<Integer> personId){
        Optional<Person> person = Optional.ofNullable(personRepository.findById(personId.getRequest()));
        List<ErrorsDto> errors = new ArrayList<>();
        int courseId = 0;
        if (person.isPresent()){
            courseId = person.get().getCourseId();
            return new Response<>(grades.findGradesById(courseId, personId.getRequest()), errors);
        }else {
            errors.add(new ErrorsDto(ErrorCoding.E_404,"Student not found"));
            return new Response<>(new ArrayList<>(),errors);
        }
    }
}
