#include "Square.hpp"

#include <stdexcept>

Square::Square(int side, int angle) noexcept(false) {
    if (angle != 90) {
        throw std::invalid_argument("Square's angle must be 90 degrees");
    }

    for (int i = 0; i < 4; i++) sides.push_back(side);
    this->angle = angle;
}

std::string Square::getName() noexcept(true) {
    return "Square";
}