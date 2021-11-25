package company;

import java.text.ParseException;

public class SortedDate212List extends Date212List {
    public SortedDate212List(){
        //empty constructor
    }
    public void add(Date212 date) throws ParseException {
        super.sort(date);
    }
}
