import java.util.Arrays;

public class TestProgram {

    public static void main(String[] args) {

        SortedArrayTable<String> dict1 = new SortedArrayTable<String>(10);

        dict1.insert("c");
        dict1.insert("d");
        dict1.insert("e");
        dict1.insert("b");
        dict1.insert("a");
        dict1.insert("asdoij");
        dict1.insert("z");
        dict1.print();

        System.out.println("Finished adding elements...");

        dict1.delete("a");
        dict1.delete("z");
        dict1.delete("asdoij");
        dict1.delete("z");
        dict1.print();
        System.out.println("Finished deleting elements...");


        System.out.println("Complete...\n");
    }
}
