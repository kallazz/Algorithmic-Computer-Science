#ifndef BST_HPP
#define BST_HPP

template <typename T>
class BST {
private:
    //Node class
    class Node {
    private:
        Node* left;
        Node* right;
        T value;

    public:
        // Constructor for Node
        Node(T value) {
            this->value = value;
            left = nullptr;
            right = nullptr;
        }

        Node* getLeftNode() {
            return left;
        }

        Node* getRightNode() {
            return right;
        }
    };

    void destroyTree(Node* root) {
        if (root != nullptr) {
            destroyTree(root->getLeftNode());
            destroyTree(root->getRightNode());
            delete root;
        }
    }

    Node* root; // The root of this BST
public:
    // Constructor for BST
    BST() {
        root = nullptr;
    }

    // Destructor for BST
    ~BST() {
        destroyTree(root);
    }

    // A utility function to insert
    // a new node with given key in BST
    Node* insert(Node* node, T key) {
        // If the tree is empty, return a new node
        if (node == nullptr)
            return BST<T>::Node(key);
    
        // Otherwise, recur down the tree
        if (key < node->key)
            node->left = insert(node->left, key);
        else if (key > node->key)
            node->right = insert(node->right, key);
    
        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to search a key in a BST
    Node* search(struct Node* root, T key) {
        // Base Cases: root is null or key is present at root
        if (root == nullptr || root->key == key)
            return root;
    
        // Key is greater than root's key
        if (root->key < key)
            return search(root->right, key);
    
        // Key is smaller than root's key
        return search(root->left, key);
    }

    // Given a binary search tree and a key, this function
    // deletes the key and returns the new root 
    Node* deleteNode(Node* root, T k) {
        // Base case
        if (root == nullptr)
            return root;
    
        // Recursive calls for ancestors of
        // node to be deleted
        if (root->key > k) {
            root->left = deleteNode(root->left, k);
            return root;
        }
        else if (root->key < k) {
            root->right = deleteNode(root->right, k);
            return root;
        }
    
        // We reach here when root is the node
        // to be deleted.
    
        // If one of the children is empty
        if (root->left == nullptr) {
            Node* temp = root->right;
            delete root;
            return temp;
        }
        else if (root->right == nullptr) {
            Node* temp = root->left;
            delete root;
            return temp;
        }
    
        // If both children exist
        else {
            Node* succParent = root;
    
            // Find successor
            Node* succ = root->right;
            while (succ->left != nullptr) {
                succParent = succ;
                succ = succ->left;
            }
    
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ->right to succParent->right
            if (succParent != root)
                succParent->left = succ->right;
            else
                succParent->right = succ->right;
    
            // Copy Successor Data to root
            root->key = succ->key;
    
            // Delete Successor and return root
            delete succ;
            return root;
        }
    }

    // A utility function to do inorder traversal of BST
    void inorder(Node* root) {
        if (root != nullptr) {
            inorder(root->left);
            printf("%d ", root->key);
            inorder(root->right);
        }
    }
};

#endif
