#include "header.h"

int phi(long int n) {
    int counter = 0;
    for (int i = 1; i <= n; i++) {
        if (gcd(i, n) == 1) counter++;
    }
    return counter;
}