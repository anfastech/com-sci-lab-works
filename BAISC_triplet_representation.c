#include <stdio.h>

int main() {
    // triplet 
    int a[10][10] = {{0,0,7,0},{3,0,4,0},{2,0,0,0}};
    int rows = 3,cols = 4;
    int i, j, non_zero_count=0, index = 0;
    for(i=0; i<rows; i++) {
        for (j=0; j<cols; j++) {
            if(a[i][j] != 0) {
                non_zero_count++;
            }
        }
    }

    int triplet[3][non_zero_count];
    for(i=0; i<rows; i++) {
        for (j=0; j<cols; j++) {
            if (a[i][j] != 0) {
                triplet[0][index] = i;
                triplet[1][index] = j;
                triplet[2][index] = a[i][j];

                index++;
            }
        }
    }
    for (i=0; i<3; i++) {
        for (j=0; j<non_zero_count; j++){
            printf("%d ", triplet[i][j]);
        }
        printf("\n");
    }
    return 0;
}