//Zadanie1.c, Michał Kallas
#include <stdio.h>

int main() {
    int n;
    printf("Podaj n:");
    scanf("%d", &n);    

    float number;
    float sum = 0;
    for (int i = 0; i < n; i++) {
        scanf("%f", &number);
        sum += number;
    }
    printf("Średnia arytmetyczna wpisanych liczb to: %f\n", sum / n);

    return 0;
}