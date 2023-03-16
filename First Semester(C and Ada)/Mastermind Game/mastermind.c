#include <stdio.h>
#include "header.h"

void mastermind(void) {
    int codes[CODES_SIZE][4];
    generate_codes(codes);
    
    int guess[4];
    int red, white;
    while (red != 4) {
        get_next_guess(guess, codes);

        if (guess[0] == -1) { //przypadek oszustwa kodującego
            printf("you are cheating!\n");
            return;
        }

        printf("[%d] [%d] [%d] [%d]?", guess[0], guess[1], guess[2], guess[3]);
        printf("\nred: ");
        scanf("%d", &red);
        printf("white: ");
        scanf("%d", &white);

        remove_wrong_codes(guess, red, white, codes);
    }
    
    printf("I win!\n");
}