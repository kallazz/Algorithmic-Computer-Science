#include "Rectangle.hpp"

#include <stdexcept>
#include <algorithm>

Rectangle::Rectangle(int a, int b, int c, int d, int angle) noexcept(false) {
    sides.push_back(a);
    sides.push_back(b);
    sides.push_back(c);
    sides.push_back(d);
    this->angle = angle;

    sort(sides.begin(), sides.end());

    if ((sides[0] != sides[1]) || (sides[2] != sides[3]) || (angle != 90)) {
        throw std::invalid_argument("This is not a rectangle(invalid sides or angle)");
    }
}

std::string Rectangle::getName() noexcept(true) {
    return "Rectangle";
}