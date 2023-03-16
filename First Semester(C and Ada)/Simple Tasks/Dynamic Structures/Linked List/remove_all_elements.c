#include <stdlib.h>
#include "header.h"

void remove_all_elements(OneWayList **List) {
    OneWayList *NextElement;
    while (*List != NULL) {
        NextElement = (*List)->next;
        free(*List);
        *List = NextElement;
    }
}