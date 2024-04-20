/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LZWcoding;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class LZWEncoding {

    public static Map<String, Integer> createDictionary(String input) {
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            String symbol = String.valueOf(input.charAt(i));
            if (!dictionary.containsKey(symbol)) {
                dictionary.put(symbol, index++);
            }
        }
        return dictionary;
    }

    public static int[] compress(String input, Map<String, Integer> dictionary) {
        StringBuilder current = new StringBuilder();
        int index = 0;
        int[] compressedOutput = new int[input.length()]; // Assuming worst case size

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            String currentPlusSymbol = current.toString() + symbol;
            if (dictionary.containsKey(currentPlusSymbol)) {
                current = new StringBuilder(currentPlusSymbol);
            } else {
                compressedOutput[index++] = dictionary.get(current.toString());
                dictionary.put(currentPlusSymbol, dictionary.size());
                current = new StringBuilder(String.valueOf(symbol));
            }
        }

        if (!current.toString().equals("")) {
            compressedOutput[index++] = dictionary.get(current.toString());
        }

        int[] compressedArray = new int[index];
        System.arraycopy(compressedOutput, 0, compressedArray, 0, index);
        return compressedArray;
    }

    public static void main(String[] args) {
        //String input = "ABABCABABCDABCDABDE";
        String input = "ADEACBGHACHGDCDABGAHD";

        // Step 1: Creating dictionary
        Map<String, Integer> dictionary = createDictionary(input);
        System.out.println("Dictionary:");
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Step 2: Compressing input string
        int[] compressedOutput = compress(input, dictionary);
        System.out.println("\nCompressed Output:");
        for (int value : compressedOutput) {
            System.out.print(value + " ");
        }
    }
}
