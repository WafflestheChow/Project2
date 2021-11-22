package company;

public abstract class Date212List {

    //Set up first node as a dummy node;
    private Date212Node first = new Date212Node(null);
    // Set up last node as first when called.
    private Date212Node last = first;

    private int length = 0;

    public int getLength(){
        return length;
    }

    public void append(Date212 date){
        Date212Node dn = new Date212Node(date);
        last.next = dn;
        last = dn;
        length++;
    }


}
