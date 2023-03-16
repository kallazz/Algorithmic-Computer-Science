#include <math.h>
#include "header.h"

double rozwiazanie(double a, double b, double eps) {
    while ((b - a) > eps) {
        double mid = (a + b) / 2;
        if ((f(a) * f(mid)) < 0) b = mid; else a = mid;
    }
    return a;
}