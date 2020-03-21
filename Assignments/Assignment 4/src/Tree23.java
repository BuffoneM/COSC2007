public class Tree23 {
    private class Node23 {

        // Data members
        private int smallItem;
        private int largeItem;
        private Node23 left, middle, right;

        // Constructors

        // Getter and setters
        public int getSmallItem() {
            return smallItem;
        }
        public void setSmallItem(int smallItem) {
            this.smallItem = smallItem;
        }

        public int getLargeItem() {
            return largeItem;
        }
        public void setLargeItem(int largeItem) {
            this.largeItem = largeItem;
        }

        // Methods
        @Override
        public String toString() {
            return "| Small item: " + smallItem + " | Large item: " + largeItem + " |";
        }

    }

    // Insert

    // Search

    // Height

    // Perform preorder

    // Perform inorder

}
