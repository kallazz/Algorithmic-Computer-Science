#include <stdlib.h>
#include <stdbool.h>
#include "binary_tree.h"

bool find_element(binary_tree *tree, int x) {
    if (tree == NULL) return false;
    if (tree->value == x) {
        return true;
    } else {
        if (x < tree->value) return find_element(tree->left, x); 
        else return find_element(tree->right, x); 
    }
}