package basic_sorting;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("A02", "Do Trung Ton", 5),
            new Employee("A04", "Pham Thi Lam", 2),
            new Employee("A03", "Nguyen An", 7),
            new Employee("A01", "Truong Phung", 5),
            new Employee("A05", "Tran Quang", 7),};

        // Sorting in ascending order
        System.out.println("Danh sách nhân viên trước khi sắp xếp:");
        printEmployees(employees);
        System.out.println("\nSắp xếp theo ID theo thứ tự tăng dần (Insertion Sort):");
        printEmployees(insertionSort(employees.clone(), true));
        System.out.println("\nSắp xếp theo ID theo thứ tự tăng dần (Selection Sort):");
        printEmployees(selectionSort(employees.clone(), true));
        System.out.println("\nSắp xếp theo ID theo thứ tự tăng dần (Bubble Sort):");
        printEmployees(bubbleSort(employees.clone(), true));
    }

    public static Employee[] insertionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Employee key = arr[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? arr[j].getId().compareTo(key.getId()) > 0 : arr[j].getId().compareTo(key.getId()) < 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static Employee[] selectionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? arr[j].getId().compareTo(arr[min_idx].getId()) < 0 : arr[j].getId().compareTo(arr[min_idx].getId()) > 0) {
                    min_idx = j;
                }
            }

            Employee temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static Employee[] bubbleSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? arr[j].getId().compareTo(arr[j + 1].getId()) > 0 : arr[j].getId().compareTo(arr[j + 1].getId()) < 0) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void printEmployees(Employee[] employees) {
        System.out.format("%-5s %-15s %-10s\n", "ID", "Name", "Level");
        for (Employee employee : employees) {
            System.out.format("%-5s %-15s %-10s\n", employee.getId(), employee.getName(), employee.getLevel());
        }
    }
}
