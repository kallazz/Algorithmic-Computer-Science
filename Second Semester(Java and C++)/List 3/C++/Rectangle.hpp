#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

#include "Quadrangle.hpp"

class Rectangle : public Quadrangle {
    public:
        Rectangle(int a, int b, int c, int d, int angle) noexcept(false);
        std::string getName() noexcept(true) override;
};

#endif