//Zadanie 4.c, Michał Kallas
#include <stdio.h>
#include <math.h>

int main() {
    double result = 1;
    double i = 2;
    while (i <= 1000) {
        result *= pow(i, 1.0/1000);
        i += 1;
    }

    printf("Przybliżenie to: %lf\n", result);
    
    return 0;
}
