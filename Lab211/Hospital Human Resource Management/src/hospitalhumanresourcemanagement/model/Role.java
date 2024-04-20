/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.model;

/**
 *
 * @author ASUS
 */
public class Role implements java.io.Serializable {
    public static final int BASE_AGE_REQUIRE = 18;

    private String name;
    private int ageRequired;

    public Role(String name, int ageRequired) {
        this.name = name;
        this.ageRequired = ageRequired;
    }

    public void setAgeRequired(int ageRequired) {
        this.ageRequired = ageRequired;
    }

    public int getAgeRequired() {
        return ageRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] toListString() {
        String[] output = {
            this.name
        };
        return output;
    }
    @Override
    public String toString() {
        return name;
    }
}
