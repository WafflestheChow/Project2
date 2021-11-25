package company;

import java.text.ParseException;

public abstract class Date212List {

    //Set up first node as a dummy node;
    private Date212Node first = new Date212Node(null);
    // Set up last node as first when called.
    private Date212Node last = first;

    private int length = 0;

    public int getLength(){
        return length;
    }

    public void append(Date212 x){
        Date212Node dn = new Date212Node(x);
        last.next = dn;
        last = dn;
        length++;
    }
    public void sort(Date212 n) throws ParseException {
        Date212Node temp = new Date212Node(n);
        Date212Node first = this.first;

        while(first.next != null && first.next.data.compareTo(temp.data)){
            first = first.next;
        }

        temp.next = first.next;
        first.next = temp;

        if(temp.next == null){
            this.last = temp;
        }
    }

    public String toString() {
        Date212Node n = this.first.next;

        String dates;
        for(dates = ""; n != null; n = n.next) {
            dates = dates + n.data + " \n";
        }

        return dates;
    }
}
