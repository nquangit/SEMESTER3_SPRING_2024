/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 7};
        int size = array.length;
        int sum = findSum(array, size);
        System.out.println("The sum of all elements in the array is: " + sum);
    }

    public static int findSum(int a[], int n) {
        // Base case: if the array has no elements, the sum is 0
        if (n == 0) {
            return 0;
        }

        // Recursive case: sum = current element + sum of the rest of the elements
        return a[n - 1] + findSum(a, n - 1);
    }
}
