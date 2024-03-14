package services.utils.fileReder;



import core.entity.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// считывает из текстового файла Курса информацию о курсе. Информация сохраняется в списке строк по строчно.
// на нулевом индексе сохраняется ИД курс а на первом его название.
public class ReadCourseFromFile implements ReadFromFile<List<String>> {
    @Override
    public List<String> readFromFile(String path) throws IOException {

        List<String> courseMaterial = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String readLine;
try {
        while ((readLine = reader.readLine()) != null){
            String readCourseId;
            String courseName;

            if (readLine.toLowerCase().contains("course_id")){

                readCourseId = (getString(readLine));

                courseMaterial.add(0, readCourseId);
            }
            if (readLine.toLowerCase().contains("course_name")){
                courseName = getString(readLine);
                courseMaterial.add(1,courseName);
            }
            courseMaterial.add(readLine);
        }
        // здесь обрабатываются возможные исключения.
    } catch (RuntimeException e) {
    System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println("Input output failed");
        e.printStackTrace();
    }finally {
    reader.close();
    }
        return courseMaterial;
    }
//вспомогательный метод для выделения значения из строки файла
    private static String getString(String readLine) {
        return readLine.split(":")[1].trim();
    }
}
