#ifndef SQUARE_HPP
#define SQUARE_HPP

#include "Quadrangle.hpp"

class Square : public Quadrangle {
    public:
        Square(int side, int angle) noexcept(false);
        std::string getName() noexcept(true) override;
};

#endif