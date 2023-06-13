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
        T key;

    public:
        // Constructor for Node
        Node(T key) {
            this->getKey() = key;
            left = nullptr;
            right = nullptr;
        }

        Node*& getLeftNode() {
            return left;
        }

        Node*& getRightNode() {
            return right;
        }

        T& getKey() {
            return key;
        }
    };

    void destroyTree(Node* root) {
        if (root != nullptr) {
            destroyTree(root->getLeftNode());
            destroyTree(root->getRightNode());
            delete root;
        }
    }

    //NOTE: BST functions are based on functions from GeeksForGeeks
    
    // A utility function to insert
    // a new node with given key in BST
    Node* insert(Node* node, T key) {
        // If the tree is empty, return a new node
        if (node == nullptr)
            return new BST<T>::Node(key);
    
        // Otherwise, recur down the tree
        if (key < node->getKey())
            node->getLeftNode() = insert(node->getLeftNode(), key);
        else if (key > node->getKey())
            node->getRightNode() = insert(node->getRightNode(), key);
    
        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to search a key in a BST
    Node* search(Node* root, T key) {
        // Base Cases: root is null or key is present at root
        if (root == nullptr || root->getKey() == key)
            return root;
    
        // Key is greater than root's key
        if (root->getKey() < key)
            return search(root->getRightNode(), key);
    
        // Key is smaller than root's key
        return search(root->getLeftNode(), key);
    }

    // Given a binary search tree and a key, this function
    // deletes the key and returns the new root 
    Node* deleteNode(Node* root, T k) {
        // Base case
        if (root == nullptr)
            return root;
    
        // Recursive calls for ancestors of
        // node to be deleted
        if (root->getKey() > k) {
            root->getLeftNode() = deleteNode(root->getLeftNode(), k);
            return root;
        }
        else if (root->getKey() < k) {
            root->getRightNode() = deleteNode(root->getRightNode(), k);
            return root;
        }
    
        // We reach here when root is the node
        // to be deleted.
    
        // If one of the children is empty
        if (root->getLeftNode() == nullptr) {
            Node* temp = root->getRightNode();
            delete root;
            return temp;
        }
        else if (root->getRightNode() == nullptr) {
            Node* temp = root->getLeftNode();
            delete root;
            return temp;
        }
    
        // If both children exist
        else {
            Node* succParent = root;
    
            // Find successor
            Node* succ = root->getRightNode();
            while (succ->getLeftNode() != nullptr) {
                succParent = succ;
                succ = succ->getLeftNode();
            }
    
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ->getRightNode() to succParent->getRightNode()
            if (succParent != root)
                succParent->getLeftNode() = succ->getRightNode();
            else
                succParent->getRightNode() = succ->getRightNode();
    
            // Copy Successor Data to root
            root->getKey() = succ->getKey();
    
            // Delete Successor and return root
            delete succ;
            return root;
        }
    }

    // A utility function to do inorder traversal of BST
    void inorder(Node* root) {
        if (root != nullptr) {
            inorder(root->getLeftNode());
            std::cout << root->getKey() << " ";
            inorder(root->getRightNode());
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

    void insertValue(T value) {
        root = insert(root, value);
    }

    void deleteValue(T value) {
        root = deleteNode(root, value);
    }

    bool searchValue(T value) {
        if (search(root, value) == nullptr) return false;
        return true;
    }

    void printTree() {
        inorder(root);
        std::cout << '\n';
    }
};

#endif
