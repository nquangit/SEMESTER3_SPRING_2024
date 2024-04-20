/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller;

import hospitalhumanresourcemanagement.model.Employee;
import hospitalhumanresourcemanagement.model.Role;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

/**
 *
 * @author ASUS
 */
public class EmployeeManager implements java.io.Serializable {

    private final LinkedHashMap<String, Employee> employeeList;

    public EmployeeManager() {
        this.employeeList = new LinkedHashMap<>();
    }

    public EmployeeManager(LinkedHashMap<String, Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.put(employee.getID(), employee);
    }

    public Employee removeEmployee(String employeeID) {
        employeeID = employeeID.toUpperCase();
        // If employee does not exist
        // Return null
        if (!isExistEmployee(employeeID)) {
            return null;
        }
        return employeeList.remove(employeeID);
    }

    // Remove Object and return Object
    // Return null if the Object does not exist
    public Employee removeEmployee(Employee employee) {
        // If employee does not exist
        // Return null
        if (!isExistEmployee(employee)) {
            return null;
        }
        return employeeList.remove(employee.getID());
    }

    public LinkedHashMap<String, Employee> searchEmployee(String employeeID) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeList.values());
        employeeArrayList.removeIf((Employee employee) -> !(employee.getID().toUpperCase().contains(employeeID.toUpperCase())));
        LinkedHashMap<String, Employee> filteredHashMap = new LinkedHashMap<>();
        Iterator<Employee> employeeIter = employeeArrayList.iterator();

        while (employeeIter.hasNext()) {
            Employee employee = (Employee) employeeIter.next();
            filteredHashMap.put(employee.getID(), employee);
        }
        return filteredHashMap;
    }

    public boolean isExistEmployee(Employee employee) {
        return searchEmployee(employee.getID()) != null;
    }

    public boolean isExistEmployee(String employeeID) {
        return employeeList.get(employeeID) != null;
    }

    public void updateEmployee(Employee employee) {
        // Put new object into the same key
        // Only the data change, the key (ID) not change
        employeeList.put(employee.getID(), employee);
    }

    public LinkedHashMap<String, Employee> getAllList() {
        return employeeList;
    }

    public LinkedHashMap<String, Employee> filterList(Predicate<Employee> predicate) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeList.values());
        employeeArrayList.removeIf(predicate);
        LinkedHashMap<String, Employee> filteredHashMap = new LinkedHashMap<>();
        Iterator<Employee> employeeIter = employeeArrayList.iterator();

        while (employeeIter.hasNext()) {
            Employee employee = (Employee) employeeIter.next();
            filteredHashMap.put(employee.getID(), employee);
        }
        return filteredHashMap;
    }

    public LinkedHashMap<String, Employee> getTakeOnList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeList.values());
        employeeArrayList.removeIf((Employee employee) -> (employee.getResignDate() != null));
        LinkedHashMap<String, Employee> filteredHashMap = new LinkedHashMap<>();
        Iterator<Employee> employeeIter = employeeArrayList.iterator();

        while (employeeIter.hasNext()) {
            Employee employee = (Employee) employeeIter.next();
            filteredHashMap.put(employee.getID(), employee);
        }
        return filteredHashMap;
    }

    public LinkedHashMap<String, Employee> getResignList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeList.values());
        employeeArrayList.removeIf((Employee employee) -> (employee.getResignDate() == null));
        LinkedHashMap<String, Employee> filteredHashMap = new LinkedHashMap<>();
        Iterator<Employee> employeeIter = employeeArrayList.iterator();

        while (employeeIter.hasNext()) {
            Employee employee = (Employee) employeeIter.next();
            filteredHashMap.put(employee.getID(), employee);
        }
        return filteredHashMap;
    }

    public LinkedHashMap<String, Employee> getEmployeeListByRole(Role roleToSearch) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeList.values());
        employeeArrayList.removeIf((Employee employee)
                -> (!employee.getRole().getName().equalsIgnoreCase(roleToSearch.getName()))
        );
        LinkedHashMap<String, Employee> filteredHashMap = new LinkedHashMap<>();
        Iterator<Employee> employeeIter = employeeArrayList.iterator();

        while (employeeIter.hasNext()) {
            Employee employee = (Employee) employeeIter.next();
            filteredHashMap.put(employee.getID(), employee);
        }
        return filteredHashMap;
    }

}
