/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager.view;

import com.bethecoder.ascii_table.ASCIITable;
import hotelmanager.model.HotelList;

/**
 *
 * @author ASUS
 */
public final class PrintTable {

    private final String[] columnNames;
    private String[][] data;
    private final HotelList hotelList;

    public PrintTable(String[] columnNames, HotelList hotelList) {
        this.columnNames = columnNames;
        this.hotelList = hotelList;
        this.data = new String[0][0];
    }

    private void convertHotelListToObjectList() {
        hotelList.forEach((hotel) -> {
            appendData(hotel.toListString());
        });
    }

    public void printTableData() {
        // Convert hotel list into object list
        convertHotelListToObjectList();
        ASCIITable.getInstance().printTable(columnNames, data);
    }

    private void appendData(String[] newData) {
        // Create a new array with increased size
        int newSize = this.data.length;
        String[][] newArray = new String[newSize + 1][];

        // Copy existing data to the new array
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);

        // Append new data to the end of the new array
        newArray[this.data.length] = newData;

        this.data = newArray;
    }
}
