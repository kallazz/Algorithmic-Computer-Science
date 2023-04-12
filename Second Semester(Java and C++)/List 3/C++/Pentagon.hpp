#ifndef PENTAGON_HPP
#define PENTAGON_HPP

#include "Shape.hpp"

class Pentagon : public Shape {
    private:
        double side;

    public:
        Pentagon(int side) noexcept(true);
        double getArea() noexcept(true) override;
        double getPerimeter() noexcept(true) override;
        std::string getName() noexcept(true) override;
};

#endif