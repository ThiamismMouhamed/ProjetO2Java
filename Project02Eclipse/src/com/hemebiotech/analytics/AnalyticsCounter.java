package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * class to count occurrences
 */
public class AnalyticsCounter {
    private List<String> symptoms;

    public AnalyticsCounter(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    /**
     * listSymptomWithOccurence method to list the number of symptom occurrences greater than 1
     *
     * @return occurence list of occurence
     */
    public Map<String, Integer> countOccurences() {

        Map<String, Integer> occurences = new TreeMap<>();

        for (int j = 0; j < symptoms.size(); j++) {
            int count = 0;
            String next = symptoms.get(j);
            for (int i=0; i<=j; i++) {
                if (symptoms.get(i).equals(next)) {
                    count++;
                }
            }

            if (count >= 1) {
                occurences.put(symptoms.get(j), count);
                //System.out.println(symptoms.get(j) + ":" + count + "\n");
            }
        }
        return occurences;
    }
}
