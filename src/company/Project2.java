package company;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Date212GUI hello = new Date212GUI();
        if(args.length > 0){
            String name = args[0];
            Date212GUI.setFileName(name);
            hello.readNumbers(name);
            hello.runDate();
        }
    }
}
