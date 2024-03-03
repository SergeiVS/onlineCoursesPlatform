package services.Utils.fileReder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseMaterialReader implements FileReader<List<String>> {
    @Override
    public List<String> readFromFile(String path) throws IOException {

        List<String> courseMaterial = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
        String readLine;

        while ((readLine = reader.readLine()) != null){
            String courseId;
            String courseName;

            if (readLine.toLowerCase().contains("courseid")){
                courseId = readLine.split("=")[1].trim();
                courseMaterial.add(0, courseId);
            }
            if (readLine.toLowerCase().contains("coursename")){
                courseName = readLine.split("=")[1].trim();
                courseMaterial.add(1,courseName);
            }

            courseMaterial.add(readLine);

        }

        return courseMaterial;
    }
}
