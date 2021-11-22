package company;

import java.text.ParseException;

public class SortedDate212 extends Date212List {
    public SortedDate212(){
    }
    public void add(Date212 date) throws ParseException {
        super.sort(date);
    }
}
