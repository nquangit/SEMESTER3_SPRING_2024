/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller;

import hospitalhumanresourcemanagement.controller.IO.FileHandler;
import hospitalhumanresourcemanagement.controller.IO.InputHandler;
import hospitalhumanresourcemanagement.model.Employee;
import hospitalhumanresourcemanagement.view.PrintTable;
import hospitalhumanresourcemanagement.view.Prompt;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public class Manager {

    public final String ROLE_FILE = "roles.txt";
    public final String EMPLOYEE_FILE = "employees.txt";
    private final FileHandler<RoleManager> roleFileHandler;
    private final FileHandler<EmployeeManager> employeeFileHandler;

    private RoleManager roleManager;
    private EmployeeManager employeeManager;

    final String[] EMPLOYEE_INFO_HEADERS = {
        "ID",
        "Name",
        "Phone",
        "BirthDay",
        "Role",
        "Hired Date",
        "Salary",
        "Contract Time",
        "Resign Date"
    };

    public Manager() {
        roleFileHandler = new FileHandler<>(ROLE_FILE);
        employeeFileHandler = new FileHandler<>(EMPLOYEE_FILE);

        try {
            roleManager = roleFileHandler.loadObjectFromFile();
            System.out.println("Load role data from file successsfully !!!");
        } catch (IOException | ClassNotFoundException e) {
            roleManager = new RoleManager();
            roleManager.initRole();
            try {
                roleFileHandler.saveObjectToFile(roleManager);
            } catch (IOException eIO) {
                System.out.println("IO Error");
                return;
            }
        }

        try {
            employeeManager = employeeFileHandler.loadObjectFromFile();
            System.out.println("Load employee data from file successsfully !!!");
        } catch (IOException | ClassNotFoundException e) {
            employeeManager = new EmployeeManager();
        }

    }

    public void run() {
        int choice;
        String[] menu = {
            "Add new employee",
            "Search employee",
            "Remove employee",
            "Update employee",
            "View all list",
            "View take-on list",
            "View resign list",
            "View doctor list",
            "View nurse list",
            "View technician list",
            "Write list to file (Automatically)",
            "Quit the program"
        };
        do {
            choice = Prompt.getChoice(menu);
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    viewAllList();
                    break;
                case 6:
                    viewTakeOnList();
                    break;
                case 7:
                    viewResignList();
                    break;
                case 8:
                    viewDoctorList();
                    break;
                case 9:
                    viewNurseList();
                    break;
                case 10:
                    viewTechnicianList();
                    break;
                case 11:
                    break;
            }
        } while (choice != menu.length);
    }

    // Function 1: Add employee
    public void addEmployee() {
        String employeeID = Prompt.enterEmployeeID();
        if (employeeID.isEmpty()) {
            System.out.println("Interrupt !!!");
            return;
        }
        boolean check = employeeManager.isExistEmployee(employeeID);
        if (check) {
            System.out.println("Employee ID EXIST !!!\nTry again !!!");
            addEmployee();
            return;
        }
        Employee employee = Prompt.enterEmployeeInfo(employeeID, roleManager);
        if (employee == null) {
            System.out.println("Interrupt !!!");
            return;
        }
        
        employeeManager.addEmployee(employee);
        // Save new data to file
        try {
            employeeFileHandler.saveObjectToFile(employeeManager);
        } catch (IOException eIO) {
            System.out.println("Unknown [IO ERROR]");
        }
    }

    // Fuction 2: Search employee
    public void searchEmployee() {
        boolean longInput = true;
        // String employeeID = InputHandler.stringInput("Enter ID: ", longInput, "^(?i)(em)\\w+");
        String employeeID = InputHandler.stringInput("Enter ID: ", longInput, Validator.MATCH_ALL_EXCEPT_SPACE);
        LinkedHashMap<String, Employee> employee = employeeManager.searchEmployee(employeeID);
        if (employee.isEmpty()) {
            System.out.println("No employee match !!!");
            return;
        }
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employee);
        printTable.printTableData();
    }

    // Function 3: Remove employee
    public void removeEmployee() {
        String employeeID = Prompt.enterEmployeeID();
        Employee employee = employeeManager.removeEmployee(employeeID);
        if (employee == null) {
            System.out.println("Employee not found !!!");
            return;
        }
        
        boolean askForSubmit = InputHandler.yesNoPrompt("Are you sure to remove employee(y/N): ");
        if (!askForSubmit) {
            return;
        }
        
        LinkedHashMap<String, Employee> employeeList = new LinkedHashMap<>();
        employeeList.put(employee.getID(), employee);
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employeeList);
        printTable.printTableData();
        
        // Save new data to file
        try {
            employeeFileHandler.saveObjectToFile(employeeManager);
        } catch (IOException eIO) {
            System.out.println("Unknown [IO ERROR]");
        }
    }

    // Function 4: Update employee
    public void updateEmployee() {
        String employeeID = Prompt.enterEmployeeID();
        LinkedHashMap<String, Employee> employeeSearch = employeeManager.searchEmployee(employeeID);
        if (employeeSearch.isEmpty()) {
            System.out.println("Employee not found !!!");
            return;
        }
        if (employeeSearch.size() != 1) {
            System.out.println("Finding...");
            PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employeeSearch);
            printTable.printTableData();
            // Re-select
            updateEmployee();
            return;
        }

        // print employee info before update
        LinkedHashMap<String, Employee> employees = new LinkedHashMap<>();
        employees.put(employeeID, employeeSearch.get(employeeID));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();

        Employee employee = Prompt.enterEmployeeInfo(employeeID, roleManager);
        if (employee == null) {
            System.out.println("Interrupt !!!");
            return;
        }

        employeeManager.updateEmployee(employee);
        System.out.println("Successfully update employee !!!");
        employees = new LinkedHashMap<>();
        printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
        
        // Save new data to file
        try {
            employeeFileHandler.saveObjectToFile(employeeManager);
        } catch (IOException eIO) {
            System.out.println("Unknown [IO ERROR]");
        }

    }

    // Function 5: View all list
    public void viewAllList() {
        LinkedHashMap<String, Employee> employeeList = employeeManager.getAllList();
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employeeList);
        printTable.printTableData();
    }

    // Function 6: View take-on list
    public void viewTakeOnList() {
        // LinkedHashMap<String, Employee> employee = employeeManager.getTakeOnList();
        // OR
        LinkedHashMap<String, Employee> employees = employeeManager.filterList((Employee employee) -> (employee.getResignDate() != null));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
    }

    // Function 7: View resign list
    public void viewResignList() {
        // LinkedHashMap<String, Employee> employee = employeeManager.getResignList();
        // OR
        LinkedHashMap<String, Employee> employees = employeeManager.filterList((Employee employee) -> (employee.getResignDate() == null));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
    }

    // Fuction 8: View doctor list
    public void viewDoctorList() {
        LinkedHashMap<String, Employee> employees = employeeManager.getEmployeeListByRole(roleManager.getRole("doctor"));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
    }

    // Fuction 9: View nurse list
    public void viewNurseList() {
        LinkedHashMap<String, Employee> employees = employeeManager.getEmployeeListByRole(roleManager.getRole("nurse"));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
    }

    // Function 10: View technician list
    public void viewTechnicianList() {
        LinkedHashMap<String, Employee> employees = employeeManager.getEmployeeListByRole(roleManager.getRole("technician"));
        PrintTable<Employee> printTable = new PrintTable<>(EMPLOYEE_INFO_HEADERS, employees);
        printTable.printTableData();
    }

    // Function 11: Auto
    // Function 12: Quit
}
