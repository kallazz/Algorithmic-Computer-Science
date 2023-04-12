#ifndef PENTAGON_HPP
#define PENTAGON_HPP

#include "Shape.hpp"

class Pentagon : public Shape {
    private:
        double side;

    public:
        Pentagon(int side) noexcept(true);
        virtual double getArea() noexcept(true) override;
        virtual double getPerimeter() noexcept(true) override;
        std::string getName() noexcept(true) override;
};

#endif