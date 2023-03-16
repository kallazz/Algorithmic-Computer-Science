//Zadanie5.c, Michał Kallas
#include <stdio.h>

int divider_sum(int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
        if (n % i == 0) sum += i;
    }

    return sum;
}

int main() {
    int sums[1000];
    for (int i = 1; i < 1000; i++) sums[i] = divider_sum(i);

    printf("Liczby doskonałe:\n");
    for (int i = 1; i < 1000; i++) {
        if (sums[i] == i) printf("%d\n", i);
    }

    printf("Liczby zaprzyjaźnone:\n");
    for (int i = 1; i < 1000; i++) {
        //Druga liczba to suma dzielników właściwych i, więc wystarczy sprawdzić czy suma jej dzielników właściwych jest równa i
        if (i == sums[sums[i]] && i < sums[i]) printf("%d %d\n", i, sums[i]); 
    }

    return 0;
}
