package company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DateGUI {
    public static TextArea unsorted = new TextArea();
    public static TextArea sorted = new TextArea();
    //Declare variables
    static JFrame myFrame;
    public static String fileName;
    private static Date212 date;
    public SortedDate212List SortedDays;
    public UnsortedDate212List UnSortedDays;
    private ArrayList<Date212> inputArray = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        DateGUI.fileName = fileName;
    }

    // generate a JFrame with parameters
    public void runDate() throws FileNotFoundException, ParseException {
        myFrame = new JFrame();
        myFrame = new JFrame();
        myFrame.setSize(480, 360);
        myFrame.setTitle("Unsorted and Sorted Dates");
        myFrame.setLayout(new GridLayout(1, 2));
        myFrame.add(unsorted);
        myFrame.add(sorted);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setVisible(true);
    }

    //read raw dates from file.
    public void readNumbers(String fileName) throws FileNotFoundException, ParseException {
        Scanner dateParser = new Scanner(new File(fileName)); // scanner reads file
        ArrayList<String> rawDates = new ArrayList<>(); // generate a String arrayList to hold values
        UnSortedDays = new UnsortedDate212List();
        SortedDays = new SortedDate212List();
        while (dateParser.hasNext()) {
            String line = dateParser.nextLine();
            if(!(line.isEmpty())){ //ignore empty lines
                Collections.addAll(rawDates, line.split(","));
            }
        }
        dateParser.close(); // close file after done.

        ArrayList<Date212> fDates = new ArrayList<>(); //set up new Array to be passed to selectionSort()

        for (String rawDate : rawDates) { //iterate through the unprocessed dates.
            date = new Date212(rawDate);
            System.out.println(date);
            UnSortedDays.add(date);
            SortedDays.add(date);
        }
        unsorted.append(UnSortedDays.toString() + "\n");
        sorted.append(SortedDays.toString() + "\n");
    }

}