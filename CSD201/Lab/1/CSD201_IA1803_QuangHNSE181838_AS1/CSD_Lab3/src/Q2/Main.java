/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 7};
        int size = array.length;
        int min = findMin(array, size);
        System.out.println("The minimum element in the array is: " + min);
    }

    public static int findMin(int a[], int n) {
        // Base case: if the array has only one element, return that element
        if (n == 1) {
            return a[0];
        }
        
        // Recursive case: find the minimum element in the subarray excluding the first element
        int minInRest = findMin(a, n - 1);

        // Compare the minimum in the rest with the first element, return the smaller of the two
        return Math.min(a[n - 1], minInRest);
    }
}
