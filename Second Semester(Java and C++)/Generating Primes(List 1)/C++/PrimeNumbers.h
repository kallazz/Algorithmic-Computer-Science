#ifndef PRIME_NUMBERS_H
#define PRIME_NUMBERS_H

#include <vector>

class PrimeNumbers {
    //Atrybuty
    private:
        std::vector<int> primes;

    //Konstruktory
    public:
        PrimeNumbers(int n);

    //Metody
    private:
        std::vector<bool> sieveOfEratosthenes(int n);
    public:
        int getNumber(int m);
};

#endif // PRIME_NUMBERS_H