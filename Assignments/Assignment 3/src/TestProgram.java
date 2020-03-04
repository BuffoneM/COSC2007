public class TestProgram {

    public static void main(String[] args) {

        SortedArrayTable<String> dict1 = new SortedArrayTable<String>(5);
        System.out.println(dict1);

        dict1.insert("a");
        dict1.insert("c");
        dict1.insert("d");
        dict1.print();
        //dict1.insert("e");


    }
}
