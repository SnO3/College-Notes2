
public class Employee extends Person{
    private String dept;

    public Employee(String position, int ucid, String first, String last, String dept){
        super(position, ucid, first, last);
        this.dept = dept;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s ", dept);
    }
}
