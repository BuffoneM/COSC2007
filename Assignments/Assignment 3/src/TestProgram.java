import java.io.*;
import java.util.Dictionary;
import java.util.Scanner;

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

        // Output file parts
        File outputFile = new File("output.txt");
        PrintWriter pw = null;

        if (!file.exists()) {
            System.out.println("The file does not exist...\n");
            System.out.println("Complete...\n-----------------------------");
            return;
        }

        try {
            Scanner input = new Scanner(file);
            pw = new PrintWriter(outputFile);
            SortedArrayTable<String> dictionary = new SortedArrayTable<String>(100);

            while(input.hasNext()) {
                String curr = input.nextLine();
                String currWord = "";
                if(curr.toUpperCase().charAt(0) != 'P') {
                    currWord = curr.substring(curr.indexOf("(") + 2, curr.indexOf(")") - 1);
                }
                System.out.print("---");

                // Method determination
                switch(curr.toUpperCase().charAt(0)) {
                    case 'D':
                        System.out.println("Deleting: " + currWord);
                        String[] elements = null;
                        try {
                            elements = dictionary.delete(currWord);
                            if(elements == null)
                                pw.println("Element \"" + currWord + "\" Deleted");
                            else {
                                pw.println("Element_Not_Found");
                                if(!elements[0].equals(""))
                                    pw.println(elements[0]);
                                if(!elements[1].equals(""))
                                    pw.println(elements[1]);
                            }
                        } catch(Dictionary_Empty dif) {
                            System.out.println("Cannot delete element because dictionary is empty");
                            pw.println("Dictionary Empty");
                        }
                        break;

                    case 'I':

                        try {
                            dictionary.insert(currWord);
                            System.out.println("Inserting: " + currWord);
                            pw.println("Inserted Element \"" + currWord + "\"");
                        } catch(Duplicate_Item_Found dif) {
                            System.out.println("Duplicate element inserted");
                            pw.println("Inserted Duplicate Element");
                        }
                        break;

                    case 'P':
                        System.out.println("Printing:");
                        dictionary.print();
                        break;

                    case 'S':
                        System.out.println("Searching for: " + currWord);
                        if(dictionary.search(currWord) == false) {
                            pw.println("Element_Not_Found");
                        }
                        break;
                    default:
                        System.out.println("Invalid instruction attempted: " + curr);
                        break;
                }
            }
            // Print all of the logical elements in the file
            String[] tempArray = dictionary.toArray();
            if(tempArray != null) {
                for(int i = 0; i < tempArray.length; i++) {
                    pw.println(tempArray[i]);
                }
            }
            pw.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            if(pw != null) pw = null;
        }

        System.out.println("Instructions complete...");
    }
}