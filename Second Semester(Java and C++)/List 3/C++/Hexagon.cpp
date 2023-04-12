#include "Hexagon.hpp"

#include <cmath>

Hexagon::Hexagon(int side) noexcept(true) {
    this->side = side;
}

double Hexagon::getArea() noexcept(true) {
    return (3 * sqrt(3) * side * side) / 2;
}

double Hexagon::getPerimeter() noexcept(true) {
    return 6 * side;
}

std::string Hexagon::getName() noexcept(true) {
    return "Hexagon";
}