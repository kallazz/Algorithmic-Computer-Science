//Zadanie 2, Michał Kallas
#include <stdio.h>
#include "header.h"

int main(void) {
    double eps = 0.1;
    for (int i = 0; i < 8; i++) {
        printf("Wynik dla a = %d; b = %d; eps = %lf to %lf\n", 2, 4, eps, rozwiazanie(2, 4, eps));
        eps = eps / 10;
    }

    return 0;
}