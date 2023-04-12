#ifndef SHAPE_HPP
#define SHAPE_HPP

#include <string>

class Shape {
    public:
        virtual double getArea() noexcept(true) = 0;
        virtual double getPerimeter() noexcept(true) = 0;
        virtual std::string getName() noexcept(true) = 0;
};

#endif 