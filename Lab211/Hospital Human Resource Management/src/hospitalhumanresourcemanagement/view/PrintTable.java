/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.view;

import com.bethecoder.ascii_table.ASCIITable;
import hospitalhumanresourcemanagement.model.Employee;
import hospitalhumanresourcemanagement.model.Role;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public final class PrintTable<ObjectType> {

    private final String[] columnNames;
    private String[][] data;
    private final LinkedHashMap<String, ObjectType> dataList;

    public PrintTable(String[] columnNames, LinkedHashMap<String, ObjectType> dataList) {
        this.columnNames = columnNames;
        this.dataList = dataList;
        this.data = new String[0][0];
    }

    private void convertListToObjectList() {
        if (dataList != null) {
            int index = 1;
            for (Map.Entry<String, ObjectType> entry : dataList.entrySet()) {
                if (entry.getValue() instanceof Role) {
                    String[] rawData = ((Role) entry.getValue()).toListString();
                    String[] dataToAppend = new String[rawData.length + 1];
                    // Copy old data to new array
                    System.arraycopy(rawData, 0, dataToAppend, 1, rawData.length);
                    dataToAppend[0] = Integer.toString(index);
                    appendData(dataToAppend);
                    index += 1;
                    continue;
                }
                if (entry.getValue() instanceof Employee) {
                    String[] dataToAppend = ((Employee) entry.getValue()).toListString();
                    // check if any entry equal null
                    for (int i = 0; i < dataToAppend.length; i++) {
                        if (dataToAppend[i] == null) {
                            // Change value to a string null for output
                            // PrintTable will throw a NullPointerException
                            // If any value in String array is null
                            dataToAppend[i] = "null";
                        }
                    }
                    appendData(dataToAppend);
                }
            }
        }
    }

    private void printDebugData() {
        for (String header : columnNames) {
            System.out.println(header);
        }

        for (String[] line : this.data) {
            for (String word : line) {
                System.out.println(word);
            }
        }
    }

    public void printTableData() {
        // Convert hotel list into object list
        this.convertListToObjectList();
        if (this.data.length == 0) {
            System.out.println("Empty list !!!");
            return;
        }
        ASCIITable.getInstance().printTable(columnNames, this.data);
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
