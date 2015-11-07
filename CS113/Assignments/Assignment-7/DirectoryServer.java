import java.util.InputMismatchException;
import java.util.Scanner;

public class DirectoryServer {
    public static void main(String args[]){
        //Declare Variables
        Directory dir = new Directory("C:/Users/Josiah/Desktop/ab.txt");
        Scanner stdin = new Scanner(System.in);
        String cmd;
        String extra;
        int ucid;
        String position;
        String firstName;
        String lastName;
        String deptMajor;
        String email;
        String office;
        boolean changed=false;

        //Welcome Message
        System.out.print("Directory Server is Ready!\n" +
                         "Command: find LastName | delete UCID | add\n" +
                         "To end enter ^Z\n\n" +
                         "Enter Command: ");

        //Directory loop
        while(stdin.hasNext()){
            cmd = stdin.next();

            //Command if Structure
            //Find
            if(cmd.equalsIgnoreCase("find")) {
                extra = stdin.next();
                if (!dir.inDirectory(extra))
                    System.out.println(extra + " is NOT in the directory");
            }
            //Delete
            else if(cmd.equalsIgnoreCase("delete")){
                extra = stdin.next();
                    try{
                        if(dir.delete(Integer.parseInt(extra))) {
                            System.out.println(extra + " deleted");
                            changed = true;
                        }
                        else
                            System.out.println("Invalid UCID");
                    }catch (NumberFormatException e){
                        System.out.println("Error: Incorrect format");
                    }
            }
            //Add
            else if(cmd.equalsIgnoreCase("add")){
                System.out.print("Enter UCID: ");

                try{
                    ucid= stdin.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Error: Incorrect format");
                    continue;
                }

                //Prompt user for Position, First Name, and Last Name
                System.out.print("Position = Professor, Adjunct, Staff,\n" +
                            "Senior, Sophomore, or Freshman\n" +
                            "MUST match case\n" +
                            "Enter Position: ");
                position = stdin.next();
                System.out.print("Enter First Name: ");
                firstName = stdin.next();
                System.out.print("Enter Last Name: ");
                lastName = stdin.next();

                //Prompt for variables depending on position
                switch(dir.evalPosition(position)){
                    //Instructor
                    case 0:
                        System.out.print("Enter Department: ");
                        deptMajor = stdin.next();
                        System.out.print("Enter Email: ");
                        email = stdin.next();
                        System.out.print("Enter Office");
                        office = stdin.next();

                        dir.add(position, ucid, firstName, lastName, deptMajor, email, office);
                        changed = true;
                        break;
                    //Student
                    case 1:
                        System.out.print("Enter Major: ");
                        deptMajor = stdin.next();
                        System.out.print("Enter Email: ");
                        email = stdin.next();
                        dir.add(position, ucid, firstName, lastName, deptMajor, email);
                        changed = true;
                        break;
                    //Employee
                    case 2:
                        System.out.print("Enter Department: ");
                        deptMajor = stdin.next();
                        dir.add(position, ucid, firstName, lastName, deptMajor);
                        changed = true;
                        break;
                    //Not valid
                    case 3:
                        System.out.println("Error: Invalid Position");
                        break;
                }
            }
            //If the command does not equal any of the other three it is invalid
            else{
                System.out.println("Error: Invalid Command");
            }
            System.out.print("Enter Command: ");
        }
        //Write to txt file if changed = true
        if(changed)
            dir.closeDirectory();
    }
}
