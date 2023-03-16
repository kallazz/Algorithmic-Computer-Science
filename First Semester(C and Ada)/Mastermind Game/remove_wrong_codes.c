#include "header.h"

void remove_wrong_codes(int *guess, int red, int white, int codes[CODES_SIZE][4]) {
    for (int i = 0; i < CODES_SIZE; i++) {
        if (codes[i][0] != -1) {
            if (!compare_codes(guess, codes[i], red, white)) codes[i][0] = -1; //kod zostaje usunięty z puli, gdy jego pierwszy element to -1
        }
    }
}