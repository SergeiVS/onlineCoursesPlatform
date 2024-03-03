package services.Utils.fileReder;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCourseFromFile implements ReadFromFile<List<String>, Integer> {
    @Override
    public List<String> readFromFile(String path, Integer courseId) throws IOException {

        List<String> courseMaterial = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
        String readLine;

        while ((readLine = reader.readLine()) != null){
            String readCourseId;
            String courseName;

            if (readLine.toLowerCase().contains("course_id")){
                readCourseId = readLine.split("=")[1].trim();

                courseMaterial.add(0, readCourseId);
            }
            if (readLine.toLowerCase().contains("course_name")){
                courseName = readLine.split("=")[1].trim();
                courseMaterial.add(1,courseName);
            }

            courseMaterial.add(readLine);

        }
        reader.close();

        return courseMaterial;
    }
}
