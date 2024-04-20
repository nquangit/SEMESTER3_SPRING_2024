/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;

import hotelmanager.controller.HotelManager;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String args[]) {
        try {
            HotelManager hotelManager = new HotelManager();
            hotelManager.run();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
