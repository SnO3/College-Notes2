import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DirLookup {

	public static void main(String[] args) throws FileNotFoundException{
		File inputText;
		//If user does not supply File location then refer to a constant file location
		try{
			inputText = new File(args[0]);
		}
		catch(Exception e){
			inputText = new File("C:/Users/Josiah/Documents/Notes/CS113/Assignments/Assignment-3/Data3.txt");
		}
		//Initialize Variables/Objects
		Scanner std = new Scanner(inputText);
		Scanner stdin = new Scanner(System.in);
		int num;
		int arraySize = std.nextInt();
		int list[] = new int[arraySize];
		//Populate Integer list with text file numbers
		for(int i=0;i<arraySize;i++){
			list[i]=std.nextInt();
		}
		//Close the text file input stream
		std.close();
		//Using the text file database loop through the list checking if the given number is in it
		while(true){
			System.out.print("Number to Lookup: ");
			num= stdin.nextInt();
			for(int i=0; i<list.length; i++){
				if(list[i]==num){
					System.out.println("\t>> "+num+" is in the database");
					//Start from the top of the while loop if num is found in list[]
					break;
				//If all elements have been checked then num is not in the database
				}else if(i==list.length-1){
					System.out.println("\t>> "+num+" is not in the database");
				}
			}
		}
	}
}