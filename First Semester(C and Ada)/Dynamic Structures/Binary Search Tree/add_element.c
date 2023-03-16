#include <stdlib.h>
#include "binary_tree.h"

void add_element(binary_tree **tree, int n) {
    if (*tree == NULL) {
        *tree = malloc(sizeof(binary_tree));
        (*tree)->value = n;
        (*tree)->left = NULL;
        (*tree)->right = NULL;
    }
    else if (n < (*tree)->value) add_element(&((*tree)->left), n);
    else if (n > (*tree)->value) add_element(&((*tree)->right), n);
}