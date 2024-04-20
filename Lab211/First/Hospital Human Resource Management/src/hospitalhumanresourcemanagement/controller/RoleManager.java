/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller;

import hospitalhumanresourcemanagement.controller.IO.InputHandler;
import hospitalhumanresourcemanagement.model.Role;
import hospitalhumanresourcemanagement.view.PrintTable;
import java.util.LinkedHashMap;

/**
 *
 * @author ASUS
 */
public class RoleManager implements java.io.Serializable {

    // Create a list to manage role
    // Use hashmap for searching with O(1)
    // The key is name of role, and value is the role Object
    private final LinkedHashMap<String, Role> roleList;

    public RoleManager(LinkedHashMap<String, Role> roleList) {
        this.roleList = roleList;
    }

    public RoleManager() {
        roleList = new LinkedHashMap<>();
    }

    public Role selectRole() {
        final String[] HEADERS = {
            "ID",
            "Name"
        };
        PrintTable<Role> printTable = new PrintTable<>(HEADERS, roleList);
        printTable.printTableData();
        while (true) {
            boolean longInput = true;
            String choice = InputHandler.stringInput("For security reasons,\nplease enter the name of the role: ", longInput);
            // Empty input will return default role
            if (choice.isEmpty()) {
                return null;
            }
            if (roleList.get(choice.toLowerCase()) != null) {
                return roleList.get(choice.toLowerCase());
            }
            System.out.println("Role not found");
        }
    }

    public void initRole() {
        int technicianLearningTime = 4;
        int nurseLearningTime = 4;
        int doctorLearningTime = 6;
        roleList.put("Nurse".toLowerCase(), new Role("Nurse", Role.BASE_AGE_REQUIRE + nurseLearningTime));
        roleList.put("Doctor".toLowerCase(), new Role("Doctor", Role.BASE_AGE_REQUIRE + doctorLearningTime));
        roleList.put("Technician".toLowerCase(), new Role("Technician", Role.BASE_AGE_REQUIRE + technicianLearningTime));
    }

    public void addRole(Role role) {
        if (!isExistRole(role)) {
            roleList.put(role.getName(), role);
        }
    }

    public Role getRole(String roleName) {
        roleName = roleName.toLowerCase();
        return roleList.get(roleName);
    }
    
    public boolean isExistRole(Role role) {
        return roleList.get(role.getName()) != null;
    }

    public void removeRole(Role role) {
        roleList.remove(role.getName());
    }
}
