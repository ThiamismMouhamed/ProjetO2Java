package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * class to count occurrences
 */
public class CountOccurences {
    List<String> list;

    public CountOccurences(List<String> list) {
        this.list = list;
    }

    /**
     * listSymptomWithOccurence method to list the number of symptom occurrences greater than 1
     *
     * @param symptoms
     * @return occurence list of occurence
     */
    public Map<String, Integer> listSymptomWithOccurence(List<String> symptoms) {

        Map<String, Integer> occurences = new TreeMap<>();

        for (int j = 0; j < symptoms.size(); j++) {
            int count = 0;
            for (String word : list) {
                if (word.equals(symptoms.get(j))) {
                    count++;
                }
            }

            if (count >= 1) {
                occurences.put(symptoms.get(j), count);
                System.out.println(symptoms.get(j) + ":" + count + "\n");
            }
        }

        return occurences;
    }
}
