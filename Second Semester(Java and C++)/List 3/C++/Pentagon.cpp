#include "Pentagon.hpp"

#include <cmath>

Pentagon::Pentagon(int side) noexcept(true) {
    this->side = side;
}

double Pentagon::getArea() noexcept(true) {
    return sqrt(25 + 10 * sqrt(5)) * ((side * side) / 4);
}

double Pentagon::getPerimeter() noexcept(true) {
    return 5 * side;
}

std::string Pentagon::getName() noexcept(true) {
    return "Pentagon";
}