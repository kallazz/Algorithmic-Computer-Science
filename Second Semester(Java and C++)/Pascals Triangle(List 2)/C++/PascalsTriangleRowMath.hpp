#ifndef PASCALS_TRIANGLE_ROW_MATH_HPP
#define PASCALS_TRIANGLE_ROW_MATH_HPP

#include <vector>

/**
 * @class PascalsTriangleRowMath
 * 
 * @brief PascalsTriangleRowMath is a static class that contains static mathematical methods realtive to the Pascal's Triangle
 */
class PascalsTriangleRowMath {
    public:
    // this is a static class, so delete constructor
    PascalsTriangleRowMath() = delete;

    ~PascalsTriangleRowMath() = delete;
    PascalsTriangleRowMath(const PascalsTriangleRowMath&) = delete;
    PascalsTriangleRowMath(PascalsTriangleRowMath&&) = delete;
    PascalsTriangleRowMath& operator=(const PascalsTriangleRowMath&) = delete;
    PascalsTriangleRowMath& operator=(PascalsTriangleRowMath&&) = delete;

    /**
     * @brief Function generates an ArrayList with the n-th row of the Pascal's Triangle
     *        For numbers < 0 and numbers > 34 the std::invalid_argument is raised
     *        Example: generateRow(0) -> {1}
     *                 generateRow(1) -> {1, 1}
     *                 generateRow(2) -> {1, 2, 1}
     *                 generateRow(3) -> {1, 3, 3, 1}
     *                 generateRow(4) -> {1, 4, 6, 4, 1}
     * 
     * @param n row number(starting from 0)
     * 
     * @return ArrayList with the elements from the n-th row of the Pascal's Triangle
     */
    static std::vector<long long> generateRow(int n) noexcept(false);
};

#endif