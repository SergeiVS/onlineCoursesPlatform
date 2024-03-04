package services.Utils.fileReder;

import services.validation.FileReadingException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
                courseName = readLine.split("=")[1].trim();
                courseMaterial.add(1,courseName);
            }
            courseMaterial.add(readLine);
        }



    } catch (
    FileNotFoundException e) {
        System.out.println("File not found");
    } catch (
    FileReadingException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("Failed numbers reading");
    } catch (NullPointerException e) {
        System.out.println("Failed file reading");
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
