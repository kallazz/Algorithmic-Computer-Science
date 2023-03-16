#include <math.h>
#include "agents.h"
#include <stdio.h>
double distance(struct agent a1, struct agent a2) {
    double a = a2.x * 1.0 - a1.x * 1.0;
    double b = a2.y * 1.0 - a1.y * 1.0;
    return sqrt(a * a + b * b);
}