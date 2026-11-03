#include <stdio.h>

int main() {
    int mat[3][3] = {{6, 6, 3}, {8, 8, 1}, {2, 3, 1}};
    int resultado[3];
    int i, j;

    resultado[0] = 0;
    for (i = 0; i < 3; i++) {
        resultado[0] += mat[i][i];
    }

    resultado[1] = 0;
    for (j = 0; j < 3; j++) {
        resultado[1] += mat[1][j];
    }

    resultado[2] = 0;
    for (i = 0; i < 3; i++) {
        resultado[2] += mat[i][0];
    }

    printf("Diagonal principal: %d\n", resultado[0]);
    printf("Soma segunda linha: %d\n", resultado[1]);
    printf("Soma primeira coluna: %d\n", resultado[2]);

    return 0;
}
