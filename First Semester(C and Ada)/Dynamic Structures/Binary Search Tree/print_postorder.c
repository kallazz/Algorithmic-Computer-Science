#include <stdlib.h>
#include <stdio.h>
#include "binary_tree.h"

void print_postorder(binary_tree *tree) {
    if (tree != NULL) {
        print_postorder(tree->left);
        print_postorder(tree->right);
        printf("%d ", tree->value);
    }
}