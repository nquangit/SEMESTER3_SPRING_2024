/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {

    public static int hashFunct(char c) {
        int asciiC = (int) c;
        if (asciiC >= 65 && asciiC <= 90) {
            return (int) (c - 'A');
        } else if (asciiC >= 97 && asciiC <= 122) {
            return (int) (c - 'a');
        } else {
            return -1;
        }
    }

    public static int hashVal(String key, int tableSize) {
        return Math.abs(key.hashCode() % tableSize);
    }

    public static void main(String[] args) {
        Student obj1 = new Student("Vu Nguyen Le", 20, 85.5f);
        Student obj2 = new Student("Phong Vu Thanh", 22, 78.3f);

        System.out.println("HashCode Obj1: " + obj1.hashCode());
        System.out.println("HashCode Obj2: " + obj2.hashCode());
        System.out.println("HashCode Vu Nguyen Le: " + obj1.getName().hashCode());
        System.out.println("HashCode Phong Vu Thanh: " + obj2.getName().hashCode());
        System.out.println("HashCode Math.abs(Vu%26): " + Math.abs(obj1.getName().hashCode() % 26));
        System.out.println("HashCode Math.abs(Phong%26): " + Math.abs(obj2.getName().hashCode() % 26));

        String key = "Phong Vu Thanh";
        int haskey = hashVal(key, 26);
        System.out.println(haskey);
        haskey = hashFunct('z');
        System.out.println(haskey);
    }
}
