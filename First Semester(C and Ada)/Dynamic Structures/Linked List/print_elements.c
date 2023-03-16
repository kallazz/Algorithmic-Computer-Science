#include <stdio.h>
#include <stdlib.h>
#include "header.h"

void print_elements(OneWayList *List) {
    while (List != NULL) {
        printf("%d ", List->value);
        List = List->next;
    }
    printf("\n");
}