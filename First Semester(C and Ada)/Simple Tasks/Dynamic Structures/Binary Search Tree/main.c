#include <stdio.h>
#include <stdlib.h>
#include "binary_tree.h"

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

int nodes(binary_tree *tree) {
    if (tree == NULL) return 0;
    int counter = 1;
    counter += nodes(tree->left) + nodes(tree->right);
    return counter;
}

int leaves(binary_tree *tree) {
    if (tree == NULL) return 0;
    if (tree->left == NULL && tree->right == NULL) return 1;
    return leaves(tree->left) + leaves(tree->right);
}

int height(binary_tree *tree) {
    if (tree == NULL) return 0;
    return 1 + max(height(tree->left), height(tree->right));
}

int main(void) {
    binary_tree *tree = NULL;
    add_element(&tree, 4);
    add_element(&tree, 2);
    add_element(&tree, 3);
    add_element(&tree, 6);
    add_element(&tree, 1);
    add_element(&tree, 7);
    add_element(&tree, 5);
    add_element(&tree, 0);

    printf("Preorder: ");
    print_preorder(tree);
    printf("\nInorder: ");
    print_inorder(tree);
    printf("\nPostorder: ");
    print_postorder(tree);
    printf("\n");

    if (find_element(tree, 3)) printf("Ten element znajduje się w drzewie!");
    else printf("Ten element nie znajduje się w drzewie!");
    printf("\n");

    //remove_tree(&tree);
    printf("\nWysokość: %d", height(tree));
    printf("\nIlość węzłów: %d", nodes(tree));
    printf("\nIlość liści: %d\n", leaves(tree));
    
    return 0;
}