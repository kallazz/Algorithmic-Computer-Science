#ifndef QUADRANGLE_HPP
#define QUADRANGLE_HPP

#include "Shape.hpp"

#include <vector>

class Quadrangle : public Shape {
    protected:
        std::vector<int> sides;
        int angle;

    public:
        double getArea() noexcept(true) override;
        double getPerimeter() noexcept(true) override;
};

#endif