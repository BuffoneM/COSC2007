import java.io.*;
import java.util.*;

public class TestProgram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a filename (0 to exit): ");
            String input = in.nextLine();
            if (input.equals("0")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                instructions(input);
            }
        }
    }

    // Execution for the file
    public static void instructions(String fileName) {

        // Attempt to read the file
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("The file does not exist...\n");
            System.out.println("Complete...\n-----------------------------");
            return;
        }

        try {
            // Read the line and store it in temp
            Scanner input = new Scanner(file);

            String tempString;
            Tree23<Integer> tree = new Tree23<Integer>();

            // -Read the number, parse the number, and add it to the tree
            while(input.hasNext()) {
                int tempNum = Integer.parseInt(input.next().replace(",", ""));
                tree.add(tempNum);
            }

            // Pre-order traversal print
            tree.postOrderPrint();

            // Height of the tree

            // Find each value


        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.out.println("Instructions complete...\n");
    }
}