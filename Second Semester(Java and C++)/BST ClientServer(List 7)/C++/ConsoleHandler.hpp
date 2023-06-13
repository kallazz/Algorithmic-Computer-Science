#ifndef CONSOLE_HANDLER_HPP
#define CONSOLE_HANDLER_HPP

#include "BST.hpp"

#include <iostream>
#include <sstream>
#include <vector>

template <typename T>
class ConsoleHandler {
private:
    unsigned int countWords(const std::string& s) {
        std::stringstream stream(s);
        unsigned int count = 0;
        std::string word;

        while (stream >> word) count++;

        return count;
    }

    T verifyInput(std::stringstream& stream, unsigned int preferredWords, unsigned int actualWords) noexcept(false) {
        if (preferredWords != actualWords)
            throw std::invalid_argument(std::to_string(actualWords - 1) + 
            " is not the apropriate number of arguments for this action!\n");
        
        char c;
        T typeValue;

        stream >> typeValue;
        if (stream.fail() || stream.get(c))
            throw std::invalid_argument("Wrong type!\n");

        return typeValue;
    }

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
                wordCount = countWords(input);

                if (wordCount < 1 || wordCount > 2) 
                    throw std::invalid_argument("You can input max 2 words, not " + std::to_string(wordCount) + '\n');
                
                std::stringstream inputStream(input);
                std::string action;
                inputStream >> action;

                if (action == "insert") {
                    tree.insertValue(verifyInput(inputStream, 2, wordCount));
                }
                else if (action == "delete") {
                    tree.deleteValue(verifyInput(inputStream, 2, wordCount));
                }
                else if (action == "search") {
                    if (tree.searchValue(verifyInput(inputStream, 2, wordCount)) == true) std::cout << "The element IS in the tree\n";
                    else std::cout << "The element IS NOT in the tree\n";
                }
                else if (action == "print") {
                    if (wordCount != 1) std::cout << "Print requires only 1 argument, not " << wordCount << '\n';
                    else tree.printTree();
                }
                else if (action == "exit") {
                    return;
                }
                else {
                    std::cout << action << " is not on of the allowed actions!\n";
                }
            }
            catch (const std::invalid_argument &e) {
                std::cout << e.what();
            }
        }
    }
};

#endif