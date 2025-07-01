#include <stdio.h>
int main() {
    int matrix[10][10], i, j, rows, cols, nonZeroCount = 0, index = 0;
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &rows, &cols);

    printf("Enter the elements of the matrix:\n");
    for(i=0;i <rows; i++) {
        for(j=0; j<cols ; j++ ){
            scanf("%d", &matrix[i][j]);
            if(matrix[i][j] != 0) {
                nonZeroCount++;
            }
        }
    }

    printf("The Matrix is : ");
    for (i=0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    int triplet[3][nonZeroCount];
    for (i = 0; i < rows; i++) {
        for (j=0; j< cols; j++){
            if (matrix[i][j] !=0){
                triplet[0][index] = i;
                triplet[1][index] = j;
                triplet[2][index] = matrix[i][j];
                index++;
            }
        }
    }

    printf("\n The Triplet Representation of the Matrix is:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < nonZeroCount; j++) {
            printf("%d ", triplet[i][j]);
        }
        printf("\n");
    }
    return 0;
}