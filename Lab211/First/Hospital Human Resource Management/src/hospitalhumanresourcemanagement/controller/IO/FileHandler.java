/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public class FileHandler<ObjectType> {

    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public boolean isFileExist() {
        return (new File(filePath)).isFile();
    }

    public void saveObjectToFile(ObjectType obj) throws IOException {
        if (!isFileExist()) {
            (new File(filePath)).createNewFile();
        }
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        fileOutputStream = new FileOutputStream(filePath);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public ObjectType loadObjectFromFile() throws IOException, ClassNotFoundException {
        FileInputStream databaseFile;
        ObjectInputStream loadObjectFromFile;

        databaseFile = new FileInputStream(filePath);
        loadObjectFromFile = new ObjectInputStream(databaseFile);

        ObjectType obj = (ObjectType) loadObjectFromFile.readObject();

        loadObjectFromFile.close();
        databaseFile.close();
        return obj;
    }
}
