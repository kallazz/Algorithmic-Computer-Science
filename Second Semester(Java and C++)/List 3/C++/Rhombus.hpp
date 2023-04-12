#ifndef RHOMBUS_HPP
#define RHOMBUS_HPP

#include "Quadrangle.hpp"

class Rhombus : public Quadrangle {
    public:
        Rhombus(int side, int angle) noexcept(false);
        std::string getName() noexcept(true) override;
};

#endif