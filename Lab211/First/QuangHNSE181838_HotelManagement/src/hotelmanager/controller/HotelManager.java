/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.controller;

import hotelmanager.model.Hotel;
import hotelmanager.model.HotelList;
import hotelmanager.view.PrintTable;
import hotelmanager.view.Prompt;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class HotelManager {

    private HotelList hotels;
    final String DATABASE_FILE;
    private final FileHandler<HotelList> fileHandler;
    final String[] INFO_HEADERS = {
        "ID",
        "Name",
        "Room Available",
        "Address",
        "Phone",
        "Rating"
    };

    public HotelManager() {
        hotels = new HotelList();
        DATABASE_FILE = "Hotel.dat";
        fileHandler = new FileHandler<>(DATABASE_FILE);

        try {
            hotels = fileHandler.loadObjectFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load data from file");
            System.out.println(e);
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
                    addHotel();
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
            fileHandler.saveObjectToFile(hotels);
            System.out.println("Successfuly add sample hotel !!!");
        } catch (IOException e) {
            System.out.println("Failed to add sample hotel !!!");
            hotels = new HotelList();
        }
    }

    public void addHotel() {
        Hotel newHotel = Prompt.enterHotelInformation();
        if (Validator.isValidHotel(newHotel)) {
            if (hotels.isExistHotelId(newHotel.getHotelId())) {
                System.out.println("Duplicated hotel ID !!! Enter hotel information again");
                addHotel();
                return;
            }
            try {
                hotels.addHotel(newHotel);
                System.out.println(hotels);
                fileHandler.saveObjectToFile(hotels);
                System.out.println("Successfuly add hotel !!!");
            } catch (IOException e) {
                System.out.println("Failed to add hotel !!!");
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
        boolean status = hotels.isExistHotelId(hotelId);
        if (status) {
            System.out.println("Exist Hotel !!!");
        } else {
            System.out.println("No Hotel Found !!!");
        }
        // ask for continue
        boolean askForContinue = Prompt.yesNoPrompt("Do you want to continue check existing hotel? (y/N): ");
        if (askForContinue) {
            checkExistHotel();
        }
    }

    public void updateHotelInformation() {
        String hotelId = Prompt.stringInput("Enter the hotel ID you want to update: ");
        HotelList lookedUpHotel = hotels.searchHotelById(hotelId, true);
        if (lookedUpHotel.size() == 1) {
            Hotel oldHotel = lookedUpHotel.get(0);
            Hotel newHotel = Prompt.enterHotelInformation(oldHotel);
            hotels.updateHotelInformation(oldHotel, newHotel);
            try {
                fileHandler.saveObjectToFile(hotels);
                System.out.println("Successfuly update hotel information !!!");
            } catch (IOException e) {
                System.out.println("Failed to update hotel information !!!");
                // Discard change
                hotels.updateHotelInformation(newHotel, oldHotel);
            }
        } else {
            System.out.println("Hotel does not exist !!!");
        }
    }

    public void deleteHotel() {
        String hotelId = Prompt.stringInput("Enter the hotel ID you want to delete: ");
        boolean askForSure = Prompt.yesNoPrompt("Do you ready want to delete this hotel? (y/N): ");
        if (askForSure) {
            boolean status = hotels.deleteHotel(hotelId);
            if (status) {
                System.out.println("Successfully delete the hotel !!!");
            } else {
                System.out.println("Failed to delete the hotel !!!");
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
                HotelList searchHotel = hotels.searchHotelById(hotelId, false);
                if (searchHotel.isEmpty()) {
                    System.out.println("No Hotel Found !!!");
                }
                Collections.sort(searchHotel, (Hotel hotel1, Hotel hotel2) -> hotel2.getHotelId().compareToIgnoreCase(hotel1.getHotelId()));
                printHotelListTable(searchHotel);
                break;
            case 2:
                String hotelName = Prompt.stringInput("Enter the hotel name you want to search: ", true);
                Hotel hotel = hotels.searchHotelByName(hotelName);
                if (Validator.isValidHotel(hotel)) {
                    System.out.println(hotel);
                } else {
                    System.out.println("No Hotel Found !!!");
                }
                break;
        }
    }

    private void printHotelListTable(HotelList hotels) {
        PrintTable printTable = new PrintTable(INFO_HEADERS, hotels);
        printTable.printTableData();
    }
    
    public void showAllHotel() {
        HotelList allHotel = hotels.getAllHotelSorted();
        printHotelListTable(allHotel);
    }

}
