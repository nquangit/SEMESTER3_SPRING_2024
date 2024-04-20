/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        int n = 5; // You can change the value of n as needed
        int result = sum(n);
        System.out.println("Sum from 1 to " + n + " is: " + result);
    }

    public static int sum(int n) {
        // Base case: if n is 1, return 1
        if (n == 1) {
            return 1;
        } // Recursive case: sum(n) = n + sum(n-1)
        else {
            return n + sum(n - 1);
        }
    }
}
