#include <stdio.h>
#include <conio.h>
#include <string.h>

int main() {
	int a[20], b[20], c[40], i, j, m, n;

	printf("ENTER NU. ELEMENTS OF 1ST ARRAY : ");
	scanf("%d", &m);
	printf("ENTER THE ELEMENTS : ");
	for (i=0; i<m; i++){
		scanf("%d", &a[i]);
	}
	printf("ENTER NU. ELEMENTS OF 2ND ARRAY : ");
	scanf("%d", &n);
	printf("ENTER THE ELEMENTS : ");
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
