/*
 * Assignment 3
 * Michael Buffone
 * March 7th, 2020
 *
 * A test program that reads data from a file and outputs to two different files
 * -Data is stored in two data structures (SortedArrayTable and ADT List)
 */

import java.io.*;
import java.util.*;

public class TestProgram {
    public static SortedArrayTable<String> dictionaryTable;
    public static List<String> dictionaryList;
    public static PrintWriter pwArray = null;
    public static PrintWriter pwList = null;


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

    // Get instructions from the file
    public static void instructions(String fileName) {

        // Attempt to read the file
        File file = new File(fileName);

        // Output file parts
        File outputFileArray = new File("outputArray.txt");
        File outputFileList = new File("outputList.txt");

        if (!file.exists()) {
            System.out.println("The file does not exist...\n");
            System.out.println("Complete...\n-----------------------------");
            return;
        }

        try {
            Scanner input = new Scanner(file);
            // File scanner initialization
            pwArray = new PrintWriter(outputFileArray);
            pwList = new PrintWriter(outputFileList);
            dictionaryTable = new SortedArrayTable<String>(100);
            dictionaryList = new ArrayList<String>();

            while (input.hasNext()) {
                String curr = input.nextLine();
                String currWord = "";
                if (curr.toUpperCase().charAt(0) != 'P') {
                    // Get the word in the quotes within the brackets
                    currWord = curr.substring(curr.indexOf("(") + 2, curr.indexOf(")") - 1);
                }
                System.out.print("---");
                // Compute the operation with the word using SortedArrayTable
                methodOperationsArray(curr, currWord);

            }
            pwArray.close();
            pwList.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            if (pwArray != null || pwList != null) {
                pwArray = null;
                pwList = null;
            }
        }

        System.out.println("Instructions complete...\n");
    }

    /*
     * Parsing Restrictions:
     * -'I' = insert
     * -'D' = delete
     * -'S' = search
     * -'P' = print
     */
    public static void methodOperationsArray(String curr, String currWord) {
        // Method determination
        switch (curr.toUpperCase().charAt(0)) {
            case 'D':
                System.out.println("Deleting: " + currWord);
                // Array case
                String[] elementsArray = null;
                try {
                    elementsArray = dictionaryTable.delete(currWord);
                    // The array won't have anything in it because the item CAN be deleted
                    if (elementsArray == null)
                        pwArray.println("Element \"" + currWord + "\" Deleted");

                    else {
                        pwArray.println("Element_Not_Found");
                        if (!elementsArray[0].equals("") && !elementsArray[1].equals("")) {
                            System.out.println("Predecessor is '" + elementsArray[0] + "' | Successor is '" + elementsArray[1] + "'");
                            pwArray.println(elementsArray[0]);
                            pwArray.println(elementsArray[1]);
                        } else if (!elementsArray[0].equals("")) {
                            System.out.println("Predecessor is '" + elementsArray[0] + "' | Successor " +
                                    ((elementsArray[1] == "") ? "doesn't exist" : "is '" + elementsArray[1] + "'"));
                            pwArray.println(elementsArray[0]);

                        } else if (!elementsArray[1].equals("")) {
                            System.out.println("Predecessor " + ((elementsArray[0] == "") ? "doesn't exist" : "is '"
                                    + elementsArray[0] + "'") + " | Successor is '" + elementsArray[1] + "'");
                            pwArray.println(elementsArray[1]);
                        }

                    }
                } catch (Dictionary_Empty dif) {
                    System.out.println("Cannot delete element because dictionary is empty");
                    pwArray.println("Dictionary Empty");
                }

                // List case
                if (dictionaryList.isEmpty()) {
                    pwList.println("Dictionary Empty");
                } else if (dictionaryList.contains(currWord)) {
                    dictionaryList.remove(currWord);
                    pwList.println("Element \"" + currWord + "\" Deleted");
                } else {
                    String[] elementsList = prePostValues(currWord, dictionaryList);
                    pwList.println("Element_Not_Found");
                    if (!elementsList[0].equals("") && !elementsList[1].equals("")) {
                        pwList.println(elementsList[0]);
                        pwList.println(elementsList[1]);
                        break;
                    }
                    if (!elementsList[0].equals(""))
                        pwList.println(elementsList[0]);
                    if (!elementsList[1].equals(""))
                        pwList.println(elementsList[1]);
                }

                break;

            case 'I':
                // Array case
                try {
                    dictionaryTable.insert(currWord);
                    System.out.println("Inserting: " + currWord);
                    dictionaryList.add(currWord);
                    Collections.sort(dictionaryList);
                    pwArray.println("Inserted Element \"" + currWord + "\"");
                    pwList.println("Inserted Element \"" + currWord + "\"");
                } catch (Duplicate_Item_Found dif) {
                    System.out.println("Duplicate element inserted: " + currWord);
                    pwArray.println("Inserted Duplicate Element");
                    pwList.println("Inserted Duplicate Element");
                }

                break;

            case 'P':
                // Array case
                System.out.println("Printing array:");
                dictionaryTable.print();

                // Write all of the logical elements into the file from the ArrayTable
                String[] tempArrayTable = dictionaryTable.toArray();
                if (tempArrayTable != null) {
                    for (int i = 0; i < tempArrayTable.length; i++) {
                        pwArray.println(tempArrayTable[i]);
                    }
                }
                pwArray.close();

                // Print all of the logical elements into the file from the ADT List
                Object[] tempListArray = dictionaryList.toArray();
                if (tempListArray != null) {
                    for (int i = 0; i < tempListArray.length; i++) {
                        pwList.println((String) tempListArray[i]);
                    }
                }

                break;

            case 'S':
                // Array case and list case
                System.out.println("Searching for: " + currWord);
                if (!dictionaryTable.search(currWord) && !dictionaryList.contains(currWord)) {
                    System.out.println("'" + currWord + "' doesn't exist in the dictionary");
                    pwArray.println("Element_Not_Found");
                    pwList.println("Element_Not_Found");
                } else {
                    System.out.println("'" + currWord + "' exists at logical position: " +
                            (dictionaryList.indexOf(currWord) + 1) + "");
                }

                break;
            default:
                System.out.println("Invalid instruction attempted: " + curr);
                break;
        }
    }

    // Get the predecessor and successor values for the object
    public static String[] prePostValues(String obj, List<String> values) {
        String[] elements = new String[2];
        // If the logical size is 1
        if (values.size() == 1) {
            if (obj.compareTo(values.get(0)) < 0) {
                elements[0] = "";
                elements[1] = values.get(0) + "";
            } else {
                elements[0] = values.get(0) + "";
                elements[1] = "";
            }
        }

        // If the obj is < than the first element
        else if (obj.compareTo(values.get(0)) < 0) {
            elements[0] = "";
            elements[1] = values.get(0) + "";
        }
        // If the obj is > than the last element
        else if (obj.compareTo(values.get(values.size() - 1)) > 0) {
            elements[0] = values.get(values.size() - 1) + "";
            elements[1] = "";
        }

        // The obj exists between elements in the array
        else {
            for (int i = 0; i < values.size(); i++) {
                if (obj.compareTo(values.get(i)) >= 1) {
                    if (obj.compareTo(values.get(i + 1)) < 0) {
                        elements[0] = values.get(i) + "";
                        elements[1] = values.get(i + 1) + "";
                    }
                }
            }
        }
        return elements;
    }
}