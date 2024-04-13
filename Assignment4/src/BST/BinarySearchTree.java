//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 4

package BST;

public class BinarySearchTree {
    Node root; //root node

    // Constructor to initialize the BST with null root
    BinarySearchTree() {
        root = null;
    }

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a key into the BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Delete a key from the BST
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key from the BST
    Node deleteRec(Node root, int key) {
        // If the tree is empty, return null
        if (root == null)
            return root;

        // Recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else { // If the key is found, delete the node with that key
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Find the minimum value in a subtree
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search for a key in the BST
    boolean searchRec(Node root, int key) {
        // If the tree is empty or the key is at the root, return true
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        // Otherwise, recur down the tree
        if (root.key < key)
            return searchRec(root.right, key);

        return searchRec(root.left, key);
    }

    // Perform inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // Recursive function to perform inorder traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Perform preorder traversal of the BST
    void preorder() {
        preorderRec(root);
    }

    // Recursive function to perform preorder traversal
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Perform postorder traversal of the BST
    void postorder() {
        postorderRec(root);
    }

    // Recursive function to perform postorder traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}
