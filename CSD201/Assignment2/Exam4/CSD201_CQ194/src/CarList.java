
import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CarList extends Car implements I_List {

    Map<String, Car> mycar;
    List<Car> list;

    public CarList() {
        this.mycar = new HashMap<>();
    }

    @Override
    public void AddFromFile(String fName) {
        try {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            fileInputStream = new FileInputStream(fName);
            objectInputStream = new ObjectInputStream(fileInputStream);

            // List is an interface, so choose another that implements List interface
            list = (ArrayList<Car>) objectInputStream.readObject();
            // Load the list to Map - HashMap
            list.forEach((car) -> {
                mycar.put(car.getCode(), car);
            });

            // Close
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    @Override
    public void saveToFile(String fName) {
        try {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            fileOutputStream = new FileOutputStream(fName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write data to file
            objectOutputStream.writeObject(list);

            // Close
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void add() {
        Car newCar = new Car();
        newCar.input();
        if (mycar.containsKey(newCar.getCode())) {
            System.out.println("Car code exist !!!");
            return;
        }
        // Not dupplicate
        list.add(newCar);
        mycar.put(newCar.getCode(), newCar);
    }

    @Override
    public void remove() {
        String codeToRemove;
        codeToRemove = Inputter.inputPattern("   - Enter code (CAxxx) to remove: ", "^CA\\d{3}");
        Car carToRemove = mycar.get(codeToRemove);
        if (carToRemove == null) {
            System.out.println("Car code not exist !!!");
            return;
        }
        // Exist car
        // Remove
        mycar.remove(codeToRemove);
        list.remove(carToRemove);
    }

    @Override
    public void update() {
        String codeToUpdate;
        codeToUpdate = Inputter.inputPattern("   - Enter code (CAxxx) to remove: ", "^CA\\d{3}");
        Car carToUpdate = mycar.get(codeToUpdate);
        if (carToUpdate == null) {
            System.out.println("Car code not exist !!!");
            return;
        }
        // Exist car
        // Update information
        String newOwner = Inputter.inputStr("Enter new owner (leave bank will not change): ");
        // Update if not empty
        if (!newOwner.isEmpty()) {
            carToUpdate.setOwner(newOwner);
        }
        
        try {
            String newPriceStr = Inputter.inputStr("Enter new price (leave bank will not change): ");
            Double newPrice = Double.parseDouble(newPriceStr);
            // Update on no Excaption
            carToUpdate.setPrice(newPrice);
        } catch (NumberFormatException e) {
            // Do nothing
        }
    }

    @Override
    public void print() {
        // Sort the List
        // With the condition in compareTo
//        Collections.sort(list);
        list.forEach((Car car) -> {
            System.out.println(car);
        });
    }
}
