package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // variable to path file
        String pathfileIn =  "Project02Eclipse/symptoms.txt";
        String pathfileExit = "result2.out";
        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(pathfileIn);
        //variable pour recuperer les symptoms
        ArrayList<String> symptoms = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();
        List<String> list = new ArrayList<>(Arrays.asList("headache","tremor","pupils"));
        System.out.println(symptoms);
        CountOccurences countOccurences = new CountOccurences(list);
        Map<String, Integer> oc = countOccurences.listSymptomWithOccurence(symptoms);
        System.out.println("--------------------");

        WriteSymptomWithOccurenceFromFile writeSymptomWithOccurenceFromFile = new WriteSymptomWithOccurenceFromFile(pathfileExit);
        writeSymptomWithOccurenceFromFile.getFileSymptomsExit(oc);
       // Map<String, Integer> occurences = readSymptomDataFromFile.CountOccurences(list);
        System.out.println(oc);
        //readSymptomDataFromFile.FichierSortie(occurences);



    }
}
