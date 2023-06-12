#ifndef CONSOLE_HANDLER_HPP
#define CONSOLE_HANDLER_HPP

#include <iostream>
#include <sstream>
#include <vector>

template <typename T>
class ConsoleHandler {
private:
    std::vector<std::string> splitWords(const std::string& s) {
        std::vector<std::string> words;
        std::stringstream stream(s);
        std::string word;

        while (stream >> word) words.push_back(word);

        return words;
    }
    
public:
    void run() {
        std::cout << "You have 4 available commands for tree manipulation: insert, delete, search and print\n";
        std::cout << "Each of these commands, except for print, takes 1 argument after a space\n";
        std::cout << "If you wish to finish the program, write exit\n";

        std::string input;
        std::vector<std::string> splitInput;
        while (true) {
            std::getline(std::cin, input); //get input from user
            splitInput = splitWords(input);

            if (splitInput.size() < 1 || splitInput.size() > 2) {
                std::cout << splitInput.size() << " is not the correct number of arguments for this action!\n";
            } 
            else {
                const std::string action = splitInput[0];

                if (action == "insert") {

                }
                else if (action == "delete") {

                }
                else if (action == "search") {

                }
                else if (action == "print") {

                }
                else if (action == "exit") {
                    return;
                }
                else {
                    std::cout << action << " is not on of the allowed actions!";
                }
            }
        }
    }
};

#endif