package hotel;

import java.util.Scanner;

/**
 *
 * @author VICTUS
 */
public class HotelManagement {

    private static final String Menu = "---------------------------\n"
            + "1) Adding new Hotel.\n"
            + "2) Checking exits Hotel.\n"
            + "3) Updating Hotel information.\n"
            + "4) Deleting Hotel.\n"
            + "5) Searching Hotel.\n"
            + "6) Displaying a hotel list (descending by Hotel_Name).\n"
            + "7) Others Quit.";

    public static void main(String[] args) {
        Tools list = new Tools("./Hotel.dat");
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(Menu);
            choice = Inputer.InputInt("Enter your choice (1 - 7): ");
            switch (choice) {
                case 1:
                    // Thêm hotel
                    list.AddHotel();
                    if (list.saveToFile()) {
                        System.out.println("Save to File success!");
                    } else {
                        System.out.println("Save to File fail, please check again!");
                    }
                    break;

                case 2:
                    //kiểm tra có hotel đó không
                    if (list.IsEmpty()) {
                        System.out.println("No Hotel here!");
                    } else {
                        String checkHotel = Inputer.InputString("Enter your Hotel you want to check: ");
                        Data a = list.findHotelID(checkHotel);
                        if (a != null) {
                            System.out.println("Exist Hotel");
                        } else {
                            System.out.println("No Hotel Found!");
                        }
                    }
                    break;
                case 3:
                    //cập nhật thông tin hotel
                    if (list.IsEmpty()) {
                        System.out.println("No Hotel here!");
                    } else {
                        list.UpdateHote();
                    }
                    break;
                case 4:
                    // Xóa hotel
                    if (list.IsEmpty()) {
                        System.out.println("No Hotel Here!");
                    } else {
                        String deleteHotelId = Inputer.InputString("Enter Hotel ID you want to delete: ");
                        boolean deleted = list.deleteHotel(deleteHotelId);
                        if (deleted) {
                            System.out.println("Hotel deleted successfully!");
                            if (list.saveToFile()) {
                                System.out.println("Save to File success!");
                            } else {
                                System.out.println("Save to File fail, please check again!");
                            }
                        } else {
                            System.out.println("Hotel not found or deletion failed!");
                        }
                    }
                    break;

                case 5:
                    //tìm kiếm hotel
                    System.out.println("1. Search by Hotel ID\n"
                            + "2. Search by Hotel Name\n"
                            + "Other. Cancel");
                    int chon = Inputer.InputInt("Enter your choice: ");
                    switch (chon) {
                        case 1:
                            //kiếm theo hotel ID
                            if (list.IsEmpty()) {
                                System.out.println("No Hotel here!");
                            } else {
                                String searchHotelId = Inputer.InputString("Enter Hotel ID you want to search: ");
                                list.searchHotelById(searchHotelId);
                                break;
                            }
                        case 2:
                            //kiếm theo tên hotel
                            if (list.IsEmpty()) {
                                System.out.println("No Hotel here!");
                            } else {
                                String searchHotelName = Inputer.InputString("Enter Hotel Name you want to search: ");
                                list.searchHotelByName(searchHotelName);
                                break;
                            }
                        default:
                            break;
                    }
                    break;
                case 6:
                    // Hiển thị danh sách khách sạn theo bảng chữ cái
                        list.readHotelDataFromFile();
                        if(list.IsEmpty())
                            list.showHotel();  
                        else
                            System.out.println("No Hotel here!");
                    
                    break;
                case 7:
                    System.out.println("BYE!!!");
            }
        } while (choice != 7);
    }
}
