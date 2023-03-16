//Zadanie 2.c, Michał Kallas
#include <stdio.h>

int main() {
    double sum = 1;
    int denominator = 1;
    while (sum <= 10) {
        denominator++;
        sum += 1.0/denominator;
    }

    printf("Szukane n to: %d", denominator);

    return 0;
}