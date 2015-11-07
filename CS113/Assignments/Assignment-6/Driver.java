import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dr. Snow on 4/13/2015.
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException{
        //Create File pointing toward the Sorted
        File filename= new File("C:/Users/Josiah/Desktop/SortedLists.txt");
        Scanner stdin = new Scanner(filename);

        //Initialize variables
        int arraySize = stdin.nextInt();
        int A[] = new int[arraySize];
        int sizeOfC = arraySize;

        //Populate array A
        for(int i=0; i<arraySize; i++)
            A[i]= stdin.nextInt();

        //Initialize the size of B
        arraySize = stdin.nextInt();
        //Finalize the size of C
        sizeOfC += arraySize;

        //Initialize array B
        int B[] = new int[arraySize];

        //Populate array B
        for(int i=0; i<arraySize; i++)
            B[i] = stdin.nextInt();

        //Initialize array C with size of A and B combined
        int C[] = new int[sizeOfC];

        //Copy A into C
        for(int i=0;i<A.length;i++)
            C[i]=A[i];

        //Copy B into C
        for(int i=0;i<B.length;i++)
            C[i+A.length]=B[i];

        //Sort C from least to greatest
        Arrays.sort(C);

        double total=0;

        //Print out A
        for(int i : A) System.out.print(i+" ");
        System.out.print("\n");

        //Print out B
        for(int i : B) System.out.print(i+" ");
        System.out.print("\n\n");

        //Print out C
        for(int i : C) {
            System.out.print(i + " ");
            total+=i;
        }
        //Print Statistics
        System.out.println("\nSize: "+C.length);
        System.out.println("Minimum Value: "+C[0]);
        System.out.println("Maximum Value: "+C[C.length-1]);
        System.out.println("Total: "+total);
        System.out.println("Average: "+(total/C.length));


    }
}
