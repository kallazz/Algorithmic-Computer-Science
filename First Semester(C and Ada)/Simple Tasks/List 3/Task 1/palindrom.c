#include <stdbool.h>
#include <string.h>
#include "header.h"

bool palindrom(char napis[]) {
    int dlugosc = strlen(napis);
    for (int i = 0; i < (dlugosc / 2); i++) {
        if (napis[i] != napis[dlugosc - i - 1]) return false;
    }
    return true;
}