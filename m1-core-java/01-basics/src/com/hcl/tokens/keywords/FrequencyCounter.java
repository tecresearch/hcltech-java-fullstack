package com.hcl.tokens.keywords;
import java.util.HashMap;

public class FrequencyCounter {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};

        // Create a HashMap to store frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Display frequencies
        for (int key : freqMap.keySet()) {
            System.out.println("Element " + key + " occurs " + freqMap.get(key) + " times.");
        }
    }
}
