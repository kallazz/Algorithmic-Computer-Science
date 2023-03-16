#include <stdbool.h>

bool compare_codes(int *guess, int *code, int red, int white) { //funkcja sprawdza czy kod daje taką samą ilość red i white co guess
    int code_red = 0;
    int code_white = 0;
    int code_copy[4];
    for (int i = 0; i < 4; i++) code_copy[i] = code[i];
    int guess_copy[4];
    for (int i = 0; i < 4; i++) guess_copy[i] = guess[i];

    for (int i = 0; i < 4; i++) { //sprawdzenie red
        if (code_copy[i] == guess_copy[i]) {
            code_red++;
            code_copy[i] = 0; //po to aby nie można było ponownie skorzystać z tego elementu
            guess_copy[i] = 0;
        }
    }

    for (int i = 0; i < 4; i++) { //sprawdzenie white
        if (guess_copy[i] != 0) {
            for (int j = 0; j < 4; j++) {
                if (code_copy[j] == guess_copy[i]) {
                    code_white++;
                    code_copy[j] = 0;
                    break;
                }
            }
        }
    }

    if (red == code_red && white == code_white) return true;
    return false;
}