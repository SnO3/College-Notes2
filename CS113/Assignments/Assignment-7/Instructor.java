
public class Instructor extends Employee {
    private String email;
    private String office;

    public Instructor(String position, int ucid, String first, String last, String dept,
                      String email, String office){
        super(position,ucid,first,last,dept);
        this.email = email;
        this.office = office;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s %s", email, office);
    }
}
