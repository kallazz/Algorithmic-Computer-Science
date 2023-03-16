#include <stdlib.h>
#include "header.h"

void delete_value(OneWayList **List, int x) {
    OneWayList *Previous, *Current;
    Previous = *List;
    Current = *List;
    while (*List != NULL && (*List)->value == x) {
        Current = (*List)->next;
        free(*List);
        *List = Current;
    }
    while (Current != NULL) {
        if (Current->value == x) {
            Previous->next = Current->next;
            free(Current);
            Current = Previous->next;
        } else {
            Previous = Current;
            Current = Current->next;
        }
    }
}