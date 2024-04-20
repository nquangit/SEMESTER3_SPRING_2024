/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemanagement.view;

import coffeemanagement.controller.Validator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Prompt {

    public static int getChoice(String choices[]) {
        // Init Scanner for input
        Scanner getChoice = new Scanner(System.in);
        int choice;
        do {
            for (int i = 0; i < choices.length; i++) {
                System.out.println(String.format("%d. %s", i + 1, choices[i]));
            }
            System.out.print("Enter your choice: ");
            // Handle int input exception
            try {
                choice = Integer.parseInt(getChoice.next());
                // Also throw Exception if choice < 0
                if (choice < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice !!!");
                // Choice = 0 to input again
                choice = 0;
            }
        } while (choice < 1 || choice > choices.length);
        return choice;
    }

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
        String result;
        while (true) {
            System.out.print(prompt);
            result = longInput ? getData.nextLine().trim() : getData.next().trim();
            if (result.matches(regex)) {
                break;
            }
            System.out.println("Wrong input !!!");
        }
        return result;
    }

    public static int intInput(String prompt, int minValue, int maxValue, boolean required) {
        // Init Scanner
        Scanner getData = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                int output = Integer.parseInt(getData.next());
                if (output <= maxValue && output >= minValue) {
                    return output;
                }
            } catch (NumberFormatException e) {
                // Do nothing on exception
            }
        } while (required);
        return minValue - 1;
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
