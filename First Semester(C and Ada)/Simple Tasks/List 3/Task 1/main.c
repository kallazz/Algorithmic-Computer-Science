//Zadanie 1, Michał Kallas
#include <stdio.h>
#include <stdbool.h>
#include "header.h"

int main(void) {
    char napis[30];
    printf("Podaj wyraz: ");
    scanf("%s", napis);
    if (palindrom(napis) == true) {
        printf("Napis jest palindromem\n");
    } else {
        printf("Napis nie jest palindromem\n");
    }

    return 0;
}