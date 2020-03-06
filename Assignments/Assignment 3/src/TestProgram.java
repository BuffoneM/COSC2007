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

        if (!file.exists()) {
            System.out.println("The file does not exist...\n");
            System.out.println("Complete...\n-----------------------------");
            return;
        }


        try {
            Scanner input = new Scanner(file);
            SortedArrayTable<String> dictionary = new SortedArrayTable<String>(100);

            while(input.hasNext()) {
                String curr = input.nextLine();
                String currWord = "";
                if(curr.toUpperCase().charAt(0) != 'P') {
                    currWord = curr.substring(curr.indexOf("(") + 2, curr.indexOf(")") - 1);
                }

                // Method determination
                switch(curr.toUpperCase().charAt(0)) {
                    case 'D':
                        System.out.println("Deleting: " + currWord);
                        dictionary.delete(currWord);
                        break;
                    case 'I':
                        System.out.println("Inserting: " + currWord);
                        dictionary.insert(currWord);
                        break;
                    case 'P':
                        System.out.println("Printing:");
                        dictionary.print();
                        break;
                    case 'S':
                        System.out.println("Searching for: " + currWord);
                        dictionary.search(currWord);
                        break;
                    default:
                        System.out.println("Invalid instruction attempted: " + curr);
                        break;
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.out.println("Instructions complete...");
    }
}