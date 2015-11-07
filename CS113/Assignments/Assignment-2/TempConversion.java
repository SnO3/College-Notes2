import java.util.Scanner;
//Converts F to C and C to F
public class TempConversion {
	public static void main(String[] args) {
		//Declare Objects and variables
		Scanner stdin = new Scanner(System.in);
		double tC;
		double tF;
		//Display program info
		System.out.println
		("Welcome to the Temperature Converter!\n"
		+"Enter 0 to convert F --> C and 1 to convert from C --> F\n"
		+"Enter Control-Z when done!");
		//Get converter mode
		if(stdin.nextInt()==0)
		{
			System.out.println("Welcome to the F --> C Converter!");
			while(stdin.hasNext()){
				tF= stdin.nextDouble();
				tC= ((tF-32.0)*5.0)/9;
				System.out.printf("%.2fF = %.2fC\n", tF, tC);
			}
		}
		else
		{
			System.out.println("Welcome to the C --> F Converter!");
			while(stdin.hasNext()){
				tC= stdin.nextDouble();
				tF= ((tC*9)/5.0)+32;
				System.out.printf("%.2fF = %.2fC\n", tC, tF);
			}
		}
		System.out.print("Goodbye!");
		System.exit(0);
	}
}
