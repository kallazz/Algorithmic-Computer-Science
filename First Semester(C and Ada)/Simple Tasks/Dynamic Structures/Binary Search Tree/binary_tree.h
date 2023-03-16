#pragma once
#include <stdbool.h>

struct binary_tree_struct {
    int value;
    struct binary_tree_struct *left;
    struct binary_tree_struct *right;
};
typedef struct binary_tree_struct binary_tree;

void add_element(binary_tree **tree, int n);
void print_preorder(binary_tree *tree);
void print_inorder(binary_tree *tree);
void print_postorder(binary_tree *tree);
bool find_element(binary_tree *tree, int x);
void remove_tree(binary_tree **tree);