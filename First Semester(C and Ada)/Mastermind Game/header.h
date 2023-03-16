#include <stdbool.h>
#define CODES_SIZE 6*6*6*6

void generate_codes(int codes[CODES_SIZE][4]);
void get_next_guess(int *guess, int codes[CODES_SIZE][4]);
bool compare_codes(int *guess, int *code, int red, int white);
void remove_wrong_codes(int *guess, int red, int white, int codes[CODES_SIZE][4]);
void mastermind(void);