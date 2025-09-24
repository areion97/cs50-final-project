package com.santaclaus.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Manipulates a | formatted File
 */
public class FileUtils {

    public List<String> lines;

    /**
     * Given fileName it populates lines private attribute
     */
    public FileUtils(String fileName) {

        lines = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        InputStream is = classloader.getResourceAsStream(fileName);
        Reader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Given a line | formatted it returns a list of String (which represent the columns) removing formatting (pipe and spaces)
     */
    public static List<String> getColumns(String line) {

        List<String> columns = new ArrayList<>();
        List<String> lineColumns = Arrays.asList(line.split("\\|"));

        for(String lineColumn : lineColumns) {
            if(StringUtils.hasSpacesAtTheEnd(lineColumn)) {
                columns.add(StringUtils.removeSpacesAtTheEnd(lineColumn));
            }else {
                columns.add(lineColumn);
            }
        }

        return columns;
    }

}
