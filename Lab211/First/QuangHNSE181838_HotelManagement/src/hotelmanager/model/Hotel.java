/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.model;

/**
 *
 * @author ASUS
 */
public class Hotel implements java.io.Serializable {

    private String hotelId;
    private String hotelName;
    private int hotelRoomAvailable;
    private String hotelAddress;
    private String hotelPhone;
    private int hotelRating;

    public Hotel(String hotelId, String hotelName, int hotelRoomAvailable, String hotelAddress, String hotelPhone, int hotelRating) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRoomAvailable = hotelRoomAvailable;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelRating = hotelRating;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getHotelRoomAvailable() {
        return hotelRoomAvailable;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelRoomAvailable(int hotelRoomAvailable) {
        this.hotelRoomAvailable = hotelRoomAvailable;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String[] toListString() {
        String[] result = {
            getHotelId(),
            getHotelName(),
            Integer.toString(getHotelRoomAvailable()),
            getHotelAddress(),
            getHotelPhone(),
            Integer.toString(getHotelRating())
        };
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelRoomAvailable=" + hotelRoomAvailable + ", hotelAddress=" + hotelAddress + ", hotelPhone=" + hotelPhone + ", hotelRating=" + hotelRating + '}';
    }

}
