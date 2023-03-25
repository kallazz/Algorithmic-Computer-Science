#include "PascalsTriangleRowGenerator.hpp"
#include "PascalsTriangleRowMath.hpp"

#include <stdexcept>

PascalsTriangleRowGenerator::PascalsTriangleRowGenerator(const int n) noexcept(false) {
    row = PascalsTriangleRowMath::generateRow(n);
}

long long PascalsTriangleRowGenerator::getElement(const int m) noexcept(false) {
    if (m < 0 || m >= row.size()) {
            throw std::out_of_range("out of range, use <0, " + std::to_string(row.size() - 1) + '>');
    }
    return row[m];
}