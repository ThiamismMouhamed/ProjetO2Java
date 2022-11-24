package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

/**
 * class which allows to read a symptom file and which implements the interface IsymptomReader
 */
public class SymptomDataFromFileReader implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public SymptomDataFromFileReader(String filepath) {

        this.filepath = filepath;
    }


    /**
     * method to return symptoms
     *
     * @return result  list of file symptoms symptoms.txt
     */
    @Override
    public List<String> getSymptoms() {
        //changement de ArrayList to List
        List<String> result = new ArrayList<>();

        if (filepath != null) {
            System.out.println("Avant classer par ordre alphabétique");
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.add(line);
                    System.out.println("" + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


}
