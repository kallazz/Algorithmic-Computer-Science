//Zadanie 3, Michał Kallas
#include <stdio.h>
#include "header.h"

int main(void) {
    int n;
    printf("Podaj liczbę: ");
    scanf("%d", &n);
    printf("Funkcja Eulera dla argumentu %d przyjmuje wartość %d\n", n, phi(n));

    return 0;
}