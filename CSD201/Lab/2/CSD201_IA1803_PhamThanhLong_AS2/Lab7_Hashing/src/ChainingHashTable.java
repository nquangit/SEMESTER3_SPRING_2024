
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class ChainingHashTable {

    private LinkedList<Student>[] table;
    private int size;

    public ChainingHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hashFunction(String name) {
        char firstChar = Character.toLowerCase(name.charAt(0));
        return firstChar - 'a';
    }

    public void insert(Student student) {
        int index = hashFunction(student.getName());
        table[index].add(student);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (Student student : table[i]) {
                System.out.print("(" + student.getName() + ", " + student.getAge() + ", " + student.getMark() + ") -> ");
            }
            System.out.println("null");
        }
    }  
}
