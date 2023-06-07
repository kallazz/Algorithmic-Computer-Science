public class BST<T extends Comparable<T>> {
    Node root = null;
   
    // This method mainly calls searchRec() and returns true if the key is in the tree, otherwise false
    public boolean search(T key) {
        if (searchRec(root, key) != null) {
            if (key.compareTo(searchRec(root, key).value) == 0) return true;
        }
        return false;
    }

    // This method calls insertRec() on the root
    public void insert(T key) { 
        root = insertRec(root, key); 
    }

    // This method calls insertRec() on the root
    public void delete(T key) { 
        root = deleteRec(root, key); 
    }

    // This method calls printInorder() to list all elements of the tree
    public void print() {
        printInorder(root);
        System.out.println();
    }


    // A recursive function to
    // insert a new key in BST
    private Node insertRec(Node root, T key)
    {
        // If the tree is empty return a new node
        if (root == null) {
            root = new Node(key); //ADD UP?
            return root;
        }
 
        // Otherwise, recur down the tree
        if (key.compareTo(root.value) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.value) > 0)
            root.right = insertRec(root.right, key);
 
        // return the (unchanged) node pointer
        return root;
    }

    /* A recursive function to
      delete an existing key in BST
     */
    private Node deleteRec(Node root, T key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key.compareTo(root.value) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.value) > 0)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.value = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
 
        return root;
    }
 
    //For deleting
    private T minValue(Node root)
    {
        T minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    // A utility function to search a given key in BST
    private Node searchRec(Node root, T key) {
        // Base Cases: root is null or key is present at root
        if (root == null || (root.value).compareTo(key) == 0)
            return root;
    
        // Key is greater than root's value
        if ((root.value).compareTo(key) < 0)
            return searchRec(root.right, key);
    
        // Key is smaller than root's value
        return searchRec(root.left, key);
    }

    // Inorder Traversal
    private void printInorder(Node root)
    {
        if (root == null)
            return;
 
        // Traverse left subtree
        printInorder(root.left);
 
        // Visit node
        System.out.print(root.value + " ");
 
        // Traverse right subtree
        printInorder(root.right);
    }

    //The structure of every node
    private class Node {
        private Node left, right; //up
        private T value;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
