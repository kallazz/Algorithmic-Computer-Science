#include <iostream>
#include <sstream>

class StringOperations {
public:
    // Delete the constructor, because this is a static class
    StringOperations() = delete;

    // Rule of 5
    ~StringOperations() = delete;
    StringOperations(const StringOperations&) = delete;
    StringOperations(StringOperations&&) = delete;
    StringOperations& operator=(const StringOperations&) = delete;
    StringOperations& operator=(StringOperations&&) = delete;

    // Counts how many words are in a string
    static unsigned int countWords(const std::string& s) {
        std::stringstream stream(s);
        unsigned int count = 0;
        std::string word;

        while (stream >> word) count++;

        return count;
    }
    
    // Converts a string to other types, for example int, double etc.
    template<typename T> 
    static T stringToVal(const std::string& s) noexcept(false) {
        std::stringstream stream(s);
        char c;
        T val;

        stream >> val;
        if (stream.fail() || stream.get(c)) 
            throw std::invalid_argument("Wrong type!");

        return val;
    }
};
