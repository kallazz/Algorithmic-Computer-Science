#include "header.h"

void get_next_guess(int *guess, int codes[CODES_SIZE][4]) { //guess zostaje ustawione na najmniejszy właściwy kod
    for (int i = 0; i < CODES_SIZE; i++) {
        if (codes[i][0] != -1) {
            for (int j = 0; j < 4; j++) guess[j] = codes[i][j];
            return;
        }
    }
    guess[0] = -1;
}