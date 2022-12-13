package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


/**
 * Utilitaire class
 */
public class Applications {

    public static void main(String args[]) throws Exception {

        String pathFileIn = "Project02Eclipse/symptoms.txt";
        String pathFileOut = "result.out";

        // intaciation class ReadSymptomDataFromFile
        SymptomDataFromFileReader symptomDataFromFileReader = new SymptomDataFromFileReader(pathFileIn);
        // read file symptom.txt with the method getSymptoms()
        List<String> symptoms = symptomDataFromFileReader.fileSymptomReader();

        //instanciation class CountOccurences
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptoms);
        // count occurences with symptoms
        Map<String, Integer> occurence = analyticsCounter.countOccurences();

        //Intaciation to class WriteSymptomWithOccurenceFromFile

        OccurenceFileOutWriter occurenceFileOutWriter = new OccurenceFileOutWriter(pathFileOut);
        // write result count occurence to file result.out

        occurenceFileOutWriter.fileSymptomsWriter(occurence);

        // afficher le resultat
        System.out.println(occurence);


    }
}
