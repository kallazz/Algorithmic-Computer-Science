#include "Quadrangle.hpp"

#include <cmath>

double Quadrangle::getArea() noexcept(true) {
    return sides[0] * sides[2] * sin(angle * (M_PI / 180.0));
}

double Quadrangle::getPerimeter() noexcept(true) {
    double result = 0.0;
    for (int i = 0; i < 4; i++) result += sides[i];
    return result; 
}