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
        Date212Node dn = new Date212Node(x); // create a new data node
        last.next = dn; // previous last.next now points to the new list node dn.
        last = dn; // last is equal to listnode dn
        length++; //increase length by 1
    }
    public void sort(Date212 n) throws ParseException { //selection sort moved from p1 DateGUI to Datelist for P2
        Date212Node temp = new Date212Node(n); // new data node to hold temp value as seen in P1 selection sort function.
        Date212Node first = this.first;

        while(first.next != null && first.next.data.compareTo(temp.data)){ //
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
