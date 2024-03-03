package services.Utils.fileReder;

import core.entity.Test;
import services.validation.FileReadingException;
import services.validation.NumberException;

import services.validation.WrongFileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

// считывает из файла данные теста для проверки знаний пользователя.
public class TestsReadFrom implements ReadFromFile<Test, Integer> {

    // метод возвращает готовый объект класса Test. На вход получает путь к нужному файлу и ид курса для проверки
    @Override
    public Test readFromFile(String path, Integer courseId) throws IOException {

        Test readTest = null;
        int questionsCounter = 0;
        int numberOfQuestions = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String readLine;
        Integer readCourseId = 0;
        String testName = null;
        boolean isActive = false;

        while ((readLine = reader.readLine()) != null) {

            if (readLine.toLowerCase().contains("number_of_questions")) {
                numberOfQuestions = Integer.parseInt(readLine.split("=")[1].trim());
                throw new NumberException();
            }

            if (readLine.toLowerCase().contains("course_id")) {
                readCourseId = Integer.parseInt(readLine.split("=")[1].trim());
                throw new NumberException();
            }
            if (!Objects.equals(courseId, readCourseId)) {
                throw new WrongFileFormatException();
            }

            if (readLine.toLowerCase().contains("test_name")) {
                testName = readLine.split("=")[1].trim();
            }

            if (readLine.toLowerCase().contains("is_active")) {
                isActive = Boolean.parseBoolean(readLine.split("=")[1].trim());
            }
            readTest = new Test(testName, isActive);

            if (readLine.contains("##")) {
                String question = null;
                String answerA = null;
                String answerB = null;
                String answerC = null;
                String proofValue = null;

                question = getStringText(readLine,"question");
                answerA = getStringText(readLine, "answer_a");
                answerB = getStringText(readLine, "answer_b");
                answerC = getStringText(readLine, "answer_b");
                proofValue = getStringText(readLine, "proof_value");

                readTest.addQuestion(new Test.Question(question, answerA, answerB, answerC, proofValue));
                questionsCounter++;
            }

        }
        //поверка корректности считывания вопросов

        reader.close();
        if (numberOfQuestions != questionsCounter){
            throw new FileReadingException();
        }
        return readTest;
    }

//внутренний метод для считывания значения типа String
    private static String getStringText(String readLine, String s) {
        if (readLine.split("=")[0].trim().toLowerCase().equals(s)) {
            return readLine.split("=")[1].trim();
        }else return null;
    }


}
