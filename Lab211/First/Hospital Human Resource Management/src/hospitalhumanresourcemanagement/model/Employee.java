/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.model;

import hospitalhumanresourcemanagement.controller.DateHandler;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Employee implements java.io.Serializable{
    private String ID;
    private String name;
    private String phone;
    private LocalDate bDate;
    private Role role;
    private LocalDate hiredDate;
    private int salary;
    private int contractTime;
    private LocalDate resignDate;

    public Employee(String ID, String name, String phone, LocalDate bDate, Role role, LocalDate hiredDate, int salary, int contractTime, LocalDate resignDate) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.bDate = bDate;
        this.role = role;
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.contractTime = contractTime;
        this.resignDate = resignDate;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public int getSalary() {
        return salary;
    }

    public int getContractTime() {
        return contractTime;
    }

    public LocalDate getResignDate() {
        return resignDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setContractTime(int contractTime) {
        this.contractTime = contractTime;
    }

    public void setResignDate(LocalDate resignDate) {
        this.resignDate = resignDate;
    }
    
    public String[] toListString() {
        String[] output = {
            this.ID,
            this.name,
            this.phone,
            DateHandler.dateToString(this.bDate),
            this.role.getName(),
            DateHandler.dateToString(this.hiredDate),
            Integer.toString(this.salary),
            Integer.toString(this.contractTime),
            DateHandler.dateToString(this.resignDate)
        };
        return output;
    }
}
