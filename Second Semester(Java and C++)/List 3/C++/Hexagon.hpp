#ifndef HEXAGON_HPP
#define HEXAGON_HPP

#include "Shape.hpp"

class Hexagon : public Shape {
    private:
        double side;

    public:
        Hexagon(int side) noexcept(true);
        double getArea() noexcept(true) override;
        double getPerimeter() noexcept(true) override;
        std::string getName() noexcept(true) override;
};

#endif