package services.Utils.fileReder;

import core.entity.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// считывает из файла данные теста для проверки знаний пользователя.
public class ReadTestFromFile implements ReadFromFile<Test> {

    // метод возвращает готовый объект класса Test. На вход получает путь к нужному файлу и ид курса для проверки
    @Override
    public Test readFromFile(String path) throws IOException {

        int questionsCounter = 0;
        int numberOfQuestions = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String readLine;
        Integer readCourseId = 0;
        String testName = null;
        boolean isActive = false;
        final var readTest = new Test(testName, isActive);

        while ((readLine = reader.readLine()) != null) {

            if (readLine.toLowerCase().contains("number_of_questions")) {
                numberOfQuestions = Integer.parseInt(readLine.split("=")[1].trim());
            }

            if (readLine.toLowerCase().contains("course_id")) {
                readCourseId = Integer.parseInt(readLine.split("=")[1].trim());
            }

            if (readLine.toLowerCase().contains("test_name")) {
                testName = readLine.split("=")[1].trim();
            }

            if (readLine.toLowerCase().contains("is_active")) {
                isActive = Boolean.parseBoolean(readLine.split("=")[1].trim());
            }


            questionsCounter = getQuestionsCounter(readLine, reader, readTest, questionsCounter);

        }
        //поверка корректности считывания вопросов

        reader.close();
    //    if (numberOfQuestions != questionsCounter){
    //        throw new FileReadingException();
     //   }
        return readTest;
    }

    private static int getQuestionsCounter(String readLine, BufferedReader reader, Test readTest, int questionsCounter) throws IOException {
        if (readLine.contains("##")) {

            readLine = reader.readLine();
            String question = null;
            String answerA = null;
            String answerB = null;
            String answerC = null;
            String proofValue = null;

            question = getStringText(readLine,"question");
            readLine = reader.readLine();
            answerA = getStringText(readLine, "answer_a");
            readLine = reader.readLine();
            answerB = getStringText(readLine, "answer_b");
            readLine = reader.readLine();
            answerC = getStringText(readLine, "answer_c");
            readLine = reader.readLine();
            proofValue = getStringText(readLine, "proof_value");
            readLine = reader.readLine();

            readTest.addQuestion(new Test.Question(question, answerA, answerB, answerC, proofValue));
            questionsCounter++;
        }
        return questionsCounter;
    }

    //внутренний метод для считывания значения типа String
    private static String getStringText(String readLine, String s) {
        if (readLine.split("=")[0].trim().toLowerCase().equals(s)) {
            return readLine.split("=")[1].trim();
        }else return null;
    }


}
