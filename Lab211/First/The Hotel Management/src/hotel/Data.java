package hotel;


import java.io.Serializable;

public class Data implements Serializable {

    public String Hotel_id;
    public String Hotel_Name;
    public int Hotel_Room_Available;
    public String Hotel_Address;
    public String Hotel_Phone;
    public float Hotel_Rating;

    public String getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(String Hotel_id) {
        this.Hotel_id = Hotel_id;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }

    public void setHotel_Name(String Hotel_Name) {
        this.Hotel_Name = Hotel_Name;
    }

    public int getHotel_Room_Available() {
        return Hotel_Room_Available;
    }

    public void setHotel_Room_Available(int Hotel_Room_Available) {
        this.Hotel_Room_Available = Hotel_Room_Available;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String Hotel_Address) {
        this.Hotel_Address = Hotel_Address;
    }

    public String getHotel_Phone() {
        return Hotel_Phone;
    }

    public void setHotel_Phone(String Hotel_Phone) {
        this.Hotel_Phone = Hotel_Phone;
    }

    public float getHotel_Rating() {
        return Hotel_Rating;
    }

    public void setHotel_Rating(float Hotel_Rating) {
        this.Hotel_Rating = Hotel_Rating;
    }

    public Data() {
        this.Hotel_id = "";
        this.Hotel_Name = "";
        this.Hotel_Room_Available = 0;
        this.Hotel_Address = "";
        this.Hotel_Phone = "";
        this.Hotel_Rating = 0;
    }

    public Data(String Hotel_id, String Hotel_Name, int Hotel_Room_Available, String Hotel_Address, String Hotel_Phone, int Hotel_Rating) {
        this.Hotel_id = Hotel_id;
        this.Hotel_Name = Hotel_Name;
        this.Hotel_Room_Available = Hotel_Room_Available;
        this.Hotel_Address = Hotel_Address;
        this.Hotel_Phone = Hotel_Phone;
        this.Hotel_Rating = Hotel_Rating;
    }
    

    @Override
    public String toString() {
        return String.format("-------------------------------------------------------------\n"
                + "|%-5s|%-25s|%-8s|%-15s|%-11s|%-4s|", this.Hotel_id, this.Hotel_Name, this.Hotel_Room_Available,
                this.Hotel_Address, this.Hotel_Phone, this.Hotel_Rating);
    }

   
}
