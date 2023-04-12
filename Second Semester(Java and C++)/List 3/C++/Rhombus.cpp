#include "Rhombus.hpp"

#include <stdexcept>

Rhombus::Rhombus(int side, int angle) noexcept(false) {
    if (angle < 1 || angle > 179) {
        throw std::invalid_argument("Rhombus' angle must be in range <1, 179>");
    }

    for (int i = 0; i < 4; i++) sides.push_back(side);
    this->angle = angle;
}

std::string Rhombus::getName() noexcept(true) {
    return "Rhombus";
}