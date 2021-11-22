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
    private ArrayList<Date212> inputArray = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        Date212GUI.fileName = fileName;
    }

    // generate a JFrame with parameters
    public void runDate() throws FileNotFoundException, ParseException {
        myFrame = new JFrame();
        unsorted = new TextArea();
        sorted = new TextArea();
        myFrame = new JFrame();
        myFrame.setSize(480, 360);
        myFrame.setTitle("Unsorted and Sorted Dates");
        myFrame.setLayout(new GridLayout(1, 2));
        myFrame.add(unsorted);
        myFrame.add(sorted);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        selectionSort(readNumbers(fileName));
    }

    //read raw dates from file.
    public ArrayList<Date212> readNumbers(String fileName) throws FileNotFoundException {
        Scanner dateParser = new Scanner(new File(fileName)); // scanner reads file
        ArrayList<String> rawDates = new ArrayList<>(); // generate a String arrayList to hold values
        while (dateParser.hasNext()) {
            String line = dateParser.nextLine();
            if(!(line.isEmpty())){ //ignore empty lines
                Collections.addAll(rawDates, line.split(","));
            }
        }
        dateParser.close(); // close file after done.

        ArrayList<Date212> fDates = new ArrayList<>(); //set up new Array to be passed to selectionSort()

        for (String rawDate : rawDates) { //iterate through the unprocessed dates.
            unsorted.append(String.valueOf(rawDate)); //appending the unsorted dates to the JFrame
            unsorted.append("\n");
            fDates.add(new Date212(rawDate)); // adding dates to separate array as a new Date212 Object.
            //testing if dates are appended properly to both textFrames
            //sorted.append(String.valueOf((new Date212(rawDate))));
            //sorted.append("\n");
        }
        return fDates;
    }



    //fDates from readNumbers passed as a parameter.
    public void selectionSort(ArrayList<Date212> inputArray) throws ParseException {
        this.inputArray = inputArray;
        for (int start = 0; start < inputArray.size() - 1; start++) { //iterate through the array
            for (int other = start + 1; other < inputArray.size(); other++) { // iterate through the array + 1 to compare n and value of n + 1;
                if (inputArray.get(other).compareTo(inputArray.get(start))) { // compareTo if n+1 is greater than n, then swap values.
                    Date212 temp = inputArray.get(start);
                    inputArray.set(start, inputArray.get(other));
                    inputArray.set(other, temp);
                }
            }
        }
        for (Date212 date212 : inputArray) { //add values to the sorted TextFrame after it has been sorted.
            //System.out.println(inputArray.get(x)); // verify if output was sorted correctly.
            sorted.append(String.valueOf(date212));
            sorted.append("\n");
        }
    }
}