public class SortedArrayTable<T extends Comparable> {
    private final int MAX_SIZE;
    private int size;
    private Object items[];

    // Constructor
    public SortedArrayTable(int max_size) {
        MAX_SIZE = max_size;
        size = 0;
        items = new Object[MAX_SIZE];
    }

    // Methods
    public void insert(T obj) throws Duplicate_Item_Found {
        // Full dictionary case
        if (size == MAX_SIZE) throw new Dictionary_Full("Dictionary full");
        if (obj.equals("")) throw new RuntimeException("Empty string entered");

        // Empty dictionary case or if the obj > last element in the array, add it at the end
        if (size == 0 || obj.compareTo(items[size - 1]) >= 1) {
            items[size++] = obj;
            return;
        }

        // If the obj < first element in the array, add it at the front
        if (obj.compareTo(items[0]) < 0) {
            // Shift the other elements over by 1 element and insert
            for (int j = items.length - 2; j >= 0; j--) {
                items[j + 1] = items[j];
            }

            items[0] = obj;
            size++;
            return;
        }

        // Insert the object in it's proper location
        for (int i = 0; i < size; i++) {
            if (obj.equals(items[i])) throw new Duplicate_Item_Found("Duplicate item being inserted: " + obj);

            // Look for the case where it is bigger than the already existing string
            if (obj.compareTo(items[i]) >= 1) {

                // Shift the other elements over by 1 element and insert
                for (int j = items.length - 2; j >= i; j--) {
                    items[j + 1] = items[j];
                }

                items[i + 1] = obj;
                size++;
                return;
            }
        }
    }

    public String[] delete(T obj) throws Duplicate_Item_Found {
        if (size == 0) throw new Dictionary_Full("Dictionary is empty");
        String elements[] = null;

        // Return the predecessor and successor of obj if obj would have existed
        if (!search(obj)) {
            elements = new String[2];
            System.out.println("Element '" + obj + "' not found");

            // If the logical size is 1
            if (size == 1) {
                if (obj.compareTo(items[0]) < 0) {
                    System.out.println("Predecessor doesn't exist | Successor: '" + items[0] + "'");
                    elements[0] = "";
                    elements[1] = items[0] + "";
                } else {
                    System.out.println("Predecessor: '" + items[0] + "' | Successor doesn't exist");
                    elements[0] = items[0] + "";
                    elements[1] = "";
                }
            }

            // If the obj is < than the first element
            else if (obj.compareTo(items[0]) < 0) {
                System.out.println("Predecessor doesn't exist | Successor: '" + items[0] + "'");
                elements[0] = "";
                elements[1] = items[0] + "";
            }
            // If the obj is > than the last element
            else if (obj.compareTo(items[size - 1]) > 0) {
                System.out.println("Predecessor: '" + items[size - 1] + "' | Successor doesn't exist");
                elements[0] = items[size - 1] + "";
                elements[1] = "";
            }

            // The obj exists between elements in the array
            else {
                for (int i = 0; i < size; i++) {
                    if (obj.compareTo(items[i]) >= 1) {
                        if (obj.compareTo(items[i + 1]) < 0) {
                            System.out.println("Predecessor: '" + items[i] + "' | Successor: '" + items[i + 1] + "'");
                            elements[0] = items[i] + "";
                            elements[1] = items[i + 1] + "";
                        }
                    }
                }
            }
            return elements;
        }

        // If the last item is being deleted, delete it and return (no need to shift everything)
        if (obj.equals(items[size - 1])) {
            items[size - 1] = null;
            size -= 1;
            return elements;
        }

        // Find the element, delete it, and shift every element ahead of it to the left
        for (int i = 0; i < size; i++) {
            if (obj.equals(items[i])) {

                items[i] = null;
                size -= 1;

                for (int j = i; j < size + 1; j++) {
                    items[j] = items[j + 1];
                }
                return elements;
            }
        }

        return elements;
    }

    public boolean search(T obj) {
        if (size == 0) throw new Dictionary_Full("Dictionary is empty");
        for (int i = 0; i < size; i++) {
            if (obj.equals(items[i])) {
                System.out.println("'" + obj + "' (exists at logical position: " + (i + 1) + ")");
                return true;
            }
        }
        System.out.println("'" + obj + "' doesn't exist in the dictionary");
        return false;
    }

    public void print() {
        System.out.print("-------------------------------\n" + toString() + "\n\nPhysical size print:\n[");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(items[i] + (i == MAX_SIZE - 1 ? "]\n" : ", "));
        }

        System.out.print("\nLogical size print:\n[");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + (i == size - 1 ? "]\n" : ", "));
        }
        System.out.println("-------------------------------");
    }

    public String[] toArray() {
        String[] array = null;
        if(size != 0) {
            array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = items[i] + "";
            }
        }
        return array;
    }
    public String toString() {
        return "Physical size: " + MAX_SIZE + " | Logical size: " + size;
    }
}