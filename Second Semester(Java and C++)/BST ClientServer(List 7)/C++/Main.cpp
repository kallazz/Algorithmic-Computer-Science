#include <iostream>
#include "ConsoleHandler.hpp"

int main (int argc, char const *argv[])
{
    std::cout << "Choose the type of your tree\n";
    std::cout << "integer / double / string\n";

    std::string type;
    while (true) {
        getline(std::cin, type);

        if (type == "integer") {
            ConsoleHandler<int> handler;
            handler.run();
            return 0;
        }
        else if (type == "double") {
            ConsoleHandler<double> handler;
            handler.run();
            return 0;
        }
        else if (type == "string") {
            ConsoleHandler<std::string> handler;
            handler.run();
            return 0;
        }
        else {
            std::cout << "Type " << type << " is not accepted. Choose integer / double / string\n";
        }
    }

    return 0;
}
