#ifndef PASCALS_TRIANGLE_ROW_GENERATOR_HPP
#define PASCALS_TRIANGLE_ROW_GENERATOR_HPP

#include <vector>

/**
 * @class PascalsTriangleRowGenerator
 * 
 * @brief This class contains the n-th row of the Pascal's Triangle
 *        In order to generate it you have to create an object with an argument n(row number) 
 *        Then you can get the m-th element of that row
 * 
 *        Example:
 *        PascalsTriangleRowGenerator r = new PascalsTriangleRowGenerator(2); //{1, 2, 1} generated
 *        int secondElement = r.getElement(1); // The second element is 2    
 */
class PascalsTriangleRowGenerator {
    private:
        std::vector<long long> row;

    public:
        /**
         * @brief Creates a class instance with the n-th row of the Pascal's Triangle
         * 
         * @param n row number(starting from 0)
         */
        explicit PascalsTriangleRowGenerator(int n) noexcept(false);

        /**
         * @brief Getting in O(1) the m-th element of the previously generated n-th row of the Pascal's triangle
         * 
         * @param m the index of the element you want to get(starting from 0)
         * 
         * @return the m-th element of the Pascal's Triangle row
         */
        long long getElement(int m) noexcept(false);

        //Rule of 5
        virtual ~PascalsTriangleRowGenerator() noexcept(true) = default;
        PascalsTriangleRowGenerator(const PascalsTriangleRowGenerator&) noexcept(true) = default;
        PascalsTriangleRowGenerator(PascalsTriangleRowGenerator&&) noexcept(true) = default;
        PascalsTriangleRowGenerator& operator=(const PascalsTriangleRowGenerator&) noexcept(true) = default;
        PascalsTriangleRowGenerator& operator=(PascalsTriangleRowGenerator&&) noexcept(true) = default;
};

#endif