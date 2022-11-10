package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // variable to path file
        String pathfile =  "Project02Eclipse/symptoms.txt";
        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(pathfile);
        //variable pour recuperer les symptoms
        ArrayList<String> symptoms = (ArrayList<String>) readSymptomDataFromFile.GetSymptoms();
        List<String> list = new ArrayList<>(Arrays.asList("headache","tremor","pupils"));
        System.out.println(symptoms);
        Map<String, Integer> occurences = readSymptomDataFromFile.CountOccurences(list);
        System.out.println(occurences);
        readSymptomDataFromFile.FichierSortie(occurences);



    }
}
