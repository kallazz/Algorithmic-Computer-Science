#include <stdlib.h>
#include "header.h"

OneWayList * push_front(OneWayList *List, int n) {
    OneWayList *NewList;
    NewList = malloc(sizeof(OneWayList));
    NewList->value = n;
    NewList->next = List;
    return NewList;
}