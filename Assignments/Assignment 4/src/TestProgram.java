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
            String tempString = input.nextLine();

            // For the entire string:
            // -If the char is a space, skip
            // -If the char is a number, concatenate it to the current number
            // -Otherwise parse it and add it to the 2-3 Tree
            String currNumber = "";
            for(int i = 0; i < tempString.length(); i++) {
                if(tempString.charAt(i) == ' ') continue;
                if(tempString.charAt(i) >= '0' && tempString.charAt(i) <= '9') {
                    currNumber = currNumber + tempString.charAt(i);
                    continue;
                }
                else {
                    // Tempnum holds the interger that will be added to the tree
                    int tempNum = Integer.parseInt(currNumber);
                    System.out.println(tempNum);
                    

                    // Reset currNumber for the next iteration
                    currNumber = "";
                }
            }


        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.out.println("Instructions complete...\n");
    }
}