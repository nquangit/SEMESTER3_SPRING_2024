/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int size = sortedArray.length;

        int result = binarySearch(sortedArray, target, 0, size - 1);

        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }

    // Recursive binary search function
    static int binarySearch(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // If the target is found at the middle index
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller than the middle element, search in the left half
            if (target < arr[mid]) {
                return binarySearch(arr, target, low, mid - 1);
            }

            // If the target is larger than the middle element, search in the right half
            return binarySearch(arr, target, mid + 1, high);
        }

        // If the target is not present in the array
        return -1;
    }
}
