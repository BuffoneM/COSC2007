import java.io.*;
import java.util.Scanner;

public class TestProgram {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a filename (0 to exit): ");
            String input = in.nextLine();
            if (input.equals("0")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println();
                instructions(input);
            }
        }*/

        // ****** File 1 ******

        instructions("input.txt");
    }

    /*
    * Parsing Restrictions:
    * -'I' = insert
    * -'D' = delete
    * -'S' = search
    * -'P' = print
     */
    public static void instructions(String fileName) {

        // Attempt to read the file
        File file = new File(fileName);
        System.out.println(file.exists());

        if (!file.exists()) {
            System.out.println("The file does not exist...\n");
            System.out.println("Complete...\n-----------------------------");
            return;
        }

        SortedArrayTable<String> dict1 = new SortedArrayTable<String>(10);

        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()) {
                String curr = input.nextLine();
                System.out.println(curr);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}