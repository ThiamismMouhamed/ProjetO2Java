package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * class that allows you to write the results of occurrences to a file. the class implements
 * the interface IsymptomsWriter
 */

public class OccurenceFileOutWriter implements SymptomWriter {

    private String filePath;

    /**
     * class constructor WriteSymptomWithOccurenceFromFile
     *
     * @param filePath the variable filePath is the file path symptoms.txt
     */
    public OccurenceFileOutWriter(String filePath) {
        this.filePath = filePath;
    }


    /**
     * method which allows to write the results of occurrences in a file
     *
     * @param wordOccurence
     */
    @Override
    public void fileSymptomsWriter(Map<String, Integer> wordOccurence) {

        try (FileWriter writer = new FileWriter(filePath)) {

            for (Map.Entry mapentry : wordOccurence.entrySet()) {
                writer.write(mapentry.getKey() + ":" + mapentry.getValue() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
