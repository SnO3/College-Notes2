
public class Person {
    //Declare variables
    private String position;
    private final int UCID;
    private String first;
    private String last;

    public Person(String position, int ucid, String first, String last){
        this.position = position;
        this.UCID = ucid;
        this.first = first;
        this.last = last;
    }
    public int getUCID() {
        return UCID;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s ", position, UCID, first, last);
    }
}
