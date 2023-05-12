#include <stdio.h>

unsigned fn (unsigned init, unsigned element) {
    //return (init + element);
    return ((element*element) + init);
}

unsigned fold_left(unsigned (*fn)(unsigned, unsigned), unsigned init, size_t len, const unsigned arr[len]);

int main() {
    unsigned init = 0;
    size_t len = 1;
    unsigned arr[len];
    /*for (int i = 0; i < len; i++) {
        arr[i] = i;
    }*/
    arr[0] = 12;
    unsigned result = fold_left(&fn, init, len, arr);
    printf("Result of folding: %u\n", result);
    return 0;
}
