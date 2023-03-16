#include <stdlib.h>
#include <stdio.h>
#include "binary_tree.h"

void print_preorder(binary_tree *tree) {
    if (tree != NULL) {
        printf("%d ", tree->value);
        print_preorder(tree->left);
        print_preorder(tree->right);
    }
}