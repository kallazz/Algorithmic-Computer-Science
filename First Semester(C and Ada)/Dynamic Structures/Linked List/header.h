#pragma once

struct OneWayListStruct {
    int value;
    struct OneWayListStruct *next;
};
typedef struct OneWayListStruct OneWayList;

OneWayList * push_front(OneWayList *List, int n);
void push_back(OneWayList **List, int n);
void print_elements(OneWayList *List);
void remove_all_elements(OneWayList **List);
void delete_value(OneWayList **List, int x);