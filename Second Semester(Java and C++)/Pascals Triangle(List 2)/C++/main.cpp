#include "PascalsTriangleRowGenerator.hpp"
#include "PascalsTriangleRowMath.hpp"

#include <iostream>
#include <stdexcept>

int main(int argc, const char* const argv[]) {
    if (argc < 3) {
            std::cout << "Program requires at least 2 arguments, got " + (argc - 1) + '\n';
            return 0;
        }

        try { //Checking if the first argument(size of vector) is correct
            const int n = std::stoi(argv[1]);
            PascalsTriangleRowGenerator row(n);

            for (int i = 2; i < argc; i++) {
                std::cout << argv[i] << " --> ";

                try {
                    const int elementIndex = std::stoi(argv[i]);
                    std::cout << row.getElement(elementIndex);
                } 
                catch (const std::out_of_range &e) {
                    std::cout << e.what();
                }
                catch (const std::invalid_argument &e) {
                    std::cout << "not an integer";
                } 

                std::cout << '\n';
            }
        }
        catch (const std::invalid_argument &e) {
            std::cout << "Program requires an integer in range <0, 34>, got " << argv[1] << '\n';
        }
    
    return 0;
}
