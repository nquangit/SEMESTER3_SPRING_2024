/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VICTUS
 */
public class Tools {

    private List<Data> ds;
    private String filePath;

    public Tools(String fileName) {
        this.ds = new ArrayList<>();
        this.filePath = fileName;
    }

    public boolean IsEmpty() {
        boolean result = false;
        if (this.ds.size() == 0) {
            result = true;
        }
        return result;
    }

    /**
     * hàm thêm 1 hotel với các giá trị Hotel ID, Name, Room available, Address,
     * Phone, Rate
     */
    public void AddHotel() {
        Data newHotel = new Data();
        /**
         * Nhập Hotel ID ID có độ dài là 4
         */
        do {
            String hotelIdInput = Inputer.InputString("Enter Hotel ID (must be a 4-digit number): ");
            if (findHotelID(hotelIdInput) == null) {
                if (hotelIdInput.length() == 4) {
                    newHotel.setHotel_id(hotelIdInput);
                    break;
                } else {
                    System.out.println("Please enter a valid 4-digit number for Hotel ID!");
                }
            } else {
                System.out.println("ID existed!");
            }
        } while (true);

        /*
        nhập Hotel name khác null
         */
        do {
            String hotelInput = Inputer.InputString("Enter Hotel name: ");
            if (hotelInput != null) {
                newHotel.setHotel_Name(hotelInput);
                break;
            } else {
                System.out.println("Hotel Name can not Empty");
            }
        } while (true);

        /*
        nhập Hotel room available khác null
         */
        do {
            newHotel.setHotel_Room_Available(Inputer.InputInt("Enter Room Available: "));
        } while (String.valueOf(newHotel.getHotel_Room_Available()).length() == 0);

        /*
        nhập Hotel Address khác null
         */
        do {
            newHotel.setHotel_Address(Inputer.InputString("Enter Hotel Address: "));
        } while (String.valueOf(newHotel.getHotel_Address()).length() == 0);

        /*
        nhập Hotel Phone đã được chuyển hóa thường số từ 9 - 11 số
         */
        do {
            String hotelInput = Inputer.InputString("Enter Hotel Phone: ");
            if (hotelInput.length() >= 9 && hotelInput.length() <= 11) {
                newHotel.setHotel_Phone(hotelInput);
                break;
            } else {
                System.out.println("Your Phone must in 9-11 number!");
            }
        } while (true);

        /*
        nhập Hotel Rating có giá trị từ 1-5
         */
        do {
            float hotelInput = Inputer.InputFloat("Enter Hotel Rating: ");
            if (hotelInput >= 1 && hotelInput <= 5) {
                newHotel.setHotel_Rating(hotelInput);
                break;
            } else {
                System.out.println("Rate must 1-5!");
            }
        } while (true);
        this.ds.add(newHotel);
    }

    /**
     * class show ra tất cả các hotel có trong danh sách
     *
     * @param ds là List hotel
     */
    public void showHotel() {
        System.out.println("|ID   |Name                     |Room    |Address        |Phone      |Rate|");
        for (Data i : this.ds) {
            System.out.println(i);
        }
    }

    /**
     * class tìm 1 hotel
     *
     * @param checkHotel là biến hotel ID cần tìm
     * @param ds là List hotel
     * @return 1 hotel đã tìm ra nếu không tìm ra sẽ trả về null
     */
    public Data findHotelID(String checkHotel) {
        Data a = null;
        for (Data i : this.ds) {
            if (i.getHotel_id().equals(checkHotel)) {
                a = i;
                break;
            }
        }
        return a;
    }

    public void UpdateHote() {
        Data updated = new Data();
        String ID = Inputer.InputString("Enter Hotel ID you want to update: ");
        Data existied = findHotelID(ID);

        if (existied != null) {
            // In ra thông tin khách sạn cần được cập nhật
            System.out.println("Hotel found. Existing information:");
            System.out.println(existied);
            // Nhập thông tin mới
            updated.setHotel_id(ID);
            /*
        nhập Hotel name khác null
             */
            String hotelInput = Inputer.InputString("Enter Hotel name(press Enter to keep old value): ");
            if (hotelInput != null) {
                updated.setHotel_Name(hotelInput);
                /*
        nhập Hotel room available khác null
                 */
                updated.setHotel_Room_Available(Inputer.InputInt("Enter Room Available(press Enter to keep old value): "));
                /*
        nhập Hotel Address khác null
                 */
                updated.setHotel_Address(Inputer.InputString("Enter Hotel Address(press Enter to keep old value): "));
                /*
        nhập Hotel Phone đã được chuyển hóa thường số từ 9 - 11 số
                 */
                String a = Inputer.InputString("Enter new Hotel Phone (press Enter to keep old value): ");
                if (a.length() >= 9 && a.length() <= 11) {
                    updated.setHotel_Phone(a);
                    /*
        nhập Hotel Rating có giá trị từ 1-5
                     */
                    int b = Inputer.InputInt("Enter Hotel Rating(press Enter to keep old value): ");
                    if (b >= 1 && b <= 5) {
                        updated.setHotel_Rating(b);

                        // Thêm thông tin mới vào danh sách và xóa thông tin cũ
                        ds.remove(existied);
                        ds.add(updated);

                        System.out.println("Hotel information updated successfully:");
                        System.out.println(updated);
                    } else {
                        System.out.println("Hotel does not exist");
                    }
                }
            }
        }
    }

    // Hàm cập nhật file với danh sách khách sạn mới
    public boolean saveToFile() {
        boolean status = false;
        try {
            File fo = new File(filePath);
            FileOutputStream fos = new FileOutputStream(fo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.ds);
            oos.close();
            fos.close();
            status = true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error file path");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error to save file");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    /*
    đọc dữ liệu từ file Hotel.dat
     */
    public void readHotelDataFromFile() {
        try {
            File fi = new File(this.filePath);
            FileInputStream fis = new FileInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolean loop = true;
            while (loop) {
                Data x = (Data)ois.readObject();
                if (x != null) {
                    this.ds.add(x);
                } else {
                    loop = false;
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: ");
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    xóa hotel có trong hotel.dat
     */
    public boolean deleteHotel(String hotelId) {
        boolean result = false;
        Data hotelToDelete = findHotelID(hotelId);
        if (hotelToDelete != null) {
            System.out.println("Do you really want to delete this hotel?");
            System.out.println(hotelToDelete);
            String confirm = Inputer.InputString("Enter 'yes' to confirm deletion: ");
            if (confirm.contains("yes")) {
                ds.remove(hotelToDelete);
                result = true;
            }
        }
        return result;
    }

//tìm hotel theo id trong file hotel.dat
    public void searchHotelById(String hotelId) {
        for (Data hotel : ds) {
            if (hotel.getHotel_id().contains(hotelId)) {
                System.out.println(hotel);
            }
        }
    }

    // tìm hotel theo tên trong file hotel.dat
    public void searchHotelByName(String hotelName) {
        List<Data> result = new ArrayList<>();
        for (Data hotel : ds) {
            if (hotel.getHotel_Name().contains(hotelName)) {
                System.out.println(hotel);
            }
        }
    }
}
