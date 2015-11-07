
public class Student extends Person {
    private String major;
    private String email;

    public Student(String position, int ucid, String first, String last, String major, String email){
        super(position,ucid,first,last);
        this.major = major;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s %s", major, email);
    }
}
