//Copy the numbers input until 0.0 is read
import java.util.*;  //for class Scanner
public class Copy{
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      System.out.println("Ready to copy!\n" +
                        "Enter 0.0 when done!");
      int n=0;
      double num;
      double total=0;
      num = stdin.nextDouble();
      while(num != 0.0) {
    	 total+=num;
    	 n++;
         System.out.printf("%.2f\n", num);
         num = stdin.nextDouble();
      }
      System.out.printf("Count of numbers read = %d\n"
      				  + "Total value of numbers read = %.2f\n"
    		          + "Average value of numbers read = %.2f\n\n", n, total, total/n);
      System.out.println("Goodbye!");
      System.exit(0);
   }
}