package AdvancedJava.FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; // corrupt file, not available , file not found
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {

        String path = "C:\\Users\\Aishwarya\\Java\\AdvancedJava\\FileHandling\\file.txt";

        // Code to create a new file
        File myFile = new File(path);
        try {
            myFile.createNewFile();
        } catch(IOException e) {
            System.out.println("Unable to create this file");
            e.printStackTrace();
        }
        
        // Code to write to a file
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("This is my first file from this java course.");
            fileWriter.close();
        } catch(IOException e) {
            System.out.println("Unable to write to this file");
            e.printStackTrace();
        }

        // Reading a file

        File myFile2 = new File(path);
        try {
            Scanner sc = new Scanner(myFile2);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        // Deleting a file

        if(myFile.delete()) {
            System.out.println("I have deleted: " + myFile.getName());
        } else {
            System.out.println("Some problem occured while deleting the file.");
        }
        
        
    }
}