#include <iostream>
#include <string>

#include "PrimeNumbers.h"

static int stringToInt(const std::string &s) {
    if (s.length() == 0) throw std::invalid_argument("");
    if (s[0] == '-' && s.length() <= 1) throw std::invalid_argument("");

    for (int i = 1; i < s.length(); i++) {
        if (!isdigit(s[i])) throw std::invalid_argument("");
    }

    int n;
    try { n = stoi(s); }
    catch(const std::out_of_range& e) { throw std::invalid_argument(""); }
    return n;
}

int main(int argc, char *argv[]) {
    if (argc < 2) return 0;

    int n;
    try { n = stringToInt(argv[1]); } //sprawdzenie czy pierwszy argument to int w odpowiednim zakresie
    catch (const std::invalid_argument& e) { std::cerr << "Nieprawidłowy zakres\n"; return 1; }
    if (n < 2) { std::cerr << "Nieprawidłowy zakres\n"; return 1; }
    
    PrimeNumbers* primes = new PrimeNumbers(n);
    for (int i = 2; i < argc; i++) {
        std::cout << argv[i] << " - ";
        try { 
            n = stringToInt(argv[i]); 
            std::cout << primes->getNumber(n); 
        }
        catch (const std::invalid_argument& e) { std::cerr << "nieprawidłowa dana"; }
        catch (const std::out_of_range& e) { std::cerr << "liczba spoza zakresu"; }
        std::cout << '\n';
    }

    return 0;
}