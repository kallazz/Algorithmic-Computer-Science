#include "header.h"

void generate_codes(int codes[CODES_SIZE][4]) { //funkcja generuje wszystkie możliwe kody
    int index = 0;
    for(int i = 1; i <= 6; i++) {
        for(int j = 1; j <= 6; j++) {
            for(int k = 1; k <= 6; k++) {
                for(int l = 1; l <= 6; l++) {
                    codes[index][0] = i;
                    codes[index][1] = j;
                    codes[index][2] = k;
                    codes[index][3] = l;
                    index++;
                }
            } 
        }
    }
}