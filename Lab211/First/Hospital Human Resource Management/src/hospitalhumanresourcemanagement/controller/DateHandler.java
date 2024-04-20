/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller;

import hospitalhumanresourcemanagement.controller.IO.InputHandler;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */
public class DateHandler {

    public static String dateToString(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(dateFormat);
        return formattedDate;
    }

    public static int comapreDate(LocalDate firstDate, LocalDate secondDate) {
        // If the first date is after then second date
        // then the first date is greater 
        if (firstDate.isAfter(firstDate)) {
            return 1;
        }
        if (firstDate.isBefore(firstDate)) {
            return -1;
        }
        // else first date equal second date
        return 0;
    }

    /*
    * @param futureDate: for enter future date or date in the past
     */
    public static LocalDate enterDate(boolean futureDate) {
        while (true) {
            boolean longInput = true;
            String dateInput = InputHandler.stringInput("Enter date (dd/MM/yyyy): ", longInput, Validator.VALID_DATE_REGEX);
            // Return null on empty input
            if (dateInput.isEmpty()) {
                return null;
            }
            String[] dateSplit = dateInput.split("/");
            int day = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int year = Integer.parseInt(dateSplit[2]);
            LocalDate enteredDate;
            try {
                enteredDate = LocalDate.of(year, month, day);
            } catch (DateTimeException e) {
                System.out.println("Invalid date !!!");
                continue;
            }
            LocalDate currentDate = LocalDate.now();

            if (futureDate && enteredDate.isBefore(currentDate)) {
                System.out.println("The date must be in the future !!!");
                continue;
            }

            if (!futureDate && enteredDate.isAfter(currentDate)) {
                System.out.println("The date must be in the past !!!");
                continue;
            }
            return enteredDate;
        }
    }
}
