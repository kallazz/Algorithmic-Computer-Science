#include <stdlib.h>
#include <stdio.h>
#include "binary_tree.h"

void print_inorder(binary_tree *tree) {
    if (tree != NULL) {
        print_inorder(tree->left);
        printf("%d ", tree->value);
        print_inorder(tree->right);
    }
}