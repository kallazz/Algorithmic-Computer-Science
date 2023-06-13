#ifndef CONSOLE_HANDLER_HPP
#define CONSOLE_HANDLER_HPP

#include "BST.hpp"
#include "StringOperations.hpp"

#include <iostream>
#include <sstream>

template <typename T>
class ConsoleHandler {
private:
    BST<T> tree;
    
public:
    void run() {
        std::cout << "You have 4 available commands for tree manipulation: insert, delete, search and print\n";
        std::cout << "Each of these commands, except for print, takes 1 argument after a space\n";
        std::cout << "If you wish to finish the program, write exit\n";

        std::string input;
        unsigned int wordCount;
        while (true) {
            try {
                std::getline(std::cin, input); //get input from user
                wordCount = StringOperations::countWords(input);

                if (wordCount < 1 || wordCount > 2) 
                    throw std::invalid_argument("You can input max 2 words, not " + std::to_string(wordCount));
                
                std::stringstream inputStream(input);
                std::string action;
                std::string argument = "";

                inputStream >> action;
                if (wordCount == 2) inputStream >> argument;

                if (action == "insert") {
                    if (wordCount != 2)
                        throw std::invalid_argument("Insert requires 2 arguments, not " + std::to_string(wordCount));

                    tree.insertValue(StringOperations::stringToVal<T>(argument));
                }
                else if (action == "delete") {
                    if (wordCount != 2)
                        throw std::invalid_argument("Delete requires 2 arguments, not " + std::to_string(wordCount));

                    tree.deleteValue(StringOperations::stringToVal<T>(argument));
                }
                else if (action == "search") {
                    if (wordCount != 2)
                        throw std::invalid_argument("Search requires 2 arguments, not " + std::to_string(wordCount));
                        
                    if (tree.searchValue(StringOperations::stringToVal<T>(argument)) == true) std::cout << "The element IS in the tree\n";
                    else std::cout << "The element IS NOT in the tree\n";
                }
                else if (action == "print") {
                    if (wordCount != 1) 
                        throw std::invalid_argument("Print requires only 1 argument, not " + std::to_string(wordCount));
                    
                    tree.printTree();
                }
                else if (action == "exit") {
                    return;
                }
                else {
                    std::cout << action << " is not on of the allowed actions!\n";
                }
            }
            catch (const std::invalid_argument &e) {
                std::cout << e.what() << '\n';
            }
        }
    }
};

#endif