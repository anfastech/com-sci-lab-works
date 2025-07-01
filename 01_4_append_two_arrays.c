#include <stdio.h>
#include <conio.h>

int main() {
	int a[20], b[20], c[40], i, j, m, n;

	printf("No. of Elements of first array : ");
	scanf("%d", &m);
	printf("Enter Elements : ");
	for (i=0; i<m; i++){
		scanf("%d", &a[i]);
	}
	printf("No. of Elements of secound array : ");
	scanf("%d", &n);
	printf("Enter Elements : ");
	for (j=0; j<n; j++){
		scanf("%d", &b[j]);
	}
	
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
