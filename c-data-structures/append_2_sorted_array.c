#include <stdio.h>
#include <stdlib.h>

int main() {
    int a[10]={1,2,3,4,5,6}; // m = 6
    int m = 6;
    int b[10]={4,6,8,10,12}; // n = 5
    int n = 5;
    int c[20], i,j;

    for (i=0; i<m; i++){
        c[i] = a[i];
    }
    for (i=0; i<n; i++){
        c[m+i] = b[i];
    }
    
    printf("\nThe Append : \n");
    for (i=0; i<m+n; i++){
        printf(" %d -> ", c[i]);
    }
    int min_index, temp;

    // Selection Sort
    for (i=0; i<m+n-1; i++){
        min_index = i;
        for (j=i+1; j<m+n; j++){
            if (c[j]<c[min_index]){
                min_index = j;
            }
        }
        if (min_index != i){
            temp = c[min_index];
            c[min_index] = c[i];
            c[i] = temp;
        }
    }
    printf("\n Sorted Array : \n");
    for (i=0; i<m+n; i++){
        printf(" %d -> ", c[i]);
    }

    return 0;
}