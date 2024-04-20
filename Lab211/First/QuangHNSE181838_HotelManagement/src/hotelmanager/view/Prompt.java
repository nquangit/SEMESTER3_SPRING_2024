/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.view;

import hotelmanager.controller.Validator;
import hotelmanager.model.Hotel;
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

    public static Hotel enterHotelInformation() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;

        boolean longInput;
        boolean required;

        // Start get the data input from the user's keyboard
        hotelId = stringInput("Enter hotel ID: ");
        longInput = true;
        hotelName = stringInput("Enter hotel name: ", longInput);
        required = true;
        hotelRoomAvailable = intInput("Enter hotel room available: ", Validator.MIN_ROOM_AVAILABLE, Validator.MAX_ROOM_AVAILABLE, required);
        hotelAddress = stringInput("Enter hotel address: ", longInput);
        longInput = false;
        hotelPhone = stringInput("Enter hotel phone: ", longInput, Validator.VALID_PHONE_NUMBER_REGEX);
        hotelRating = intInput("Enter hotel rating: ", Validator.MIN_RATING, Validator.MAX_RATING, required);
        return new Hotel(hotelId, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating);
    }

    public static Hotel enterHotelInformation(Hotel oldHotel) {
        // Update hotel with the hotelId
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;

        boolean longInput;
        boolean required;

        // Start get the data input from the user's keyboard
        longInput = true;
        hotelName = stringInput("Enter hotel name: ", longInput);
        oldHotel.setHotelName(hotelName.isEmpty() ? oldHotel.getHotelName() : hotelName);

//        try {
//            hotelRoomAvailable = Integer.parseInt(stringInput("Enter hotel room available: "));
//            oldHotel.setHotelRoomAvailable(hotelRoomAvailable);
//        } catch (NumberFormatException e) {
//            // Do nothing
//            // Not change value
//        }
        required = false;
        hotelRoomAvailable = intInput("Enter hotel room available: ", Validator.MIN_ROOM_AVAILABLE, Validator.MAX_ROOM_AVAILABLE, required);
        if (hotelRoomAvailable != Validator.MIN_ROOM_AVAILABLE - 1) {
            oldHotel.setHotelRoomAvailable(hotelRoomAvailable);
        }

        hotelAddress = stringInput("Enter hotel address: ", longInput);
        oldHotel.setHotelAddress(hotelAddress.isEmpty() ? oldHotel.getHotelAddress() : hotelAddress);

        hotelPhone = stringInput("Enter hotel phone: ", longInput, Validator.VALID_PHONE_NUMBER_REGEX);
        oldHotel.setHotelPhone(hotelPhone.isEmpty() ? oldHotel.getHotelPhone() : hotelPhone);

//        try {
//            hotelRating = Integer.parseInt(stringInput("Enter hotel rating: "));
//            oldHotel.setHotelRating(hotelRating);
//        } catch (NumberFormatException e) {
//            // Do nothing
//            // Not change value
//        }

        required = false;

        hotelRating = intInput("Enter hotel room available: ", Validator.MIN_RATING, Validator.MAX_RATING, required);
        if (hotelRoomAvailable != Validator.MIN_RATING - 1) {
            oldHotel.setHotelRating(hotelRating);
        }
        return oldHotel;
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
