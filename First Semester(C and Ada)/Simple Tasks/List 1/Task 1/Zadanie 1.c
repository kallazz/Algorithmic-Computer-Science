//Zadanie 1, Michał Kallas
#include <stdio.h> 

int main() {
    char text[] = "A B R A K A D A B R A";
    int text_length = 21;
    int spaces = 0;

    for (int i = 0; i < 11; i++) {
        for (int j = 0; j < spaces; j++) printf(" ");

        for (int j = 0; j < text_length; j++) printf("%c", text[j]);

        text_length = text_length - 2;
        spaces += 1;
        printf("\n");
    }

    return 0;
}