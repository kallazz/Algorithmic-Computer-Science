#include "Disk.hpp"

#include <cmath>

Disk::Disk(int radius) noexcept(true) {
    this->radius = radius;
}

double Disk::getArea() noexcept(true) {
    return M_PI * radius * radius;
}

double Disk::getPerimeter() noexcept(true) {
    return 2 * M_PI * radius;
}

std::string Disk::getName() noexcept(true) {
    return "Disk";
}