package company;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        DateGUI hello = new DateGUI();
        if(args.length > 0){
            String name = args[0];
            DateGUI.setFileName(name);
            hello.readNumbers(name);
            hello.runDate();
        }
    }
}
