package services.utils.fileReder;

import core.entity.Test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// считывает из файла данные теста для проверки знаний пользователя.
public class ReadTestFromFile implements ReadFromFile<Test> {

    // Метод возвращает готовый объект класса Test. На вход получает путь к нужному файлу и ид курса для проверки
    @Override
    public Test readFromFile(String path) throws IOException {

        int questionsCounter = 0;
        int numberOfQuestions = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String readLine;
        Integer readCourseId = 0;
        String testName = null;
        boolean isActive = false;
        final var readTest = new Test(readCourseId, testName, isActive);

        try {

            while ((readLine = reader.readLine()) != null) {

                if (readLine.toLowerCase().contains("number_of_questions")) {
                    numberOfQuestions = Integer.parseInt(getString(readLine));
                }
                if (readLine.toLowerCase().contains("course_id")) {
                    readCourseId = Integer.parseInt(getString(readLine));
                }
                if (readLine.toLowerCase().contains("test_name")) {
                    testName = getString(readLine);
                }
                if (readLine.toLowerCase().contains("is_active")) {
                    isActive = Boolean.parseBoolean(getString(readLine));
                }
                if (readLine.contains("##")) {
                    Test.Question question = getQuestion(readLine, reader);
                    readTest.addQuestion(question);
                    questionsCounter++;
                }
            }

            reader.close();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Input output failed");
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return readTest;
    }


    private static String getString(String readLine) {
        return readLine.split("=")[1].trim();
    }

    private static Test.Question getQuestion(String readLine, BufferedReader reader) throws IOException {


        readLine = reader.readLine();
        String question = null;
        String answerA = null;
        String answerB = null;
        String answerC = null;
        String proofValue = null;

        question = getStringText(readLine, "question");
        readLine = reader.readLine();
        answerA = getStringText(readLine, "answer_a");
        readLine = reader.readLine();
        answerB = getStringText(readLine, "answer_b");
        readLine = reader.readLine();
        answerC = getStringText(readLine, "answer_c");
        readLine = reader.readLine();
        proofValue = getStringText(readLine, "proof_value");
        readLine = reader.readLine();

        return new Test.Question(question, answerA, answerB, answerC, proofValue);
    }

    //внутренний метод для считывания значения типа String
    private static String getStringText(String readLine, String s) {
        if (readLine.split("=")[0].trim().toLowerCase().equals(s)) {
            return readLine.split("=")[1].trim();
        } else return null;
    }


}
