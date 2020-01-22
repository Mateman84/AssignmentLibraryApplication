package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void writeObject(Object object, String listName){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        listName = listName + ".ser";
        try{
            fileOutputStream = new FileOutputStream(listName, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Object readObject(String fileName){
        ObjectInputStream objectinputstream = null;
        Object object = null;
        fileName = fileName + ".ser";
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            object = objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
