package services;


import core.dto.requests.Request;
import core.dto.responses.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestLoader {

    private TestRepositoryService testRepositoryService;

    public TestLoader(TestRepositoryService testRepositoryService) {
        this.testRepositoryService = testRepositoryService;
    }

    public void loadTests(String loadTestsFilePath) {
        try {
            // Чтение всех путей к файлам тестов
            List<String> testFilePaths = Files.readAllLines(Paths.get(loadTestsFilePath));

            // Перебор всех путей и добавление каждого теста в репозиторий
            for (String testFilePath : testFilePaths) {
                Request<String> testFileRequest = new Request<>(testFilePath);
                Response<String> response = testRepositoryService.addTestFromFile(testFileRequest);
                if (!response.getErrors().isEmpty()) {
                    System.out.println("Errors occurred while adding the test: " + response.getErrors());
                } else {
                    System.out.println("Test added successfully from: " + testFilePath);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the tests list file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
