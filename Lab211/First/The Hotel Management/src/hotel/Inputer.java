/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Scanner;

public class Inputer {

    public static String InputString(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        String chuoi = sc.nextLine();
        return chuoi;
    }

    public static int InputInt(String mess) {
        int num = 0;
        do {
            String cs = InputString(mess);
            try {
                num = Integer.parseInt(cs);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter number!");

            }
        } while (true);
        return num;
    }

    public static float InputFloat(String mess) {
        float num = 0;
        do {
            String cs = InputString(mess);
            try {
                num = Float.parseFloat(cs);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter number!");
            }
        } while (true);

        return num;
    }
}
