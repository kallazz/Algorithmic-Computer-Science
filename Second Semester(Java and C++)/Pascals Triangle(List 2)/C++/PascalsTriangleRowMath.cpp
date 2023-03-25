#include "PascalsTriangleRowMath.hpp"

#include <stdexcept>
#include <vector>

std::vector<long long> PascalsTriangleRowMath::generateRow(const int n) noexcept(false) {
    if (n < 0 || n > 34) throw std::invalid_argument("Expected an integer in range <0, 34>, got " + n);

    std::vector<long long> row;
    row.push_back(1);

    for (int i = 0; i < n; i++) row.push_back((row[i] * (n - i)) / (i + 1));

    return row;
}