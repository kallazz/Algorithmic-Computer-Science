//Zadanie 2 extra, Michał Kallas
#include <stdio.h>
#include <math.h>

int main() {
    double a, b, c; // a =/= 0
    printf("Podaj a:");
    scanf("%lf", &a);
    printf("Podaj b:");
    scanf("%lf", &b);
    printf("Podaj c:");
    scanf("%lf", &c);

    if (a == 0 && b == 0 && c == 0) printf("Każda liczba rzeczywista spełnia to równianie!");
    else if (a == 0 && b == 0) printf("Sprzeczność!");
    else if (a == 0) printf("Rozwiązanie to: %lf", (-c) / b);
    else {
        double delta = (b * b) - 4 * a * c;
        if (delta < 0) printf("Brak rozwiązań w zbiorze liczb rzeczywistych!");
        else if (delta == 0) printf("Rozwiązanie to: %lf", -b / (2 * a)); 
        else printf("Rozwiązania to: %lf oraz %lf", (-b - sqrt(delta)) / (2 * a), (-b + sqrt(delta)) / (2 * a));
    }
    printf("\n");

    return 0;
}