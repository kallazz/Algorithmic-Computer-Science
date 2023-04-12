#include "Disk.hpp"
#include "Hexagon.hpp"
#include "Pentagon.hpp"
#include "Quadrangle.hpp"
#include "Rectangle.hpp"
#include "Rhombus.hpp"
#include "Shape.hpp"
#include "Square.hpp"

#include <iostream>
#include <cstring>
#include <stdexcept>

int main(int argc, const char* const argv[]) {
    if (argc < 3) {
        std::cout << "Expected at least 3 arguments, got " << argc << '\n';
        return 0;
    }

    Shape *newShape;

    if (std::strcmp(argv[1], "c") == 0) { //Czworokąt
        if (argc != 7) {
            std::cout << "Expected 7 arguments, got " << argc << '\n';
            return 0;
        }
        
        int sides[4];
        int angle;

        for (int i = 2; i < 6; i++) { //Sprawdzenie czy wszystkie argumenty to inty
            try {
                sides[i - 2] = std::stoi(argv[i]);
            } 
            catch (const std::logic_error &e) {
                std::cout << argv[i] << " is not an integer\n";
                return 0;
            }
        }

        try {
            angle = std::stoi(argv[6]);
        } 
        catch (const std::logic_error &e) {
            std::cout << argv[6] << " is not an integer\n";
            return 0;
        }

        if (sides[0] == sides[1] && sides[0] == sides[2] && sides[0] == sides[3]) {
            if (angle == 90) newShape = new Square(sides[0], angle); //Kwadrat
            else { //Romb
                try {
                    newShape = new Rhombus(sides[0], angle);
                }
                catch (const std::invalid_argument &e) {
                    std::cout << "This is not a rhombus. Angle should be in <1, 179>, got " << sides[5] << '\n';
                    return 0;
                }
            }
        } 
        else { //Prostokąt
            try {
                newShape = new Rectangle(sides[0], sides[1], sides[2], sides[3], angle);
            }
            catch (const std::invalid_argument &e) {
                std::cout << "This is not a rectangle\n";
                return 0;
            }
        }


    }
    else if (std::strcmp(argv[1], "o") == 0 || std::strcmp(argv[1], "p") == 0 || std::strcmp(argv[1], "s") == 0) { //Koło, pięciokąt, sześciokąt
        if (argc != 3) {
            std::cout << "Expected 3 arguments, got " << argc << '\n';
            return 0;
        }

        int n;
        try {
            n = std::stoi(argv[2]);
        } 
        catch (const std::logic_error &e) {
            std::cout << argv[2] << " is not an integer\n";
            return 0;
        }

        if (std::strcmp(argv[1], "o") == 0) { //Koło
            newShape = new Disk(n);
        }
        else if (std::strcmp(argv[1], "p") == 0) { //Pięciokąt
            newShape = new Pentagon(n);
        }
        else if (std::strcmp(argv[1], "s") == 0) { //Sześciokąt
            newShape = new Hexagon(n);
        }            
    } 
    else {
        std::cout << "Expected c or o or p or s as the first argument, got " << argv[1] << '\n';
        return 0;
    } 

    std::cout << "Name: " << newShape->getName() << '\n';
    std::cout << "Area: " << newShape->getArea() << '\n';
    std::cout << "Perimeter: " << newShape->getPerimeter() << '\n';

    delete newShape;

    return 0;
}