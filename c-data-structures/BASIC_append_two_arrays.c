#include <stdio.h>
#include <conio.h>

int main() {
	int c[40], i, j;

	int a[10] = {2,4,2,5};  // n = 4
	int b[10] = {4,5,6,3,2,7};  // m = 6

	int m = 4, n = 6;
	
	for (i=0; i<m; i++) {
		c[i] = a[i];
	}
	for (j=0; j<n; j++) {
		c[j+m] = b[j];
	}
	
	printf("\nARRAY ONE : ");
	for (i=0; i<m; i++){
		printf("%d ", a[i]);
	}
	printf("\nARRAY TWO : ");
	for (j=0; j<n; j++){
		printf("%d ", b[j]);
	}
	
	printf("\n\nARRAYS AFTER APPENDING : ");
	for (i=0; i<m+n; i++){
		printf("%d ", c[i]);
	}
	return 0;
}
