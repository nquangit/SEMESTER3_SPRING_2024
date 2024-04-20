/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.controller;

import hotelmanager.model.Hotel;

/**
 *
 * @author ASUS
 */
public class Validator {
    
    public static final String VALID_PHONE_NUMBER_REGEX = "^0\\d{9}$";
    public static final String MATCH_ALL_EXCEPT_SPACE = ".*";
    
    public static final int MIN_RATING = 0;
    public static final int MAX_RATING = 10;
    
    public static final int MAX_ROOM_AVAILABLE = Integer.MAX_VALUE;
    public static final int MIN_ROOM_AVAILABLE = 0;

    public static boolean isValidHotel(Hotel hotel) {
        return (hotel != null);
    }
}
