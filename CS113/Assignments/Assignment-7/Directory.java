import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Directory {
    //Declare and initialize variables
    private final int DIRECTORY_MAX_SIZE = 1024;
    private Person directory[]= new Person[DIRECTORY_MAX_SIZE];
    private int directorySize = 0;
    private File directoryFile = null;
    private Scanner directoryDataIn = null;

    public Directory(String directoryFileName){

        //Refer to directory file
        directoryFile = new File(directoryFileName);
        try{
            directoryDataIn = new Scanner(directoryFile);
        }catch(FileNotFoundException e){
            System.out.printf("File %s not found, exiting!",directoryFileName);
            System.exit(0);
        }

        //Initialize String array for current entry
        String[] entry;

        //Read and populate directory
        while(directoryDataIn.hasNext()) {
            entry = directoryDataIn.nextLine().split(" ");

            switch(evalPosition(entry[0])){
                case 0:
                    directory[directorySize++] = new Instructor(entry[0],Integer.parseInt(entry[1]),entry[2],
                            entry[3], entry[4], entry[5],entry[6]);
                    break;
                case 1:
                    directory[directorySize++] = new Student(entry[0],Integer.parseInt(entry[1]),entry[2],
                            entry[3], entry[4], entry[5]);
                    break;
                case 2:
                    directory[directorySize++] = new Employee(entry[0],Integer.parseInt(entry[1]),entry[2],
                            entry[3], entry[4]);
                    break;
                default:
                    System.out.println("Error: Invalid Position");

            }
        }
    }

    //Method to evaluate the position and return an int
    public int evalPosition(String pos){
        if(pos.equals("Adjunct") || pos.equals("Professor"))
            return 0;
        else if(pos.equals("Freshman")||pos.equals("Sophomore") ||
                pos.equals("Junior") ||pos.equals("Senior"))
            return 1;
        else if(pos.equals("Staff"))
            return 2;
        else
            return 3;
    }

    //Check if lastName matches any last name of a person in the directory
    public boolean inDirectory(String lastName) {
        boolean entered=false;
        for(int i=0; i<directorySize; i++){
            if(directory[i].getLast().equalsIgnoreCase(lastName)) {
                System.out.println(directory[i].toString());
                entered = true;
            }
        }
        return entered;
    }

    //Instructor add
    public boolean add(String position, int ucid, String first, String last, String dept,
                       String email, String office){
        if(directorySize==DIRECTORY_MAX_SIZE)
            return false;
        else {
            directory[directorySize++] = new Instructor(position,ucid,first,last,dept,email,office);
            return true;
        }
    }

    //Student add
    public boolean add(String position, int ucid, String first, String last, String major,
                       String email){
        if(directorySize==DIRECTORY_MAX_SIZE)
            return false;
        else {
            directory[directorySize++] = new Student(position,ucid,first,last,major,email);
            return true;
        }
    }

    //Employee add
    public boolean add(String position, int ucid, String first, String last, String dept){
        if(directorySize==DIRECTORY_MAX_SIZE)
            return false;
        else {
            directory[directorySize++] = new Employee(position,ucid,first,last,dept);
            return true;
        }
    }

    //Remove a Person from the directory
    public boolean delete(int ucid){
        for(int i=0;i<directorySize; i++){
            if(directory[i].getUCID() == ucid){
                for(int j=i; j<directorySize; j++)
                    directory[j]=directory[j+1];
                directorySize--;
                return true;
            }
        }
        return false;
    }


    //Write to the directory and close the input stream
    public void closeDirectory(){
        directoryDataIn.close();
        PrintStream directoryDataOut = null;
        // now open the directory data file for writing
        try {
            directoryDataOut = new PrintStream(directoryFile);
        }
        catch (FileNotFoundException e) {
            System.out.printf
                    ("File %s not found, exiting!",directoryFile);
            System.exit(0);
        }
        // write possibly updated directory back to file
        for (int i = 0; i < directorySize; i++)
            directoryDataOut.println(directory[i].toString());
        directoryDataOut.close();
    }
}