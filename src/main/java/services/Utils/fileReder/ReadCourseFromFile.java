package services.Utils.fileReder;

import services.validation.exeptions.FileReadingException;
import services.validation.exeptions.NullException;
import services.validation.exeptions.NumberException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCourseFromFile implements ReadFromFile<List<String>> {
    @Override
    public List<String> readFromFile(String path) throws IOException {

        List<String> courseMaterial = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
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



    } catch (FileReadingException | NumberException | NullException e) {
    System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println("Input output failed");
        e.printStackTrace();
    }finally {
    reader.close();
    }
        return courseMaterial;
    }

    private static String getString(String readLine) {
        return readLine.split("=")[1].trim();
    }
}
