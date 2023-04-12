#ifndef DISK_HPP
#define DISK_HPP

#include "Shape.hpp"

class Disk : public Shape {
    private:
        double radius;

    public:
        Disk(int radius) noexcept(true);
        double getArea() noexcept(true) override;
        double getPerimeter() noexcept(true) override;
        std::string getName() noexcept(true) override;
};

#endif