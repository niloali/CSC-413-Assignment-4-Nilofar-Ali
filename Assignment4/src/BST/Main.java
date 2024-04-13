//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 4

package BST;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Test insert functionality
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        // Test delete functionality
        bst.delete(5);

        // Test search functionality
        System.out.println("Search for 10: " + bst.search(10)); // Should print true
        System.out.println("Search for 5: " + bst.search(5)); // Should print false

        // Test traversal functionalities
        System.out.print("In-order Traversal: ");
        bst.inorder();
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        bst.preorder();
        System.out.println();

        System.out.print("Post-order Traversal: ");
        bst.postorder();
        System.out.println();
    }
}
