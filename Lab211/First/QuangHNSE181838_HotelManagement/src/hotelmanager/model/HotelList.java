/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class HotelList extends ArrayList<Hotel> {

    public void addHotel(Hotel newHotel) {
        this.add(newHotel);
    }

    public boolean isExistHotelId(String hotelId) {
        HotelList lookedUpHotel = this.searchHotelById(hotelId, true);
        return (lookedUpHotel.size() == 1);
    }

    public void updateHotelInformation(Hotel oldHotel, Hotel updatedHotel) {
        int indexOfHotel = this.indexOf(oldHotel);
        this.set(indexOfHotel, updatedHotel);
    }

    public boolean deleteHotel(String hotelId) {
        HotelList hotels = searchHotelById(hotelId, true);
        if (hotels.size() == 1) {
            return this.remove(hotels.get(0));
        }
        return false;
    }

    public HotelList searchHotelById(String hotelId, boolean exactWord) {
        HotelList filteredHotel = (HotelList) this.clone();
        if (exactWord) {
            filteredHotel.removeIf(hotel -> (!hotel.getHotelId().equals(hotelId)));
        } else {
            filteredHotel.removeIf(hotel -> (!hotel.getHotelId().toLowerCase().contains(hotelId.toLowerCase())));
        }
        return filteredHotel;
    }

    public Hotel searchHotelByName(String hotelName) {
        for (Hotel iter : this) {
            if (iter.getHotelName().equals(hotelName)) {
                return iter;
            }
        }
        return null;
    }

    public HotelList getAllHotelSorted() {
        HotelList allHotel = (HotelList) this.clone();
        Collections.sort(allHotel, (Hotel firstHotel, Hotel secondHotel) -> secondHotel.getHotelName().compareTo(firstHotel.getHotelName()));
        return allHotel;
    }

    @Override
    public String toString() {
        this.forEach(hotel ->{
            System.out.println(hotel);
        });
        return "";
    }
    
    
}
