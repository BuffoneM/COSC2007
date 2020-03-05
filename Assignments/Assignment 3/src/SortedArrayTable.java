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
    public void insert(T obj) {
        if (size == MAX_SIZE) throw new Dictionary_Full("Dictionary full");

        if (size == 0) {
            //if (size == 0 || obj.compareTo(items[size-1]) > 1) {
            items[size++] = obj;
            return;
        }

        items[size++] = obj;
        return;
        // Traverse the list until the item is in the proper location of the array for insertion

        // Insert the next element
    }

    public boolean search(T obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(items[i])) return true;
        }
        return false;
    }

    public void print() {
        System.out.print("-------------------------------\nPhysical size print:\n[");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(items[i] + (i == MAX_SIZE - 1 ? "]\n" : ", "));
        }

        System.out.print("\nLogical size print:\n[");
        for (int i = 0; i <= size; i++) {
            System.out.print(items[i] + (i == size ? "]\n" : ", "));
        }
        System.out.print("-------------------------------\n");
    }

    public String toString() {
        return "Physical size: " + MAX_SIZE + " | Logical size: " + size;
    }
}
