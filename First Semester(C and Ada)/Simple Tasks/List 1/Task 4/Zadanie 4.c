//Zadanie 4, Michał Kallas
#include <stdio.h>

int main() {
    int n;
    printf("Podaj n:");
    scanf("%d", &n);

    int spaces = n - 1;
    int row_size = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < spaces; j++) printf(" ");
        for (int j = 0; j < row_size; j++) printf("*");
        printf("\n");

        row_size += 2;
        spaces--;
    }

    return 0;
}