package services.Utils.fileReder;

import services.validation.exeptions.FileReadingException;
import services.validation.exeptions.NullException;
import services.validation.exeptions.NumberException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadPassesFromFile implements ReadFromFile<Map<Integer, Integer>> {
    @Override
    public Map<Integer, Integer> readFromFile(String path) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<Integer, Integer> passes = new HashMap<>();
        String readLine;

        try {
            while ((readLine = reader.readLine()) != null) {

                String[] strings = readLine.split("=");
                passes.put(Integer.parseInt(strings[0].trim()), Integer.parseInt(strings[1].trim()));
            }

        } catch (FileReadingException | NumberException | NullException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Input output failed");
            e.printStackTrace();
        } finally {
            reader.close();
        }

        return passes;
    }
}
