//Zadanie 1, Michał Kallas
#include <stdio.h>
#include "header.h"
#include <string.h>
int main(void) {
    char pattern[100];
    char text[100];
    printf("Podaj wzorzec:");
    scanf("%s", pattern);
    printf("Podaj łańcuch:");
    scanf("%s", text);
    
    if (match(pattern, text) == true) {
        printf("Wzorzec jest zgodny z łańcuchem!\n");
    } else {
        printf("Wzorzec nie jest zgodny z łańcuchem!\n");
    }

    return 0;
}
