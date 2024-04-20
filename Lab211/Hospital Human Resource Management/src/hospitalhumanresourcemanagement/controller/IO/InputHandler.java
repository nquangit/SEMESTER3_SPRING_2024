/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller.IO;

import hospitalhumanresourcemanagement.controller.Validator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class InputHandler {

    public static String stringInput(String prompt) {
        // regex ".*" to match every string
        boolean longInput = false;
        return stringInput(prompt, longInput, Validator.MATCH_ALL_EXCEPT_SPACE);

    }

    public static String stringInput(String prompt, boolean longInput) {
        // regex ".*" to match every string
        return stringInput(prompt, longInput, Validator.MATCH_ALL_EXCEPT_SPACE);

    }

    public static String stringInput(String prompt, boolean longInput, String regex) {
        // Init Scanner
        Scanner getData = new Scanner(System.in);

        // Create a Pattern object
        String result;
        while (true) {
            System.out.print(prompt);
            result = longInput ? getData.nextLine().trim() : getData.next().trim();
            // Create a Matcher object
            if (result.isEmpty()) {
                return "";
            }
            if (result.matches(regex)) {
                return result;
            }
            System.out.println("Wrong format !!! Format: " + regex);
        }

    }

    public static int intInput(String prompt, int minValue, int maxValue) {
        // Init Scanner
        Scanner getData = new Scanner(System.in);
        String inputInteger = "";
        do {
            try {
                System.out.print(prompt);
                inputInteger = getData.nextLine().trim();
                int enteredNum = Integer.parseInt(inputInteger);
                if (enteredNum <= maxValue && enteredNum >= minValue) {
                    return enteredNum;
                }
            } catch (NumberFormatException e) {
                // return if the input is empty
                if (inputInteger.isEmpty()) {
                    return minValue - 1;
                }
                System.out.println("Wrong input !!!");
            }
        } while (true);
    }

    public static boolean yesNoPrompt(String prompt) {
        System.out.print(prompt);
        String choice;
        // Init Scanner
        Scanner getData = new Scanner(System.in);
        choice = getData.next();
        return choice.equalsIgnoreCase("y");
    }

}
