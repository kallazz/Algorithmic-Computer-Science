#include <stdio.h>
#include <stdlib.h>
#include "header.h"

int main(void) {
    OneWayList *list = NULL;
    list = push_front(list, 2);
    push_back(&list, 3);
    push_back(&list, 3);
    list = push_front(list, 1);
    push_back(&list, 4);
    push_back(&list, 5);
    push_back(&list, 3);
    list = push_front(list, 1);
    list = push_front(list, 7);
    list = push_front(list, 1);
    list = push_front(list, 1);
    push_back(&list, 1);
    print_elements(list);
    delete_value(&list, 1);
    print_elements(list);
    delete_value(&list, 3);
    print_elements(list);
    //remove_all_elements(&list);
    print_elements(list);
    delete_value(&list, 7);
    delete_value(&list, 2);
    delete_value(&list, 4);
    delete_value(&list, 5);
    print_elements(list);

    return 0;
}