/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.controller;

import hotelmanager.model.Hotel;
import hotelmanager.view.Prompt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class HotelManager {

    private ArrayList<Hotel> hotels = new ArrayList<>();
    final String DATABASE_FILE = "Hotel.dat";

    public HotelManager() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (!loadDataFromFile()) {
            addSampleData();
        }
    }

    public void run() {
        int choice;
        String[] menu = {
            "Add hotel",
            "Check exist hotel",
            "Update hotel information",
            "Delete hotel",
            "Search hotel",
            "Show all hotel",
            "Quit"
        };
        do {
            choice = Prompt.getChoice(menu);
            switch (choice) {
                case 1:
                    this.addHotel();
                    break;
                case 2:
                    checkExistHotel();
                    break;
                case 3:
                    updateHotelInformation();
                    break;
                case 4:
                    deleteHotel();
                    break;
                case 5:
                    searchHotel();
                    break;
                case 6:
                    showAllHotel();
                    break;
            }
        } while (choice != 7);
    }

    private void addSampleData() {
        System.out.println("Adding sample data !!!");
        hotels.add(new Hotel("H01", "Seraton", 10, "189 Ung Van Khiem, Ward 25, Binh Thanh District, Ho Chi Minh City", "0911796099", 4));
        hotels.add(new Hotel("H02", "VinStar", 5, "200 Ung Van Khiem, Ward 25, Binh Thanh District, Ho Chi Minh City", "0918940111", 5));
        hotels.add(new Hotel("H03", "OutString", 7, "300 D1, Ward 24, Binh Thanh District, Ho Chi Minh City", "0988940222", 6));
        hotels.add(new Hotel("H04", "Betigar", 8, "189 Duong Quang Ham, Ward 5, Go Vap District, Ho Chi Minh City", "0977940100", 3));
        try {
            saveDataToFile();
            System.out.println("Successfuly add sample hotel !!!");
        } catch (IOException e) {
            System.out.println("Failed to add sample hotel !!!");
            hotels = new ArrayList<>();
        }
    }

    private boolean isDuplicatedHotelId(String hotelId) {
        ArrayList<Hotel> lookedUpHotel = this.searchHotelById(hotelId);
        return (lookedUpHotel.size() == 1 && lookedUpHotel.get(0).getHotelName().equalsIgnoreCase(hotelId));
    }
    
    public void addHotel() {
        Hotel newHotel = Prompt.enterHotelInformation();
        if (newHotel != null) {
            if (isDuplicatedHotelId(newHotel.getHotelId())) {
                System.out.println("Duplicated hotel ID !!! Enter hotel information again");
                addHotel();
                return;
            }
            try {
                hotels.add(newHotel);
                saveDataToFile();
                System.out.println("Successfuly add hotel !!!");
            } catch (IOException e) {
                System.out.println("Failed to add hotel !!! [IO]");
                hotels.remove(newHotel);
            }
        } else {
            System.out.println("Failed to add hotel !!!");
        }
        // ask for continue
        boolean askForContinue = Prompt.yesNoPrompt("Do you want to continue adding hotels? (y/N): ");
        if (askForContinue) {
            addHotel();
        }
    }

    public void checkExistHotel() {
        String hotelId = Prompt.stringInput("Enter the hotel ID you want to check: ");
        ArrayList<Hotel> lookedUpHotel = this.searchHotelById(hotelId);
        if (lookedUpHotel.size() == 1 && lookedUpHotel.get(0).getHotelName().equalsIgnoreCase(hotelId)) {
            System.out.println("Exist Hotel !!!");
        } else {
            System.out.println("No Hotel Found !!!");
        }
    }

    public void updateHotelInformation() {
        String hotelId = Prompt.stringInput("Enter the hotel ID you want to update: ");
        ArrayList<Hotel> lookedUpHotel = this.searchHotelById(hotelId);
        if (lookedUpHotel.size() == 1 && lookedUpHotel.get(0).getHotelName().equalsIgnoreCase(hotelId)) {
            Hotel hotelToUpdate = lookedUpHotel.get(0);
            int indexOfHotel = hotels.indexOf(hotelToUpdate);
            Hotel updatedHotel = Prompt.enterHotelInformation(hotelToUpdate);
            hotels.set(indexOfHotel, updatedHotel);
            try {
                hotels.set(indexOfHotel, updatedHotel);
                saveDataToFile();
                System.out.println("Successfuly update hotel information !!!");
            } catch (IOException e) {
                System.out.println("Failed to update hotel information !!!");
                hotels.set(indexOfHotel, hotelToUpdate);
            }
        } else {
            System.out.println("Hotel does not exist !!!");
        }
    }

    public void deleteHotel() {
        String hotelId = Prompt.stringInput("Enter the hotel ID you want to delete: ");
        boolean askForSure = Prompt.yesNoPrompt("Do you ready want to delete this hotel? (y/N): ");
        ArrayList<Hotel> backUpHotel = (ArrayList<Hotel>) hotels.clone();
        if (askForSure) {
            boolean status = hotels.removeIf(hotel -> hotel.getHotelId().equalsIgnoreCase(hotelId));
            if (status) {
                try {
                    saveDataToFile();
                    System.out.println("Successfuly delete hotel !!!");
                } catch (IOException e) {
                    System.out.println("Failed to add hotel !!!");
                    hotels = (ArrayList<Hotel>) backUpHotel.clone();
                }
            } else {
                System.out.println("Failed to delete hotel !!!");
            }
        }
    }

    public void searchHotel() {
        String[] menu = {
            "Search by Hotel ID",
            "Search by Hotel Name",
            "Back"
        };
        int choice = Prompt.getChoice(menu);
        switch (choice) {
            case 1:
                String hotelId = Prompt.stringInput("Enter the hotel ID you want to search: ");
                ArrayList<Hotel> searchHotel = searchHotelById(hotelId);
                Collections.sort(searchHotel, new Comparator<Hotel>() {
                    @Override
                    public int compare(Hotel hotel1, Hotel hotel2) {
                        return hotel2.getHotelId().compareToIgnoreCase(hotel1.getHotelId());
                    }
                });
                for (Hotel hotel : searchHotel) {
                    System.out.println(hotel);
                }
                break;
            case 2:
                String hotelName = Prompt.stringInput("Enter the hotel name you want to search: ", true);
                System.out.println(searchHotelByName(hotelName));
                break;
        }
    }

    public ArrayList<Hotel> searchHotelById(String hotelId) {
        ArrayList<Hotel> filteredHotel = hotels;
        filteredHotel.removeIf(hotel -> (!hotel.getHotelId().toLowerCase().contains(hotelId.toLowerCase())));
        return filteredHotel;
    }

    public Hotel searchHotelByName(String hotelName) {
        hotelName = hotelName.toLowerCase();
        for (Hotel iter : hotels) {
            if (iter.getHotelName().toLowerCase().equalsIgnoreCase(hotelName)) {
                return iter;
            }
        }
        return null;
    }

    public void showAllHotel() {
        Collections.sort(hotels, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel hotel1, Hotel hotel2) {
                return hotel2.getHotelName().compareToIgnoreCase(hotel1.getHotelName());
            }
        });
        hotels.forEach(hotel -> {
            System.out.println(hotel);
        });
    }

    private boolean databaseFileExist() {
        return (new File(DATABASE_FILE)).exists();
    }

    private void saveDataToFile() throws IOException, FileNotFoundException {
        if (!databaseFileExist()) {
            (new File(DATABASE_FILE)).createNewFile();
        }
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        fileOutputStream = new FileOutputStream(DATABASE_FILE);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(hotels);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    private boolean loadDataFromFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (!databaseFileExist()) {
            (new File(DATABASE_FILE)).createNewFile();
        }
        FileInputStream databaseFile;
        ObjectInputStream loadObjectFromFile;

        databaseFile = new FileInputStream(DATABASE_FILE);
        try {
            loadObjectFromFile = new ObjectInputStream(databaseFile);
        } catch (IOException e) {
            // Close file handler before init database file
            databaseFile.close();
            saveDataToFile();
            return false;
        }

        hotels = (ArrayList<Hotel>) loadObjectFromFile.readObject();

        loadObjectFromFile.close();
        databaseFile.close();
        return true;
    }
}
