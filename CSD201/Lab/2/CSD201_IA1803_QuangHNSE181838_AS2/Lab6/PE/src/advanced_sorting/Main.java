/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced_sorting;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("A05", "Tran Quang", 7),
            new Employee("A03", "Nguyen An", 7),
            new Employee("A01", "Truong Phung", 5),
            new Employee("A04", "Pham Thi Lam", 2),
            new Employee("A02", "Do Trung Ton", 5)};

        // Sorting in ascending order
        System.out.println("Ascending Order:");
        System.out.println("Original:\n" + formatTable(employees));
        System.out.println("Heap Sort:\n" + formatTable(heapSort(employees.clone(), true)));
        System.out.println("Quick Sort:\n" + formatTable(quickSort(employees.clone(), true)));
        System.out.println("Merge Sort:\n" + formatTable(mergeSort(employees.clone(), true)));

        // Sorting in descending order
        System.out.println("\nDescending Order:");
        System.out.println("Original:\n" + formatTable(employees));
        System.out.println("Heap Sort:\n" + formatTable(heapSort(employees.clone(), false)));
        System.out.println("Quick Sort:\n" + formatTable(quickSort(employees.clone(), false)));
        System.out.println("Merge Sort:\n" + formatTable(mergeSort(employees.clone(), false)));
    }

    public static String formatTable(Employee[] employees) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("%-5s %-15s %-10s\n", "ID", "Name", "Level"));
        table.append("-------------------------------\n");
        for (Employee employee : employees) {
            table.append(String.format("%-5s %-15s %-10s\n", employee.getId(), employee.getName(), employee.getLevel()));
        }
        return table.toString();
    }

    public static Employee[] heapSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, ascending);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            Employee temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, ascending);
        }
        return arr;
    }

    public static void heapify(Employee[] arr, int n, int i, boolean ascending) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && (ascending ? arr[left].getId().compareTo(arr[largest].getId()) > 0 : arr[left].getId().compareTo(arr[largest].getId()) < 0)) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && (ascending ? arr[right].getId().compareTo(arr[largest].getId()) > 0 : arr[right].getId().compareTo(arr[largest].getId()) < 0)) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            Employee swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, ascending);
        }
    }

    public static Employee[] quickSort(Employee[] arr, boolean ascending) {
        quickSortHelper(arr, 0, arr.length - 1, ascending);
        return arr;
    }

    public static void quickSortHelper(Employee[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(arr, low, high, ascending);
            quickSortHelper(arr, low, pi - 1, ascending);
            quickSortHelper(arr, pi + 1, high, ascending);
        }
    }

    public static int partition(Employee[] arr, int low, int high, boolean ascending) {
        Employee pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (ascending ? arr[j].getId().compareTo(pivot.getId()) < 0 : arr[j].getId().compareTo(pivot.getId()) > 0) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static Employee[] mergeSort(Employee[] arr, boolean ascending) {
        mergeSortHelper(arr, 0, arr.length - 1, ascending);
        return arr;
    }

    public static void mergeSortHelper(Employee[] arr, int l, int r, boolean ascending) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSortHelper(arr, l, m, ascending);
            mergeSortHelper(arr, m + 1, r, ascending);

            // Merge the sorted halves
            merge(arr, l, m, r, ascending);
        }
    }

    public static void merge(Employee[] arr, int l, int m, int r, boolean ascending) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temporary arrays */
        Employee L[] = new Employee[n1];
        Employee R[] = new Employee[n2];

        /*Copy data to temporary arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temporary arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (ascending ? L[i].getId().compareTo(R[j].getId()) <= 0 : L[i].getId().compareTo(R[j].getId()) >= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
