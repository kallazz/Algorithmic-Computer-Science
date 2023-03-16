#include <stdbool.h>
#include <string.h>

bool match(char* pattern, char* text) {
    if (pattern[0] == '\0' && text[0] == '\0') return true;
    if (pattern[0] == '\0') return false;

    if (pattern[0] == '*') {
        if (text[0] == '\0') return match(pattern + 1, text); else return (match(pattern + 1, text) || match(pattern, text + 1));
    }

    if ((pattern[0] == '?') || (pattern[0] == text[0])) return match(pattern + 1, text + 1);

    return false;
}