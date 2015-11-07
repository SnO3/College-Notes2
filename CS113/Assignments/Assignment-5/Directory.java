import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class Directory {
	
	private final int DIRECTORY_MAX_SIZE = 1024;
	String directory[]= new String[DIRECTORY_MAX_SIZE];
	int directorySize = 0; //use this
	File directoryFile = null;
	Scanner directoryDataIn = null;
	
	public Directory(String directoryFileName){
	
		directoryFile = new File(directoryFileName);
		try{
			directoryDataIn = new Scanner(directoryFile);
		}catch(FileNotFoundException e){
			System.out.printf("File %s not found, exiting!",directoryFileName);
			System.exit(0);
		}
		
		while(directoryDataIn.hasNext())
			directory[directorySize++] = directoryDataIn.nextLine();
	}
		
	public boolean inDirectory(String name) {
		for(int i=0; i<directorySize; i++){
			if(directory[i].equalsIgnoreCase(name))
				return true;
			}
		return false;
	}
	
	public boolean add(String name){
		if(directorySize==DIRECTORY_MAX_SIZE){
			directory[directorySize++]=name;
			return true;
		}else
			return false;
	}
	
	public boolean delete(String name){
		for(int i=0;i<directorySize; i++){
			if(directory[i].equalsIgnoreCase(name)){
				for(int j=i; j<directorySize;j++){
					directory[j]=directory[j+1];
				}
				directorySize--;
				return true;
			}
		}
		return false;
	}
	
	
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
			directoryDataOut.println(directory[i]);
		directoryDataOut.close();
	}
}
