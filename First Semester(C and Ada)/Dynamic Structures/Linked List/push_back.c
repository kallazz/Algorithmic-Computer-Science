#include <stdlib.h>
#include "header.h"

void push_back(OneWayList **List, int n) {
    OneWayList *NewList, *Temp;
    NewList = malloc(sizeof(OneWayList));
    NewList->value = n;
    NewList->next = NULL;

    if (*List == NULL) {
        (*List)->next = NewList;
    } else {
        Temp = *List;
        while (Temp->next != NULL) {
            Temp = Temp->next;
        }
        Temp->next = NewList;
    }
}