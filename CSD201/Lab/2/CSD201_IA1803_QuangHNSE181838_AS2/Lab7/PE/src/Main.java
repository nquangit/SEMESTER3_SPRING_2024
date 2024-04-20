
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
        Student obj1 = new Student("Long Thanh Luong", 21, 82.6f);
        Student obj2 = new Student("Hoang Vu Thanh", 22, 77.5f);

        System.out.println("HashCode Obj1: " + obj1.hashCode());
        System.out.println("HashCode Obj2: " + obj2.hashCode());
        System.out.println("HashCode Vu Nguyen Le: " + obj1.getName().hashCode());
        System.out.println("HashCode Phong Vu Thanh: " + obj2.getName().hashCode());
        System.out.println("HashCode Math.abs(Vu%26): " + Math.abs(obj1.getName().hashCode() % 26));
        System.out.println("HashCode Math.abs(Phong%26): " + Math.abs(obj2.getName().hashCode() % 26));

        String key = "Long Thanh Luong";
        int haskey = hashVal(key, 26);
        System.out.println(haskey);
        haskey = hashFunct('z');
        System.out.println(haskey);
    }
}
