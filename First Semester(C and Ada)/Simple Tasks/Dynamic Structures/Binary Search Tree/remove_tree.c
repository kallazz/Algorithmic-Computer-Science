#include <stdlib.h>
#include "binary_tree.h"

void remove_tree(binary_tree **tree) {
    if (*tree != NULL) {
        remove_tree(&((*tree)->left));
        remove_tree(&((*tree)->right));
        free(*tree);
        *tree = NULL;
    }
}