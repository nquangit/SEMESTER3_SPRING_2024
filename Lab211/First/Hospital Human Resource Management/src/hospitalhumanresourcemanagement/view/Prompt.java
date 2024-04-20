/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.view;

import hospitalhumanresourcemanagement.controller.DateHandler;
import hospitalhumanresourcemanagement.controller.IO.InputHandler;
import static hospitalhumanresourcemanagement.controller.IO.InputHandler.intInput;
import static hospitalhumanresourcemanagement.controller.IO.InputHandler.stringInput;
import hospitalhumanresourcemanagement.controller.RoleManager;
import hospitalhumanresourcemanagement.controller.Validator;
import hospitalhumanresourcemanagement.model.Employee;
import hospitalhumanresourcemanagement.model.Role;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author ASUS
 */
public class Prompt {

    public static int getChoice(String choices[]) {
        int choice;
        do {
            for (int i = 0; i < choices.length; i++) {
                System.out.println(String.format("%d. %s", i + 1, choices[i]));
            }
            // Handle int input exception
            choice = InputHandler.intInput("Enter your choice: ", 1, choices.length);
        } while (choice < 1 || choice > choices.length);
        return choice;
    }

    public static String enterEmployeeID() {
        String ID;
        while (true) {
            try {
                boolean longInput = true;
                ID = stringInput("Enter ID: ", longInput, Validator.VALID_ID_REGEX);
                break;
            } catch (Exception e) {
                // do nothing
                // let user reenter the value
            }
        }
        return ID.toUpperCase();
    }

    public static Employee enterEmployeeInfo(String ID, RoleManager roleManager) {
        String name;
        String phone;
        LocalDate bDate;
        Role role;
        LocalDate hiredDate;
        int salary;
        int contractTime;
        LocalDate resignDate;

        boolean longInput = true;
        // Start get input
        name = stringInput("Enter employee's name: ", longInput);
        if (name.isEmpty()) {
            return null;
        }
        longInput = true;
        phone = stringInput("Enter employee's phone: ", longInput, Validator.VALID_PHONE_NUMBER_REGEX);
        if (phone.isEmpty()) {
            return null;
        }

        boolean futureDate = false; // false: day in the past
        System.out.println("Enter employee's birthday");
        while (true) {
            bDate = DateHandler.enterDate(futureDate);
            if (bDate == null) {
                return null;
            }
            int currentAge = Period.between(bDate, LocalDate.now()).getYears();
            if (currentAge < Role.BASE_AGE_REQUIRE) {
                System.out.println("It is not allowed to hire employees under 18 years of age !!!");
                continue;
            }
            break;
        }
        // Use role manager to select tole
        while (true) {
            role = roleManager.selectRole();
            if (role == null) {
                return null;
            }
            int currentAge = Period.between(bDate, LocalDate.now()).getYears();
            if (currentAge < role.getAgeRequired()) {
                System.out.println("Not old enough to get this role !!!");
                continue;
            }
            break;
        }
        futureDate = false;
        System.out.println("Enter employee's hired date");
        while (true) {
            hiredDate = DateHandler.enterDate(futureDate); // Hired in the past
            if (hiredDate == null) {
                return null;
            }
            if (DateHandler.comapreDate(hiredDate, bDate) == -1) {
                System.out.println("Employee can not be hired before he/she was born !!!");
                continue;
            }
            int age = Period.between(bDate, hiredDate).getYears();
            if (age < Role.BASE_AGE_REQUIRE) {
                System.out.println("It is not allowed to hire employees under 18 years of age !!!");
                continue;
            }
            if (age < role.getAgeRequired()) {
                System.out.println("Not old enough to get this role !!!");
            }
            break;
        }
        salary = intInput("Enter employee's salary: ", 0, Integer.MAX_VALUE);
        // If the input lower then min value
        // equal min value - 1, it is an empty input
        if (salary == -1) {
            return null;
        }
        contractTime = intInput("Enter employee's contract time: ", 1, Integer.MAX_VALUE);
        // If the input lower then min value
        // equal min value - 1, it is an empty input
        if (contractTime == 0) {
            return null;
        }
        futureDate = false;
        System.out.println("Enter employee's resign date (leave empty if employee haven't resign yet): ");
        resignDate = DateHandler.enterDate(futureDate);
        return new Employee(ID, name.toUpperCase(), phone, bDate, role, hiredDate, salary, contractTime, resignDate);
    }
}
