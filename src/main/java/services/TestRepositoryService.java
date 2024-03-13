package services;

import core.dto.errors.ErrorCoding;
import core.dto.errors.ErrorsDto;
import core.dto.requests.Request;
import core.dto.responses.Response;
import core.entity.Test;
import repository.TestsRepository;
import services.utils.fileReder.ReadTestFromFile;
import services.validation.StringRequestValidation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestRepositoryService {

    private final TestsRepository repository;
    private final ReadTestFromFile testFromFile;

    public TestRepositoryService(TestsRepository repository, ReadTestFromFile testFromFile) {
        this.repository = repository;
        this.testFromFile = testFromFile;
    }

    public Response<String> addTestFromFile(Request<String> path) throws IOException {

        StringRequestValidation validation = new StringRequestValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        boolean isValid = validation.validate(path, errors);
        try {
            File file = new File(path.toString());
             Optional<Test> test = Optional.empty();

            if (file.exists()) {
                 test = Optional.ofNullable(testFromFile.readFromFile(String.valueOf(path)));

            }else {errors.add(new ErrorsDto(ErrorCoding.E_404, "File not found"));}
           if (test.isPresent()) {
               int courseId = test.get().getCourseId();
               repository.addTest(courseId, test.get());

           }
        }


    }
}
