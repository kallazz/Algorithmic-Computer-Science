#include <iostream>
#include <vector>

#include "PrimeNumbers.h"

//Definicja konstruktorów
PrimeNumbers::PrimeNumbers(int n) {
    std::vector<bool> primePositions = sieveOfEratosthenes(n);
    for (int i = 2; i <= n; i++) {
        if (primePositions[i] == true) primes.push_back(i);
    }
}

//Definicja metod
std::vector<bool> PrimeNumbers::sieveOfEratosthenes(int n) {
    std::vector<bool> primePositions;
    for (int i = 0; i <= n; i++) primePositions.push_back(true);

    for (long i = 2; i * i <= n; i++) {
        if (primePositions[i] == true) {
            for (long j = i * i; j <= n; j = j + i) primePositions[j] = false;
        }
    }
    return primePositions;
}

int PrimeNumbers::getNumber(int m) {
    if (m >= primes.size() || m < 0) throw std::out_of_range("");
    return primes[m];
}