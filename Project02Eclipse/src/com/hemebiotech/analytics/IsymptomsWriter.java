package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Anything that will write symptom data from a source
 * <p>
 * that may contain many duplications
 */
public interface IsymptomsWriter {

    /**
     * Method to write symptom data from a file
     *
     * @param symptom returns an occurrence list of symptom
     */
    void getFileSymptomsExit(Map<String, Integer> symptom);
}
